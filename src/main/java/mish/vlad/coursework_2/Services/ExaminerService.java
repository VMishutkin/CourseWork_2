package mish.vlad.coursework_2.Services;

import mish.vlad.coursework_2.Data.Question;

import java.util.Collection;

public interface ExaminerService {


    Collection<Question> getQuestions(int amount);
}
