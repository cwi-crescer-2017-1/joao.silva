package br.com.crescer.security;

import br.com.crescer.controller.login.LoggedUserController;
import br.com.crescer.entity.Usuario;
import br.com.crescer.service.Usuario.UsuarioServiceImpl;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author joao.silva
 */
@Service
public class SocialUserDetailsService implements UserDetailsService {

    @Autowired
    UsuarioServiceImpl usuarioService;
    @Autowired
    LoggedUserController logger;
    
    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        List<GrantedAuthority> grants = new ArrayList<>();
        Usuario usuario = usuarioService.findOneByEmail(username);
        return new User(usuario.getEmail(),usuario.getSenha(),grants);
    }
}
