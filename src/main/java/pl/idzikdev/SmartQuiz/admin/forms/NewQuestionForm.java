package pl.idzikdev.SmartQuiz.admin.forms;

import lombok.Data;
import pl.idzikdev.SmartQuiz.models.Category;

@Data
public class NewQuestionForm {
    private String question;
    private Category category;
    private String answerA;
    private String answerB;
    private String answerC;
    private String answerD;
    private String valid;
}
