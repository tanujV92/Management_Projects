package com.mill.management.errorhandlers;

import com.mill.management.errorhandlers.error.CustomErrorResponse;
import com.mill.management.exceptions.DuplicateEntryException;
import com.mill.management.exceptions.NoCustomerAvailableException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.io.IOException;
import java.util.Date;

@ControllerAdvice
public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(DuplicateEntryException.class)
    public ResponseEntity<CustomErrorResponse> springHandleDuplicateEntry(Exception e, WebRequest request) {
        CustomErrorResponse errorResponse=new CustomErrorResponse();
             errorResponse.setError(e.getMessage());
             errorResponse.setStatus(HttpStatus.CONFLICT.value());
             errorResponse.setTimeStamp(new Date());
             errorResponse.setPath(request.getContextPath());
             return new ResponseEntity<>(errorResponse,HttpStatus.CONFLICT);
    }

    @ExceptionHandler(NoCustomerAvailableException.class)
    public ResponseEntity<CustomErrorResponse> springHandleNoEntriesFound(Exception e,WebRequest request){
        CustomErrorResponse errorResponse=new CustomErrorResponse();
        errorResponse.setError(e.getMessage());
        errorResponse.setStatus(HttpStatus.NOT_ACCEPTABLE.value());
        errorResponse.setTimeStamp(new Date());
        errorResponse.setPath(request.getContextPath());
        return new ResponseEntity<>(errorResponse,HttpStatus.NOT_ACCEPTABLE);
    }
}
