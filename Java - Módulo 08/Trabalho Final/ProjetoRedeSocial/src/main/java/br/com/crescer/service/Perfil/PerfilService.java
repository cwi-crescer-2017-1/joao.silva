/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.service.Perfil;

import br.com.crescer.entity.Perfil;
import br.com.crescer.service.LessBasicService;
import java.util.List;

/**
 *
 * @author joao.silva
 */
public interface PerfilService extends LessBasicService<Perfil,Long>{
    List<Perfil> findByNameWithFriendship(Long idPerfil, String nome);
    List<Perfil> fiendPeopleWithRelation(Long idPerfil);
}
