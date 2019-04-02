package pl.idzikdev.SmartQuiz.auth.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.idzikdev.SmartQuiz.auth.services.UserSession;

@Controller
public class MainController {
    @Autowired
    UserSession userSession;

    @GetMapping("/main")
    public String main(){
        return "main";
    }

    @GetMapping("/")
    public String index(){
        if(!userSession.isLogin()){
            return "redirect:/main";
        }
        return "index";
    }

    @PostMapping("/")
    public String index(Model model) {
        if(!userSession.isLogin()){
            return "redirect:/auth/login";
        }
        return "index";
    }
}
