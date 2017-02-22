package com.epam.task5.parser.exception;

/**
 *
 */
public class ParserException extends Exception {
    public ParserException() {
        super();
    }

    public ParserException(String message) {
        super(message);
    }

    public ParserException(Exception e) {
        super(e);
    }
}
