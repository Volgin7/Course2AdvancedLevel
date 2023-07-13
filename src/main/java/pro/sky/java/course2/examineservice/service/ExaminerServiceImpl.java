package pro.sky.java.course2.examineservice.service;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.examineservice.exception.NotEnoughQuestionsException;
import pro.sky.java.course2.examineservice.model.Question;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final JavaQuestionServiceImpl serviceJQ;
    private final MathQuestionServiceImpl serviceMQ;
    public ExaminerServiceImpl(JavaQuestionServiceImpl serviceJQ, MathQuestionServiceImpl serviceMQ) {
        this.serviceJQ = serviceJQ;
        this.serviceMQ = serviceMQ;
    }

    @Override
    public List<Question> getQuestions(int amount) {
        Set<Question> questions = new HashSet<>();
        if(amount > serviceJQ.getQuestionsList().size() + serviceMQ.getQuestionsList().size()) {
            throw new NotEnoughQuestionsException("Not Enough Questions");
        }
        Random random = new Random();
        int key = random.nextInt(2);
 //       System.out.println("key = " + key);
        while (questions.size() < amount) {
            Question question;
            if(key == 0) {
                question = serviceJQ.getRandomQuestion();
                if(question != null) questions.add(question);
                key = 1;
            } else {
                question = serviceMQ.getRandomQuestion();
                if(question != null) questions.add(question);
                key = 0;
            }
        }
        return List.copyOf(questions);
    }
}