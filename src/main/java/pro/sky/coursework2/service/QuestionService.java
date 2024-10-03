package pro.sky.coursework2.service;

import pro.sky.coursework2.model.Question;

import java.util.List;

public interface QuestionService {
    void addQuestion(Question question);

    void removeQuestion(Question question);

    List<Question> getAllQuestions();

    Question getRandomQuestion();
}
