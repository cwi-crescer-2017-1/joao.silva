/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula4.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author joao.silva
 */
public class RunJPA {

    public static void main(String[] args) {
        final EntityManagerFactory emf;
        emf = Persistence.createEntityManagerFactory("localPU");
        final EntityManager em;
        em = emf.createEntityManager();
        
        final Cliente cliente = new Cliente(); 
//        cliente.setId(5L);
//        cliente.setNome("Pedro");
        final Cliente clienteBD = em.find(Cliente.class, 1L);
        clienteBD.setNome("Ala");
        em.getTransaction().begin();
        //em.persist(cliente);       
        
        
        //em.remove(cliente2);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
