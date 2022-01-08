package ru.callinsight.backendSalary.exception;

public class OperatorNotFoundException extends RuntimeException {
    public OperatorNotFoundException(String message) {
        super(message);
    }
}
