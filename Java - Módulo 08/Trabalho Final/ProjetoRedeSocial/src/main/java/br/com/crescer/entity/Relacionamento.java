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

/**
 *
 * @author joao.silva
 */
@Entity
@Table(name = "RELACIONAMENTO", catalog = "", schema = "SEED")
public class Relacionamento implements Serializable {

    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_RELACIONAMENTO")
    @SequenceGenerator(name = "SEQ_RELACIONAMENTO", sequenceName = "SEQ_RELACIONAMENTO")
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Long id;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "DATA_SOLICITACAO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataSolicitacao;
    
    @Column(name = "DATA_RESPOSTA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataResposta;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "PENDENTE")
    private Boolean pendente;
    
    @Column(name = "RESPOSTA")
    private Boolean resposta;
    
    @JoinColumn(name = "ID_PERFIL_SOLICITANTE", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Perfil perfilSolicitante;
    
    @JoinColumn(name = "ID_PERFIL_SOLICITADO", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Perfil perfilSolicitado;

    protected Relacionamento() {
    }

    public Relacionamento(Perfil perfilSolicitante, Perfil perfilSolicitado, 
            Date dataSolicitacao, Boolean pendente) {
        this.perfilSolicitante = perfilSolicitante;
        this.perfilSolicitado = perfilSolicitado;
        this.dataSolicitacao = dataSolicitacao;
        this.pendente = pendente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDataSolicitacao() {
        return dataSolicitacao;
    }

    public void setDataSolicitacao(Date dataSolicitacao) {
        this.dataSolicitacao = dataSolicitacao;
    }

    public Date getDataResposta() {
        return dataResposta;
    }

    public void setDataResposta(Date dataResposta) {
        this.dataResposta = dataResposta;
    }

    public Boolean getPendente() {
        return pendente;
    }

    public void setPendente(Boolean pendente) {
        this.pendente = pendente;
    }

    public Boolean getResposta() {
        return resposta;
    }

    public void setResposta(Boolean resposta) {
        this.resposta = resposta;
    }

    public Perfil getPerfilSolicitante() {
        return perfilSolicitante;
    }

    public void setPerfilSolicitante(Perfil perfilSolicitante) {
        this.perfilSolicitante = perfilSolicitante;
    }

    public Perfil getPerfilSolicitado() {
        return perfilSolicitado;
    }

    public void setPerfilSolicitado(Perfil perfilSolicitado) {
        this.perfilSolicitado = perfilSolicitado;
    }
}
