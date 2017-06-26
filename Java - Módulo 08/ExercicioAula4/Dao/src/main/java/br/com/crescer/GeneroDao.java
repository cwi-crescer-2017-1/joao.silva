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
public class GeneroDao extends CrudDaoImpl<Genero,Long>{
    
    public GeneroDao() {
        super(Genero.class);
    }
    
}
