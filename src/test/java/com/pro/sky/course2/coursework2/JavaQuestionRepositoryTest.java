package com.pro.sky.course2.coursework2;

import com.pro.sky.course2.coursework2.domain.Question;
import com.pro.sky.course2.coursework2.exception.QuestinAlreadyAddedException;
import com.pro.sky.course2.coursework2.exception.QuestionNotFoundException;
import com.pro.sky.course2.coursework2.repository.JavaQuestionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.HashSet;

import static org.assertj.core.api.Assertions.*;
import static com.pro.sky.course2.coursework2.TestConstants.TEST_JAVA_QUESTION_SET;

public class JavaQuestionRepositoryTest {
    private final JavaQuestionRepository out = new JavaQuestionRepository();
    @BeforeEach
    public void init(){
        out.init();
    }
    @Test
    public void mustAddQuestion() {
        Question expected = new Question("(Java) Вопрос 6", "(Java) Ответ 6");
        Question actual = out.add(new Question("(Java) Вопрос 6", "(Java) Ответ 6"));
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void mustRemoveQuestion() {
        Question expected = new Question("(Java) Вопрос 1", "(Java) Ответ 1");
        Question actual = out.remove(new Question("(Java) Вопрос 1", "(Java) Ответ 1"));
        assertThat(actual).isEqualTo(expected);
    }
    @Test
    public void mustThrowQuestioAlredyAddedException() {
        assertThatExceptionOfType(QuestinAlreadyAddedException.class)
                .isThrownBy(() -> out.add(new Question("(Java) Вопрос 1", "(Java) Ответ 1")));
    }

    @Test
    public void mustThrowQuestionNotFoundException() {
        assertThatExceptionOfType(QuestionNotFoundException.class)
                .isThrownBy(() -> out.remove(new Question("(Java) Вопрос 6", "(Java) Ответ 6")));
    }

    @Test
    public void mustGetAll() {
        Collection<Question> actualQuestions = out.getAll();
        assertThat(actualQuestions).hasSameElementsAs(TEST_JAVA_QUESTION_SET);
    }


}
