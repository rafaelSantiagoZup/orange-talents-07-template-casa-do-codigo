package br.com.zupacademy.rafael.casadocodigo.configuration.utils.validators.Annotations;

import br.com.zupacademy.rafael.casadocodigo.configuration.utils.validators.MustBeFutureValidator;
import br.com.zupacademy.rafael.casadocodigo.configuration.utils.validators.NomeUnicoValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = MustBeFutureValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MustBeFuture {
    String message() default "A data inserida precisa estar no futuro!";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
