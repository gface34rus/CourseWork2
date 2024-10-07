package pro.sky.coursework2.service;

import org.junit.jupiter.api.Test;
import pro.sky.coursework2.exception.MyBadRequestException;
import pro.sky.coursework2.model.Question;

import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;
import static pro.sky.coursework2.service.TestData.*;

public class JavaQuestionServiceTest {
    private final JavaQuestionService javaQuestionService = new JavaQuestionService();

    @Test
    void shouldAddQuestion_WhenCorrectQuestion_ThenAdd() {

        //test
        Question actual = javaQuestionService.addQuestion(TEST_QUESTION_1);

        //check
        assertThat(actual).isEqualTo(TEST_QUESTION_1);

    }

    @Test
    void shouldAddQuestion_WhenQuestionAlreadyAdded_ThenThrowException() {
        javaQuestionService.addQuestion(TEST_QUESTION_1);
        //test & check
        assertThatExceptionOfType(MyBadRequestException.class)
                .isThrownBy(() -> javaQuestionService.addQuestion(TEST_QUESTION_1));
    }

    @Test
    void shouldAddQuestion_WhenCorrectQuestionAndAnswer_ThenAdd() {
        //test
        Question actual = javaQuestionService.addQuestion(TEST_QUESTION_1.getQuestion(), TEST_QUESTION_1.getAnswer());
        assertThat(actual).isEqualTo(TEST_QUESTION_1);
    }

    @Test
    void shouldAddQuestion_WhenQuestionAndAnswerAlreadyAdded_ThenThrowException() {
        javaQuestionService.addQuestion(TEST_QUESTION_1.getQuestion(), TEST_QUESTION_1.getAnswer());
        //test & check
        assertThatExceptionOfType(MyBadRequestException.class)
                .isThrownBy(() -> javaQuestionService.addQuestion(TEST_QUESTION_1));
    }

    @Test
    void shouldRemoveQuestion_WhenCorrectQuestion_ThenRemove() {
        javaQuestionService.addQuestion(TEST_QUESTION_1);

        // test
        Question actual = javaQuestionService.removeQuestion(TEST_QUESTION_1);

        //check
        Collection<Question> result = javaQuestionService.getAllQuestions();
        assertThat(result).isEmpty();
        assertThat(actual).isEqualTo(TEST_QUESTION_1);

    }

    @Test
    void shouldRemoveQuestion_WhenCorrectQuestionAndAnswer_ThenRemove() {
        javaQuestionService.addQuestion(TEST_QUESTION_1.getQuestion(), TEST_QUESTION_1.getAnswer());

        // test
        Question actual = javaQuestionService.removeQuestion(TEST_QUESTION_1);

        //check
        Collection<Question> result = javaQuestionService.getAllQuestions();
        assertThat(result).isEmpty();
        assertThat(actual).isEqualTo(TEST_QUESTION_1);

    }

    @Test
    void shouldRemoveQuestion_WhenQuestionNotExist_ThenThrowException() {
        // test
        assertThatExceptionOfType(MyBadRequestException.class)
                .isThrownBy(() -> javaQuestionService.removeQuestion(TEST_QUESTION_1));

    }

    @Test
    void shouldReturnAllQuestions() {
        javaQuestionService.addQuestion(TEST_QUESTION_1);
        javaQuestionService.addQuestion(TEST_QUESTION_2);
        javaQuestionService.addQuestion(TEST_QUESTION_3);

        //test
        Collection<Question> actual = javaQuestionService.getAllQuestions();

        //check
        assertThat(actual).hasSize(3);
        assertThat(actual).containsExactlyInAnyOrderElementsOf(getAll());
    }

    @Test
    void shouldReturnRandomQuestion() {
        javaQuestionService.addQuestion(TEST_QUESTION_1);
        javaQuestionService.addQuestion(TEST_QUESTION_2);
        javaQuestionService.addQuestion(TEST_QUESTION_3);

        //test
        Question actual = javaQuestionService.getRandomQuestion();

        //check
        assertThat(getAll()).contains(actual);
    }
}
