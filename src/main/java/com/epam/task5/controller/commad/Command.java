package com.epam.task5.controller.commad;

import com.epam.task5.bean.Dish;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 */
public interface Command {
    HashMap<String, ArrayList<Dish>> execute(String xmlPath);
}
