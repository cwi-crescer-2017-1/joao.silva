/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.service.AlteracaoSenha;

import br.com.crescer.entity.AlteracaoSenha;
import br.com.crescer.repository.AlteracaoSenhaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author joao.silva
 */
@Service
public class AlteracaoSenhaServiceImpl implements AlteracaoSenhaService{
    @Autowired
    AlteracaoSenhaRepository alteracaoSenhaRepository;
    
    @Override
    public AlteracaoSenha save(AlteracaoSenha alteracaoSenha) {
        return alteracaoSenhaRepository.save(alteracaoSenha);
    }

    @Override
    public void delete(AlteracaoSenha alteracaoSenha) {
        alteracaoSenhaRepository.delete(alteracaoSenha);
    }

    @Override
    public AlteracaoSenha findOne(Long id) {
        return alteracaoSenhaRepository.findOne(id);          
    }
}
