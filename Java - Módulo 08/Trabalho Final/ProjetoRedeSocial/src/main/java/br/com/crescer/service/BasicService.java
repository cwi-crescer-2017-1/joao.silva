package br.com.crescer.service;

import java.util.List;
import org.springframework.data.domain.Page;

/**
 * @author jpedr
 * @param <Entity>
 * @param <ID>
 */
public interface BasicService<Entity, ID> {
     
    Entity save(Entity e);
    
    void delete(Entity e);

    Entity findOne(ID id);
}
