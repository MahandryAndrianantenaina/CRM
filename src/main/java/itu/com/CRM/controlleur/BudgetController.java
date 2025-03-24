package itu.com.CRM.controlleur;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import itu.com.CRM.features.dto.LoginResultDto;
import itu.com.CRM.features.request.DeleteBudgetRequest;
import itu.com.CRM.features.request.ModifyBudgetRequest;
import itu.com.CRM.features.request.UpdateBudgetRequest;
import itu.com.CRM.features.result.DeleteBudgetResult;
import itu.com.CRM.features.result.GetBudgetListResult;
import itu.com.CRM.features.result.GetBudgetSingleResult;
import itu.com.CRM.features.result.UpdateBudgetResult;
import itu.com.CRM.model.entities.Budget;
import itu.com.CRM.response.ApiSuccessResult;
import itu.com.CRM.service.BudgetService;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/Budget")
public class BudgetController {

    private final BudgetService _budgetService;

    public BudgetController(BudgetService budgetService) {
        this._budgetService = budgetService;
    }

    @GetMapping("/List")
    public String getListBudget(
        RedirectAttributes redirectAttributes,
        Model model
    ) {
        ApiSuccessResult<GetBudgetListResult> result = _budgetService.getListBuget();
        if (result.getContent() != null && result.getContent().getData() != null) {
            model.addAttribute("budgets", result.getContent().getData());
            return "budget/list";
        } else {
            redirectAttributes.addFlashAttribute("error", "Error "+result.getCode()+": "+result.getMessage());
            return "budget/list"; 
        }
    }

    @GetMapping("/{id}")
    public String getListBudget(
        @PathVariable("id") String id,
        RedirectAttributes redirectAttributes,
        Model model
    ) {
        ApiSuccessResult<GetBudgetSingleResult> result = _budgetService.getUniqueBudget(id);
        if (result.getContent() != null && result.getContent().getData() != null) {
            model.addAttribute("budget", result.getContent().getData());
            return "budget/form";
        } else {
            redirectAttributes.addFlashAttribute("error", "Error "+result.getCode()+": "+result.getMessage());
            return "budget/form"; 
        }
    }

    @GetMapping("/Delete/{id}")
    public String deleteBudget(
        @PathVariable("id") String id,
        HttpSession session,
        RedirectAttributes redirectAttributes,
        Model model
    ) {
        DeleteBudgetRequest delete = new DeleteBudgetRequest();
        LoginResultDto login = (LoginResultDto) session.getAttribute("user");
        delete.setDeletedById(login.getUserId());
        delete.setId(id);
        ApiSuccessResult<DeleteBudgetResult> result = _budgetService.deleteBudget(delete);
        if (result.getContent() != null && result.getContent().getData() != null) {
            model.addAttribute("budget", result.getContent().getData());
            return "redirect:/Budget/List";
        } else {
            redirectAttributes.addFlashAttribute("error", "Error "+result.getCode()+": "+result.getMessage());
            return "redirect:/Budget/List"; 
        }
    }
    
    @PostMapping("/Update")
    public String updateBudget(
        @ModelAttribute ModifyBudgetRequest request,
        RedirectAttributes redirectAttributes,
        Model model
    ) {
        ApiSuccessResult<GetBudgetSingleResult> data = _budgetService.getUniqueBudget(request.getId());
        Budget budget = data.getContent().getData();
        UpdateBudgetRequest update = new UpdateBudgetRequest();
        update.setAmount(request.getAmount());
        update.setBudgetDate(budget.getBudgetDate());
        update.setCampaignId(budget.getCampaignId());
        update.setDescription(budget.getDescription());
        update.setId(budget.getId());
        update.setStatus(budget.getStatus());
        update.setTitle(budget.getTitle());
        update.setUpdatedById(budget.getUpdatedById());
        ApiSuccessResult<UpdateBudgetResult> result = _budgetService.updateBudget(update);
        if (result.getContent() != null && result.getContent().getData() != null) {
            model.addAttribute("budget", result.getContent().getData());
            return "redirect:/Budget/List";
        } else {
            redirectAttributes.addFlashAttribute("error", "Error "+result.getCode()+": "+result.getMessage());
            return "redirect:/Budget/List"; 
        }
    }
}

