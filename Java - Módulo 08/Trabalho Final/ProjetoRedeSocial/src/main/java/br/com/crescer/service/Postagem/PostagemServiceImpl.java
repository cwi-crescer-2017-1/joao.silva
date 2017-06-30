/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.service.Postagem;

import br.com.crescer.entity.Postagem;
import br.com.crescer.repository.PostagemRepository;
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
public class PostagemServiceImpl implements PostagemService{
    @Autowired
    PostagemRepository postagemRepository;

    @Override
    public List<Postagem> findAll() {
        return (List<Postagem>) postagemRepository.findAll();
    }

    @Override
    public Page<Postagem> findPage(int page, int size) {
        return postagemRepository.findAll(new PageRequest(page, size));
    }

    @Override
    public Postagem save(Postagem postagem) {
        return postagemRepository.save(postagem);
    }

    @Override
    public void delete(Postagem postagem) {
        postagemRepository.delete(postagem);
    }

    @Override
    public Postagem findOne(Long id) {
        return postagemRepository.findOne(id);          
    }
}
