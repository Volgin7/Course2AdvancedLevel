package pro.sky.java.course2.examineservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.course2.examineservice.model.Question;
import pro.sky.java.course2.examineservice.service.ExaminerServiceImpl;

import java.util.Collection;

@RestController
@RequestMapping("/exam/java")
public class ExamController {
    private final ExaminerServiceImpl serviceExam;
    public ExamController(ExaminerServiceImpl serviceExam) { this.serviceExam = serviceExam;}
    @GetMapping("/get/{amount}")
    public Collection<Question> getQuestions(@PathVariable int amount) {
        return  serviceExam.getQuestions(amount);
    }
}