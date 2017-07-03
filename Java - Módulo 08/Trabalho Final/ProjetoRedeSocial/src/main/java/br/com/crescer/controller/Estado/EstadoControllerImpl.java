/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.controller.Estado;

import br.com.crescer.entity.Estado;
import br.com.crescer.service.Estado.EstadoServiceImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 *
 * @author jpedr
 */
@RestController
@RequestMapping("/estado")
public class EstadoControllerImpl implements EstadoController{
    @Autowired
    EstadoServiceImpl estadoService;
    
    @Override
    @GetMapping(value = "/all")
    public List<Estado> findAll() {
        return estadoService.findAll();
    }

}
