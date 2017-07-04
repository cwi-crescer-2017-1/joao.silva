/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.service.Curtida;

import br.com.crescer.entity.Curtida;
import br.com.crescer.entity.Postagem;
import br.com.crescer.repository.CurtidaRepository;
import br.com.crescer.repository.PostagemRepository;
import java.util.Date;
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

    @Autowired
    PostagemRepository postagemRepository;
    
    @Override
    public List<Curtida> findAll() {
        return (List<Curtida>) curtidaRepository.findAll();
    }

    @Override
    public Page<Curtida> findPage(int page, int size) {
        return curtidaRepository.findAll(new PageRequest(page, size));
    }

    /**
     *
     * @param curtida
     * @param idPostagem
     * @return
     */
    @Override
    public Curtida save(Curtida curtida, Long idPostagem) {
        Curtida curtidaExistente = curtidaRepository.Curtida_findByIdPostagemAndIdPerfil(idPostagem, curtida.getPerfil().getId());
        if(curtidaExistente!=null){return curtidaExistente;}
        Postagem postagem = postagemRepository.findOne(idPostagem);
        curtida.setPostagem(postagem);
        curtida.setData(new Date());
        return curtidaRepository.save(curtida);
    }

    @Override
    public void delete(Curtida curtida) {
        curtidaRepository.delete(curtida);
    }
    
    @Override
    public void remove(Long idPostagem, Long idPerfil){
        curtidaRepository.remove(idPostagem, idPerfil);
    }

    @Override
    public Curtida findOne(Long id) {
        return curtidaRepository.findOne(id);          
    }

    @Override
    public Curtida save(Curtida e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
