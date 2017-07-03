/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author joao.silva
 */
@Entity
@Table(name = "CURTIDA", catalog = "", schema = "SEED")
public class Curtida implements Serializable {

    protected Curtida() {
    }

    public Curtida(Date dataCurtida, Postagem postagem,Perfil perfil ) {
        this.dataCurtida = dataCurtida;
        this.perfil = perfil;
        this.postagem = postagem;
    }
    
    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_CURTIDA")
    @SequenceGenerator(name = "SEQ_CURTIDA", sequenceName = "SEQ_CURTIDA")
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Long id;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "DataCurtida")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCurtida;
    
    @JoinColumn(name = "ID_PERFIL", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Perfil perfil;
    
    @JsonIgnore
    @JoinColumn(name = "ID_POSTAGEM", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Postagem postagem;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getData() {
        return dataCurtida;
    }

    public void setData(Date dataCurtida) {
        this.dataCurtida = dataCurtida;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }
    
    @JsonIgnore
    public Postagem getPostagem() {
        return postagem;
    }

    public void setPostagem(Postagem postagem) {
        this.postagem = postagem;
    }
    
}
