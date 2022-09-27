package mish.vlad.coursework_2.Services;

import mish.vlad.coursework_2.Exceptions.BadAmountException;
import mish.vlad.coursework_2.Data.Question;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final JavaQuestionService questionService;

    public ExaminerServiceImpl(JavaQuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        if (amount > questionService.getAll().size() || amount< 1) {
            throw new BadAmountException();
        }
        if (amount == questionService.getAll().size()) {
            return questionService.getAll();
        }

        List<Question> questionList = new ArrayList<Question>();
        int qCounter = 0;
        do {
            Question question = questionService.getRandomQuestion();
            if (!questionList.contains(question)) {
                questionList.add(question);
                qCounter++;
            }
        } while (qCounter < amount);

        return questionList;

    }

}

