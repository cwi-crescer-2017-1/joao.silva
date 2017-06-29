/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.service;

import java.util.List;
import org.springframework.data.domain.Page;

/**
 *
 * @author jpedr
 * @param <Entity>
 * @param <ID>
 */
public interface BasicService<Entity, ID> {
     
    Entity save(Entity e);
    
    void delete(Entity e);

    Entity findOne(ID id);

    List<Entity> findAll();
    
    Page<Entity> findPage(int page, int size);
}
