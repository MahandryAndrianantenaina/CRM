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
import itu.com.CRM.features.request.DeleteCampaignRequest;
import itu.com.CRM.features.request.ModifyCampaignRequest;
import itu.com.CRM.features.request.UpdateCampaignRequest;
import itu.com.CRM.features.result.DeleteCampaignResult;
import itu.com.CRM.features.result.GetCampaignListResult;
import itu.com.CRM.features.result.GetCampaignSingleResult;
import itu.com.CRM.features.result.UpdateCampaignResult;
import itu.com.CRM.model.entities.Campaign;
import itu.com.CRM.response.ApiSuccessResult;
import itu.com.CRM.service.CampaignService;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/Campaign")
public class CampaignController {

    private final CampaignService _campaignService;

    public CampaignController(CampaignService campaignService) {
        this._campaignService = campaignService;
    }

    @GetMapping("/List")
    public String getListCampaign(
        RedirectAttributes redirectAttributes,
        Model model
    ) {
        ApiSuccessResult<GetCampaignListResult> result = _campaignService.getListCampaign();
        if (result.getContent() != null && result.getContent().getData() != null) {
            model.addAttribute("campaigns", result.getContent().getData());
            return "campaign/list";
        } else {
            redirectAttributes.addFlashAttribute("error", "Error "+result.getCode()+": "+result.getMessage());
            return "campaign/list"; 
        }
    }

    @GetMapping("/{id}")
    public String getListCampaign(
        @PathVariable("id") String id,
        RedirectAttributes redirectAttributes,
        Model model
    ) {
        ApiSuccessResult<GetCampaignSingleResult> result = _campaignService.getUniqueCampaign(id);
        if (result.getContent() != null && result.getContent().getData() != null) {
            model.addAttribute("campaign", result.getContent().getData());
            return "campaign/form";
        } else {
            redirectAttributes.addFlashAttribute("error", "Error "+result.getCode()+": "+result.getMessage());
            return "campaign/form"; 
        }
    }

    @GetMapping("/Delete/{id}")
    public String deleteCampaign(
        @PathVariable("id") String id,
        HttpSession session,
        RedirectAttributes redirectAttributes,
        Model model
    ) {
        DeleteCampaignRequest delete = new DeleteCampaignRequest();
        LoginResultDto login = (LoginResultDto) session.getAttribute("user");
        delete.setDeletedById(login.getUserId());
        delete.setId(id);
        ApiSuccessResult<DeleteCampaignResult> result = _campaignService.deleteCampaign(delete);
        if (result.getContent() != null && result.getContent().getData() != null) {
            model.addAttribute("campaign", result.getContent().getData());
            return "redirect:/Campaign/List";
        } else {
            redirectAttributes.addFlashAttribute("error", "Error "+result.getCode()+": "+result.getMessage());
            return "redirect:/Campaign/List"; 
        }
    }
    
    @PostMapping("/Update")
    public String updateCampaign(
        @ModelAttribute ModifyCampaignRequest request,
        RedirectAttributes redirectAttributes,
        Model model
    ) {
        ApiSuccessResult<GetCampaignSingleResult> data = _campaignService.getUniqueCampaign(request.getId());
        Campaign campaign = data.getContent().getData();
        UpdateCampaignRequest update = new UpdateCampaignRequest();
        update.setTargetRevenueAmount(request.getTargetRevenueAmount());
        update.setCampaignDateFinish(campaign.getCampaignDateFinish());
        update.setCampaignDateStart(campaign.getCampaignDateStart());
        update.setDescription(campaign.getDescription());
        update.setId(campaign.getId());
        update.setStatus(campaign.getStatus());
        update.setTitle(campaign.getTitle());
        update.setSalesTeamId(campaign.getSalesTeamId());
        update.setUpdatedById(campaign.getUpdatedById());
        ApiSuccessResult<UpdateCampaignResult> result = _campaignService.updateCampaign(update);
        if (result.getContent() != null && result.getContent().getData() != null) {
            model.addAttribute("campaign", result.getContent().getData());
            return "redirect:/Campaign/List";
        } else {
            redirectAttributes.addFlashAttribute("error", "Error "+result.getCode()+": "+result.getMessage());
            return "redirect:/Campaign/List"; 
        }
    }
}

