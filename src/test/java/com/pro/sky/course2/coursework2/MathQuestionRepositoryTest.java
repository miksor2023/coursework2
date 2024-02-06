package com.pro.sky.course2.coursework2;

import com.pro.sky.course2.coursework2.domain.Question;
import com.pro.sky.course2.coursework2.exception.QuestinAlreadyAddedException;
import com.pro.sky.course2.coursework2.exception.QuestionNotFoundException;
import com.pro.sky.course2.coursework2.repository.JavaQuestionRepository;
import com.pro.sky.course2.coursework2.repository.MathQuestionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collection;

import static com.pro.sky.course2.coursework2.TestConstants.TEST_JAVA_QUESTION_SET;
import static com.pro.sky.course2.coursework2.TestConstants.TEST_MATH_QUESTION_SET;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class MathQuestionRepositoryTest {
    private final MathQuestionRepository out = new MathQuestionRepository();
    @BeforeEach
    public void init(){
        out.init();
    }
    @Test
    public void mustAddQuestion() {
        Question expected = new Question("(Math) Вопрос 6", "(Math) Ответ 6");
        Question actual = out.add(new Question("(Math) Вопрос 6", "(Math) Ответ 6"));
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void mustRemoveQuestion() {
        Question expected = new Question("(Math) Вопрос 1", "(Math) Ответ 1");
        Question actual = out.remove(new Question("(Math) Вопрос 1", "(Math) Ответ 1"));
        assertThat(actual).isEqualTo(expected);
    }
    @Test
    public void mustThrowQuestioAlredyAddedException() {
        assertThatExceptionOfType(QuestinAlreadyAddedException.class)
                .isThrownBy(() -> out.add(new Question("(Math) Вопрос 1", "(Math) Ответ 1")));
    }

    @Test
    public void mustThrowQuestionNotFoundException() {
        assertThatExceptionOfType(QuestionNotFoundException.class)
                .isThrownBy(() -> out.remove(new Question("(Math) Вопрос 6", "(Math) Ответ 6")));
    }

    @Test
    public void mustGetAll() {
        Collection<Question> actualQuestions = out.getAll();
        assertThat(actualQuestions).hasSameElementsAs(TEST_MATH_QUESTION_SET);
    }


}
