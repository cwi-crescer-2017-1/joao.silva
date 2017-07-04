/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.repository;

import br.com.crescer.entity.Perfil;
import br.com.crescer.entity.Relacionamento;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author joao.silva
 */
public interface RelacionamentoRepository extends PagingAndSortingRepository<Relacionamento, Long>{
    Relacionamento findOneByPerfilSolicitanteAndPerfilSolicitado(Perfil perfilSolicitante, Perfil perfilSolicitado);
}
