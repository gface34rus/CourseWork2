package pro.sky.coursework2.service;

import org.apache.coyote.BadRequestException;
import pro.sky.coursework2.model.Question;

import java.util.Collection;
import java.util.List;

public interface  ExaminerService {
    Collection<Question> getQuestions(int amount)
            throws BadRequestException;

}
