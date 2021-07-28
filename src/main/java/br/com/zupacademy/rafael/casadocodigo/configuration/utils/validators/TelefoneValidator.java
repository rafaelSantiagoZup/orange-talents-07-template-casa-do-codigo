package br.com.zupacademy.rafael.casadocodigo.configuration.utils.validators;

import br.com.zupacademy.rafael.casadocodigo.configuration.utils.validators.Annotations.Telefone;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class TelefoneValidator implements ConstraintValidator<Telefone,String> {
    @Override
    public void initialize(Telefone constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String telefone, ConstraintValidatorContext constraintValidatorContext) {
        String regex = "(\\(?\\d{2}\\)?\\s?)?(\\d{4,5}\\-?\\d{4})";
        return telefone.matches(regex);
    }
}
