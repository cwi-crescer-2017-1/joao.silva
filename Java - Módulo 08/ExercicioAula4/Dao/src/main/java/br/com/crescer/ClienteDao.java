/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer;

/**
 *
 * @author joao.silva
 */
public class ClienteDao extends CrudDaoImpl<Cliente,Long>{
    
    public ClienteDao() {
        super(Cliente.class);
    }
    
}
