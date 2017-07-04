/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.service.Relacionamento;

import br.com.crescer.entity.Perfil;
import br.com.crescer.entity.Relacionamento;
import br.com.crescer.service.LessBasicService;

/**
 *
 * @author joao.silva
 */
public interface RelacionamentoService extends LessBasicService<Relacionamento,Long>{
     Relacionamento responder(Relacionamento relacionamento, Boolean resposta);
     void removerAmigo(Long idPerfilUsuario, Perfil perfilAmigo);
}
