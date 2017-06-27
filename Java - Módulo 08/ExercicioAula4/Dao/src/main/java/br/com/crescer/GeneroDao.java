/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer;

import javax.persistence.EntityManager;

/**
 *
 * @author joao.silva
 */
public class GeneroDao extends CrudDaoImpl<Genero,Long>{
    
    private final EntityManager entityManager;
    
    public GeneroDao(EntityManager em) {
        super(Genero.class);
        this.entityManager = em;
    }
    public EntityManager getEntityManager() {
        return entityManager;
    }
    
}
