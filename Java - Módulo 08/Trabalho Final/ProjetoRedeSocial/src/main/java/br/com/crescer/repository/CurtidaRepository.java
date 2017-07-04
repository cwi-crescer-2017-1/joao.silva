/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.repository;

import br.com.crescer.entity.Curtida;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author joao.silva
 */
public interface CurtidaRepository extends PagingAndSortingRepository<Curtida, Long>{
    @Modifying
    @Transactional
    @Query("delete from Curtida where postagem.id = ?1 And perfil.id = ?2")
    public void remove(Long idPostagem, Long idPerfil);
    
    @Query("select cur from Curtida cur where cur.postagem.id = ?1 And cur.perfil.id = ?2")
    public Curtida Curtida_findByIdPostagemAndIdPerfil(Long idPostagem, Long idPerfil);
}
