/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer;

import java.util.List;

/**
 * 
 * @author carloshenrique
 * @param <Entity>
 * @param <ID>
 * 
 */
public interface CrudDao<Entity, ID> {
    
    Entity save(Entity e);
    
    void remove(Entity e);

    Entity loadById(ID id);

    List<Entity> findAll();
    
}