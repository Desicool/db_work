package com.ecust.db_work.repository;

import com.ecust.db_work.entity.Deliveryinfo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.awt.geom.RectangularShape;
import java.util.List;

@Repository
@Transactional
public class DeliveryInfoRepositoryImpl implements DeliveryInfoRepository {
    @Autowired
    private SessionFactory sessionFactory;
    public Session getCurrentSession(){
        return this.sessionFactory.openSession();
    }

    @Override
    public Deliveryinfo load(Integer id) {
        return (Deliveryinfo) getCurrentSession().load(Deliveryinfo.class,id);
    }

    @Override
    public Deliveryinfo get(Integer id) {
        return (Deliveryinfo) getCurrentSession().get(Deliveryinfo.class,id);
    }

    @Override
    public List<Deliveryinfo> findAll() {
        return getCurrentSession().createCriteria(Deliveryinfo.class).list();
    }

    @Override
    public void persisit(Deliveryinfo entity) {
        getCurrentSession().persist(entity);
    }

    @Override
    public Integer save(Deliveryinfo entity) {
        return (Integer) getCurrentSession().save(entity);
    }

    @Override
    public void saveOrUpdate(Deliveryinfo entity) {
        getCurrentSession().saveOrUpdate(entity);
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public void flush() {
        getCurrentSession().flush();
    }

    @Override
    public Deliveryinfo findByDeliveryID(String DeliveryID) {
        return (Deliveryinfo) getCurrentSession().createCriteria(Deliveryinfo.class).
                add(Restrictions.eq("deliveryId",DeliveryID)).uniqueResult();
    }
}
