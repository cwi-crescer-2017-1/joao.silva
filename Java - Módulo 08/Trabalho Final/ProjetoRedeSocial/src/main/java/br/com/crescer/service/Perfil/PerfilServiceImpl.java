/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.service.Perfil;

import br.com.crescer.entity.Perfil;
import br.com.crescer.repository.PerfilRepository;
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
public class PerfilServiceImpl implements PerfilService{
    @Autowired
    PerfilRepository perfilRepository;

    @Override
    public List<Perfil> findAll() {
        return (List<Perfil>) perfilRepository.findAll();
    }

    @Override
    public Page<Perfil> findPage(int page, int size) {
        return perfilRepository.findAll(new PageRequest(page, size));
    }

    @Override
    public Perfil save(Perfil perfil) {
        return perfilRepository.save(perfil);
    }

    @Override
    public void delete(Perfil perfil) {
        perfilRepository.delete(perfil);
    }

    @Override
    public Perfil findOne(Long id) {
        return perfilRepository.findOne(id);          
    }
}
