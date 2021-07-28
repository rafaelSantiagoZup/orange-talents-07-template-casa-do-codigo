package br.com.zupacademy.rafael.casadocodigo.configuration.utils.validators;

import br.com.zupacademy.rafael.casadocodigo.configuration.utils.validators.Annotations.CEP;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CEPValidatorValidator implements ConstraintValidator<CEP,String> {
    @Override
    public void initialize(CEP constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String cep, ConstraintValidatorContext constraintValidatorContext) {
        String regex = "[0-9]{5}-[0-9]{3}";
        return cep.matches(regex);
    }
}
