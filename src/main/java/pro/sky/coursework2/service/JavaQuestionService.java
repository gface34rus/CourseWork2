package pro.sky.coursework2.service;

import org.springframework.stereotype.Service;
import pro.sky.coursework2.exception.MyBadRequestException;
import pro.sky.coursework2.model.Question;

import java.util.*;

import static java.util.Collections.unmodifiableCollection;

@Service
public class JavaQuestionService implements QuestionService {
    private Set<Question> questions = new HashSet<>();
    private final Random random = new Random();

    @Override
    public Question addQuestion(String question, String answer) {
        Question questionResult = new Question(question, answer);
        if (questions.contains(questionResult)) {
            throw new MyBadRequestException("Вопрос уже присутствует в базе");
        }
        questions.add(questionResult);
        return questionResult;
    }

    @Override
    public Question addQuestion(Question question) {
        if (questions.contains(question)) {
            throw new MyBadRequestException("Вопрос уже присутствует в базе");
        }
        questions.add(question);
        return question;
    }

    @Override
    public Question removeQuestion(String question, String answer) {
        Question questionResult = new Question(question, answer);
        if (!questions.contains(questionResult)) {
            throw new MyBadRequestException("Вопрос отсутствует в базе");
        }
        questions.remove(questionResult);
        return questionResult;
    }


    @Override
    public Question removeQuestion(Question question) {
        if (!questions.contains(question)) {
            throw new MyBadRequestException("Вопрос отсутствует в базе");
        }
        questions.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAllQuestions() {
        return unmodifiableCollection(questions);
    }

    @Override
    public Question getRandomQuestion() {
        return questions.toArray(new Question[0])[random.nextInt(questions.size())];
    }
}
