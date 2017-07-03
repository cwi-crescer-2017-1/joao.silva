/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.repository;

import br.com.crescer.entity.Usuario;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author joao.silva
 */
public interface UsuarioRepository extends PagingAndSortingRepository<Usuario, Long> {
    Usuario findOneByEmail(String email);
}
