package br.com.crescer.controller;

/**
 * @author jpedr
 * @param <Entity>
 * @param <ID>
 */
public interface BasicController<Entity,ID> {
    Entity save(Entity e);
    
    void delete(Entity e);

    Entity findOne(ID id);
}
