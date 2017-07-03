/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author joao.silva
 */
@Entity
@Table(name = "ESTADO", catalog = "", schema = "SEED")
public class Estado implements Serializable {
    
    protected Estado(){
    }
    
    public Estado(String Nome,String Pais){
        this.nome = Nome;
        this.pais = Pais;
    }
    
    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_ESTADO")
    @SequenceGenerator(name = "SEQ_ESTADO", sequenceName = "SEQ_ESTADO")
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Long id;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NOME")
    private String nome;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "PAIS")
    private String pais;
    
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estado")
    private Set<Perfil> perfilSet;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public Set<Perfil> getPerfilSet() {
        return perfilSet;
    }

    public void setPerfilSet(Set<Perfil> perfilSet) {
        this.perfilSet = perfilSet;
    }
    
}
