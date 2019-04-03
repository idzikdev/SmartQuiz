package pl.idzikdev.SmartQuiz.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.idzikdev.SmartQuiz.services.SystemService;

@Controller
@RequestMapping("/admin/")
public class AdminController {
    @Autowired
    SystemService service;

    @GetMapping("addQuestions")
    public String addQuestions() {
        return null;
    }

}
