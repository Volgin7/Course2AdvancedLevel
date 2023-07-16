package service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pro.sky.java.course2.examineservice.model.Question;
import pro.sky.java.course2.examineservice.repository.QuestionRepository;
import pro.sky.java.course2.examineservice.repository.QuestionRepositoryImpl;

import java.util.Collection;

public class QuestionRepositoryImplTest {

    private QuestionRepository repository;
    @BeforeEach
    public void init() {
        repository = new QuestionRepositoryImpl();
    }
    @Test
    @DisplayName("Test of add question method. Positive")
    void addPositiveTest() {
        Question newQuestion = new Question("New question 1", "New answer 1");
        Assertions.assertTrue(repository.add("New question 1", "New answer 1").equals(newQuestion));
    }
    @Test
    @DisplayName("Test of add question method. Negative")
    void addNegativeTest() {
        repository.add("Question 2","Answer 2");
        Assertions.assertNull(repository.add("Question 2","Answer 2"));
    }
    @Test
    @DisplayName("Test of remove question method. Positive")
    void removePositiveTest() {
        repository.add("Question 1", "Answer 1");
        Question newQuestion = new Question("Question 1", "Answer 1");
        Assertions.assertTrue(repository.remove("Question 1", "Answer 1").equals(newQuestion));
    }
    @Test
    @DisplayName("Test of java question method. Negative")
    void removeNegativeTest() {
        repository.add("Question 1", "Answer 1");
        Assertions.assertNull(repository.remove("Another Question","Another Answer"));
    }

    @Test
    @DisplayName("Test of getAll question method")
    void getAllTest() {
        Collection<Question> allQuestions;
        repository.add("Question 1", "Answer 1");
        repository.add("Question 2", "Answer 2");
        allQuestions = repository.getAll();
        Assertions.assertEquals(2, allQuestions.size());
        Assertions.assertNotNull (allQuestions);
    }

}

