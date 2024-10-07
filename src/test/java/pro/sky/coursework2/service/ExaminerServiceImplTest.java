package pro.sky.coursework2.service;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.coursework2.exception.MyBadRequestException;
import pro.sky.coursework2.exception.QuestionAmountMismatchException;
import pro.sky.coursework2.model.Question;
import pro.sky.coursework2.service.ExaminerServiceImpl;
import pro.sky.coursework2.service.JavaQuestionService;

import java.util.Collection;
import java.util.List;

import static org.apache.commons.lang3.RandomUtils.nextInt;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;
import static pro.sky.coursework2.service.TestData.*;
import static org.assertj.core.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {
    @Mock
    private JavaQuestionService javaQuestionService;
    @InjectMocks
    private ExaminerServiceImpl examinerService;

    @BeforeEach
    public void setUp() {
        when(javaQuestionService.getAllQuestions()).thenReturn(getAll());
    }

    @Test
    void shouldReturnCollectionOfRandomQuestions() {
        when(javaQuestionService.getRandomQuestion()).thenReturn(
                TEST_QUESTION_1,
                TEST_QUESTION_2,
                TEST_QUESTION_3
        );

        // test
        Collection<Question> actual = examinerService.getQuestions(2);

        //check
        assertThat(getAll()).containsAnyElementsOf(actual);

        verify(javaQuestionService, times(1)).getAllQuestions();
        verify(javaQuestionService, times(2)).getRandomQuestion();
    }

    @Test
    void shouldReturnAllQuestionsDoNotSendOutServiceAgain() {
        int amount = 3;
        // test
        Collection<Question> actual = examinerService.getQuestions(amount);

        //check
        assertThat(getAll()).containsAnyElementsOf(actual);

        verify(javaQuestionService, times(1)).getAllQuestions();
        verify(javaQuestionService, never()).getRandomQuestion();
    }

    @Test
    void shouldThrowException() {

        // test
        assertThatExceptionOfType(QuestionAmountMismatchException.class).
                isThrownBy(() -> examinerService.getQuestions(4));
    }
}
