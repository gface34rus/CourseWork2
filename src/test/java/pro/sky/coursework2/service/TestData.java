package pro.sky.coursework2.service;

import pro.sky.coursework2.model.Question;

import java.util.Collection;
import java.util.List;

public class TestData {
    public final static Question TEST_QUESTION_1 = new Question("Что такое String?",
            "Это объект, который представляет последовательность символов.");
    public final static Question TEST_QUESTION_2 = new Question("Что такое int?",
            " Это целочисленная переменная.");
    public final static Question TEST_QUESTION_3 = new Question("Что такое Класс?",
            "Класс представляет собой шаблон или модель, по которой создаются объекты.");

    public static Collection<Question> getAll() {
        return List.of(TEST_QUESTION_1, TEST_QUESTION_2, TEST_QUESTION_3);
    }
}
