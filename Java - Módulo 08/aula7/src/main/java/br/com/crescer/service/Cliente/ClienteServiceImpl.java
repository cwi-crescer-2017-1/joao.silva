/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.service.Cliente;

import br.com.crescer.service.Cliente.ClienteService;
import br.com.crescer.entity.Cliente;
import br.com.crescer.repository.ClienteRepository;
import br.com.crescer.repository.ClienteRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

/**
 *
 * @author jpedr
 */
@Service
public class ClienteServiceImpl implements ClienteService{
    @Autowired
    ClienteRepository clienteRepository;
    
    @Override
    public Cliente save(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public void delete(Cliente cliente) {
        clienteRepository.delete(cliente);
    }

    @Override
    public Cliente findOne(Long id) {
        return clienteRepository.findOne(id);          
    }

    @Override
    public List<Cliente> findAll() {
        return (List<Cliente>) clienteRepository.findAll();
    }

    @Override
    public Page<Cliente> findPage(int page, int size) {
        return clienteRepository.findAll(new PageRequest(page, size));
    }
    
}
