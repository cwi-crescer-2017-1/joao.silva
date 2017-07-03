/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.repository;

import br.com.crescer.entity.Postagem;
import br.com.crescer.entity.Usuario;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @author joao.silva
 */
public interface PostagemRepository extends JpaRepository<Postagem, Long>{

    /**
     * @param idUsuario
     * @return
     */
    @Query(value="Select pos.* From Postagem pos Where pos.ID_Perfil "
            + "IN( Select pe.ID From Perfil pe Where pe.ID "
            + "IN(Select re.ID_PERFIL_SOLICITADO From Relacionamento re Where re.ID_PERFIL_SOLICITADO = ?1 "
            + "OR re.ID_PERFIL_SOLICITANTE = ?1 AND re.Resposta = 1) "
            + "OR pe.ID IN (Select re.ID_PERFIL_SOLICITANTE From Relacionamento re Where re.ID_PERFIL_SOLICITADO = ?1 "
            + "OR re.ID_PERFIL_SOLICITANTE = ?1 AND re.Resposta = 1)) ORDER BY pos.DATA_POSTAGEM DESC",
            nativeQuery=true)
        List<Postagem> Postagem_findByUsuario(Long idUsuario);
    
    @Query(value="Select pos.* From Postagem pos Where pos.ID_Perfil "
            + "IN( Select pe.ID From Perfil pe Where pe.ID "
            + "IN(Select re.ID_PERFIL_SOLICITADO From Relacionamento re Where re.ID_PERFIL_SOLICITADO = ?1 "
            + "OR re.ID_PERFIL_SOLICITANTE = ?1 AND re.Resposta = 1) "
            + "OR pe.ID IN (Select re.ID_PERFIL_SOLICITANTE From Relacionamento re Where re.ID_PERFIL_SOLICITADO = ?1 "
            + "OR re.ID_PERFIL_SOLICITANTE = ?1 AND re.Resposta = 1)) ORDER BY pos.DATA_POSTAGEM DESC /*#pageable*/",
        countQuery="Select Count(pos.ID) From Postagem pos Where pos.ID_Perfil IN( Select pe.ID From Perfil pe Where pe.ID IN(Select re.ID_PERFIL_SOLICITADO From Relacionamento re Where re.ID_PERFIL_SOLICITADO = ?1 OR re.ID_PERFIL_SOLICITANTE = ?1 AND re.Resposta = 1) OR pe.ID IN (Select re.ID_PERFIL_SOLICITANTE From Relacionamento re Where re.ID_PERFIL_SOLICITADO = ?1 OR re.ID_PERFIL_SOLICITANTE = ?1 AND re.Resposta = 1))",
        nativeQuery=true)
    Page<Postagem> Postagem_findByUsuario(Long idUsuario, Pageable pageable);
}
