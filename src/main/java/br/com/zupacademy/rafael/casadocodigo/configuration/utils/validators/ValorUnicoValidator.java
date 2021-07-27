package br.com.zupacademy.rafael.casadocodigo.configuration.utils.validators;

import br.com.zupacademy.rafael.casadocodigo.configuration.utils.validators.Annotations.ValorUnico;

import javax.persistence.EntityManager;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class ValorUnicoValidator implements ConstraintValidator<ValorUnico,String> {

    private final EntityManager entityManager;
    private String nomeDoCampo;
    private Class<?> classeDoDominio;

    public ValorUnicoValidator(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void initialize(ValorUnico constraintAnnotation) {
        this.nomeDoCampo = constraintAnnotation.nomeDoCampo();
        this.classeDoDominio = constraintAnnotation.classeDoDominio();
    }

    @Override
    public boolean isValid(String campo, ConstraintValidatorContext constraintValidatorContext) {
        List<?> result = entityManager.createQuery("select d from "+ classeDoDominio.getName()+" d where "+nomeDoCampo+"=:campo").setParameter("campo",campo).getResultList();

        return (result.isEmpty());
    }
}
