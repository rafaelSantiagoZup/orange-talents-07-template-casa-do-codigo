package br.com.zupacademy.rafael.casadocodigo.configuration.utils.validators.Annotations;

import br.com.zupacademy.rafael.casadocodigo.configuration.utils.validators.EmailDuplicadoValidator;
import br.com.zupacademy.rafael.casadocodigo.configuration.utils.validators.NomeUnicoValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = NomeUnicoValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface NomeUnico {
    String message() default "A categoria inserida deve ser única!";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
