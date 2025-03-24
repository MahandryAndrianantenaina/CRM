package itu.com.CRM.features.result;

import java.util.List;

import itu.com.CRM.features.dto.GetExpenseListDto;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class GetExpenseListResult {
    public List<GetExpenseListDto> data;
}
