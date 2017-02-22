package com.epam.task5.main;

import com.epam.task5.bean.Dish;
import com.epam.task5.parser.XMLParse;
import com.epam.task5.parser.exception.ParserException;
import com.epam.task5.parser.factory.ParserFactory;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 */
public class Main {
    private static final String XML_PATH = "menu.xml";
    public static void main(String[] args) {
        ParserFactory parserFactory = ParserFactory.getInstance();
        XMLParse domParser = parserFactory.getDOMParser();
        XMLParse saxParser = parserFactory.getSAXParser();
        XMLParse staxParser = parserFactory.getStAXParser();
        try {
            //domParser.getMeals(XML_PATH);
            //HashMap<String, ArrayList<Dish>> allDish = saxParser.getMeals(XML_PATH);
            HashMap<String, ArrayList<Dish>> allDish = staxParser.getMeals(XML_PATH);
            for (String key : allDish.keySet()) {
                System.out.println("                " + key);
                for (ArrayList<Dish> values : allDish.values()) {
                    for (Dish value : values) {
                        System.out.println(value.toString());
                    }
                }
            }
        } catch (ParserException e) {
            e.printStackTrace();
        }
    }
}
