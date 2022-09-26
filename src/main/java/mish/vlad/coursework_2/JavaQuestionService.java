package mish.vlad.coursework_2;

import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {
    private List<Question> examQuestions;

    public JavaQuestionService() {
        this.examQuestions = new ArrayList<Question>();
    }

    @Override
    public Question add(String question, String answer) {
        if (question == null || answer == null) {
            throw new AddNullException();
        }
        if (examQuestions.contains(new Question(question, answer))) {
            throw new ItemAlreadyAddedException();
        }
        examQuestions.add(new Question(question, answer));
        return new Question(question, answer);
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
        Random random = new Random();
        return examQuestions.get(random.nextInt(examQuestions.size()));

    }

}
