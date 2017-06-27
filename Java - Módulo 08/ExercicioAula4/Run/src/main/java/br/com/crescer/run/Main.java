/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.run;

import br.com.crescer.Cliente;
import br.com.crescer.ConnectionUtils;
import br.com.crescer.CrudDao;
import br.com.crescer.CrudDaoImpl;
import br.com.crescer.Funcionario;
import br.com.crescer.FuncionarioDao;
import br.com.crescer.Genero;
import br.com.crescer.Locacao;
import br.com.crescer.Video;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 *
 * @author jpedr
 */
public class Main {
    public static void main(String[] args) throws CloneNotSupportedException{
        ConnectionUtils.openConnections();
        CrudDao<Funcionario,Long> funcionarioDao = new CrudDaoImpl<>(Funcionario.class);
        CrudDao<Cliente,Long> clienteDao = new CrudDaoImpl<>(Cliente.class);
        CrudDao<Genero,Long> generoDao = new CrudDaoImpl<>(Genero.class);
        CrudDao<Locacao,Long> locacaoDao = new CrudDaoImpl<>(Locacao.class);
        CrudDao<Video,Long> videoDao = new CrudDaoImpl<>(Video.class);
        Funcionario funcionario = new Funcionario("Joao","123456789");
        funcionarioDao.save(funcionario);
        System.out.println(funcionario.getId());
        funcionario.setNome("Troucou");
        funcionario.setRg("111111111");
        System.out.println(funcionario.getId());
        List<Funcionario> funcionarios = funcionarioDao.findAll();
        funcionarios.forEach((func) -> {
            System.out.println(func.getNome());
        });    
        Cliente cliente = new Cliente("Arthur","1111111111","984156563");
        clienteDao.save(cliente);
        Cliente clienteDois = new Cliente("Henrique","2222222222","985695656");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.YEAR, -25);
        clienteDois.setNascimento(calendar.getTime());
        clienteDao.save(clienteDois);
        Long id = cliente.getId();
        System.out.println(id);
        clienteDao.remove(cliente);
        System.out.println("Cliente removido sendo buscado : "+ (funcionarioDao.loadById(id)));
        Genero genero = new Genero("Terror");
        generoDao.save(genero);
        Video video = new Video();
        video.setValor(300.00F);
        videoDao.save(video);
        Locacao locacao = new Locacao(300.00F);
        locacao.setCliente(clienteDois);
        locacao.setVideo(video);
        locacao.setFuncionario(funcionario);
        locacao.setDevolucaoPrevista(new Date());
        locacaoDao.save(locacao);
        Long idLocacao = locacao.getId();
        Locacao oi = locacaoDao.loadById(idLocacao);
        System.out.println(oi.getCliente().getId());
        System.out.println((funcionarios.stream().anyMatch(f->f.getId()==99999999999L)));
        locacaoDao.remove(oi);
        ConnectionUtils.closeConnections();
    }
}
