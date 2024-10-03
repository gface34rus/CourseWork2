package pro.sky.coursework2.service;

import org.junit.jupiter.api.Test;
import pro.sky.coursework2.exception.MyBadRequestException;
import pro.sky.coursework2.model.Question;
import pro.sky.coursework2.service.ExaminerServiceImpl;
import pro.sky.coursework2.service.JavaQuestionService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ExaminerServiceImplTest {

    private final JavaQuestionService mockJavaQuestionService = mock(JavaQuestionService.class);
    private final ExaminerServiceImpl examinerService = new ExaminerServiceImpl(mockJavaQuestionService);

    @Test
    void testGetUniqueQuestions() {
        when(mockJavaQuestionService.
                getRandomQuestion()).thenReturn(new Question("Вопрос 1", "Ответ 1"));
        when(mockJavaQuestionService.
                getAllQuestions()).
                thenReturn(List.of(new Question("Вопрос 1", "Ответ 1"),
                        new Question("Вопрос 2", "Ответ 2")));

        List<Question> questions = examinerService.getQuestions(1);
        assertEquals(1, questions.size());
    }

    @Test
    void testNotEnoughUniqueQuestionsThrowsException() {
        when(mockJavaQuestionService.
                getRandomQuestion()).thenReturn(new Question("Вопрос 1", "Ответ 1"));
        when(mockJavaQuestionService.
                getAllQuestions()).thenReturn(List.of(new Question("Вопрос 1", "Ответ 1")));

        Exception exception = assertThrows(MyBadRequestException.class, () -> examinerService.getQuestions(2));
        assertEquals("Недостаточно уникальных вопросов", exception.getMessage());
    }
}
