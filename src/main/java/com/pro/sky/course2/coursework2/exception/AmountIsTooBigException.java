package com.pro.sky.course2.coursework2.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class AmountIsTooBigException extends RuntimeException{
    public AmountIsTooBigException() {
        super();
    }
    public AmountIsTooBigException(String message) {
        super(message);
    }
}
