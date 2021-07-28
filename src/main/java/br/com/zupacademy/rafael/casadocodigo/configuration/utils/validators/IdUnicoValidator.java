package br.com.zupacademy.rafael.casadocodigo.configuration.utils.validators;

import br.com.zupacademy.rafael.casadocodigo.configuration.utils.validators.Annotations.IdUnico;

import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class IdUnicoValidator implements ConstraintValidator<IdUnico,Object> {
    private Class<?> classeDoDominio;
    private String nomeDoAtributo;

    private final EntityManager em;

    public IdUnicoValidator(EntityManager em) {
        this.em = em;
    }

    @Override
    public void initialize(IdUnico constraintAnnotation) {
        this.classeDoDominio = constraintAnnotation.classeDoDominio();
        this.nomeDoAtributo = constraintAnnotation.nomeDoAtributo();
    }

    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext constraintValidatorContext) {
        if(obj == null){
            return true;
        }
        Query busca = em.createQuery("select v from "+classeDoDominio.getName()+" v where "+nomeDoAtributo+"=:obj").setParameter("obj",obj);
        List<?> list = busca.getResultList();
        return !list.isEmpty();
    }
}
