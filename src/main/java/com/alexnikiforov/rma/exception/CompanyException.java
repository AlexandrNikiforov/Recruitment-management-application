package com.alexnikiforov.rma.exception;

public class CompanyException extends RuntimeException {
    public CompanyException(String message) {
        super(message);
    }

    public CompanyException(String message, Throwable cause) {
        super(message, cause);
    }
}
