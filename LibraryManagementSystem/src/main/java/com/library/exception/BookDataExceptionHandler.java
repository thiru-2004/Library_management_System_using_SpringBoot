package com.library.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.ui.Model;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class BookDataExceptionHandler
{
	@ExceptionHandler(MethodArgumentNotValidException.class)
	 public  String bookInvalidExceptionHandler(MethodArgumentNotValidException ex,Model model)
    {
        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getAllErrors().forEach(error -> {
            if (error instanceof FieldError) {
                String fieldName = ((FieldError) error).getField();
                String errorMessage = error.getDefaultMessage();
                errors.put(fieldName, errorMessage);
            } else {
                // Handle global errors, if any.
                // For this example, we'll put them under a generic key.
                errors.put(error.getObjectName(), error.getDefaultMessage());
            }
        });
        
        model.addAttribute("AllErrorFileds",errors);

        return "AddBook";
    }

}
