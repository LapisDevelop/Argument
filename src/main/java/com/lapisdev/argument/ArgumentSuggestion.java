package com.lapisdev.argument;

import co.aikar.commands.BukkitCommandCompletionContext;

import java.util.List;

public interface ArgumentSuggestion {
    String getName();
    List<String> suggest(BukkitCommandCompletionContext ctx);
}
