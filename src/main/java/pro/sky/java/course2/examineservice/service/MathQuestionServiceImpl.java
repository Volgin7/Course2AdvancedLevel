package pro.sky.java.course2.examineservice.service;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.examineservice.repository.MathQuestionRepository;

@Service
public class MathQuestionServiceImpl extends QuestionServiceImpl {
    private final MathQuestionRepository repository;

    public MathQuestionServiceImpl(MathQuestionRepository repository) {
        this.repository = repository;
    }

    public MathQuestionRepository getRepository() {
        return repository;
    }
}
