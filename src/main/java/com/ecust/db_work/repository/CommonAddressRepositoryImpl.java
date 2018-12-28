package com.ecust.db_work.repository;

import com.ecust.db_work.entity.Commonaddress;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class CommonAddressRepositoryImpl implements CommonAddressRepository {
    @Autowired
    private SessionFactory sessionFactory;
    public Session getCurrentSession(){
        return this.sessionFactory.getCurrentSession();
    }
    @Override
    public Commonaddress load(Integer id) {
        return (Commonaddress) getCurrentSession().load(Commonaddress.class,id);
    }

    @Override
    public Commonaddress get(Integer id) {
        return (Commonaddress) getCurrentSession().get(Commonaddress.class,id);
    }

    @Override
    public List<Commonaddress> findAll() {
        return getCurrentSession().createCriteria(Commonaddress.class).list();
    }

    @Override
    public void persisit(Commonaddress entity) {
        getCurrentSession().persist(entity);
    }

    @Override
    public Integer save(Commonaddress entity) {
        return (Integer) getCurrentSession().save(entity);
    }

    @Override
    public void saveOrUpdate(Commonaddress entity) {
        getCurrentSession().saveOrUpdate(entity);
    }

    @Override
    public void update(Commonaddress entity){
        getCurrentSession().update(entity);
    }
    @Override
    public void delete(Integer id) {
        getCurrentSession().delete(get(id));
    }

    @Override
    public void flush() {
        getCurrentSession().flush();
    }

    public List<Commonaddress> findByCustomerID(String CustomerID){
        Criteria c = getCurrentSession().createCriteria(Commonaddress.class);
        c.add(Restrictions.eq("customerId", CustomerID));
        return c.list() == null? new ArrayList<>():c.list();
    }
}
