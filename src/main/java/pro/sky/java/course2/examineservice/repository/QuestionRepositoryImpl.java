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

    @Override
    public Question add(String question, String answer) {
        Question newQuestion  = new Question(question,answer);
        if(this.questionsList.contains(newQuestion)) {
            return null;
        }
        this.questionsList.add(newQuestion);
        return newQuestion;
    }

    @Override
    public Question remove(String question, String answer) {
        Question questionToRemove = new Question(question, answer);
        if (!this.questionsList.contains(questionToRemove)) {
            return null;
        }
        this.questionsList.remove(questionToRemove);
        return questionToRemove;
    }


}
