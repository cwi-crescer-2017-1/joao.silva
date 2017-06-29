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
@Table(name = "LOCACAO")
public class Locacao implements Serializable {

    protected Locacao() {}

    public Locacao(Float valor){
        this.valor = valor;
    }
    
    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_LOCACAO")
    @SequenceGenerator(name = "SEQ_LOCACAO", sequenceName = "SEQ_LOCACAO")
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;
    
    @Basic(optional = false)
    @Column(name = "VALOR_TOTAL")
    private Float valor;
    
    @ManyToOne
    @JoinColumn(name = "ID_FUNCIONARIO")
    private Funcionario funcionario;
    
    @ManyToOne
    @JoinColumn(name = "ID_CLIENTE")
    private Cliente cliente;
    
    @ManyToOne
    @JoinColumn(name = "ID_VIDEO")
    private Video video;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "DATA_DEVOLUCAO")
    private Date devolucaoPrevista;

    public Long getId() {
        return id;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Video getVideo() {
        return video;
    }

    public void setVideo(Video video) {
        this.video = video;
    }

    public Date getDevolucaoPrevista() {
        return devolucaoPrevista;
    }

    public void setDevolucaoPrevista(Date devolucaoPrevista) {
        this.devolucaoPrevista = devolucaoPrevista;
    }
}

