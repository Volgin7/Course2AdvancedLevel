package pro.sky.java.course2.examineservice.service;

import pro.sky.java.course2.examineservice.model.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestions(int amount);
}
