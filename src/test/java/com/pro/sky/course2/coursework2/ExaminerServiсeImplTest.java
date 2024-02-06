package com.pro.sky.course2.coursework2;

import com.pro.sky.course2.coursework2.domain.Question;
import com.pro.sky.course2.coursework2.exception.AmountIsTooBigException;
import com.pro.sky.course2.coursework2.service.ExaminerServiceImpl;
import com.pro.sky.course2.coursework2.service.JavaQuestionService;
import com.pro.sky.course2.coursework2.service.MathQuestionService;
import com.pro.sky.course2.coursework2.service.QuestionService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.Collection;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.when;
import static com.pro.sky.course2.coursework2.TestConstants.TEST_MATH_QUESTION_SET;
import static com.pro.sky.course2.coursework2.TestConstants.TEST_JAVA_QUESTION_SET;
@ExtendWith(MockitoExtension.class)
public class ExaminerServiсeImplTest {
    @Mock
    private JavaQuestionService javaQuestionServiceMock;
    @Mock
    private MathQuestionService mathQuestionServiceMock;
    @InjectMocks
    private ExaminerServiceImpl out;
    @Test
    public void mustReturnRandomQuestionSet(){
        when(javaQuestionServiceMock.getAll()).thenReturn(TEST_JAVA_QUESTION_SET);
        when(mathQuestionServiceMock.getAll()).thenReturn(TEST_MATH_QUESTION_SET);
        when(javaQuestionServiceMock.getRandomQuestion()).thenReturn(
                new Question("(Java) Вопрос 1", "(Java) Ответ 1"),
                new Question("(Java) Вопрос 2", "(Java) Ответ 2"),
                new Question("(Java) Вопрос 3", "(Java) Ответ 3"),
                new Question("(Java) Вопрос 4", "(Java) Ответ 4"),
                new Question("(Java) Вопрос 5", "(Java) Ответ 5"));
        when(mathQuestionServiceMock.getRandomQuestion()).thenReturn(
                new Question("(Math) Вопрос 1", "(Math) Ответ 1"),
                new Question("(Math) Вопрос 2", "(Math) Ответ 2"),
                new Question("(Math) Вопрос 3", "(Math) Ответ 3"),
                new Question("(Math) Вопрос 4", "(Math) Ответ 4"),
                new Question("(Math) Вопрос 5", "(Math) Ответ 5"));
        Collection<Question> actual = out.getQuestions(5);
        assertThat(actual).containsAnyElementsOf(TEST_JAVA_QUESTION_SET);
        assertThat(actual).containsAnyElementsOf(TEST_MATH_QUESTION_SET);
    }
    @Test
    public void mustThrowAmountIsTooBigException(){
        when(javaQuestionServiceMock.getAll()).thenReturn(TEST_JAVA_QUESTION_SET);
        when(mathQuestionServiceMock.getAll()).thenReturn(TEST_MATH_QUESTION_SET);
        assertThatExceptionOfType(AmountIsTooBigException.class).isThrownBy(()->
                out.getQuestions(TEST_JAVA_QUESTION_SET.size() + TEST_MATH_QUESTION_SET.size()+ 1));
    }
}
