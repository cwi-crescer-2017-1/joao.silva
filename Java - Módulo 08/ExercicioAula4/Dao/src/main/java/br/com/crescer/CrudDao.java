/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer;

import java.util.List;

/**
 * @author carloshenrique
 * @param <Entity>
 * @param <ID>
 * @param <T>
 */
public interface CrudDao<Entity, ID, T> {
    
    Entity save(Entity e);

    boolean remove(Entity e);

    Entity loadById(ID id,Class T);

    List<Entity> findAll(Class T);
    
}