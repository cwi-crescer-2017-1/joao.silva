/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula5.Bean;

import br.com.crescer.Cliente;
import br.com.crescer.ClienteDao;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author jpedr
 */
@Stateless
public class ClienteBean {
    @PersistenceContext(unitName = "crescer")
    private EntityManager entityManager;
    
    public Cliente save(Cliente cliente) {
        return new ClienteDao(entityManager).save(cliente);
    }

    public List<Cliente> findAll() {
        return new ClienteDao(entityManager).findAll();
    }
}
