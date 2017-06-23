/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula3.atividade;

import br.com.crescer.aula3.atividade.Cidade.Cidade;
import br.com.crescer.aula3.atividade.Cidade.CidadeDao;
import br.com.crescer.aula3.atividade.Cidade.CidadeDaoImpl;
import br.com.crescer.aula3.atividade.Estado.Estado;
import br.com.crescer.aula3.atividade.Estado.EstadoDao;
import br.com.crescer.aula3.atividade.Estado.EstadoDaoImpl;
import br.com.crescer.aula3.atividade.Pais.Pais;
import br.com.crescer.aula3.atividade.Pais.PaisDao;
import br.com.crescer.aula3.atividade.Pais.PaisDaoImpl;

/**
 *
 * @author joao.silva
 */
public class Run {
    public static void main(String[] args){
        PaisDao paisDao = new PaisDaoImpl();
        Pais pais = new Pais();
        pais.setId(2l);
        pais.setNome("Argentina");
        pais.setSigla("AR");
        paisDao.insert(pais);
        pais.setNome("Update");
        paisDao.update(pais);
        Pais country = paisDao.loadBy(2l);
        System.out.println(country.getNome());
        
        EstadoDao estadoDao = new EstadoDaoImpl();
        Estado estado = new Estado();
        estado.setId(100l);
        estado.setNome("Rio Grande do Sul");
        estado.setPais(2l);
        estado.setUf("RS");
        estadoDao.insert(estado);
        estado.setNome("Update");
        estadoDao.update(estado);
        Estado state = estadoDao.loadBy(100l);
        System.out.println(state.getNome());
        
        CidadeDao cidadeDao = new CidadeDaoImpl();
        Cidade cidade = new Cidade();
        cidade.setId(100l);
        cidade.setNome("Rio Grande do Sul");
        cidade.setEstado(100l);
        cidadeDao.insert(cidade);
        cidade.setNome("Update");
        cidadeDao.update(cidade);
        Cidade city = cidadeDao.loadBy(100l);
        System.out.println(city.getNome());
        
    }
}
