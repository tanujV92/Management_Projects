package com.mill.management.exceptions;

public class NoCustomerAvailableException extends RuntimeException {

    public NoCustomerAvailableException(String msz){
        super(msz);
    }
}
