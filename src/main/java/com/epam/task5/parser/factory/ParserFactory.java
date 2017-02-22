package com.epam.task5.parser.factory;

import com.epam.task5.parser.XMLParse;
import com.epam.task5.parser.implParse.dom.DOMParser;
import com.epam.task5.parser.implParse.sax.SAXParser;
import com.epam.task5.parser.implParse.stax.StAXParser;

/**
 *
 */
public final class ParserFactory {
    private static final ParserFactory instance = new ParserFactory();

    private XMLParse DOMParser = new DOMParser();
    private XMLParse SAXParser = new SAXParser();
    private XMLParse StAXParser = new StAXParser();

    public static ParserFactory getInstance() {
        return instance;
    }

    public XMLParse getDOMParser() {
        return DOMParser;
    }

    public XMLParse getSAXParser() {
        return SAXParser;
    }

    public XMLParse getStAXParser() {
        return StAXParser;
    }
}
