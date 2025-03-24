package itu.com.CRM.features.result;

import java.util.List;

import itu.com.CRM.features.dto.GetBudgetListDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetBudgetListResult
{
    private List<GetBudgetListDto> Data;
}
