package br.com.zupacademy.rafael.casadocodigo.configuration.utils.validators.Annotations;

import br.com.zupacademy.rafael.casadocodigo.configuration.utils.validators.CPFouCNPJValidator;
import br.com.zupacademy.rafael.casadocodigo.configuration.utils.validators.EmailDuplicadoValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = CPFouCNPJValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CpfOuCnpj {
    String message() default "CPF ou CNPJ inválido!";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
