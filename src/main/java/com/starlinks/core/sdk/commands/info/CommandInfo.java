package com.starlinks.core.sdk.commands.info;

import com.starlinks.core.api.command.CommandTarget;
import com.starlinks.core.api.command.StarCommandInfo;
import lombok.Builder;
import lombok.Getter;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Builder
@Getter
public final class CommandInfo implements StarCommandInfo {

    private final static List<String> EMPTY_ALIASES = Collections.emptyList();

    private final String name, permission;
    private final String[] aliases;
    private final CommandTarget target;

    public List<String> getAliases() {
        return aliases == null ? EMPTY_ALIASES : Arrays.asList(aliases);
    }
}
