package com.epam.task5.parser;

import com.epam.task5.bean.Dish;
import com.epam.task5.parser.exception.ParserException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 */
public interface XMLParse {
    HashMap<String, ArrayList<Dish>> getMeals(String xmlPath) throws ParserException;
}
