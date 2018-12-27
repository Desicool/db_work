package com.ecust.db_work.repository;

import com.ecust.db_work.entity.OrderDelivery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class OrderDeliveryRepositoryImpl implements OrderDeliveryRepository {
    @Autowired
    private SessionFactory sessionFactory;
    public Session getCurrentSession(){
        return this.sessionFactory.openSession();
    }
    @Override
    public OrderDelivery load(String id) {
        return (OrderDelivery) getCurrentSession().load(OrderDelivery.class,id);
    }

    @Override
    public OrderDelivery get(String id) {
        return (OrderDelivery) getCurrentSession().get(OrderDelivery.class,id);
    }

    @Override
    public List<OrderDelivery> findAll() {
        return getCurrentSession().createCriteria(OrderDelivery.class).list();
    }

    @Override
    public void persisit(OrderDelivery entity) {
        getCurrentSession().persist(entity);
    }

    @Override
    public String save(OrderDelivery entity) {
        return (String) getCurrentSession().save(entity);
    }

    @Override
    public void saveOrUpdate(OrderDelivery entity) {
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
    public List<OrderDelivery> findByOrderID(String orderID) {
        return getCurrentSession().createCriteria(OrderDelivery.class).
                add(Restrictions.eq("orderId",orderID)).list();
    }
}
