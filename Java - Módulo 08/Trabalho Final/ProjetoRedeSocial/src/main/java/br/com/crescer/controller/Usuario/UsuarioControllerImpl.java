/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.controller.Usuario;

import br.com.crescer.entity.Usuario;
import br.com.crescer.service.Usuario.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jpedr
 */
@RestController
@RequestMapping("/usuarioCon")
public class UsuarioControllerImpl implements UsuarioController{
    @Autowired
    UsuarioServiceImpl usuarioService;
    
    @Override
    @PostMapping(value = "/save")
    public Usuario save(@RequestBody Usuario usuario) {
       usuario.setSenha(new BCryptPasswordEncoder(6).encode(usuario.getSenha())); 
       Usuario retorno = usuarioService.save(usuario); 
       if(retorno == null){ 
           throw new RuntimeException("Email já cadastrado");
       }else{
           return retorno;
       }
       
    }
    
    @Override
    @PutMapping(value = "/delete")
    public void delete(@RequestBody Usuario usuario) {
        usuarioService.delete(usuario);
    }

    @Override
    @GetMapping(value = "/findOne/{id}")
    public Usuario findOne(@PathVariable Long id) {
        return usuarioService.findOne(id);
    }
    
    
}
