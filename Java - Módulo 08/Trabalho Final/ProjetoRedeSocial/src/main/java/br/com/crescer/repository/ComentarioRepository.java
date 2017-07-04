/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.repository;

import br.com.crescer.entity.Comentario;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author joao.silva
 */
public interface ComentarioRepository extends PagingAndSortingRepository<Comentario, Long>{
    @Query("select co from Comentario co where co.postagem.id = ?1)")
    List<Comentario> findByPostagem(Long idPostagem);
}
