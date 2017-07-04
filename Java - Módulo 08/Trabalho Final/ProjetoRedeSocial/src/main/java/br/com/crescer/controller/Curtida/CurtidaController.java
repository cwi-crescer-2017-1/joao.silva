/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.controller.Curtida;

import br.com.crescer.controller.BasicController;
import br.com.crescer.entity.Curtida;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author jpedr
 */
public interface CurtidaController extends BasicController<Curtida,Long>{
    void remove(Long idPostagem, Long idPerfil);
    Curtida save(Long idPostagem, Curtida curtida);
}
