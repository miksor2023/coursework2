package com.pro.sky.course2.coursework2;

import com.pro.sky.course2.coursework2.domain.Question;
import com.pro.sky.course2.coursework2.exception.QuestinAlreadyAddedException;
import com.pro.sky.course2.coursework2.exception.QuestionNotFoundException;
import com.pro.sky.course2.coursework2.exception.SetOfQuestionsIsEmptyException;
import com.pro.sky.course2.coursework2.repository.JavaQuestionRepository;
import com.pro.sky.course2.coursework2.service.JavaQuestionService;
import com.pro.sky.course2.coursework2.service.QuestionService;
//import org.junit.jupiter.api.Assertions;
import static com.pro.sky.course2.coursework2.TestConstants.TEST_JAVA_QUESTION_SET;
import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
@ExtendWith(MockitoExtension.class)
public class JavaQuestionServiceTest {
    @Mock
    private JavaQuestionRepository javaQuestionRepositorymock;
    @InjectMocks
    private JavaQuestionService out;

    @Test
    public void mustAddQuestion() {
        Question expected = new Question("(Java) Вопрос 6", "(Java) Ответ 6");
        when(javaQuestionRepositorymock.add(expected)).thenReturn(expected);
        Question actual = out.add(new Question("(Java) Вопрос 6", "(Java) Ответ 6"));
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void mustRemoveQuestion() {
        Question expected = new Question("(Java) Вопрос 1", "(Java) Ответ 1");
        when(javaQuestionRepositorymock.remove(expected)).thenReturn(expected);
        Question actual = out.remove(new Question("(Java) Вопрос 1", "(Java) Ответ 1"));
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void mustGetAll() {
        when(javaQuestionRepositorymock.getAll()).thenReturn(TEST_JAVA_QUESTION_SET);
        Collection<Question> expectedQuestions = TEST_JAVA_QUESTION_SET;
        assertThat(out.getAll()).hasSameElementsAs(expectedQuestions);
    }

    @Test
    public void mustGetRandomQuestion() {
        when(javaQuestionRepositorymock.getAll()).thenReturn(TEST_JAVA_QUESTION_SET);
        assertThat(TEST_JAVA_QUESTION_SET).contains(out.getRandomQuestion());
    }

    @Test
    public void mustThrowSetOfQuestionsIsEmptyException() {
        when(javaQuestionRepositorymock.getAll()).thenReturn(new HashSet<>());
        assertThatExceptionOfType(SetOfQuestionsIsEmptyException.class)
                .isThrownBy(() -> out.getRandomQuestion());
    }

}
