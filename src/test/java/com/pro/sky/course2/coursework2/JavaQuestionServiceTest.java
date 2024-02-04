package com.pro.sky.course2.coursework2;

import com.pro.sky.course2.coursework2.domain.Question;
import com.pro.sky.course2.coursework2.exception.QuestinAlreadyAddedException;
import com.pro.sky.course2.coursework2.exception.QuestionNotFoundException;
import com.pro.sky.course2.coursework2.exception.SetOfQuestionsIsEmptyException;
import com.pro.sky.course2.coursework2.service.JavaQuestionService;
import com.pro.sky.course2.coursework2.service.QuestionService;
//import org.junit.jupiter.api.Assertions;
import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class JavaQuestionServiceTest {
    JavaQuestionService out = new JavaQuestionService();

    @BeforeEach
    public void createQuestionSet() {
        Collection<Question> questions = new ArrayList<>(out.getAll());
        for (Question question : questions) {
            out.remove(question);
        }
        for (int i = 0; i < 5; i++) {
            Question question = new Question("Вопрос " + i, "Ответ " + i);
            out.add(question);
        }
    }

    @Test
    public void mustAddQuestion() {
        Question expected = new Question("Вопрос 6", "Ответ 6");
        Question actual = out.add(new Question("Вопрос 6", "Ответ 6"));
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void mustRemoveQuestion() {
        Question expected = new Question("Вопрос 1", "Ответ 1");
        Question actual = out.remove(new Question("Вопрос 1", "Ответ 1"));
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void mustGetAll() {
        Collection<Question> expectedQuestions = new HashSet<>();
        for (int i = 0; i < 5; i++) {
            Question question = new Question("Вопрос " + i, "Ответ " + i);
            expectedQuestions.add(question);
        }
        Collection<Question> actualQuestions = out.getAll();
        assertThat(actualQuestions).hasSameElementsAs(expectedQuestions);
    }

    @Test
    public void mustGetRandomQuestion() {
        Collection<Question> actualQuestions = out.getAll();
        assertThat(actualQuestions).contains(out.getRandomQuestion());
    }

    @Test
    public void mustThrowQuestioAlredyAddedException() {
        assertThatExceptionOfType(QuestinAlreadyAddedException.class)
                .isThrownBy(() -> out.add(new Question("Вопрос 1", "Ответ 1")));
    }

    @Test
    public void mustThrowQuestionNotFoundException() {
        assertThatExceptionOfType(QuestionNotFoundException.class)
                .isThrownBy(() -> out.remove(new Question("Вопрос 6", "Ответ 6")));
    }

    @Test
    public void mustThrowSetOfQuestionsIsEmptyException() {
        Collection<Question> questions = new ArrayList<>(out.getAll());
        for (Question question : questions) {
            out.remove(question);
        }
        assertThatExceptionOfType(SetOfQuestionsIsEmptyException.class)
                .isThrownBy(() -> out.getRandomQuestion());
    }

}
