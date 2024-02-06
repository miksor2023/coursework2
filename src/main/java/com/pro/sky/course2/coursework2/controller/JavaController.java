package com.pro.sky.course2.coursework2.controller;

import com.pro.sky.course2.coursework2.domain.Question;
import com.pro.sky.course2.coursework2.service.QuestionService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/exam/java")
public class JavaController {
    private final QuestionService service;

    public JavaController(@Qualifier("javaQuestionService") QuestionService service) {
        this.service = service;
    }
    @GetMapping("/add")
    public Question addQuestion(@RequestParam(name = "question")  String question,
                                @RequestParam(name = "answer") String answer){
        Question newQuestion = new Question(question, answer);
        return service.add(newQuestion);
    }
    @GetMapping("/get")
    public Collection<Question> getQuestions(){
        return service.getAll();
    };
    @GetMapping("/remove")
    public Question removeQuestion(@RequestParam(name = "question")  String question,
                                   @RequestParam(name = "answer") String answer){
        Question questionToRemove = new Question(question, answer);
        return service.remove(questionToRemove);
    }
}
