package com.example.kursovaya___3.SERVICE;

import com.example.kursovaya___3.Exception.BadRequestException;
import com.example.kursovaya___3.MODEL.Question;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ExaminerServicemImpl implements ExaminerService {
    private final List<QuestionService> questionServices;
    private final UtilService utilService;

    public ExaminerServicemImpl(List<QuestionService> questionServices, UtilService utilService) {
        this.questionServices = questionServices;
        this.utilService = utilService;
    }

    @Override
    public Collection<Question> getQuestion(int amount) {
        if (amount <= 0 || calculateAmountOfQuestions() < amount) {
            throw new BadRequestException("incorrect amount");
        }
        Set<Question> result = new HashSet<>();
        while (result.size() < amount) {
            var serviceNamber = utilService.getRandomInt(questionServices.size());
            var questionService = questionServices.get(serviceNamber);
            result.add(questionService.getRandomQuestion());
        }
        return result;
    }

    private int calculateAmountOfQuestions() {
        return questionServices.stream().mapToInt(s -> s.getAll().size()).sum();
    }


}
