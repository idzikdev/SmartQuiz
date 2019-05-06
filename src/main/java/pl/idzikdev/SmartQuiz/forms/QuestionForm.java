package pl.idzikdev.SmartQuiz.forms;

import lombok.Data;

@Data
public class QuestionForm {
    private String question;
    private String id;
    private String answerA;
    private String answerB;
    private String answerC;
    private String answerD;
}
