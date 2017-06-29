/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.controller.Funcionario;

import br.com.crescer.entity.Funcionario;
import br.com.crescer.service.Funcionario.FuncionarioServiceImpl;
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
@RequestMapping("/funcionario")
public class FuncionarioControllerImpl implements FuncionarioController{

    @Autowired
    FuncionarioServiceImpl funcionarioService;
    Funcionario funcionario;
    
    @Override
    @PostMapping(value = "/save")
    public Funcionario save(@RequestBody Funcionario funcionario) {
        return funcionarioService.save(funcionario);
    }

    @Override
    @PutMapping(value = "/delete")
    public void delete(@RequestBody Funcionario funcionario) {
        funcionarioService.delete(funcionario);
    }

    @Override
    @GetMapping(value = "/findOne/{id}")
    public Funcionario findOne(@PathVariable Long id) {
        return funcionarioService.findOne(id);
    }

    @Override
    @GetMapping(value = "/findAll")
    public List<Funcionario> findAll() {
        return funcionarioService.findAll();
    }

    @Override
    @GetMapping(value = "/findPage/{page}/{size}")
    public Page<Funcionario> findPage(@PathVariable int page, @PathVariable int size) {
        return funcionarioService.findPage(page,size);
    }
    
}
