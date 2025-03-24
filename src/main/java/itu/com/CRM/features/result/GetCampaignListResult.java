package itu.com.CRM.features.result;

import java.util.List;

import itu.com.CRM.features.dto.GetCampaignListDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetCampaignListResult
{
    private List<GetCampaignListDto> data;
}
