package com.example.kursovaya___3.Repository;

import com.example.kursovaya___3.Exception.BadRequestException;
import com.example.kursovaya___3.Exception.NotFoundException;
import com.example.kursovaya___3.MODEL.Question;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class  JavaQuestionRepository implements QuestionRepository {
    private final Set<Question> questions = new HashSet<>();

    @PostConstruct
    private void  init(){
        questions.add(new Question("есть прикурить?","неа"));
        questions.add(new Question("а если найду?","ты мусорской чтоли?  Порядочных людей шмонать"));
        questions.add(new Question("а ты за понятия чтоль","неа"));
        questions.add(new Question("а мобилка позвонить есть?","деньги закончились"));
        questions.add(new Question("пойдем пивас пить","гоу"));
    }


    @Override
    public Question  add(Question question) {
        if (question==null){
            throw new BadRequestException();
        }
        questions.add(question);
        return question;
    }

    @Override
    public Question  remove(Question question) {
        if (!questions.contains(question)){
            throw new NotFoundException("question not found");
        }
        questions.remove(question);
        return question;
    }

    @Override
    public Collection<Question>  getAll() {
        return questions;
    }
}
