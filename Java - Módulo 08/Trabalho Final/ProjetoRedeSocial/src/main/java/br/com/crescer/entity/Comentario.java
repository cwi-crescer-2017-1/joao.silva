/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.entity;

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
import javax.validation.constraints.Size;

/**
 *
 * @author joao.silva
 */
@Entity
@Table(name = "COMENTARIO", catalog = "", schema = "SEED")
public class Comentario implements Serializable {

    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_COMENTARIO")
    @SequenceGenerator(name = "SEQ_COMENTARIO", sequenceName = "SEQ_COMENTARIO")
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Long id;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "TEXTO")
    private String texto;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "DataComentario")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataComentario;
    
    @JoinColumn(name = "ID_PERFIL", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Perfil perfil;
    
    @JoinColumn(name = "ID_POSTAGEM", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Postagem postagem;

    protected Comentario() {
    }

    public Comentario(String texto,Postagem postagem, Perfil perfil ,Date dataComentario) {
        this.texto = texto;
        this.dataComentario = dataComentario;
        this.postagem = postagem;
        this.perfil = perfil;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Date getData() {
        return dataComentario;
    }

    public void setData(Date dataComentario) {
        this.dataComentario = dataComentario;
    }

    public Perfil getPerfil() {
        return this.perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    public Postagem getPostagem() {
        return this.postagem;
    }

    public void setPostagem(Postagem postagem) {
        this.postagem = postagem;
    } 
}
