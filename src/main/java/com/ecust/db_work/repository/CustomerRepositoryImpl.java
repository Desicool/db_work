package com.ecust.db_work.repository;

import com.ecust.db_work.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CustomerRepositoryImpl implements CustomerRepository {
    @Autowired
    private SessionFactory sessionFactory;
    public Session getCurrentSession(){
        return this.sessionFactory.openSession();
    }
    public Customer load(String id) {
        return (Customer) getCurrentSession().load(Customer.class,id);
    }

    public Customer get(String id) {
        return (Customer) getCurrentSession().get(Customer.class,id);

    }

    public List<Customer> findAll() {
        return getCurrentSession().createCriteria(Customer.class).list();
    }

    public void persisit(Customer entity) {
        getCurrentSession().persist(entity);
    }

    public String save(Customer entity) {
        return (String) getCurrentSession().save(entity);
    }

    public void saveOrUpdate(Customer entity) {
        getCurrentSession().saveOrUpdate(entity);
    }

    public void delete(String id) {
        getCurrentSession().delete(id);
    }

    public void flush() {

    }
    public Customer findByName(String name){
        return (Customer) getCurrentSession().createCriteria(Customer.class).
                add(Restrictions.like("name","%" + name + "%")).
                uniqueResult();
    }
}
