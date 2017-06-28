/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.controller;

import br.com.crescer.entity.Ator;
import br.com.crescer.service.AtorService;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author joao.silva
 */

@RestController

public class AtorController {
    
    @Autowired
    AtorService service;

    @RequestMapping(value = "/ator/{id}", method = RequestMethod.GET)
    Ator getAtor(@PathVariable Long id) {
        return service.getByID(id);
    }
    @RequestMapping(value = "/atores", method = RequestMethod.GET)
    List<Ator> getAll() {
        return service.getAll();
    }

}
