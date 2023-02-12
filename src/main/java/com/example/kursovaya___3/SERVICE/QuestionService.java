package com.example.kursovaya___3.SERVICE;

import com.example.kursovaya___3.MODEL.Question;

import java.util.Collection;

public interface QuestionService {
    Question add(String question, String answer);

    Question add(Question question);

    Question remove(Question question);

    Collection<Question> getAll();

    Question getRandomQuestion();

}
