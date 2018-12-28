package com.ecust.db_work.repository;

import com.ecust.db_work.entity.Deliveryinfo;
import org.aspectj.weaver.ast.Or;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.awt.geom.RectangularShape;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class DeliveryInfoRepositoryImpl implements DeliveryInfoRepository {
    @Autowired
    private SessionFactory sessionFactory;
    public Session getCurrentSession(){
        return this.sessionFactory.getCurrentSession();
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
    public List<Deliveryinfo> findByDeliveryID(List<String>deliveryID) {
        if(deliveryID.size() <= 0)
            return new ArrayList<>();
        Criteria c = getCurrentSession().createCriteria(Deliveryinfo.class).
                add(Restrictions.in("deliveryId",deliveryID));
        c.addOrder(Order.asc("transferNum"));
        List<Deliveryinfo> ret = c.list();
        return ret;
    }

    @Override
    public Deliveryinfo findLastTransferredOne(List<String>deliveryID){
        if(deliveryID.size() <= 0){
            return null;
        }
        int max = (int) getCurrentSession().createCriteria(Deliveryinfo.class).
                add(Restrictions.in("deliveryId",deliveryID)).setProjection(
                Projections.projectionList().add(Projections.max("transferNum"))).uniqueResult();
        return (Deliveryinfo) getCurrentSession().createCriteria(Deliveryinfo.class).
                add(Restrictions.eq("transferNum",max)).
                add(Restrictions.in("deliveryId",deliveryID)).uniqueResult();

    }

    @Override
    public String generatedDeliveryID() {
        int tmp = ((Number)getCurrentSession().createCriteria(Deliveryinfo.class).setProjection(
                Projections.projectionList().add(Projections.max("id"))).uniqueResult()).intValue();
        String ID = "D";
        tmp++;
        ID += tmp / 10000 % 10;
        ID += tmp / 1000 % 10;
        ID += tmp / 100 % 10;
        ID += tmp / 10 % 10;
        ID += tmp % 10;
        return ID;
    }

    public void update(Deliveryinfo deliveryinfo){
        getCurrentSession().update(deliveryinfo);
    }
}
