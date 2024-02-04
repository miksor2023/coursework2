package com.pro.sky.course2.coursework2.service;

import com.pro.sky.course2.coursework2.domain.Question;

import java.util.Collection;

public interface ExaminerService {
Collection<Question> getQuestions(int amount);
}
