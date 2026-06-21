package com.lapisdev.argument;

import co.aikar.commands.BukkitCommandExecutionContext;

public interface ArgumentParser<T> {
    Class<T> getType();
    T parse(BukkitCommandExecutionContext ctx);
}
