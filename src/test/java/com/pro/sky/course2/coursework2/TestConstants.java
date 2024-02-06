package com.pro.sky.course2.coursework2;

import com.pro.sky.course2.coursework2.domain.Question;

import java.util.Set;

public class TestConstants {
    public static final Set<Question> TEST_JAVA_QUESTION_SET = Set.of(
            new Question("(Java) Вопрос 1", "(Java) Ответ 1"),
            new Question("(Java) Вопрос 2", "(Java) Ответ 2"),
            new Question("(Java) Вопрос 3", "(Java) Ответ 3"),
            new Question("(Java) Вопрос 4", "(Java) Ответ 4"),
            new Question("(Java) Вопрос 5", "(Java) Ответ 5"));

    public static final Set<Question> TEST_MATH_QUESTION_SET = Set.of(
            new Question("(Math) Вопрос 1", "(Math) Ответ 1"),
            new Question("(Math) Вопрос 2", "(Math) Ответ 2"),
            new Question("(Math) Вопрос 3", "(Math) Ответ 3"),
            new Question("(Math) Вопрос 4", "(Math) Ответ 4"),
            new Question("(Math) Вопрос 5", "(Math) Ответ 5"));
}
