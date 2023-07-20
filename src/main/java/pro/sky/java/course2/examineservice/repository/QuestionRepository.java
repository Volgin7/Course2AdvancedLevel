package pro.sky.java.course2.examineservice.repository;

import pro.sky.java.course2.examineservice.model.Question;

import java.util.Collection;
import java.util.List;

public interface QuestionRepository {

    Question add(String question, String answer);
    Question remove(String question, String answer);
    List<Question> getAll();

  //  Collection<Question> getAll();
}
