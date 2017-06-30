/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.service.Usuario;

import br.com.crescer.entity.Usuario;
import br.com.crescer.service.BasicService;

/**
 * @author joao.silva
 */
public interface UsuarioService extends BasicService<Usuario,Long>{      
    Usuario findOneByEmail(String email);
}
