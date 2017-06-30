package br.com.crescer.security;

import br.com.crescer.entity.Usuario;
import br.com.crescer.service.Usuario.UsuarioServiceImpl;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author joao.silva
 */
@Service
public class SocialUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final List<GrantedAuthority> grants = new ArrayList<>();
        System.err.println(username);
        if ("admin".equals(username)) {
            grants.add(() -> "ROLE_ADMIN");
        }
        return new User(username, "123", grants);
    }
}
