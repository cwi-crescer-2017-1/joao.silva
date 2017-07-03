/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.service.Usuario;

import br.com.crescer.entity.Usuario;
import br.com.crescer.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author joao.silva
 */
@Service
public class UsuarioServiceImpl implements UsuarioService{
    @Autowired
    UsuarioRepository usuarioRepository;
    
    @Autowired
    UsuarioServiceImpl usuarioService;
    
    @Override
    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public void delete(Usuario usuario) {
        usuarioRepository.delete(usuario);
    }

    @Override
    public Usuario findOne(Long id) {
        return usuarioRepository.findOne(id);          
    }

    @Override
    public Usuario findOneByEmail(String email) {
        return usuarioRepository.findOneByEmail(email);
    }

}
