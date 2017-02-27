package com.epam.task5.main;

import com.epam.task5.bean.Dish;
import com.epam.task5.controller.Controller;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 */
public class Main {

    private static final String SAX_PARSER = "sax";
    private static final String STAX_PARSER = "stax";
    private static final String DOM_PARSER = "dom";

    public static void main(String[] args) {
        Controller controller = new Controller();
        menuOutput(controller.executeTask(SAX_PARSER));

    }

    private static void menuOutput(HashMap<String, ArrayList<Dish>> allDish) {
        for (String key : allDish.keySet()) {
            System.out.println(key.toUpperCase());
            for (Dish values : allDish.get(key)) {
                System.out.println(values.toString());
            }
        }
    }
}
