package com.apepeskul.validator;


import com.apepeskul.domain.Phone;
import com.apepeskul.dto.PhoneDto;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Repository
public class PhoneValidator implements Validator {
    @Autowired
    SessionFactory mSessionFactory;

    @Override
    public boolean supports(Class<?> aClass) {
        return Phone.class.equals(aClass);
    }

    @Override
    @Transactional
    public void validate(Object o, Errors errors) {
        PhoneDto phoneDto = (PhoneDto) o;

        Criteria crit = mSessionFactory.openSession().createCriteria(Phone.class);
        crit.add(Restrictions.eq("firstName", phoneDto.getFirstName()));
        if (!crit.list().isEmpty()) {
            errors.rejectValue("firstName", "", "Name already exists");
        }
        crit = mSessionFactory.openSession().createCriteria(Phone.class);
        crit.add(Restrictions.eq("lastName", phoneDto.getLastName()));
        if (!crit.list().isEmpty()) {
            errors.rejectValue("lastName", "", "Name already exists");
        }
        crit = mSessionFactory.openSession().createCriteria(Phone.class);
        crit.add(Restrictions.eq("phone", phoneDto.getPhone()));
        if (!crit.list().isEmpty()) {
            errors.rejectValue("phone", "", "Phone already exists");
        }

    }
}
