package com.pro.sky.course2.coursework2;

import com.pro.sky.course2.coursework2.domain.Question;
import com.pro.sky.course2.coursework2.exception.AmountIsTooBigException;
import com.pro.sky.course2.coursework2.service.ExaminerServiceImpl;
import com.pro.sky.course2.coursework2.service.JavaQuestionService;
import com.pro.sky.course2.coursework2.service.QuestionService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.*;

import static com.pro.sky.course2.coursework2.TestConstants.TEST_QUESTION_SET;
import static org.mockito.Mockito.when;
@ExtendWith(MockitoExtension.class)
public class ExaminerServiсeImplTest {
    @Mock
    private JavaQuestionService javaQuestionServiceMock;
    @InjectMocks
    private ExaminerServiceImpl out;
    @Test
    public void mustReturnRandomQuestionSet(){
        when(javaQuestionServiceMock.getAll()).thenReturn(TEST_QUESTION_SET);
        when(javaQuestionServiceMock.getRandomQuestion()).thenReturn(
                new Question("Вопрос 1", "Ответ 1"),
                new Question("Вопрос 2", "Ответ 2"),
                new Question("Вопрос 2", "Ответ 2"),
                new Question("Вопрос 3", "Ответ 3"));
        assertThat(out.getQuestions(3)).containsAnyElementsOf(TEST_QUESTION_SET);
    }
    @Test
    public void mustThrowAmountIsTooBigException(){
        when(javaQuestionServiceMock.getAll()).thenReturn(TEST_QUESTION_SET);
        assertThatExceptionOfType(AmountIsTooBigException.class).isThrownBy(()-> out.getQuestions(TEST_QUESTION_SET.size() + 1));
    }
}
