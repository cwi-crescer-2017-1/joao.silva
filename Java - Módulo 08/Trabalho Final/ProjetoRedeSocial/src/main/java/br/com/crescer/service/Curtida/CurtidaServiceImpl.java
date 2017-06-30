/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.service.Curtida;

import br.com.crescer.entity.Curtida;
import br.com.crescer.repository.CurtidaRepository;
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
public class CurtidaServiceImpl implements CurtidaService{
    @Autowired
    CurtidaRepository curtidaRepository;

    @Override
    public List<Curtida> findAll() {
        return (List<Curtida>) curtidaRepository.findAll();
    }

    @Override
    public Page<Curtida> findPage(int page, int size) {
        return curtidaRepository.findAll(new PageRequest(page, size));
    }

    @Override
    public Curtida save(Curtida curtida) {
        return curtidaRepository.save(curtida);
    }

    @Override
    public void delete(Curtida curtida) {
        curtidaRepository.delete(curtida);
    }

    @Override
    public Curtida findOne(Long id) {
        return curtidaRepository.findOne(id);          
    }
}
