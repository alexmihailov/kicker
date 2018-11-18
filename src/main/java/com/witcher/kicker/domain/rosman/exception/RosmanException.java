package com.witcher.kicker.domain.rosman.exception;

public class RosmanException extends Exception {

    public RosmanException() {
    }

    public RosmanException(Throwable cause) {
        super(cause);
    }

    public RosmanException(String message) {
        super(message);
    }

    public RosmanException(String message, Throwable cause) {
        super(message, cause);
    }
}
