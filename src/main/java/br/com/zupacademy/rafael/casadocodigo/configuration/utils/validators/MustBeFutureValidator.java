package br.com.zupacademy.rafael.casadocodigo.configuration.utils.validators;

import br.com.zupacademy.rafael.casadocodigo.configuration.utils.validators.Annotations.MustBeFuture;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MustBeFutureValidator implements ConstraintValidator<MustBeFuture,String> {

    @Override
    public boolean isValid(String dataPassada, ConstraintValidatorContext constraintValidatorContext) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate local = LocalDate.parse(dataPassada,formatter);
        return !local.isBefore(LocalDate.now());
    }

    @Override
    public void initialize(MustBeFuture constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }
}
