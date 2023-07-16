package pro.sky.java.course2.examineservice.service;

import pro.sky.java.course2.examineservice.model.Question;

import java.util.List;
import java.util.Random;

public class QuestionServiceImpl implements QuestionService{
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
