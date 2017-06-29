/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.controller.Genero;

import br.com.crescer.entity.Genero;
import br.com.crescer.service.Genero.GeneroServiceImpl;
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
 * @author jpedr
 */
@RestController
@RequestMapping("/genero")
public class GeneroControllerImpl implements GeneroController{
    @Autowired
    GeneroServiceImpl generoService;
    Genero genero;
    
    @Override
    @PostMapping(value = "/save")
    public Genero save(@RequestBody Genero genero) {
        return generoService.save(genero);
    }

    @Override
    @PutMapping(value = "/delete")
    public void delete(@RequestBody Genero genero) {
        generoService.delete(genero);
    }

    @Override
    @GetMapping(value = "/findOne/{id}")
    public Genero findOne(@PathVariable Long id) {
        return generoService.findOne(id);
    }

    @Override
    @GetMapping(value = "/findAll")
    public List<Genero> findAll() {
        return generoService.findAll();
    }

    @Override
    @GetMapping(value = "/findPage/{page}/{size}")
    public Page<Genero> findPage(@PathVariable int page, @PathVariable int size) {
        return generoService.findPage(page,size);
    }
}
