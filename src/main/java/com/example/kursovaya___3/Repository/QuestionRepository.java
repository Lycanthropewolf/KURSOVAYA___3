package com.example.kursovaya___3.Repository;

import com.example.kursovaya___3.MODEL.Question;

import java.util.Collection;

public interface  QuestionRepository {
    Question  add(Question question);

    Question remove(Question question);

    Collection<Question>  getAll();
}
