package pro.sky.coursework2.controller;

import org.apache.coyote.BadRequestException;
import org.springframework.web.bind.annotation.*;
import pro.sky.coursework2.model.Question;
import pro.sky.coursework2.service.ExaminerService;


import java.util.Collection;
import java.util.List;


@RestController
@RequestMapping("/exam")
public class ExamController {
    private final ExaminerService examinerService;

    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping("/get/{amount}")
    public Collection<Question> getQuestions(@PathVariable int amount) throws BadRequestException {
        return examinerService.getQuestions(amount);
    }
}
