package br.com.crescer.service;

import java.util.List;
import org.springframework.data.domain.Page;

/**
 *
 * @author joao.silva
 * @param <Entity>
 * @param <ID>
 */
public interface LessBasicService<Entity,ID> extends BasicService<Entity,ID>{
      List<Entity> findAll();
    
      Page<Entity> findPage(int page, int size);
}


