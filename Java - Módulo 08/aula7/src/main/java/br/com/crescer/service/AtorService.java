/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.service;

import br.com.crescer.entity.Ator;
import br.com.crescer.repository.AtorRepository;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author joao.silva
 */
@Service
public class AtorService {
    @Autowired
    AtorRepository atorRepository;
    
    public Ator getByID(Long id){
        Ator ator = new Ator();
        return atorRepository.findOne(id);          
    }
    public List<Ator> getAll(){
        return (List<Ator>) atorRepository.findAll();
    }
}
