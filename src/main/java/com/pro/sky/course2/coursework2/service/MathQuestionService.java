package com.pro.sky.course2.coursework2.service;

import com.pro.sky.course2.coursework2.domain.Question;
import com.pro.sky.course2.coursework2.exception.QuestinAlreadyAddedException;
import com.pro.sky.course2.coursework2.exception.QuestionNotFoundException;
import com.pro.sky.course2.coursework2.exception.SetOfQuestionsIsEmptyException;
import com.pro.sky.course2.coursework2.repository.QuestionRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MathQuestionService implements QuestionService {

    private final QuestionRepository repository;

    public MathQuestionService(@Qualifier("mathQuestionRepository") QuestionRepository repository) {
        this.repository = repository;
    }
    private Random random = new Random();

    @Override
    public Question add(String question, String answer) {
        Question newQuestion = new Question(question, answer);
        return repository.add(newQuestion);
    }

    @Override
    public Question add(Question question) {
        return repository.add(question);
    }

    @Override
    public Question remove(Question question) {
        return repository.remove(question);
    }

    @Override
    public Collection<Question> getAll() {
        return repository.getAll();
    }

    @Override
    public Question getRandomQuestion() throws SetOfQuestionsIsEmptyException {
        if (repository.getAll().isEmpty()){
            throw new SetOfQuestionsIsEmptyException("Хранилище пусто");
        }
        List<Question> questionList = new ArrayList<>(repository.getAll());
        return questionList.get(random.nextInt(repository.getAll().size()));
    }
}
