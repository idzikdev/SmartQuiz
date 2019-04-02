package pl.idzikdev.SmartQuiz.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.idzikdev.SmartQuiz.models.Category;
import pl.idzikdev.SmartQuiz.models.Question;
import pl.idzikdev.SmartQuiz.services.QuestionService;

import java.util.logging.Logger;

@Controller
public class HomeController {
    @Autowired
    QuestionService service;

    @GetMapping("/index")
    public String saveTestQuestion(Model model){
        Question question=new Question()
                .builder()
                .category(Category.INFORMATYKA)
                .question("Pytanko")
                .build();
        System.out.println(question);
        service.saveQuestion(question);
        model.addAttribute("pytanko","tekst");
        return "index";
    }
}
