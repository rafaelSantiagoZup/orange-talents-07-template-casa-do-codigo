package br.com.zupacademy.rafael.casadocodigo.configuration.utils.validators;

import br.com.zupacademy.rafael.casadocodigo.configuration.utils.EmailDuplicado;
import br.com.zupacademy.rafael.casadocodigo.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailDuplicadoValidator implements ConstraintValidator<EmailDuplicado,String> {

    @Autowired
    private AutorRepository autorRepository;

    @Override
    public void initialize(EmailDuplicado constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }
    @Override
    public boolean isValid(String email, ConstraintValidatorContext constraintValidatorContext) {
        return !autorRepository.findByEmail(email).isPresent();
    }
}
