package pro.sky.java.course2.examineservice.repository;

import pro.sky.java.course2.examineservice.model.Question;

import java.util.Collection;
import java.util.List;

public interface QuestionRepository {
    List<Question> getAll();
}
