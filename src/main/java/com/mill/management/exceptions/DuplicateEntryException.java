package com.mill.management.exceptions;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

public class DuplicateEntryException extends SQLException {
    public DuplicateEntryException(String msz){
        super(msz);
    }
}
