/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.service.Relacionamento;

import br.com.crescer.entity.Relacionamento;
import br.com.crescer.repository.RelacionamentoRepository;
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
public class RelacionamentoServiceImpl implements RelacionamentoService{
    @Autowired
    RelacionamentoRepository relacionamentoRepository;

    @Override
    public List<Relacionamento> findAll() {
        return (List<Relacionamento>) relacionamentoRepository.findAll();
    }

    @Override
    public Page<Relacionamento> findPage(int page, int size) {
        return relacionamentoRepository.findAll(new PageRequest(page, size));
    }

    @Override
    public Relacionamento save(Relacionamento relacionamento) {
        return relacionamentoRepository.save(relacionamento);
    }

    @Override
    public void delete(Relacionamento relacionamento) {
        relacionamentoRepository.delete(relacionamento);
    }

    @Override
    public Relacionamento findOne(Long id) {
        return relacionamentoRepository.findOne(id);          
    }
}
