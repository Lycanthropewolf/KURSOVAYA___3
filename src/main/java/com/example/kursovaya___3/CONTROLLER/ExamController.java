package com.example.kursovaya___3.CONTROLLER;

import com.example.kursovaya___3.MODEL.Question;
import com.example.kursovaya___3.SERVICE.ExaminerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Collection;

public class ExamController {
    private final ExaminerService examinerService;

    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping("/get/{amount}")
    public Collection<Question> getQuestion(@PathVariable("amount") Integer amount) {
        return examinerService.getQuestion(amount);
    }

}
