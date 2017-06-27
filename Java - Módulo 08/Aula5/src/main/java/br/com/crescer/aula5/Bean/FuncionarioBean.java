/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula5.Bean;

import br.com.crescer.Funcionario;
import br.com.crescer.FuncionarioDao;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author jpedr
 */
@Stateless
public class FuncionarioBean {
    @PersistenceContext(unitName = "crescer")
    private EntityManager entityManager;
    
    public Funcionario save(Funcionario funcionario) {
        return new FuncionarioDao(entityManager).save(funcionario);
    }

    public List<Funcionario> findAll() {
        return new FuncionarioDao(entityManager).findAll();
    }
}
