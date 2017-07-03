/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.service.Postagem;

import br.com.crescer.entity.Postagem;
import br.com.crescer.entity.Usuario;
import br.com.crescer.service.BasicService;
import java.util.List;
import org.springframework.data.domain.Page;

/**
 *
 * @author joao.silva
 */
public interface PostagemService extends BasicService<Postagem,Long>{
    
    List<Postagem> findAll(Usuario usuario);
    
    Page<Postagem> findPage(Usuario usuario, int page, int size);
}
