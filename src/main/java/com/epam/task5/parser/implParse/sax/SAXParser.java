package com.epam.task5.parser.implParse.sax;

import com.epam.task5.bean.Dish;
import com.epam.task5.parser.XMLParse;
import com.epam.task5.parser.exception.ParserException;
import com.epam.task5.parser.implParse.sax.handler.MenuSaxHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 */
public class SAXParser implements XMLParse {
    @Override
    public HashMap<String, ArrayList<Dish>> getMeals(String xmlPath) throws ParserException {
        HashMap<String, ArrayList<Dish>> menu;

        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();
            MenuSaxHandler handler = new MenuSaxHandler();
            reader.setContentHandler(handler);
            reader.parse(new InputSource(xmlPath));
            menu = handler.getAllDish();
        } catch (SAXException | IOException e) {
            throw new ParserException(e);
        }

        return menu;
    }
}
