package mish.vlad.coursework_2.Controllers;

import mish.vlad.coursework_2.Services.JavaQuestionService;
import mish.vlad.coursework_2.Data.Question;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RequestMapping("/java")
@RestController
public class JavaQuestionController {
    private final JavaQuestionService javaQuestionService;

    public JavaQuestionController(JavaQuestionService javaQuestionService) {
        this.javaQuestionService = javaQuestionService;
    }
    @GetMapping("/add")
    public Question add(@RequestParam("question") String question, @RequestParam("answer") String answer){
        return javaQuestionService.add(question,answer);
    }
    @GetMapping("/remove")
    public Question remove(@RequestParam("question")String question,@RequestParam("answer") String answer){
        return javaQuestionService.remove(new Question(question, answer));
    }
@GetMapping
    public Collection<Question> getQuestions(){
        return javaQuestionService.getAll();
    }
    @GetMapping("/test")
    public Question test(){
        return javaQuestionService.getRandomQuestion();
    }


}
