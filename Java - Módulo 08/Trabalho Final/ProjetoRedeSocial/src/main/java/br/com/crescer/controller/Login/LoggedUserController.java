package br.com.crescer.controller.login;

import br.com.crescer.entity.Perfil;
import br.com.crescer.entity.Usuario;
import br.com.crescer.service.Usuario.UsuarioServiceImpl;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author carloshenrique
 */
@RestController
@RequestMapping("/usuario")
public class LoggedUserController {

    @Autowired
    UsuarioServiceImpl usuarioService;
    
    @GetMapping("/get")
    public Usuario getUserDetails() {
        return Optional.ofNullable(SecurityContextHolder.getContext())
                .map(SecurityContext::getAuthentication)
                .map(Authentication::getPrincipal)
                .map(User.class::cast)
                .map(User::getUsername)
                .map(usuarioService::findOneByEmail)
                .orElse(null);
    }
    @GetMapping(value = "/getPerfil")
    public Perfil getUserDetailsPerfil() {
       return Optional.ofNullable(SecurityContextHolder.getContext())
                .map(SecurityContext::getAuthentication)
                .map(Authentication::getPrincipal)
                .map(User.class::cast)
                .map(User::getUsername)
                .map(usuarioService::findOneByEmail)
                .map(Usuario::getPerfil)
                .orElse(null);
    }
}       