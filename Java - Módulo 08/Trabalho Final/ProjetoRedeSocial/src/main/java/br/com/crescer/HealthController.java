/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author carloshenrique
 */
@RestController
@RequestMapping(HealthController.PATH)
public class HealthController {

    public static final String PATH = "/health";
    
    @Secured("ROLE_ADMIN")
    @GetMapping
    public boolean health() {
        return true;
    }
}

