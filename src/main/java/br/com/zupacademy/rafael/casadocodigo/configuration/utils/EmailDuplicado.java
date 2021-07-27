package br.com.zupacademy.rafael.casadocodigo.configuration.utils;

import br.com.zupacademy.rafael.casadocodigo.configuration.utils.validators.EmailDuplicadoValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = EmailDuplicadoValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface EmailDuplicado {
    String message() default "O email inserido deve ser único!";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
