package com.witcher.kicker.domain.potterland.exception;

public class PotterlandException extends Exception {

    public PotterlandException(String message) {
        super(message);
    }

    public PotterlandException(Throwable cause) {
        super(cause);
    }

    public PotterlandException(String message, Throwable cause) {
        super(message, cause);
    }
}
