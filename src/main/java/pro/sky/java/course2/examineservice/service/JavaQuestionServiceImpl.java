package pro.sky.java.course2.examineservice.service;
import org.springframework.stereotype.Service;
import pro.sky.java.course2.examineservice.repository.JavaQuestionRepository;
import pro.sky.java.course2.examineservice.repository.QuestionRepository;


// @Qualifier
@Service
public class JavaQuestionServiceImpl extends QuestionServiceImpl {
    private JavaQuestionRepository repository;

    public JavaQuestionServiceImpl(JavaQuestionRepository repository) {
        super(repository);
    }

    public JavaQuestionRepository getRepository() {
        return repository;
    }
}

