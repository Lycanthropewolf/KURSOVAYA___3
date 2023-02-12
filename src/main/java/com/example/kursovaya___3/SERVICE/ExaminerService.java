package com.example.kursovaya___3.SERVICE;

import com.example.kursovaya___3.MODEL.Question;

import java.util.Collection;

public interface ExaminerService {

    Collection<Question> getQuestion(int amount);
}
