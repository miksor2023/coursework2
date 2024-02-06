package com.pro.sky.course2.coursework2.service;

import com.pro.sky.course2.coursework2.domain.Question;
import com.pro.sky.course2.coursework2.exception.AmountIsTooBigException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final JavaQuestionService javaQuestionService;
    private final MathQuestionService mathQuestionService;

    public ExaminerServiceImpl(JavaQuestionService javaQuestionService, MathQuestionService mathQuestionService) {
        this.javaQuestionService = javaQuestionService;
        this.mathQuestionService = mathQuestionService;
    }
    private Random random = new Random();
    @Override
    public Collection<Question> getQuestions(int amount) throws AmountIsTooBigException {
        Set<Question> randomQuestionSet = new HashSet<>();
        int javaQuestionQty;//количество вопросов по java
        int lowerRangeLimit;//нижняя граница диапазона возможных значений количества вопросов по java
        int upperRangeLimit;//верхняя граница диапазона возможных значений количества вопросов по java
        if (amount > javaQuestionService.getAll().size() + mathQuestionService.getAll().size()) {
            throw new AmountIsTooBigException("Введённый параметр превышает размер хранилища");
        }
        if (amount <= mathQuestionService.getAll().size()){
            lowerRangeLimit = 0;
        } else {
            lowerRangeLimit = amount - mathQuestionService.getAll().size();
        }
        if (amount < javaQuestionService.getAll().size()){
            upperRangeLimit = amount;
        } else {
            upperRangeLimit = javaQuestionService.getAll().size();
        }

        javaQuestionQty = random.nextInt((upperRangeLimit - lowerRangeLimit) + 1) + lowerRangeLimit;

        while (randomQuestionSet.size() < javaQuestionQty) {
            randomQuestionSet.add(javaQuestionService.getRandomQuestion());
        }
        while (randomQuestionSet.size() < amount) {
            randomQuestionSet.add(mathQuestionService.getRandomQuestion());
        }
        return randomQuestionSet;
    }
}
