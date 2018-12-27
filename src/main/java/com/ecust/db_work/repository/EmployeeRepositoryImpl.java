package com.ecust.db_work.repository;

import com.ecust.db_work.entity.Employee;
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
public class EmployeeRepositoryImpl implements EmployeeRepository {
    @Autowired
    private SessionFactory sessionFactory;
    public Session getCurrentSession(){
        return this.sessionFactory.openSession();
    }
    public Employee load(String id) {
        return (Employee) getCurrentSession().load(Employee.class,id);
    }

    public Employee get(String id) {
        return (Employee) getCurrentSession().get(Employee.class,id);
    }

    public List<Employee> findAll() {
        //return getCurrentSession().createCriteria(Employee.class).list();
        return null;
    }

    public void persisit(Employee entity) {
        getCurrentSession().persist(entity);
    }

    public String save(Employee entity) {
        return (String) getCurrentSession().save(entity);
    }

    public void saveOrUpdate(Employee entity) {
        getCurrentSession().saveOrUpdate(entity);
    }

    public void delete(String id) {
        getCurrentSession().delete(id);
    }

    public void flush() {
        getCurrentSession().flush();
    }

    @Override
    public List<Employee> findByName(String name) {
        Criteria c = getCurrentSession().createCriteria(Employee.class).
                add(Restrictions.like("name","%"+name+"%"));
        return c.list() == null?new ArrayList<Employee>():c.list();
    }
}
