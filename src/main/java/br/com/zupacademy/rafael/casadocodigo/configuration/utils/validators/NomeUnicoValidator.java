package br.com.zupacademy.rafael.casadocodigo.configuration.utils.validators;

import br.com.zupacademy.rafael.casadocodigo.configuration.utils.validators.Annotations.NomeUnico;
import br.com.zupacademy.rafael.casadocodigo.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NomeUnicoValidator implements ConstraintValidator<NomeUnico,String> {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public void initialize(NomeUnico constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String nome, ConstraintValidatorContext constraintValidatorContext) {
        return !categoriaRepository.findByNome(nome).isPresent();
    }
}
