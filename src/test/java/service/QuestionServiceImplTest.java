package service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pro.sky.java.course2.examineservice.model.Question;
import pro.sky.java.course2.examineservice.repository.QuestionRepository;
import pro.sky.java.course2.examineservice.repository.QuestionRepositoryImpl;
import pro.sky.java.course2.examineservice.service.QuestionServiceImpl;

import java.util.Collection;

public class QuestionServiceImplTest {

    private QuestionServiceImpl service;
    @BeforeEach
    public void init() {
        QuestionRepository repository = new QuestionRepositoryImpl();
        service = new QuestionServiceImpl(repository);
    }
    @Test
    @DisplayName("Test of add question method. Positive")
    void addPositiveTest() {
        Question newQuestion = new Question("New question 1", "New answer 1");
        Assertions.assertTrue(service.add("New question 1", "New answer 1").equals(newQuestion));
    }
    @Test
    @DisplayName("Test of add question method. Negative")
    void addNegativeTest() {
        service.add("Question 2","Answer 2");
        Assertions.assertNull(service.add("Question 2","Answer 2"));
    }
    @Test
    @DisplayName("Test of remove question method. Positive")
    void removePositiveTest() {
        service.add("Question 1", "Answer 1");
        Question newQuestion = new Question("Question 1", "Answer 1");
        Assertions.assertTrue(service.remove("Question 1", "Answer 1").equals(newQuestion));
    }
    @Test
    @DisplayName("Test of java question method. Negative")
    void removeNegativeTest() {
        service.add("Question 1", "Answer 1");
        Assertions.assertNull(service.remove("Another Question","Another Answer"));
    }

    @Test
    @DisplayName("Test of getAll question method")
    void getAllTest() {
        Collection<Question> allQuestions;
        service.add("Question 1", "Answer 1");
        service.add("Question 2", "Answer 2");
        allQuestions = service.getAll();
        Assertions.assertEquals(2, allQuestions.size());
        Assertions.assertNotNull (allQuestions);
    }

}

