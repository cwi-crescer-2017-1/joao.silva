/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author jpedr
 */
public class CrudDaoImpl implements CrudDao<Object, Long, Class> {

    private static EntityManagerFactory emf;
    private static EntityManager em;
    private static Session session;
    private static final String PERSISTENCE_UNIT_NAME = "CRESCER";

    public CrudDaoImpl() {
    }

    @Override
    public Object save(Object object) {
        openConnections();
        try {
            em.getTransaction().begin();
            em.persist(object);
            em.getTransaction().commit();
            em.detach(object);
            return object;
        } catch (Exception e) {
            System.err.print(e);
        }
        return null;
    }

    public Object merge(Object object) {
        openConnections();
        try {
            em.getTransaction().begin();
            em.merge(object);
            em.getTransaction().commit();
            return object;
        } catch (Exception e) {
            System.err.print(e);
        }
        return null;
    }

    @Override
    public boolean remove(Object object) {
        openConnections();
        try {
            em.getTransaction().begin();
            em.remove(object);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            System.err.print(e);
        }
        return false;
    }

    @Override
    public Object loadById(Long id, Class classe) {
        openConnections();
        try {
            em.getTransaction().begin();
            Object object = em.find(classe, id);
            em.getTransaction().commit();
            return object;
        } catch (Exception e) {
            System.err.print(e);
        }
        return null;
    }

    @Override
    public List<Object> findAll(Class classe) {
        openConnections();
        try {
            em.getTransaction().begin();
            session = em.unwrap(Session.class);
            List<Object> listObject = session.createCriteria(classe).list();
            em.getTransaction().commit();
            return listObject;
        } catch (HibernateException e) {
            System.err.print(e);
        }
        return null;
    }

    public void openConnections() {
        if (emf == null || !emf.isOpen()) {
            emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }
        if (em == null || !em.isOpen()) {
            em = emf.createEntityManager();
        }
    }

    public void closeConnections() {
        if (emf.isOpen()) {
            if (em.isOpen()) {
                em.close();
            }
            emf.close();
        }
    }
}
