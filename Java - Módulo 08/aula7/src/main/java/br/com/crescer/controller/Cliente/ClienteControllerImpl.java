/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.controller.Cliente;

import br.com.crescer.entity.Cliente;
import br.com.crescer.service.Cliente.ClienteServiceImpl;
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
@RequestMapping("/cliente")
public class ClienteControllerImpl implements ClienteController{

    @Autowired
    ClienteServiceImpl clienteService;
    Cliente cliente;
    
    @Override
    @PostMapping(value = "/save")
    public Cliente save(@RequestBody Cliente cliente) {
        return clienteService.save(cliente);
    }

    @Override
    @PutMapping(value = "/delete")
    public void delete(@RequestBody Cliente cliente) {
        clienteService.delete(cliente);
    }

    @Override
    @GetMapping(value = "/findOne/{id}")
    public Cliente findOne(@PathVariable Long id) {
        return clienteService.findOne(id);
    }

    @Override
    @GetMapping(value = "/findAll")
    public List<Cliente> findAll() {
        return clienteService.findAll();
    }

    @Override
    @GetMapping(value = "/findPage/{page}/{size}")
    public Page<Cliente> findPage(@PathVariable int page, @PathVariable int size) {
        return clienteService.findPage(page,size);
    }
    
}
