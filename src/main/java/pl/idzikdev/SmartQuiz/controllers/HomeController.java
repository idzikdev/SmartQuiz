package pl.idzikdev.SmartQuiz.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.idzikdev.SmartQuiz.auth.services.UserService;
import pl.idzikdev.SmartQuiz.models.Category;
import pl.idzikdev.SmartQuiz.models.Question;
import pl.idzikdev.SmartQuiz.services.QuestionService;

import java.util.List;
import java.util.logging.Logger;

@Controller
public class HomeController {
    @Autowired
    QuestionService service;
    @Autowired
    UserService userService;

    @GetMapping("/index")
    public String saveTestQuestion(Model model){
        model.addAttribute("pytanko","tekst");
        return "index";
    }
    @GetMapping("/questions")
    public String getAllQuestions(Model model){
        List<Question> questions=service.findAllByCategory(Category.FIZYKA);
        model.addAttribute("questions",questions);
        return "questions";
    }

    @GetMapping("/randomQuestion")
    public String getRandomQuestion(Model model){
        Question question=service.getRandomQuestions();
        model.addAttribute("question",question);
        return "showRandomQuestion";
    }

    @PostMapping("/submitQuestion")
    public String sumbitQuestion(@RequestParam(name = "answer") String answer,
                                 @RequestParam(name = "id") String id,
                                 Model model){
        //TODO id= numer pytania, pobrać valid z tego pytania z bazy
        //TODO i porównać z przesłanym answer
        String result="błędna odpowiedź :-(";
        if (answer.equals(service.getValidById(Integer.valueOf(id)))){
            result="dobra odpowiedź :-)";
        }
//        System.out.println("Valid "+answer);
//        System.out.println("Id "+id);
        model.addAttribute("result",result);
        model.addAttribute("login",userService.getUserDto().getLogin());
        model.addAttribute("role",userService.getUserDto().getRole());
        model.addAttribute("score",userService.getUserDto().getScore());
        return "redirect:/randomQuestion";
    }
}
