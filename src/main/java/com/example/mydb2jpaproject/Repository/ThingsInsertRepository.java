package com.example.mydb2jpaproject.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.mydb2jpaproject.entity.Things;

@Repository
public class ThingsInsertRepository {
 
    @PersistenceContext
    private EntityManager entityManager;
    
    @Transactional
    public void insertWithQuery(Things thing) {
        entityManager.createNativeQuery("INSERT INTO things (id, name) VALUES (?,?)")
          .setParameter(1, thing.getId())
          .setParameter(2, thing.getName())
          .executeUpdate();
    }
 
}