package itu.com.CRM.controlleur;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import itu.com.CRM.features.request.CreateRateRequest;
import itu.com.CRM.features.result.CreateRateResult;
import itu.com.CRM.response.ApiSuccessResult;
import itu.com.CRM.service.ConfigurationService;

@Controller
@RequestMapping("/Config")
public class ConfigController {

    private final ConfigurationService _configurationService;

    public ConfigController(ConfigurationService configurationService) {
        this._configurationService = configurationService;
    }

    @GetMapping("/Budget")
    public String getBudgetConfig(
        Model model
    ) {
        model.addAttribute("rateRequest", new CreateRateRequest());
        return "budget/config";
    }

    @PostMapping("/Create")
    public String createBudgetConfig(
        @ModelAttribute CreateRateRequest request,
        RedirectAttributes redirectAttributes,
        Model model
    ) {
        ApiSuccessResult<CreateRateResult> result = _configurationService.createRate(request);
        if (result.getContent() != null && result.getContent().getData() != null) {
            redirectAttributes.addFlashAttribute("success", "Rate insert");
            return "redirect:/Config/Budget";
        } else {
            redirectAttributes.addFlashAttribute("error", "Error "+result.getCode()+": "+result.getMessage());
            return "redirect:/Config/Budget"; 
        }
    }
}

