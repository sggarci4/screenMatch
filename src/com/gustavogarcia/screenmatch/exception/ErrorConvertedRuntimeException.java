package com.gustavogarcia.screenmatch.exception;

public class ErrorConvertedRuntimeException extends RuntimeException{
    private String message;

    public ErrorConvertedRuntimeException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
