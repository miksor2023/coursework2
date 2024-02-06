package com.pro.sky.course2.coursework2;

import com.pro.sky.course2.coursework2.domain.Question;
import com.pro.sky.course2.coursework2.exception.SetOfQuestionsIsEmptyException;
import com.pro.sky.course2.coursework2.repository.JavaQuestionRepository;
import com.pro.sky.course2.coursework2.repository.MathQuestionRepository;
import com.pro.sky.course2.coursework2.service.JavaQuestionService;
import com.pro.sky.course2.coursework2.service.MathQuestionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

import static com.pro.sky.course2.coursework2.TestConstants.TEST_MATH_QUESTION_SET;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MathQuestionServiceTest {
    @Mock
    private MathQuestionRepository mathQuestionRepositorymock;
    @InjectMocks
    private MathQuestionService out;

    @Test
    public void mustAddQuestion() {
        Question expected = new Question("(Math) Вопрос 6", "(Math) Ответ 6");
        when(mathQuestionRepositorymock.add(expected)).thenReturn(expected);
        Question actual = out.add(new Question("(Math) Вопрос 6", "(Math) Ответ 6"));
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void mustRemoveQuestion() {
        Question expected = new Question("(Math) Вопрос 1", "(Math) Ответ 1");
        when(mathQuestionRepositorymock.remove(expected)).thenReturn(expected);
        Question actual = out.remove(new Question("(Math) Вопрос 1", "(Math) Ответ 1"));
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void mustGetAll() {
        when(mathQuestionRepositorymock.getAll()).thenReturn(TEST_MATH_QUESTION_SET);
        Collection<Question> expectedQuestions = TEST_MATH_QUESTION_SET;
        assertThat(out.getAll()).hasSameElementsAs(expectedQuestions);
    }

    @Test
    public void mustGetRandomQuestion() {
        when(mathQuestionRepositorymock.getAll()).thenReturn(TEST_MATH_QUESTION_SET);
        assertThat(TEST_MATH_QUESTION_SET).contains(out.getRandomQuestion());
    }

    @Test
    public void mustThrowSetOfQuestionsIsEmptyException() {
        when(mathQuestionRepositorymock.getAll()).thenReturn(new HashSet<>());
        assertThatExceptionOfType(SetOfQuestionsIsEmptyException.class)
                .isThrownBy(() -> out.getRandomQuestion());
    }

}
