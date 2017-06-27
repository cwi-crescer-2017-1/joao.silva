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
public class VideoDao extends CrudDaoImpl<Video,Long>{
    
    private final EntityManager entityManager;
    public VideoDao(EntityManager em) {
        super(Video.class);
        this.entityManager = em;
    }
    public EntityManager getEntityManager() {
        return entityManager;
    }
    
}
