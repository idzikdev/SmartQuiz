package pl.idzikdev.SmartQuiz.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.idzikdev.SmartQuiz.auth.services.UserService;
import pl.idzikdev.SmartQuiz.services.QuestionService;

@Controller
public class ButtonsController {

    @Autowired
    QuestionService service;
    @Autowired
    UserService userService;


    @RequestMapping(value = "/submitButtons", params = "button1", method = RequestMethod.POST)
    public String button1(@RequestParam(name = "id") int id,
                          Model model) {
        String result = "bad";
        if ("a".equals(service.getValidById(Integer.valueOf(id)))) {
            result = "good";
        }
        model.addAttribute("result", result);
        return "buttons-clicked";
    }

    @RequestMapping(value = "/submitButtons", params = "button2", method = RequestMethod.POST)
    public String button2(@RequestParam(name = "id") int id,
                          Model model) {
        String result = "bad";
        if ("b".equals(service.getValidById(Integer.valueOf(id)))) {
            result = "good";
        }
        model.addAttribute("result", result);
        return "buttons-clicked";
    }


    @RequestMapping(value = "/submitButtons", params = "button3", method = RequestMethod.POST)
    public String button3(@RequestParam(name = "id") int id,
                          Model model) {
        String result = "bad";
        if ("c".equals(service.getValidById(Integer.valueOf(id)))) {
            result = "good";
        }
        model.addAttribute("result", result);
        return "buttons-clicked";
    }

    @RequestMapping(value = "/submitButtons", params = "button4", method = RequestMethod.POST)
    public String button4(@RequestParam(name = "id") int id,
                          Model model) {
        String result = "bad";
        if ("d".equals(service.getValidById(Integer.valueOf(id)))) {
            result = "good";
        }
        model.addAttribute("result", result);
        return "buttons-clicked";
    }
}
