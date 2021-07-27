package br.com.zupacademy.rafael.casadocodigo.configuration.utils.validators.Annotations;

import br.com.zupacademy.rafael.casadocodigo.configuration.utils.validators.NomeUnicoValidator;
import br.com.zupacademy.rafael.casadocodigo.configuration.utils.validators.ValorUnicoValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ValorUnicoValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ValorUnico {
    String message() default "A categoria inserida deve ser única!";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    String nomeDoCampo();
    Class<?> classeDoDominio();
}
