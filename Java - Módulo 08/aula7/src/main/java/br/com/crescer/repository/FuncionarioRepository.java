/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.repository;


import br.com.crescer.entity.Funcionario;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author jpedr
 */
public interface FuncionarioRepository extends PagingAndSortingRepository<Funcionario, Long>{
    
}
