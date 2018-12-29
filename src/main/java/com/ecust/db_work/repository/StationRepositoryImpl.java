package com.ecust.db_work.repository;

import com.ecust.db_work.entity.Deliveryinfo;
import com.ecust.db_work.entity.Station;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class StationRepositoryImpl implements StationRepository {
    @Autowired
    private SessionFactory sessionFactory;
    public Session getCurrentSession(){
        return this.sessionFactory.getCurrentSession();
    }

    @Override
    public Station load(String id) {
        return (Station) getCurrentSession().load(Station.class,id);
    }

    @Override
    public Station get(String id) {
        return (Station) getCurrentSession().get(Station.class,id);
    }

    @Override
    public List<Station> findAll() {
        return getCurrentSession().createCriteria(Station.class).list();
    }

    @Override
    public void persisit(Station entity) {
        getCurrentSession().persist(entity);
    }

    @Override
    public String save(Station entity) {
        return (String) getCurrentSession().save(entity);
    }

    @Override
    public void saveOrUpdate(Station entity) {
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
    public List<Station> findByName(String name) {
        Criteria c = getCurrentSession().createCriteria(Station.class);
        c.add(Restrictions.like("name","%" + name + "%"));
        return c.list() == null? new ArrayList<>() : c.list();
    }

    @Override
    public List<Station> findByAddress(String address) {
        Criteria c = getCurrentSession().createCriteria(Station.class);
        c.add(Restrictions.like("address","%" + address + "%"));
        return c.list();
    }

    public void update(Station station){
        getCurrentSession().update(station);
    }

    public String generatedStationID() {
        int tmp = ((Number)getCurrentSession().createCriteria(Station.class).setProjection(
                Projections.rowCount()).uniqueResult()).intValue();
        String ID = "S";
        tmp++;
        ID += tmp / 10000 % 10;
        ID += tmp / 1000 % 10;
        ID += tmp / 100 % 10;
        ID += tmp / 10 % 10;
        ID += tmp % 10;
        return ID;
    }
}
