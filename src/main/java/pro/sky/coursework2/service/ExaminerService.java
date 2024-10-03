package pro.sky.coursework2.service;

import org.apache.coyote.BadRequestException;
import pro.sky.coursework2.model.Question;

import java.util.List;

public interface ExaminerService {
    List<Question> getQuestions(int amount) throws BadRequestException;

}
