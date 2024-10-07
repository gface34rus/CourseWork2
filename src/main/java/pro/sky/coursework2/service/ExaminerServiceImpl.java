package pro.sky.coursework2.service;

import org.springframework.stereotype.Service;
import pro.sky.coursework2.exception.MyBadRequestException;
import pro.sky.coursework2.exception.QuestionAmountMismatchException;
import pro.sky.coursework2.model.Question;

import java.util.*;

@Service
public class  ExaminerServiceImpl implements ExaminerService {
    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        Collection<Question> allQuestions = questionService.getAllQuestions();
        if (amount < 0 || amount > allQuestions.size()) {
            throw new QuestionAmountMismatchException("Недостаточно уникальных вопросов");
        }
        if (amount == allQuestions.size()) {
            return allQuestions;
        }
        Set<Question> resultSet = new HashSet<>();
        while (resultSet.size() < amount) {
            resultSet.add(questionService.getRandomQuestion());
        }

        return resultSet;
    }
}
