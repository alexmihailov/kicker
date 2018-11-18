package com.witcher.kicker.domain.zigzag.exception;

public class ZigzagException extends Exception {

    public ZigzagException() {
    }

    public ZigzagException(String message) {
        super(message);
    }

    public ZigzagException(Throwable cause) {
        super(cause);
    }

    public ZigzagException(String message, Throwable cause) {
        super(message, cause);
    }
}
