package pro.sky.java.course2.examineservice.service;

import pro.sky.java.course2.examineservice.model.Question;

import java.util.*;

public class QuestionServiceImpl implements QuestionService {

    private List<Question> questionsList;

    public QuestionServiceImpl() {
        this.questionsList = new ArrayList<>();
    }



    public List<Question> getQuestionsList() {
        return questionsList;
    }

    @Override
    public Question add(String question, String answer) {
        Question newQuestion  = new Question(question,answer);
        if(questionsList.contains(newQuestion)) {
            return null;
        }
        questionsList.add(newQuestion);
        return newQuestion;
    }

    @Override
    public Question remove(String question, String answer) {
        Question questionToRemove = new Question(question, answer);
        if (!questionsList.contains(questionToRemove)) {
            return null;
        }
        questionsList.remove(questionToRemove);
        return questionToRemove;
    }

    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableList(questionsList);
    }

    @Override
    public Question getRandomQuestion() {
        Random random = new Random();
        if(questionsList.size() == 0) {
            return null;
        }
        int i = random.nextInt(questionsList.size());
        Question randomQuestion = new Question(questionsList.get(i).getQuestion(), questionsList.get(i).getAnswer());
        return randomQuestion;
    }


}
