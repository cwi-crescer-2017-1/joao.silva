/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.controller.Locacao;

import br.com.crescer.entity.Locacao;
import br.com.crescer.service.Locacao.LocacaoServiceImpl;
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
@RequestMapping("/locacao")
public class LocacaoControllerImpl implements LocacaoController{
    @Autowired
    LocacaoServiceImpl locacaoService;
    Locacao locacao;
    
    @Override
    @PostMapping(value = "/save")
    public Locacao save(@RequestBody Locacao locacao) {
        return locacaoService.save(locacao);
    }

    @Override
    @PutMapping(value = "/delete")
    public void delete(@RequestBody Locacao locacao) {
        locacaoService.delete(locacao);
    }

    @Override
    @GetMapping(value = "/findOne/{id}")
    public Locacao findOne(@PathVariable Long id) {
        return locacaoService.findOne(id);
    }

    @Override
    @GetMapping(value = "/findAll")
    public List<Locacao> findAll() {
        return locacaoService.findAll();
    }

    @Override
    @GetMapping(value = "/findPage/{page}/{size}")
    public Page<Locacao> findPage(@PathVariable int page, @PathVariable int size) {
        return locacaoService.findPage(page,size);
    }
}
