/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.service.Genero;

import br.com.crescer.entity.Genero;
import br.com.crescer.repository.GeneroRepository;
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
public class GeneroServiceImpl implements GeneroService{
    
    @Autowired
    GeneroRepository generoRepository;
    
    @Override
    public Genero save(Genero genero) {
        return generoRepository.save(genero);
    }

    @Override
    public void delete(Genero genero) {
        generoRepository.delete(genero);
    }

    @Override
    public Genero findOne(Long id) {
        return generoRepository.findOne(id);          
    }

    @Override
    public List<Genero> findAll() {
        return (List<Genero>) generoRepository.findAll();
    }

    @Override
    public Page<Genero> findPage(int page, int size) {
        return generoRepository.findAll(new PageRequest(page, size));
    }
}
