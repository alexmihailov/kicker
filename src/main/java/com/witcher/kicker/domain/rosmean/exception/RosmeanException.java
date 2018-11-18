package com.witcher.kicker.domain.rosmean.exception;

public class RosmeanException extends Exception {

    public RosmeanException() {
    }

    public RosmeanException(String message) {
        super(message);
    }

    public RosmeanException(Throwable cause) {
        super(cause);
    }

    public RosmeanException(String message, Throwable cause) {
        super(message, cause);
    }
}
