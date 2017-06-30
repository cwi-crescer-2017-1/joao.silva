/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.service.Estado;

import br.com.crescer.entity.Estado;
import br.com.crescer.repository.EstadoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

/**
 *
 * @author joao.silva
 */
@Service
public class EstadoServiceImpl implements EstadoService{
    @Autowired
    EstadoRepository estadoRepository;

    @Override
    public List<Estado> findAll() {
        return (List<Estado>) estadoRepository.findAll();
    }

    @Override
    public Page<Estado> findPage(int page, int size) {
        return estadoRepository.findAll(new PageRequest(page, size));
    }

    @Override
    public Estado save(Estado estado) {
        return estadoRepository.save(estado);
    }

    @Override
    public void delete(Estado estado) {
        estadoRepository.delete(estado);
    }

    @Override
    public Estado findOne(Long id) {
        return estadoRepository.findOne(id);          
    }
    
}
