/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.repository;

import br.com.crescer.entity.Perfil;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author joao.silva
 */
public interface PerfilRepository extends PagingAndSortingRepository<Perfil, Long>{

    public List<Perfil> findByNomeStartsWith(String nome);
    
    public List<Perfil> findByNome(String nome);
    
    @Query("select pe from Perfil pe where "
            + "pe.id "
            + "In (select re.perfilSolicitado.id from Relacionamento re where re.perfilSolicitante.id = ?1 And re.pendente = 0 And re.resposta = 1) "
            + "Or "
            + "pe.id "
            + "In (select re.perfilSolicitante.id from Relacionamento re where re.perfilSolicitado.id = ?1 And re.pendente = 0 And re.resposta = 1) "
            + "And pe.id != ?1")
    List<Perfil> Perfil_fiendFriends(Long idPerfil);
    
    @Query("select pe from Perfil pe where pe.id "
            + "In (select re.perfilSolicitado.id from Relacionamento re where re.perfilSolicitante.id = ?1 "
            + "And re.resposta = null And re.pendente = true)"
            + "And pe.id != ?1")
    List<Perfil> Perfil_fiendPendingFriends(Long idPerfil);
    //Retorna as pessoas as quais o usuário pediu amizade
    
    @Query("select pe from Perfil pe where pe.id "
            + "In (select re.perfilSolicitante.id from Relacionamento re where re.perfilSolicitado.id = ?1 "
            + "And re.resposta = null And re.pendente = true)"
            + "And pe.id != ?1")
    List<Perfil> Perfil_fiendRequestedFriendship(Long idPerfil);
    //Retorna as pessoas que pediram amizade ao usuário
    
}
