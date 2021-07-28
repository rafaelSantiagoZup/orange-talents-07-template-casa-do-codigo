package br.com.zupacademy.rafael.casadocodigo.configuration.utils.validators.Annotations;

import br.com.zupacademy.rafael.casadocodigo.configuration.utils.validators.CEPValidatorValidator;
import br.com.zupacademy.rafael.casadocodigo.configuration.utils.validators.EmailDuplicadoValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = CEPValidatorValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CEP {
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    String message() default "O email inserido deve ser único!";
}
