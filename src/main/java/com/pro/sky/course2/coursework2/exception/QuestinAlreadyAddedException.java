package com.pro.sky.course2.coursework2.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.ACCEPTED)
public class QuestinAlreadyAddedException extends RuntimeException{
    public QuestinAlreadyAddedException() {
        super();
    }
    public QuestinAlreadyAddedException(String message) {
        super(message);
    }
}
