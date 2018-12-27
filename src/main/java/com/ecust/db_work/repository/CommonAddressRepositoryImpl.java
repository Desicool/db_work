package com.ecust.db_work.repository;

import com.ecust.db_work.entity.Commonaddress;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CommonAddressRepositoryImpl implements CommonAddressRepository {
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public Commonaddress load(Integer id) {
        return null;
    }

    @Override
    public Commonaddress get(Integer id) {
        return null;
    }

    @Override
    public List<Commonaddress> findAll() {
        return null;
    }

    @Override
    public void persisit(Commonaddress entity) {

    }

    @Override
    public Integer save(Commonaddress entity) {
        return null;
    }

    @Override
    public void saveOrUpdate(Commonaddress entity) {

    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public void flush() {

    }
}
