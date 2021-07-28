package br.com.zupacademy.rafael.casadocodigo.configuration.utils.validators.Annotations;

import br.com.zupacademy.rafael.casadocodigo.configuration.utils.validators.IdUnicoValidator;
import br.com.zupacademy.rafael.casadocodigo.configuration.utils.validators.NomeUnicoValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = IdUnicoValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface IdUnico {
    String message() default "O Id inserido deve ser único!";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    Class<?> classeDoDominio();
    String nomeDoAtributo();
}
