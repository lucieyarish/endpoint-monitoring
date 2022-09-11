package com.endpointsmonitoring.exceptions;

public class InvalidEmailException extends Exception {

    public InvalidEmailException() { super("Email address is invalid!"); }
}
