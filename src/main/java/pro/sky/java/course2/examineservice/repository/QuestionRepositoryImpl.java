package pro.sky.java.course2.examineservice.repository;

import org.springframework.stereotype.Repository;
import pro.sky.java.course2.examineservice.model.Question;
import pro.sky.java.course2.examineservice.repository.QuestionRepository;

import java.util.*;
@Repository
public class QuestionRepositoryImpl implements QuestionRepository {

    private List<Question> questionsList;

    public QuestionRepositoryImpl() {
        this.questionsList = new ArrayList<>();
    }
    public List<Question> getAll() {
        return questionsList;
    }


}
