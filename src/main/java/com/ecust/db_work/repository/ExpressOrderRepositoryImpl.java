package com.ecust.db_work.repository;

import com.ecust.db_work.entity.Expressorder;
import com.ecust.db_work.entity.Station;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class ExpressOrderRepositoryImpl implements ExpressOrderRepository {
    @Autowired
    private SessionFactory sessionFactory;
    public Session getCurrentSession(){
        return this.sessionFactory.getCurrentSession();
    }
    @Override
    public Expressorder load(String id) {
        return (Expressorder) getCurrentSession().load(Expressorder.class,id);
    }

    @Override
    public Expressorder get(String id) {
        return (Expressorder) getCurrentSession().get(Expressorder.class,id);
    }

    @Override
    public List<Expressorder> findAll() {
        return getCurrentSession().createCriteria(Expressorder.class).list();
    }

    @Override
    public void persisit(Expressorder entity) {
        getCurrentSession().persist(entity);
    }

    @Override
    public String save(Expressorder entity) {
        return (String) getCurrentSession().save(entity);
    }

    @Override
    public void saveOrUpdate(Expressorder entity) {
        getCurrentSession().saveOrUpdate(entity);
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public void flush() {
        getCurrentSession().flush();
    }


    public String generatedOrderID(){
        int tmp = ((Number)getCurrentSession().createCriteria(Expressorder.class).setProjection(
                Projections.rowCount()).uniqueResult()).intValue();
        String ID = "O";
        tmp++;
        ID += tmp / 10000 % 10;
        ID += tmp / 1000 % 10;
        ID += tmp / 100 % 10;
        ID += tmp / 10 % 10;
        ID += tmp % 10;
        return ID;
    }
}
