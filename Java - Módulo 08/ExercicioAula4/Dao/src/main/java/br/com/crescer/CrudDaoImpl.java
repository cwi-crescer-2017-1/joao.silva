/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer;

import static br.com.crescer.ConnectionUtils.getEntityManager;
import static br.com.crescer.ConnectionUtils.getSession;
import java.util.List;
import javax.persistence.EntityManager;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author jpedr
 * @param <Entity>
 * @param <ID>
 * 
 */
public class CrudDaoImpl<Entity, ID> implements CrudDao<Entity, ID> {
 
    private final Class<Entity> classe;
    
    public CrudDaoImpl(Class classe){
        this.classe = classe;
    }
    @Override
    public Entity save(Entity object) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(object);
            em.getTransaction().commit();
            return object;
        } catch (Exception e) {
            //System.err.print(e);
            throw new RuntimeException(e);
        }
        //return null;
    }

    @Override
    public void remove(Entity object) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.remove(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            //System.err.print(e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public Entity loadById(ID id) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            Entity object = em.find(classe, id);
            em.getTransaction().commit();
            return object;
        } catch (Exception e) {
            //System.err.print(e);
            throw new RuntimeException(e);
        }
      //  return null;
    }

    @Override
    public List<Entity> findAll() {
        EntityManager em = getEntityManager();
        Session session = getSession();
        try {
            em.getTransaction().begin();
            List<Entity> listObject = session.createCriteria(classe).list();
            em.getTransaction().commit();
            return listObject;
        } catch (HibernateException e) {
            //System.err.print(e);
            throw new RuntimeException(e);
        }
     //   return null;
    }
}
