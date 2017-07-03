/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.controller.Postagem;

import br.com.crescer.entity.Postagem;
import br.com.crescer.entity.Usuario;
import br.com.crescer.service.Postagem.PostagemServiceImpl;
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
@RequestMapping("/postagem")
public class PostagemControllerImpl implements PostagemController{

    @Autowired
    PostagemServiceImpl postagemService;
    
    @Override
    @PostMapping(value = "/findAll")
    public List<Postagem> findAll(@RequestBody Usuario usuario) {
        return postagemService.findAll(usuario);
    }
    @Override
    @PostMapping(value = "/findPage/{page}/{size}")
    public Page<Postagem> findPage(@RequestBody Usuario usuario, @PathVariable int page,@PathVariable int size) {
        return postagemService.findPage(usuario ,page, size);
    }

    @Override
    @PostMapping(value = "/save")
    public Postagem save(@RequestBody Postagem e) {
        return postagemService.save(e);
    }

    @Override
    @PutMapping(value = "/delete")
    public void delete(@RequestBody Postagem e) {
        postagemService.delete(e);
    }

    @Override
    @GetMapping(value = "/findOne/{id}")
    public Postagem findOne(@PathVariable Long id) {
        return postagemService.findOne(id);
    }
}
