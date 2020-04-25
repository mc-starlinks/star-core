package com.starlinks.core.api.command;

import java.util.List;

public interface StarCommandInfo {

    String getName();

    String getPermission();

    CommandTarget getTarget();

    List<String> getAliases();

}
