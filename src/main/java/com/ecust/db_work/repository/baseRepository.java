package com.ecust.db_work.repository;

import org.hibernate.SessionFactory;

import java.io.Serializable;
import java.util.List;

public interface baseRepository <T,PK extends Serializable> {
    T load(PK id);
    T get(PK id);
    List<T> findAll();
    void persisit(T entity);
    PK save(T entity);
    void saveOrUpdate(T entity);
    void delete(PK id);
    void flush();
}
