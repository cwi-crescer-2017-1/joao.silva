/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.controller.Postagem;

import br.com.crescer.controller.BasicController;
import br.com.crescer.entity.Postagem;
import br.com.crescer.entity.Usuario;
import java.util.List;
import org.springframework.data.domain.Page;

/**
 *
 * @author jpedr
 */
public interface PostagemController extends BasicController<Postagem,Long>{
    List<Postagem> findAll(Usuario usuario);
    
    Page<Postagem> findPage(Usuario usuario, int page, int size);
}
