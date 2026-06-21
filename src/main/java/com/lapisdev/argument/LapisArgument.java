package com.lapisdev.argument;

import co.aikar.commands.PaperCommandManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class LapisArgument extends JavaPlugin {

    public static final ArgumentParser<?>[] PARSERS = new ArgumentParser<?>[]{

    };

    public static final ArgumentSuggestion[] SUGGESTIONS = new ArgumentSuggestion[]{

    };

    public static void register(PaperCommandManager commandManager) {
        for (ArgumentParser<?> parser : PARSERS) {
            commandManager.getCommandContexts().registerContext((Class)parser.getType(), parser::parse);
        }

        for (ArgumentSuggestion suggestion : SUGGESTIONS) {
            commandManager.getCommandCompletions().registerCompletion(suggestion.getName(), suggestion::suggest);
        }
    }
}
