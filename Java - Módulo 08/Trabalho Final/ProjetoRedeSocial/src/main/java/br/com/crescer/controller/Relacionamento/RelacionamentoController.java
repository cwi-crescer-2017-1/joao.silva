/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.controller.Relacionamento;

import br.com.crescer.controller.BasicController;
import br.com.crescer.entity.Perfil;
import br.com.crescer.entity.Relacionamento;

/**
 *
 * @author jpedr
 */
public interface RelacionamentoController extends BasicController<Relacionamento, Long>{
    Relacionamento responder(Boolean Resposta, Relacionamento relacionamento);
    void removerAmigo(Long idPerfilUsuario, Perfil perfilAmigo );
}
