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
import javax.persistence.OneToOne;
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
@Table(name = "PERFIL", catalog = "", schema = "SEED")

public class Perfil implements Serializable {

    protected Perfil() {
    }

    public Perfil(String nome, String fotoUrl, String sexo, Date dataNascimento, Estado estado) {
        this.nome = nome;
        this.fotoUrl = fotoUrl;
        this.sexo = sexo;
        this.dataNascimento = dataNascimento;
        this.estado = estado;
    }
    
    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_PERFIL")
    @SequenceGenerator(name = "SEQ_PERFIL", sequenceName = "SEQ_PERFIL")
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
    @Size(min = 1, max = 2000)
    @Column(name = "FOTO_URL")
    private String fotoUrl;
    
    @Size(max = 300)
    @Column(name = "INTERESSES")
    private String interesses;
    
    @Size(max = 100)
    @Column(name = "STATUS")
    private String status;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "SEXO")
    private String sexo;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "DATA_NASCIMENTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataNascimento;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "perfil")
    private Set<Postagem> postagemSet;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "perfil")
    private Set<Comentario> comentarioSet;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "perfil")
    private Set<Curtida> curtidaSet;
    
    @JoinColumn(name = "ID_ESTADO", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Estado estado;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "perfilSolicitante")
    private Set<Relacionamento> relacionamentoSet;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "perfilSolicitado")
    private Set<Relacionamento> relacionamentoSet1;
    
    @OneToOne(mappedBy = "perfil")
    private Usuario usuario;

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

    public String getFotoUrl() {
        return fotoUrl;
    }

    public void setFotoUrl(String fotoUrl) {
        this.fotoUrl = fotoUrl;
    }

    public String getInteresses() {
        return interesses;
    }

    public void setInteresses(String interesses) {
        this.interesses = interesses;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Set<Postagem> getPostagemSet() {
        return postagemSet;
    }

    public void setPostagemSet(Set<Postagem> postagemSet) {
        this.postagemSet = postagemSet;
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

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado idEstado) {
        this.estado = idEstado;
    }

    public Set<Relacionamento> getRelacionamentoSet() {
        return relacionamentoSet;
    }

    public void setRelacionamentoSet(Set<Relacionamento> relacionamentoSet) {
        this.relacionamentoSet = relacionamentoSet;
    }

    public Set<Relacionamento> getRelacionamentoSet1() {
        return relacionamentoSet1;
    }

    public void setRelacionamentoSet1(Set<Relacionamento> relacionamentoSet1) {
        this.relacionamentoSet1 = relacionamentoSet1;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
}
