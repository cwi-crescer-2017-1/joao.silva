/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.hibernate.Session;

/**
 *
 * @author jpedr
 */
public final class ConnectionUtils {
    
    private static EntityManagerFactory emf;
    private static EntityManager em;
    private static Session session;
    private static final String PERSISTENCE_UNIT_NAME = "CRESCER";
        
    private ConnectionUtils(){}
    
    public static void openConnections() {
        if (emf == null || !emf.isOpen()) {
            emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }
        if (em == null || !em.isOpen()) {
            em = emf.createEntityManager();
        }
        if(session == null || !session.isOpen()){
            session = em.unwrap(Session.class);
        }
    }


    public static void closeConnections() {
        if (emf != null || emf.isOpen()) {
            if (em != null || em.isOpen()) {
                em.close();
            }
            emf.close();
        }
    }
    
    public static EntityManager getEntityManager(){
        openConnections();
        return em;
    }
    public static Session getSession(){
        openConnections();
        return session;
    }
}
