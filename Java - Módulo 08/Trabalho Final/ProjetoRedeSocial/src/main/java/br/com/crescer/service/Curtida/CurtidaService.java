/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.service.Curtida;

import br.com.crescer.entity.Curtida;
import br.com.crescer.service.LessBasicService;

/**
 *
 * @author joao.silva
 */
public interface CurtidaService extends LessBasicService<Curtida,Long> {
    void remove(Long idPostagem, Long idPerfil);
    Curtida save(Curtida curtida, Long idPostagem);
}
