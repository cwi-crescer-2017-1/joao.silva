/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author jpedr
 */
@Entity
@Table(name = "GENERO")
public class Genero implements Serializable {
    
    protected Genero() {}
    
    public Genero(String descricao){
      this.descricao = descricao;
    }
    
    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_GENERO")
    @SequenceGenerator(name = "SEQ_GENERO", sequenceName = "SEQ_GENERO")
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;
    
    @Basic(optional = false)
    @Column(name = "DESCRICAO")
    private String descricao;

    public Long getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
}
