package pro.sky.coursework2.service;

import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;
import pro.sky.coursework2.exception.MyBadRequestException;
import pro.sky.coursework2.model.Question;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final JavaQuestionService javaQuestionService;

    public ExaminerServiceImpl(JavaQuestionService javaQuestionService) {
        this.javaQuestionService = javaQuestionService;
    }

    @Override
    public List<Question> getQuestions(int amount)  {
        Set<Question> uniqueQuestions = new HashSet<>();

        while (uniqueQuestions.size() < amount) {
            uniqueQuestions.add(javaQuestionService.getRandomQuestion());
            if (uniqueQuestions.size() >= javaQuestionService.getAllQuestions().size()) {
                throw new MyBadRequestException("Недостаточно уникальных вопросов");
            }
        }
        return List.copyOf(uniqueQuestions);
    }
}
