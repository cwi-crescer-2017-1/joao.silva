/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula3.atividade.Estado;

/**
 *
 * @author joao.silva
 */
public class Estado {

    private long id;
    private String nome;
    private String uf;
    private long pais;
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public long getPais() {
        return pais;
    }

    public void setPais(long pais) {
        this.pais = pais;
    }
}
