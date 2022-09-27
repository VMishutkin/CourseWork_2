package mish.vlad.coursework_2.Services;

import mish.vlad.coursework_2.Exceptions.AddNullException;
import mish.vlad.coursework_2.Exceptions.ItemAlreadyAddedException;
import mish.vlad.coursework_2.Exceptions.ItemNotFoundException;
import mish.vlad.coursework_2.Data.Question;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {
    private final List<Question> examQuestions;
    private final Random random;

    public JavaQuestionService() {
        this.examQuestions = new ArrayList<Question>();
        this.random = new Random();
    }

    @Override
    public Question add(String question, String answer) {
        return add(new Question(question, answer));
    }

    @Override
    public Question add(Question question) {
        if (question == null) {
            throw new AddNullException();
        }
        if (examQuestions.contains(question)) {
            throw new ItemAlreadyAddedException();
        }
        examQuestions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        if (examQuestions.contains(question)) {
            examQuestions.remove(question);
            return question;
        } else {
            throw new ItemNotFoundException();
        }

    }

    @Override
    public Collection<Question> getAll() {
        if (examQuestions == null) {
            throw new ItemNotFoundException();
        }
        return examQuestions;
    }

    @Override
    public Question getRandomQuestion() {

        return examQuestions.get(random.nextInt(examQuestions.size()));

    }

}
