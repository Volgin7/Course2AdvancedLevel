package pro.sky.java.course2.examineservice.service;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.examineservice.repository.JavaQuestionRepository;
import pro.sky.java.course2.examineservice.repository.MathQuestionRepository;

@Service
public class MathQuestionServiceImpl extends QuestionServiceImpl {
    private MathQuestionRepository repository;


    public MathQuestionServiceImpl(MathQuestionRepository repository) {
        super(repository);
    }

    public MathQuestionRepository getRepository() {
        return repository;
    }
}
