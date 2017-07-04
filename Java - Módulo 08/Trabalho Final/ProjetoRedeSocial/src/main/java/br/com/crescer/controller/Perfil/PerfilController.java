/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.controller.Perfil;

import br.com.crescer.controller.BasicController;
import br.com.crescer.entity.Perfil;
import java.util.List;

/**
 *
 * @author jpedr
 */
public interface PerfilController extends BasicController<Perfil,Long>{
    List<Perfil> findByNameWithFriendship(Long idPerfil,String nome);
    List<Perfil> findByName(String nome);
    List<Perfil> fiendPeopleWithRelation(Long idPerfil);
}
