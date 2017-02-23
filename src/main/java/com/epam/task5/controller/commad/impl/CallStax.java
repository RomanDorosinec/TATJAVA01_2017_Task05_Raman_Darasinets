package com.epam.task5.controller.commad.impl;

import com.epam.task5.bean.Dish;
import com.epam.task5.controller.commad.Command;
import com.epam.task5.parser.XMLParse;
import com.epam.task5.parser.exception.ParserException;
import com.epam.task5.parser.factory.ParserFactory;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 */
public class CallStax implements Command{
    private static final String XML_PATH = "menu.xml";

    @Override
    public HashMap<String, ArrayList<Dish>> execute(String xmlPath) {
        HashMap<String, ArrayList<Dish>> allDish = null;
        try {
            ParserFactory parserFactory = ParserFactory.getInstance();
            XMLParse staxParser = parserFactory.getStAXParser();
            allDish = staxParser.getMeals(XML_PATH);
        } catch (ParserException e) {

        }
        return allDish;
    }
}
