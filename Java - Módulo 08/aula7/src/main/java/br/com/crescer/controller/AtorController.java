/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.controller;

import br.com.crescer.entity.Ator;
import br.com.crescer.service.AtorService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author joao.silva
 */
@RestController
@RequestMapping("/ator")
public class AtorController implements BasicController<Ator,Long>{

    @Autowired
    AtorService service;
    Ator ator;

    @Override
    @PostMapping(value = "/save")
    public Ator save(@RequestBody Ator ator) {
        return service.save(ator);
    }

    @Override
    @PutMapping(value = "/delete")
    public void delete(@RequestBody Ator ator) {
        service.delete(ator);
    }

    @Override
    @GetMapping(value = "/findOne/{id}")
    public Ator findOne(@PathVariable Long id) {
        return service.findOne(id);
    }

    @Override
    @GetMapping(value = "/findAll")
    public List<Ator> findAll() {
        return service.findAll();
    }

    @Override
    public Page<Ator> findPage(int page, int size) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
