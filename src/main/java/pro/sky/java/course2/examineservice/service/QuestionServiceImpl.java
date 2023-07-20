package pro.sky.java.course2.examineservice.service;

import pro.sky.java.course2.examineservice.model.Question;
import pro.sky.java.course2.examineservice.repository.QuestionRepository;

import java.util.*;

public class QuestionServiceImpl implements QuestionService {

    private QuestionRepository repository;

    public QuestionServiceImpl(QuestionRepository repository) {
        this.repository = repository;
    }


    @Override
    public Question add(String question, String answer) {
        return repository.add(question, answer);
    }

    @Override
    public Question remove(String question, String answer) {
        return  repository.remove(question, answer);
    }

    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableList(repository.getAll());
    }

    @Override
    public Question getRandomQuestion(List<Question> questionsList) {
        Random random = new Random();
        if(questionsList.size() == 0) {
            return null;
        }
        int i = random.nextInt(questionsList.size());
        Question randomQuestion = new Question(questionsList.get(i).getQuestion(), questionsList.get(i).getAnswer());
        return randomQuestion;
    }
}
