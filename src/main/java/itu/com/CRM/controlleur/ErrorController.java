package itu.com.CRM.controlleur;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ErrorController {

    @GetMapping("/erreur")
    public String showErrorPage(Model model) {
        return "erreur"; 
    }
}