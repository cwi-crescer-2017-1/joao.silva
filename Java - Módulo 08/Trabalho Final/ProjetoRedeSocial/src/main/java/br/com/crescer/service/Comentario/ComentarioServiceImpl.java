/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.service.Comentario;

import br.com.crescer.entity.Comentario;
import br.com.crescer.repository.ComentarioRepository;
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
public class ComentarioServiceImpl implements ComentarioService{
    @Autowired
    ComentarioRepository comentarioRepository;

    @Override
    public List<Comentario> findAll() {
        return (List<Comentario>) comentarioRepository.findAll();
    }

    @Override
    public Page<Comentario> findPage(int page, int size) {
        return comentarioRepository.findAll(new PageRequest(page, size));
    }

    @Override
    public Comentario save(Comentario comentario) {
        return comentarioRepository.save(comentario);
    }

    @Override
    public void delete(Comentario comentario) {
        comentarioRepository.delete(comentario);
    }

    @Override
    public Comentario findOne(Long id) {
        return comentarioRepository.findOne(id);          
    }
}
