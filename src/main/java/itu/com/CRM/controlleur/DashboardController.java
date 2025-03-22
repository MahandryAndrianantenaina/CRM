package itu.com.CRM.controlleur;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import itu.com.CRM.features.queries.CRMItem;
import itu.com.CRM.features.result.GetCRMDashboardResult;
import itu.com.CRM.response.ApiSuccessResult;
import itu.com.CRM.service.DashboardService;

@Controller
@RequestMapping("/Dashboard")
public class DashboardController {

    private final DashboardService _dashboardService;

    public DashboardController(DashboardService dashboardService) {
        this._dashboardService = dashboardService;
    }

    @GetMapping("/Home")
    public String getCRMDashboard(
        RedirectAttributes redirectAttributes,
        Model model
    ) {
        try {
            ApiSuccessResult<GetCRMDashboardResult> result = _dashboardService.getCRMDashboard();
            if (result != null && result.getContent() != null && result.getContent().getData() != null  && result.getContent().getData().getCrmDashboard() != null) {
                CRMItem item = result.getContent().getData().getCrmDashboard();
                System.out.println("Item: " + item);
                model.addAttribute("item", item);
                return "dashboard";
            } else {
                model.addAttribute("error", "Data not found.");
                return "dashboard"; 
            }
        } catch (RuntimeException re) {
            redirectAttributes.addFlashAttribute("error", re.getMessage());
            return "redirect:/"; 
        }
    }
}

