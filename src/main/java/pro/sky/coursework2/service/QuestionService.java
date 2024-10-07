package pro.sky.coursework2.service;

import pro.sky.coursework2.model.Question;

import java.util.Collection;
import java.util.List;

public interface QuestionService {
    Question addQuestion(String question, String answer);

    Question addQuestion(Question question);

    Question removeQuestion(String question, String answer);

    Question removeQuestion(Question question);

    Collection<Question> getAllQuestions();

    Question getRandomQuestion();
}
