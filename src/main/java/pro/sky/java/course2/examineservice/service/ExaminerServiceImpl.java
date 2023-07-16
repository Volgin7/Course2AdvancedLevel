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
        if(amount > serviceJQ.getRepository().getAll().size() + serviceMQ.getRepository().getAll().size()) {
           throw new NotEnoughQuestionsException("Not Enough Questions");
        }

        Set<Question> questions = new HashSet<>();
        Random random = new Random();
        int key = random.nextInt(2); // if key == 0 => java  or if key ==1 => math
        while (questions.size() < amount) {
            Question question;
            if(key == 0) {
                question = serviceJQ.getRandomQuestion((List<Question>) serviceJQ.getRepository().getAll());
                if(question != null) questions.add(question);
                key = 1;
            } else {
                question = serviceMQ.getRandomQuestion((List<Question>) serviceMQ.getRepository().getAll());
                if(question != null) questions.add(question);
                key = 0;
            }
        }
        return List.copyOf(questions);
    }
}