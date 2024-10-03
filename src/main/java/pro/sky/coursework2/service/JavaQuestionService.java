package pro.sky.coursework2.service;

import org.springframework.stereotype.Service;
import pro.sky.coursework2.model.Question;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class JavaQuestionService implements QuestionService {
    private List<Question> questions = new ArrayList<>();
    private Random random = new Random();

    @Override
    public void addQuestion(Question question) {
        questions.add(question);
    }

    @Override
    public void removeQuestion(Question question) {
        questions.remove(question);
    }

    @Override
    public List<Question> getAllQuestions() {
        return new ArrayList<>(questions);
    }

    @Override
    public Question getRandomQuestion() {
        if (questions.isEmpty()) {
            throw new IllegalStateException("Нет доступных вопросов");
        }
        int index = random.nextInt(questions.size());
        return questions.get(index);
    }
}
