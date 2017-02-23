package com.epam.task5.controller;

import com.epam.task5.controller.commad.Command;
import com.epam.task5.controller.commad.CommandName;
import com.epam.task5.controller.commad.impl.CallDom;
import com.epam.task5.controller.commad.impl.CallSax;
import com.epam.task5.controller.commad.impl.CallStax;
import com.epam.task5.controller.commad.impl.WrongRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mrdor on 23.02.2017.
 */
final class CommandProvider {
    private final Map<CommandName, Command> repository = new HashMap<>();

    CommandProvider() {
        repository.put(CommandName.SAX, new CallSax());
        repository.put(CommandName.STAX, new CallStax());
        repository.put(CommandName.DOM, new CallDom());
        repository.put(CommandName.WRONG_REQUEST, new WrongRequest());
    }

    Command getCommand(String name) {
        CommandName commandName;
        Command command;

        try {
            commandName = CommandName.valueOf(name.toUpperCase());
            command = repository.get(commandName);
        } catch (IllegalArgumentException | NullPointerException e) {
            command = repository.get(CommandName.WRONG_REQUEST);
        }
        return command;
    }
}
