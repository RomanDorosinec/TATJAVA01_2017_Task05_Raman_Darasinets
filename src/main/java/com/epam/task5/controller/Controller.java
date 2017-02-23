package com.epam.task5.controller;

import com.epam.task5.bean.Dish;
import com.epam.task5.controller.commad.Command;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 */
public final class Controller {

    private final CommandProvider provider = new CommandProvider();

    public HashMap<String, ArrayList<Dish>> executeTask(String request) {
        Command executionCommand;

        executionCommand = provider.getCommand(request);

        HashMap<String, ArrayList<Dish>> allDish = executionCommand.execute(request);

        return allDish;
    }
}
