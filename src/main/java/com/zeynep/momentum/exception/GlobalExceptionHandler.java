package com.zeynep.momentum.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


import java.util.HashMap;
import java.util.Map;


@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(EmailAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public Map<String,String> handleEmailAlreadyExists(
            EmailAlreadyExistsException exception
    ){

        Map<String,String> error = new HashMap<>();

        error.put(
                "message",
                exception.getMessage()
        );

        return error;
    }


}