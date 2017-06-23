package br.com.crescer.aula3.orm.dao.pessoa;

/**
 * @author carloshenrique
 */
public class Pessoa {

    private Long id;

    private String nome;

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

}
