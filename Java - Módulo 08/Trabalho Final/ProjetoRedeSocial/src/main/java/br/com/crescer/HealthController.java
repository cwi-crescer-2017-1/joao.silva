/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer;

import br.com.crescer.entity.Usuario;
import br.com.crescer.service.Usuario.UsuarioServiceImpl;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author carloshenrique
 */
@RestController
@RequestMapping("/health")
public class HealthController {

    @Autowired
    UsuarioServiceImpl usuarioService;
 //   @Secured("ROLE_USER")
    @GetMapping("/oi")
    public boolean health() {
        return true;
    }
}

