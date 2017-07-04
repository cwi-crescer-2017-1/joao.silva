/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.controller.Comentario;

import br.com.crescer.entity.Comentario;
import br.com.crescer.service.Comentario.ComentarioServiceImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/comentario")
public class ComentarioControllerImpl implements ComentarioController {

    @Autowired
    ComentarioServiceImpl comentarioService;

    @PostMapping("/save/{idPostagem}")
    public Comentario create(@PathVariable Long idPostagem, @RequestBody Comentario comentario) {
        return comentarioService.save(comentario,idPostagem);
    }
    
    @GetMapping("/get/postagem/{idPostagem}")
    public List<Comentario> findByPostagem(@PathVariable Long idPostagem){
        return comentarioService.findByPostagem(idPostagem);
    }

    @Override
    @PutMapping("/delete")
    public void delete(@RequestBody Comentario comentario) {
        comentarioService.delete(comentario);
    }

    @Override
    @GetMapping(value = "/findOne/{id}")
    public Comentario findOne(@PathVariable Long id) {
        return comentarioService.findOne(id);
    }

    @Override
    public Comentario save(Comentario e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
