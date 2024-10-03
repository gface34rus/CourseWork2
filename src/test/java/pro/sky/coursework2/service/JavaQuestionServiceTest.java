package pro.sky.coursework2.service;

import org.junit.jupiter.api.Test;
import pro.sky.coursework2.model.Question;

import static org.junit.jupiter.api.Assertions.*;

public class JavaQuestionServiceTest {
    private final JavaQuestionService service = new JavaQuestionService();

    @Test
    void testAddAndGetAllQuestions() {
        service.addQuestion(new Question("Вопрос 1", "Ответ 1"));
        assertEquals(1, service.getAllQuestions().size());
    }

    @Test
    void testRemoveQuestion() {
        Question question = new Question("Вопрос 1", "Ответ 1");
        service.addQuestion(question);
        service.removeQuestion(question);
        assertTrue(service.getAllQuestions().isEmpty());
    }

    @Test
    void testGetRandomQuestion() {
        service.addQuestion(new Question("Вопрос 1", "Ответ 1"));
        assertNotNull(service.getRandomQuestion());
    }
}
