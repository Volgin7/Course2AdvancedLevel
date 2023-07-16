package pro.sky.java.course2.examineservice.service;
import org.springframework.stereotype.Service;
import pro.sky.java.course2.examineservice.repository.JavaQuestionRepository;


// @Qualifier
@Service
public class JavaQuestionServiceImpl extends QuestionServiceImpl {
    private final JavaQuestionRepository repository;

    public JavaQuestionServiceImpl(JavaQuestionRepository repository) {
        this.repository = repository;
    }

    public JavaQuestionRepository getRepository() {
        return repository;
    }
}

