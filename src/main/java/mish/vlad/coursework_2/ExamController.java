package mish.vlad.coursework_2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
@RequestMapping("/exam/get")

@RestController
public class ExamController {
    ExaminerService examSerivce;

    public ExamController(ExaminerService examSerivce) {
        this.examSerivce = examSerivce;
    }

    @GetMapping
    public Collection<Question> getQuestions(@RequestParam("amount") int amount) {
        return examSerivce.getQuestions(amount);
    }


}
