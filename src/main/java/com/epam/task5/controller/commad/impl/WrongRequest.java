package com.epam.task5.controller.commad.impl;

import com.epam.task5.bean.Dish;
import com.epam.task5.controller.commad.Command;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 */
public class WrongRequest implements Command {

    @Override
    public HashMap<String, ArrayList<Dish>> execute(String xmlPath) {
        HashMap<String, ArrayList<Dish>> allDish = null;
        return allDish;
    }
}
