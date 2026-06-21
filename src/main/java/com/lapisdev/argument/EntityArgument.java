package com.lapisdev.argument;

import co.aikar.commands.BukkitCommandCompletionContext;
import co.aikar.commands.BukkitCommandExecutionContext;
import co.aikar.commands.InvalidCommandArgument;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class EntityArgument implements ArgumentParser<Entity>, ArgumentSuggestion {
    @Override
    public Entity parse(BukkitCommandExecutionContext ctx) {
        String input = ctx.popFirstArg();
        CommandSender sender = ctx.getSender();

        if (sender instanceof Player player)
        {
            List<Entity> result = Bukkit.selectEntities(player, input);
            if (result.size() == 1)
            {
                return result.getFirst();
            }
            throw new InvalidCommandArgument("Must select exactly one entity");
        }

        throw new InvalidCommandArgument("Console cannot use selectors");
    }

    @Override
    public Class<Entity> getType() {
        return Entity.class;
    }

    @Override
    public String getName() {
        return "entity";
    }

    @Override
    public List<String> suggest(BukkitCommandCompletionContext ctx) {
        String input = ctx.getInput();
        CommandSender sender = ctx.getSender();

        List<String> results = new ArrayList<>();

        for (Player p : Bukkit.getOnlinePlayers())
        {
            if (p.getName().toLowerCase().startsWith(input.toLowerCase()))
            {
                results.add(p.getName());
            }
        }

        if ("@".startsWith(input))
        {
            results.add("@p");
            results.add("@e");
            results.add("@a");
            results.add("@r");
            results.add("@s");
            results.add("@n");
        }

        return results;
    }
}
