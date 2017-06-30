/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.controller.Login;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;


/**
 *
 * @author joao.silva
 */
public interface LoginController{
    User getUserDetails(Authentication authentication);
}
