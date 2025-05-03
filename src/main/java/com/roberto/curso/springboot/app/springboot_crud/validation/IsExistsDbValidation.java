package com.roberto.curso.springboot.app.springboot_crud.validation;

import org.springframework.beans.factory.annotation.Autowired;

import com.roberto.curso.springboot.app.springboot_crud.services.ProductService;

import jakarta.validation.ConstraintValidator;

public class IsExistsDbValidation implements ConstraintValidator<IsExistsDb, String> {

    @Autowired
    private ProductService productService;

    @Override
    public boolean isValid(String value, jakarta.validation.ConstraintValidatorContext context) {
        if(productService != null){
            return !productService.existsBySku(value);
        }
        return true;
    }
}
