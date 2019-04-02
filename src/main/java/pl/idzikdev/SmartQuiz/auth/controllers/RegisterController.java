package pl.idzikdev.SmartQuiz.auth.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.idzikdev.SmartQuiz.auth.forms.RegisterForm;
import pl.idzikdev.SmartQuiz.auth.services.UserService;

@Controller
@RequestMapping("/auth")
public class RegisterController {
    @Autowired
    UserService service;

    @GetMapping("register")
    public String register(Model model) {
        model.addAttribute("registerForm", new RegisterForm());
        return "register";
    }

    @PostMapping("register")
    public String register(@ModelAttribute RegisterForm registerForm,
                           Model model) {
        if (!service.registerUser(registerForm)) {
            model.addAttribute("info", "Login is already in use");
            return "register";
        }
        return "redirect:/auth/login";
    }
}