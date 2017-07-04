/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.controller.Perfil;

import br.com.crescer.entity.Perfil;
import br.com.crescer.service.Perfil.PerfilServiceImpl;
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
@RequestMapping("/perfil")
public class PerfilControllerImpl implements PerfilController{
    @Autowired
    PerfilServiceImpl perfilService;
    
    @Override
    @PostMapping("/save")
    public Perfil save(@RequestBody Perfil perfil) {
        return perfilService.save(perfil);
    }

    @Override
    @PutMapping("/delete")
    public void delete(@RequestBody Perfil perfil) {
        perfilService.delete(perfil);
    }

    @Override
    @GetMapping(value = "/findOne/{id}")
    public Perfil findOne(@PathVariable Long id) {
        return perfilService.findOne(id);
    }
    
    @Override
    @GetMapping(value = "/findByName/{nome}")
    public List<Perfil> findByName(@PathVariable String nome){
        return perfilService.findByName(nome);
    }
    
    @Override
    @GetMapping(value = "/findByName/WithFriendship/{idPerfil}/{nome}")
    public List<Perfil> findByNameWithFriendship(@PathVariable Long idPerfil,@PathVariable String nome){
        return perfilService.findByNameWithFriendship(idPerfil, nome);
    }
    @Override
    @GetMapping(value = "/findAll/WithRelation/{idPerfil}")
    public List<Perfil> fiendPeopleWithRelation(@PathVariable Long idPerfil){
        return perfilService.fiendPeopleWithRelation(idPerfil);
    }
}
