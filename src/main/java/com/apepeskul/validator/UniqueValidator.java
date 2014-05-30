package com.apepeskul.validator;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.io.Serializable;

@Component
public class UniqueValidator implements ConstraintValidator<UniqueColumn, Serializable> {
    private Class<?> entityClass;
    private String field;
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void initialize(UniqueColumn unique) {
        entityClass = unique.entity();
        field = unique.property();

    }

    @Transactional(readOnly = true)
    @Override
    public boolean isValid(Serializable property, ConstraintValidatorContext constraintValidatorContext) {
        Criteria crit = sessionFactory.openSession().createCriteria(entityClass);
        crit.add(Restrictions.eq(field, property));
        return crit.list().isEmpty();
    }

}


