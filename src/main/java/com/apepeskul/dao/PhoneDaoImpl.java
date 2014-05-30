package com.apepeskul.dao;

import com.apepeskul.domain.Phone;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by admin on 5/28/2014.
 */


@Repository
public class PhoneDaoImpl extends HibernateDaoSupport implements PhoneDao {

    @Autowired
    SessionFactory mSessionFactory;

    @Autowired
    HibernateTemplate hibernateTemplate;


    @Autowired
    public void init(SessionFactory factory) {
        setSessionFactory(factory);
    }

    @Override
    public Phone get(long id) {
        return (Phone)getSessionFactory().getCurrentSession().get(Phone.class, id);
    }

    @Override
    public void delete(long id) {
        getSessionFactory().getCurrentSession().delete(this.get(id));
    }

    @Override
    public void update(Phone phone) {

        getSessionFactory().getCurrentSession().update(phone);
        //  mSessionFactory.getCurrentSession().update(phone);

    }

    @Override
    public void save(Phone phone) {
        getSessionFactory().getCurrentSession().save(phone);
    }

    @Override
    public List<Phone> getAll() {
        return getSessionFactory().getCurrentSession().createCriteria(Phone.class).list();
    }
}
