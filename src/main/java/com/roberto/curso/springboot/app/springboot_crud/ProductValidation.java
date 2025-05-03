package com.roberto.curso.springboot.app.springboot_crud;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.roberto.curso.springboot.app.springboot_crud.entities.Product;

@Component
public class ProductValidation implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Product.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Product product = (Product) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "NotEmpty.product.name", "Name is mandatory");
        // ValidationUtils.rejectIfEmptyOrWhitespace(errors, "price",
        // "NotEmpty.product.price", "Price is mandatory");

        if (product.getPrice() == null || product.getPrice() <= 0) {
            errors.rejectValue("price", "NotNull.product.price", "Price must be greater than 0");
        }
        if (product.getName() != null && (product.getName().length() < 3 || product.getName().length() > 50)) {
            errors.rejectValue("name", "Size.product.name", "Name must be between 3 and 50 characters");
        }

    }

}
