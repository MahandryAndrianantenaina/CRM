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
import itu.com.CRM.features.request.DeleteExpenseRequest;
import itu.com.CRM.features.request.ModifyExpenseRequest;
import itu.com.CRM.features.request.UpdateExpenseRequest;
import itu.com.CRM.features.result.DeleteExpenseResult;
import itu.com.CRM.features.result.GetExpenseListResult;
import itu.com.CRM.features.result.GetExpenseSingleResult;
import itu.com.CRM.features.result.UpdateExpenseResult;
import itu.com.CRM.model.entities.Expense;
import itu.com.CRM.response.ApiSuccessResult;
import itu.com.CRM.service.ExpenseService;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/Expense")
public class ExpenseController {

    private final ExpenseService _expenseService;

    public ExpenseController(ExpenseService expenseService) {
        this._expenseService = expenseService;
    }

    @GetMapping("/List")
    public String getListExpense(
        RedirectAttributes redirectAttributes,
        Model model
    ) {
        ApiSuccessResult<GetExpenseListResult> result = _expenseService.getListExpense();
        if (result.getContent() != null && result.getContent().getData() != null) {
            model.addAttribute("expenses", result.getContent().getData());
            return "expense/list";
        } else {
            redirectAttributes.addFlashAttribute("error", "Error "+result.getCode()+": "+result.getMessage());
            return "expense/list"; 
        }
    }

    @GetMapping("/{id}")
    public String getListExpense(
        @PathVariable("id") String id,
        RedirectAttributes redirectAttributes,
        Model model
    ) {
        ApiSuccessResult<GetExpenseSingleResult> result = _expenseService.getUniqueExpense(id);
        if (result.getContent() != null && result.getContent().getData() != null) {
            model.addAttribute("expense", result.getContent().getData());
            return "expense/form";
        } else {
            redirectAttributes.addFlashAttribute("error", "Error "+result.getCode()+": "+result.getMessage());
            return "expense/form"; 
        }
    }

    @GetMapping("/Delete/{id}")
    public String deleteExpense(
        @PathVariable("id") String id,
        HttpSession session,
        RedirectAttributes redirectAttributes,
        Model model
    ) {
        DeleteExpenseRequest delete = new DeleteExpenseRequest();
        LoginResultDto login = (LoginResultDto) session.getAttribute("user");
        delete.setDeletedById(login.getUserId());
        delete.setId(id);
        ApiSuccessResult<DeleteExpenseResult> result = _expenseService.deleteExpense(delete);
        if (result.getContent() != null && result.getContent().getData() != null) {
            model.addAttribute("expense", result.getContent().getData());
            return "redirect:/Expense/List";
        } else {
            redirectAttributes.addFlashAttribute("error", "Error "+result.getCode()+": "+result.getMessage());
            return "redirect:/Expense/List"; 
        }
    }
    
    @PostMapping("/Update")
    public String updateExpense(
        @ModelAttribute ModifyExpenseRequest request,
        RedirectAttributes redirectAttributes,
        Model model
    ) {
        ApiSuccessResult<GetExpenseSingleResult> data = _expenseService.getUniqueExpense(request.getId());
        Expense expense = data.getContent().getData();
        UpdateExpenseRequest update = new UpdateExpenseRequest();
        update.setAmount(request.getAmount());
        update.setExpenseDate(expense.getExpenseDate());
        update.setCampaignId(expense.getCampaignId());
        update.setDescription(expense.getDescription());
        update.setId(expense.getId());
        update.setStatus(expense.getStatus());
        update.setTitle(expense.getTitle());
        update.setUpdatedById(expense.getUpdatedById());
        ApiSuccessResult<UpdateExpenseResult> result = _expenseService.updateExpense(update);
        if (result.getContent() != null && result.getContent().getData() != null) {
            model.addAttribute("expense", result.getContent().getData());
            return "redirect:/Expense/List";
        } else {
            redirectAttributes.addFlashAttribute("error", "Error "+result.getCode()+": "+result.getMessage());
            return "redirect:/Expense/List"; 
        }
    }
}

