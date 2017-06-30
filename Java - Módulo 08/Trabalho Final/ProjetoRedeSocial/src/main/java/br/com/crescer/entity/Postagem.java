/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
@Table(name = "POSTAGEM", catalog = "", schema = "SEED")
public class Postagem implements Serializable {

    protected Postagem() {
    }

    public Postagem(Perfil perfil, Date dataPostagem) {
        this.perfil = perfil;
        this.dataPostagem = dataPostagem;
    }

    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_POSTAGEM")
    @SequenceGenerator(name = "SEQ_POSTAGEM", sequenceName = "SEQ_POSTAGEM")
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Long id;

    @Size(max = 2000)
    @Column(name = "URL_IMG")
    private String urlImg;

    @Size(max = 500)
    @Column(name = "DESCRICAO")
    private String descricao;

    @Basic(optional = false)
    @NotNull
    @Column(name = "DataPostagem")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataPostagem;

    @JoinColumn(name = "ID_PERFIL", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Perfil perfil;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "postagem")
    private Set<Comentario> comentarioSet;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "postagem")
    private Set<Curtida> curtidaSet;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrlImg() {
        return urlImg;
    }

    public void setUrlImg(String urlImg) {
        this.urlImg = urlImg;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getData() {
        return dataPostagem;
    }

    public void setData(Date dataPostagem) {
        this.dataPostagem = dataPostagem;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    public Set<Comentario> getComentarioSet() {
        return comentarioSet;
    }

    public void setComentarioSet(Set<Comentario> comentarioSet) {
        this.comentarioSet = comentarioSet;
    }

    public Set<Curtida> getCurtidaSet() {
        return curtidaSet;
    }

    public void setCurtidaSet(Set<Curtida> curtidaSet) {
        this.curtidaSet = curtidaSet;
    }
}
