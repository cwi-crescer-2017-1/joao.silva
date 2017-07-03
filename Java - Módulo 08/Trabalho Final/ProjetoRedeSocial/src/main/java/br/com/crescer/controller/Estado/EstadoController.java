/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.controller.Estado;

import br.com.crescer.entity.Estado;
import java.util.List;

/**
 *
 * @author jpedr
 */
public interface EstadoController {
      List<Estado> findAll();
}
