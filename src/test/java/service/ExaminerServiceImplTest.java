package service;

import com.example.kursovaya___3.Exception.BadRequestException;
import org.assertj.core.api.Assertions;
import com.example.kursovaya___3.MODEL.Question;
import com.example.kursovaya___3.SERVICE.ExaminerServiceImpl;
import com.example.kursovaya___3.SERVICE.QuestionService;
import com.example.kursovaya___3.SERVICE.UtilService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import static org.mockito.ArgumentMatchers.anyInt;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {
    @InjectMocks
    private ExaminerServiceImpl out;
    @Mock
    QuestionService questionService;
    @Mock
    UtilService utilService;

    @BeforeEach
    void setUp() {
        out = new ExaminerServiceImpl(List.of(questionService), utilService);
    }

    @Test
    void getQuestionWithCorrectAmount() {
        Question expected = new Question("Question", "Answer");
        Collection<Question> expectedList = Set.of(expected);
        Mockito.when(utilService.getRandomInt(anyInt())).thenReturn(0);
        Mockito.when(questionService.getRandomQuestion()).thenReturn(expected);
        Mockito.when(questionService.getAll()).thenReturn(expectedList);
        Collection<Question> actualList = out.getQuestion(1);
        Assertions.assertThat(actualList).isEqualTo(expectedList);
        Mockito.verify(questionService, Mockito.times(1)).getAll();
        Mockito.verify(questionService, Mockito.times(1)).getRandomQuestion();
        Mockito.verify(utilService, Mockito.times(1)).getRandomInt(anyInt());
    }

    @Test
    void getQuestionWithIncorrectAmount() {
        Mockito.when(questionService.getAll()).thenReturn(Set.of(new Question("Question", "Answer")));
        Assertions.assertThatExceptionOfType(BadRequestException.class).isThrownBy(() -> {
            out.getQuestion(5);
        });
        Mockito.verify(questionService, Mockito.times(1)).getAll();
        Mockito.verify(questionService, Mockito.never()).getRandomQuestion();
        Mockito.verify(utilService, Mockito.never()).getRandomInt(anyInt());
    }

}
