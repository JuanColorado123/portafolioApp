package com.jdcolorado.portafolioapp.exception.handler;

import com.jdcolorado.portafolioapp.exception.ValidationException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ValidationException.class)
    public String handlerValidationException(ValidationException ex, Model model){

        model.addAttribute("errors", ex.getBindingResult().getAllErrors());
        model.addAttribute("message", "Se encontraron errores de validacion");
        return "error/validation";
    }
}
