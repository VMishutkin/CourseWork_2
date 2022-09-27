package mish.vlad.coursework_2;

import mish.vlad.coursework_2.Data.Question;
import mish.vlad.coursework_2.Exceptions.BadAmountException;
import mish.vlad.coursework_2.Services.ExaminerServiceImpl;
import mish.vlad.coursework_2.Services.JavaQuestionService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class ExamServiceTest {

    @InjectMocks
    private ExaminerServiceImpl examinerService;

    @Mock
    private JavaQuestionService questionService;

    @Test
    public void exam(){
        List<Question> questions= new ArrayList<Question>();
        questions.add(new Question("HOW ARE YOU", "FINE"));
        questions.add(new Question("HOW MUCH IS THe fish", "cheap"));
        questions.add(new Question("HOW Are you?", "hey Joey"));
        questions.add(new Question("What is the capital of the great Britain", "London"));

        Mockito.when(questionService.getAll()).thenReturn(questions);
        Assertions.assertEquals(questions, examinerService.getQuestions(4));

        Assertions.assertThrows(BadAmountException.class, () -> examinerService.getQuestions(8));


    }


}
