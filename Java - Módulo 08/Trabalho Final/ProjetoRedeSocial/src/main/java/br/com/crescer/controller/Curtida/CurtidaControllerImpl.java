/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.controller.Curtida;

import br.com.crescer.entity.Curtida;
import br.com.crescer.service.Curtida.CurtidaServiceImpl;
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
@RequestMapping("/curtida")
public class CurtidaControllerImpl implements CurtidaController{
    
    @Autowired
    CurtidaServiceImpl curtidaService;
    
    @Override
    public Curtida save(@RequestBody Curtida curtida) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     *
     * @param idPostagem
     * @param curtida
     * @return
     */
    @Override
    @PostMapping("/save/{idPostagem}")
    public Curtida save(@PathVariable Long idPostagem, @RequestBody Curtida curtida) {
        return curtidaService.save(curtida,idPostagem);
    }

    @Override
    @PutMapping("/delete")
    public void delete(@RequestBody Curtida curtida) {
        curtidaService.delete(curtida);
    }
    @Override
    @PutMapping("/remove/{idPostagem}/{idPerfil}")
    public void remove(@PathVariable Long idPostagem, @PathVariable Long idPerfil) {
        curtidaService.remove(idPostagem,idPerfil);
    }
    @Override
    @GetMapping(value = "/findOne/{id}")
    public Curtida findOne(@PathVariable Long id) {
        return curtidaService.findOne(id);
    }
    
}
