package br.com.crescer.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author carloshenrique
 */
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SocialWebSecurityConfig extends WebSecurityConfigurerAdapter {    
    @Value("${social.security.public:/estado/all}") 
    private String[] securityPublic;
    
    @Value("${social.security.public:/usuarioCon/save}") 
    private String[] securityPublicUser;
    
    @Value("${social.security.public:/perfil/save}")
    private String[] securityPublicPerfil;  
    
    @Value("${social.security.public:/usuarioCon/update}")
    private String[] securityPublicUsuarioPerfil;  
    
    @Autowired
    private SocialUserDetailsService userDetailsService;
    
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .authorizeRequests().anyRequest().authenticated()
                .and()
                .httpBasic()
                .and()
                .cors()
                .and()
                .csrf().disable();
    }
    
    @Override
    public void configure(WebSecurity webSecurity) throws Exception {
       webSecurity.ignoring()
               .antMatchers(securityPublic)
               .antMatchers(securityPublicUser)
               .antMatchers(securityPublicPerfil)
               .antMatchers(securityPublicUsuarioPerfil);
    }
    
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedMethods("PUT", "DELETE","POST","GET");
            }
        };
    }

    @Autowired
    public void setDetailsService(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }
}
