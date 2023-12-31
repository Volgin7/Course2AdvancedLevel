package pro.sky.java.course2.examineservice.model;

import java.util.Objects;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Question question1)) return false;
   //     return getQuestion().equals(question1.getQuestion()) && getAnswer().equals(question1.getAnswer());
        return getQuestion().equals(question1.getQuestion()); // if questions are equal => objects are equal
    }

    @Override
    public int hashCode() {
        return Objects.hash(getQuestion(), getAnswer());
    }

    @Override
    public String toString() {
        return "Question{" +
                "question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                '}';
    }
}
