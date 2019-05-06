package pl.idzikdev.SmartQuiz.controllers.rest;

import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.idzikdev.SmartQuiz.auth.services.UserService;
import pl.idzikdev.SmartQuiz.models.Category;
import pl.idzikdev.SmartQuiz.models.Question;
import pl.idzikdev.SmartQuiz.services.QuestionService;

import java.util.List;

@RestController
public class HomeRestContoller {
    @Autowired
    QuestionService service;

    @GetMapping(value = "/questionRest", produces = "application/json")
    public ResponseEntity<List<Question>> getAllQuestions() {
        List<Question> questions = service.findAllByCategory(0);
        if (questions == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else
            return new ResponseEntity<>(questions, HttpStatus.OK);
    }
}
