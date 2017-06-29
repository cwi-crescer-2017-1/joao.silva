/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.service.Locacao;

import br.com.crescer.entity.Locacao;
import br.com.crescer.repository.LocacaoRepository;
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
public class LocacaoServiceImpl implements LocacaoService{
    @Autowired
    LocacaoRepository locacaoRepository;
    
    @Override
    public Locacao save(Locacao locacao) {
        return locacaoRepository.save(locacao);
    }

    @Override
    public void delete(Locacao locacao) {
        locacaoRepository.delete(locacao);
    }

    @Override
    public Locacao findOne(Long id) {
        return locacaoRepository.findOne(id);          
    }

    @Override
    public List<Locacao> findAll() {
        return (List<Locacao>) locacaoRepository.findAll();
    }

    @Override
    public Page<Locacao> findPage(int page, int size) {
        return locacaoRepository.findAll(new PageRequest(page, size));
    }
}
