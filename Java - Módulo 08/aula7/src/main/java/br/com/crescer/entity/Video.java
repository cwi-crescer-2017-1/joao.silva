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

/**
 *
 * @author jpedr
 */
@Entity
@Table(name = "VIDEO")
public class Video implements Serializable {
    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_VIDEO")
    @SequenceGenerator(name = "SEQ_VIDEO", sequenceName = "SEQ_VIDEO")
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;
    
    @Basic(optional = false)
    @Column(name = "VALOR")
    private Float valor;

    @Column(name = "DURACAO")
    private String duracao;
    
    @ManyToOne
    @JoinColumn(name = "ID_GENERO")
    private Genero genero;
    
    @Column(name = "NOME")
    private String nome;
    
    @Column(name = "QUANTIDADE_ESTOQUE")
    private Integer quantidadeEstoque;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "DATA_LANCAMENTO")
    private Date lancamento;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(Integer quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public Date getLancamento() {
        return lancamento;
    }

    public void setLancamento(Date lancamento) {
        this.lancamento = lancamento;
    }

    
}
