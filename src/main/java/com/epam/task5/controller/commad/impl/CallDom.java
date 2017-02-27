package com.epam.task5.controller.commad.impl;

import com.epam.task5.bean.Dish;
import com.epam.task5.controller.commad.Command;
import com.epam.task5.parser.XMLParse;
import com.epam.task5.parser.exception.ParserException;
import com.epam.task5.parser.factory.ParserFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 */
public class CallDom implements Command {
    private static final String XML_PATH = "menu.xml";

    private static final Logger logger = LogManager.getLogger(CallDom.class);

    @Override
    public HashMap<String, ArrayList<Dish>> execute(String xmlPath) {
        HashMap<String, ArrayList<Dish>> allDish = null;
        try {
            ParserFactory parserFactory = ParserFactory.getInstance();
            XMLParse domParser = parserFactory.getDOMParser();
            allDish = domParser.getMeals(XML_PATH);
        } catch (ParserException e) {
            logger.error(e);
        }
        return allDish;
    }
}
