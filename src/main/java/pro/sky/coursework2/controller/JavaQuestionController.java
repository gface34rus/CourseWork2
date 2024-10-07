package pro.sky.coursework2.controller;

import org.springframework.web.bind.annotation.*;
import pro.sky.coursework2.model.Question;
import pro.sky.coursework2.service.JavaQuestionService;
import pro.sky.coursework2.service.QuestionService;

import java.util.Collection;

@RestController
@RequestMapping("/exam/java")
public class JavaQuestionController {
    private final QuestionService questionService;

    public JavaQuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/add")
    public Question addQuestion(@RequestParam String question, @RequestParam String answer) {
        return questionService.addQuestion(question, answer);
    }

    @GetMapping("/remove")
    public Question removeQuestion(@RequestParam String question, @RequestParam String answer) {
        return questionService.removeQuestion(new Question(question, answer));
    }

    @GetMapping
    public Collection<Question> getAllQuestions() {
        return questionService.getAllQuestions();
    }
}
