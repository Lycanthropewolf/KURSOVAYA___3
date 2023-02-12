package com.example.kursovaya___3.SERVICE;

import com.example.kursovaya___3.Exception.BadRequestException;
import com.example.kursovaya___3.MODEL.Question;
import com.example.kursovaya___3.Repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.Collection;

public class JavaQuestionService  implements QuestionService {
    private final QuestionRepository questionRepository;
    private final UtilService utilService;

    public  JavaQuestionService(@Qualifier("javaQuestionRepository") QuestionRepository questionRepository, UtilService utilService) {
        this.questionRepository = questionRepository;
        this.utilService = utilService;
    }

    @Override
    public Question  add(String question, String answer) {
        if (question == null || question.isBlank()) {
            throw new BadRequestException(" некорректный вопрос");
        }
        if (answer == null || answer.isBlank()) {
            throw new BadRequestException(" некорректный ответ");
        }
        return questionRepository.add(new Question(question, answer));
    }

    @Override
    public Question  add(Question question) {
        return questionRepository.add(question);
    }

    @Override
    public Question  remove(Question question) {
        return questionRepository.remove(question);
    }

    @Override
    public Collection<Question>  getAll() {
        return questionRepository.getAll();
    }

    @Override
    public Question  getRandomQuestion() {
        return utilService.getRandomQuestion(questionRepository.getAll());
    }
}
