package com.pro.sky.course2.coursework2.repository;

import com.pro.sky.course2.coursework2.domain.Question;

import java.util.Collection;

public interface QuestionRepository {
    Question add (Question question);
    Question remove (Question question);
    Collection<Question> getAll();
}
