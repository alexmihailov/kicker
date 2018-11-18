package com.witcher.kicker.domain.kupipotter.exception;

public class KupipotterException extends Exception {

    public KupipotterException(String message) {
        super(message);
    }

    public KupipotterException(Throwable cause) {
        super(cause);
    }

    public KupipotterException(String message, Throwable cause) {
        super(message, cause);
    }
}
