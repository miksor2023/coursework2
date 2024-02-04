package com.pro.sky.course2.coursework2.service;

import com.pro.sky.course2.coursework2.domain.Question;
import com.pro.sky.course2.coursework2.exception.AmountIsTooBigException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    JavaQuestionService javaQuestionService;

    public ExaminerServiceImpl(JavaQuestionService javaQuestionService) {
        this.javaQuestionService = javaQuestionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) throws AmountIsTooBigException {
        if (amount <= javaQuestionService.getAll().size()) {
            Set<Question> randomQuestionSet = new HashSet<>();
            while (randomQuestionSet.size() < amount) {
                randomQuestionSet.add(javaQuestionService.getRandomQuestion());
            }
            return randomQuestionSet;
        } else {
            throw new AmountIsTooBigException("Введённый параметр превышает размер хранилища");
        }
    }
}
