package mish.vlad.coursework_2;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private JavaQuestionService questionService;

    public ExaminerServiceImpl(JavaQuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        if (amount > questionService.getAll().size()) {
            throw new BadAmountException();
        }
        if (amount == questionService.getAll().size()) {
            return questionService.getAll();
        }
        if (amount < 1) {
            throw new NullPointerException();
        }
        List<Question> questionList = new ArrayList<Question>();
        int qCounter = 0;
        do {
            Question question = questionService.getRandomQuestion();
            if (!questionList.contains(question)) {
                questionList.add(question);
                qCounter++;
            }
        } while (qCounter <= amount);
        System.out.println(questionList);
        return questionList;
    }

}

