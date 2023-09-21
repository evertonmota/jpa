package com.minhaempresa.application.services;

import infrastructure.models.Request;
import infrastructure.utils.EntityManagerFactorySingleton;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.List;

public class RequestService {
    EntityManagerFactory entityManagerFactory = EntityManagerFactorySingleton.getInstance();
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    public Request requestRegistration(Request request){
        entityManager.getTransaction().begin();
        entityManager.persist(request);
        entityManager.getTransaction().commit();
        return request;
    }
    public Request findById(String id){
        return entityManager.find(Request.class, id);
    }
    public List<Request> findAll(){
        Query query = entityManager.createQuery("from Request");
        return query.getResultList();
    }
    public void deleteById(Request request){
        entityManager.getTransaction().begin();
        entityManager.remove(request);
        entityManager.getTransaction().commit();
    }

    public Request update(Request request){
        entityManager.getTransaction().begin();
        entityManager.persist(request);
        entityManager.getTransaction().commit();
        return request;
    }
    public void closeEntityManager(){
        entityManager.close();
    }

}
