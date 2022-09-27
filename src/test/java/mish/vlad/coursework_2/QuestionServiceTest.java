package mish.vlad.coursework_2;

import mish.vlad.coursework_2.Data.Question;
import mish.vlad.coursework_2.Exceptions.AddNullException;
import mish.vlad.coursework_2.Exceptions.ItemAlreadyAddedException;
import mish.vlad.coursework_2.Exceptions.ItemNotFoundException;
import mish.vlad.coursework_2.Services.JavaQuestionService;
import mish.vlad.coursework_2.Services.QuestionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class QuestionServiceTest {
    private final QuestionService questionService = new JavaQuestionService();


    @BeforeEach
    private void init() {

        questionService.add(new Question("HOW ARE YOU", "FINE"));
        questionService.add(new Question("HOW MUCH IS THe fish", "cheap"));
        questionService.add(new Question("HOW Are you?", "hey Joey"));
        questionService.add(new Question("What is the capital of the great Britain", "London"));

    }


    @Test
    public void adding(){
        assertThrows(AddNullException.class, () -> questionService.add(null));
        assertThrows(AddNullException.class, () -> questionService.add(null ,"jasd"));
        assertThrows(AddNullException.class, () -> questionService.add("WHO ARE YOU ", null));
        assertThrows(ItemAlreadyAddedException.class, () -> questionService.add(new Question("HOW ARE YOU", "FINE")));
    }
    @Test
    public void remove(){
        assertEquals(new Question("HOW Are you?", "hey Joey"), questionService.remove(new Question("HOW Are you?", "hey Joey")));
        assertThrows(ItemNotFoundException.class, () -> questionService.remove(new Question("HOW Are you?", "hey Joey")));
    }

    @Test
    public void getAll(){
        List<Question> questions = new ArrayList<Question>();
        questions.add(new Question("HOW ARE YOU", "FINE"));
        questions.add(new Question("HOW MUCH IS THe fish", "cheap"));
        questions.add(new Question("HOW Are you?", "hey Joey"));
        questions.add(new Question("What is the capital of the great Britain", "London"));
        assertEquals(questions, questionService.getAll());
    }

}
