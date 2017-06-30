/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.controller;

import java.util.List;
import org.springframework.data.domain.Page;

/**
 *
 * @author joao.silva
 * @param <Entity>
 * @param <ID>
 */
public interface LessBasicController<Entity,ID> extends BasicController<Entity,ID>{
    List<Entity> findAll();
    
    Page<Entity> findPage(int page, int size);
}
