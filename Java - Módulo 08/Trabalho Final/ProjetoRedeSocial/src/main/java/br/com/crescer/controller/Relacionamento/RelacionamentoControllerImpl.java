/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.controller.Relacionamento;

import br.com.crescer.entity.Perfil;
import br.com.crescer.entity.Relacionamento;
import br.com.crescer.service.Relacionamento.RelacionamentoServiceImpl;
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
@RequestMapping("/relacionamento")
public class RelacionamentoControllerImpl implements RelacionamentoController {

    @Autowired
    RelacionamentoServiceImpl relacionamentoService;

    @Override
    @PostMapping("/save")
    public Relacionamento save(@RequestBody Relacionamento e) {
        return relacionamentoService.save(e);
    }

    @Override
    @PutMapping("/delete")
    public void delete(@RequestBody  Relacionamento e) {
        relacionamentoService.delete(e);
    }
    
    @Override
    @PutMapping("/removerAmigo/{idPerfilUsuario}")
    public void removerAmigo(@PathVariable Long idPerfilUsuario,@RequestBody Perfil perfilAmigo ) {
        relacionamentoService.removerAmigo(idPerfilUsuario, perfilAmigo);
    }

    @Override
    @GetMapping(value = "/findOne/{id}")
    public Relacionamento findOne(@PathVariable Long id) {
        return relacionamentoService.findOne(id);
    }

    @Override
    @PutMapping("/responder/{resposta}")
    public Relacionamento responder(@PathVariable Boolean resposta, @RequestBody Relacionamento relacionamento) {
        return relacionamentoService.responder(relacionamento, resposta);
    }
    
    @GetMapping(value = "/findOneByPerfil/{idPerfil}/{idPerfil2}")
    public Relacionamento findOneByPerfil(@PathVariable Long idPerfil, @PathVariable Long idPerfil2){
        return relacionamentoService.findOneByPerfil(idPerfil,idPerfil2);
    }

}
