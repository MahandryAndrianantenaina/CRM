package itu.com.CRM.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ApiSuccessResult<T> {
    
    private Integer code;
    private String message;
    public T content;

}
