/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula4.jpa;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author joao.silva
 */
@Entity
@Table(name = "CLIENTE")
public class Cliente implements Serializable{

    @Id
    @Basic(optional = false)
    @Column(name = "ID_CLIENTE")
    private Long Id;
//    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_CLIENTE")
//    @SequenceGenerator(name = "SEQ_CLIENTE", sequenceName = "SEQ_CLIENTE")    
 
    
    @Basic(optional = false)
    @Column(name = "NM_CLIENTE")
    private String Nome;
    
    public Cliente(){}
    public Cliente(Long Id, String Nome){
        this.Id=Id;
        this.Nome=Nome;
    }
    public Long getId() {
        return this.Id;
    }
    
    public String getNome() {
        return this.Nome;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }
    public void setNome(String Nome) {
        this.Nome = Nome;
    }
    
}
