package service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.java.course2.examineservice.exception.NotEnoughQuestionsException;
import pro.sky.java.course2.examineservice.model.Question;
import pro.sky.java.course2.examineservice.service.ExaminerServiceImpl;
import pro.sky.java.course2.examineservice.service.JavaQuestionServiceImpl;
import pro.sky.java.course2.examineservice.service.MathQuestionServiceImpl;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceTest {
    @Mock
    JavaQuestionServiceImpl javaService;

    @Mock
    MathQuestionServiceImpl mathService;

    @InjectMocks
    ExaminerServiceImpl examService;

    @Test
    @DisplayName("Test of getQuestions method - exception if not enough questions")
    void getQuestionsExceptionTest() {
        List<Question> javaQuestionsList = new ArrayList<Question>();

        javaQuestionsList.add(new Question("Question 1", "Answer 1"));
        javaQuestionsList.add(new Question("Question 2", "Answer 2"));

        List<Question> mathQuestionsList = new ArrayList<Question>();
        mathQuestionsList.add(new Question("Math Question 1", "Math Answer 1"));
        mathQuestionsList.add(new Question("Math Question 2", "Math Answer 2"));

        when(javaService.getQuestionsList()).thenReturn(javaQuestionsList);
        when(mathService.getQuestionsList()).thenReturn(mathQuestionsList);
        // ask for number of questions = 5 > when exist = 4
        Assertions.assertThrows(NotEnoughQuestionsException.class, ()->examService.getQuestions(5));
    }

    @Test
    @DisplayName("Test of getQuestions question method")
    void getQuestionsTest() {
        List<Question> javaQuestionsList = new ArrayList<Question>();
        javaQuestionsList.add(new Question("Java Question 1", "Jav Answer 1"));
        javaQuestionsList.add(new Question("Java Question 2", "Jav Answer 2"));

       List<Question> mathQuestionsList = new ArrayList<Question>();
       mathQuestionsList.add(new Question("Math Question 1", "Math Answer 1"));
       mathQuestionsList.add(new Question("Math Question 2", "Math Answer 2"));

        when(javaService.getQuestionsList()).thenReturn(javaQuestionsList);
        when(mathService.getQuestionsList()).thenReturn(mathQuestionsList);
        when(javaService.getRandomQuestion()).thenReturn(javaQuestionsList.get(0));
        when(mathService.getRandomQuestion()).thenReturn(mathQuestionsList.get(0));

        Assertions.assertNotNull(examService.getQuestions(2));
    }


}

