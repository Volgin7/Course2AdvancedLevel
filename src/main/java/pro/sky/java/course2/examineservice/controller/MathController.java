package pro.sky.java.course2.examineservice.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.course2.examineservice.model.Question;
import pro.sky.java.course2.examineservice.service.MathQuestionServiceImpl;

import java.util.Collection;

@RestController
@RequestMapping("/exam/math")
public class MathController {
    private final MathQuestionServiceImpl serviceMQ;

    public MathController(MathQuestionServiceImpl serviceMQ) {
        this.serviceMQ = serviceMQ;
    }

    @GetMapping("/add")
    public Question addQuestion(@RequestParam String question, @RequestParam String answer) {
        return serviceMQ.getRepository().add(question, answer);
    }

    @GetMapping("/remove")
    public Question removeQuestion(@RequestParam String question, @RequestParam String answer) {
        return serviceMQ.getRepository().remove(question, answer);
    }
    @GetMapping
    public Collection<Question> getAll() {
        return serviceMQ.getRepository().getAll();
    }

}
