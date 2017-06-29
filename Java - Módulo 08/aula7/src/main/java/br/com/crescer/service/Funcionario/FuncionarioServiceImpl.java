/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.service.Funcionario;

import br.com.crescer.entity.Funcionario;
import br.com.crescer.repository.FuncionarioRepository;
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
public class FuncionarioServiceImpl implements FuncionarioService{

    @Autowired
    FuncionarioRepository funcionarioRepository;
    
    @Override
    public Funcionario save(Funcionario funcionario) {
        return funcionarioRepository.save(funcionario);
    }

    @Override
    public void delete(Funcionario funcionario) {
        funcionarioRepository.delete(funcionario);
    }

    @Override
    public Funcionario findOne(Long id) {
        return funcionarioRepository.findOne(id);          
    }

    @Override
    public List<Funcionario> findAll() {
        return (List<Funcionario>) funcionarioRepository.findAll();
    }

    @Override
    public Page<Funcionario> findPage(int page, int size) {
        return funcionarioRepository.findAll(new PageRequest(page, size));
    }
    
}
