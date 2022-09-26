package mish.vlad.coursework_2;

public class Question {
    private String question;
    private String answer;

    public Question(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (this.getClass() != obj.getClass() || obj == null) {
            return false;
        }
        return this.question.equals(((Question) obj).getQuestion()) && this.answer.equals(((Question) obj).getAnswer());

    }


    @Override
    public String toString() {
        return String.format("Question: %s,%nAnswer: %s", question, answer);
    }
}
