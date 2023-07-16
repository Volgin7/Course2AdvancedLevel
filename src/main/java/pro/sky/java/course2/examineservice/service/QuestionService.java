package pro.sky.java.course2.examineservice.service;

import pro.sky.java.course2.examineservice.model.Question;

import java.util.List;

public interface QuestionService {
    Question getRandomQuestion(List<Question> questionsList);
}
