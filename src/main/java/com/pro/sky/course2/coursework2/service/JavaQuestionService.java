package com.pro.sky.course2.coursework2.service;

import com.pro.sky.course2.coursework2.domain.Question;
import com.pro.sky.course2.coursework2.exception.QuestinAlreadyAddedException;
import com.pro.sky.course2.coursework2.exception.QuestionNotFoundException;
import com.pro.sky.course2.coursework2.exception.SetOfQuestionsIsEmptyException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {
    private final Set<Question> questions = new HashSet<>();

    @Override
    public Question add(String question, String answer) {
        Question newQuestion = new Question(question, answer);
        return add(newQuestion);
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

    @Override
    public Question getRandomQuestion() throws SetOfQuestionsIsEmptyException {
        if (questions.isEmpty()){
            throw new SetOfQuestionsIsEmptyException("Хранилище пусто");
        }
        List<Question> questionList = new ArrayList<>(questions);
        Random random = new Random();
        return questionList.get(random.nextInt(questions.size()));
    }

    @Override
    public Collection<Question> fill() {
        for (int i = 0; i < 5; i++) {
            Question question = new Question("Вопрос " + String.valueOf(i), "Ответ " + String.valueOf(i));
            questions.add(question);
        }
        return questions;
    }
}
