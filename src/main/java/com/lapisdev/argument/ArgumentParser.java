package com.lapisdev.argument;

import co.aikar.commands.BukkitCommandExecutionContext;

public interface ArgumentParser<T> {
    T parse(BukkitCommandExecutionContext ctx);
}
