package com.ecust.db_work.repository;

import com.ecust.db_work.entity.Customer;
import com.ecust.db_work.entity.Employee;
import com.ecust.db_work.entity.Payroll;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class PayrollRepositoryImpl implements PayrollRepository {
    @Autowired
    private SessionFactory sessionFactory;
    private Session getCurrentSession(){
        return this.sessionFactory.getCurrentSession();
    }
    @Override
    public Payroll load(String id) {
        return (Payroll) getCurrentSession().load(Payroll.class,id);
    }

    @Override
    public Payroll get(String id) {
        return (Payroll) getCurrentSession().get(Payroll.class,id);
    }

    @Override
    public List<Payroll> findAll() {
        return getCurrentSession().createCriteria(Payroll.class).list();
    }

    @Override
    public void persisit(Payroll entity) {
        getCurrentSession().persist(entity);
    }

    @Override
    public String save(Payroll entity) {
        return (String) getCurrentSession().save(entity);
    }

    @Override
    public void saveOrUpdate(Payroll entity) {
        getCurrentSession().saveOrUpdate(entity);
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public void flush() {
        getCurrentSession().flush();
    }

    @Override
    public List<Payroll> findByEmployee(Employee employee) {
        return getCurrentSession().createCriteria(Payroll.class).
                add(Restrictions.eq("employeeByEmployeeId",employee)).list();
    }

    @Override
    public Payroll findByPayrollID(String payrollID){
        return (Payroll) getCurrentSession().createCriteria(Payroll.class).
                add(Restrictions.eq("payrollId",payrollID)).uniqueResult();
    }
}
