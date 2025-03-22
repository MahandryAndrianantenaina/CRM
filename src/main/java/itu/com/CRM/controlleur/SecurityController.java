package itu.com.CRM.controlleur;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import itu.com.CRM.features.request.LoginRequest;
import itu.com.CRM.features.result.LoginResult;
import itu.com.CRM.response.ApiSuccessResult;
import itu.com.CRM.service.SecurityService;

@Controller
public class SecurityController {

    private final SecurityService _securityService;

    public SecurityController(SecurityService securityService) {
        this._securityService = securityService;
    }

    @GetMapping("/")
    public String showLoginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String login(
        @RequestParam String email,
        @RequestParam String password,
        RedirectAttributes redirectAttributes,
        Model model
    ) {
        LoginRequest request = new LoginRequest();
        request.setEmail(email);
        request.setPassword(password);

        ApiSuccessResult<LoginResult> result = _securityService.login(request);

        if (result != null && result.getContent() != null && result.getContent().getData() != null) {
            model.addAttribute("user", result.getContent().getData());
            return "redirect:/Dashboard/Home";
        } else {
            redirectAttributes.addFlashAttribute("error", "Invalid login credentials. NotSucceeded.");
            return "redirect:/"; 
        }
    }
}

