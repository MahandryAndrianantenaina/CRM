package itu.com.CRM.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ApiException.class)
    public String handleApiException(ApiException ex, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("errorCode", ex.getErrorCode());
        redirectAttributes.addFlashAttribute("errorMessage", ex.getErrorMessage());
        redirectAttributes.addFlashAttribute("errorType", ex.getErrorType());
        redirectAttributes.addFlashAttribute("stackTrace", ex.getStackTrace());

        return "redirect:/erreur";
    }
}