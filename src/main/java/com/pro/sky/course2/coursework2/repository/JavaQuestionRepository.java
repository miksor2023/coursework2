package com.pro.sky.course2.coursework2.repository;

import com.pro.sky.course2.coursework2.domain.Question;
import com.pro.sky.course2.coursework2.exception.QuestinAlreadyAddedException;
import com.pro.sky.course2.coursework2.exception.QuestionNotFoundException;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Repository
public class JavaQuestionRepository implements QuestionRepository{

    private Set<Question> questions = new HashSet<>();
    @PostConstruct
    public void init () {
        int repositorySize = 5;
        for (int i = 1; i <= repositorySize; i++) {
            Question question = new Question("(Java) Вопрос " + i, "(Java) Ответ " + i);
            questions.add(question);
        }
    }
    @Override
    public Question add(Question question) throws QuestinAlreadyAddedException {
        if (!questions.contains(question)) {
            questions.add(question);
            return question;
        } else {
            throw new QuestinAlreadyAddedException("Вопрос уже есть в хранилище");
        }
    }
    @Override
    public Question remove(Question question) throws QuestionNotFoundException {
        if (questions.contains(question)) {
            questions.remove(question);
            return question;
        } else {
            throw new QuestionNotFoundException("Вопрос в хранилище не найден");
        }
    }
    @Override
    public Collection<Question> getAll() {
        return questions;
    }
}
