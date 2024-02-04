package com.pro.sky.course2.coursework2.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class SetOfQuestionsIsEmptyException extends RuntimeException{
    public SetOfQuestionsIsEmptyException() {
        super();
    }
    public SetOfQuestionsIsEmptyException(String message) {
        super(message);
    }
}
