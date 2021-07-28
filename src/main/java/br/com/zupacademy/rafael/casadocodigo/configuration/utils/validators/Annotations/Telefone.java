package br.com.zupacademy.rafael.casadocodigo.configuration.utils.validators.Annotations;

import br.com.zupacademy.rafael.casadocodigo.configuration.utils.validators.EmailDuplicadoValidator;
import br.com.zupacademy.rafael.casadocodigo.configuration.utils.validators.TelefoneValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = TelefoneValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Telefone {
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    String message() default "Digite um telefone válido!";
}
