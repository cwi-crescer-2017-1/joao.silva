/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer;

import static br.com.crescer.ConnectionUtils.getEntityManager;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author carloshenrique
 */
public class LocacaoDaoTest{

    private final LocacaoDao locacaoDao;

    public LocacaoDaoTest() {
        this.locacaoDao = new LocacaoDao(ConnectionUtils.getEntityManager());
    }

    /**
     * Test of findAll method, of class LocacaoDao.
     */
    @Test
    public void testFindAll() {
        final Locacao genero = this.createLocacao();
        final List<Locacao> generos = locacaoDao.findAll();
        assertTrue(generos.stream()
                .map(Locacao::getCliente)
                .anyMatch(genero.getCliente()::equals));
    }

    /**
     * Test of loadById method, of class LocacaoDao.
     */
    @Test
    public void testLoadById() {
        final Locacao locacao = this.createLocacao();
        assertEquals(locacao.getCliente(), locacaoDao.loadById(locacao.getId()).getCliente());
    }

    /**
     * Test of save method, of class LocacaoDao.
     */
    @Test
    public void testSave() {
        final Locacao locacao = new Locacao();
        locacao.setCliente(createCliente());
        locacao.setValor(300F);
        locacaoDao.save(locacao);
        assertEquals(locacao.getCliente(), getEntityManager().find(Locacao.class, locacao.getId()).getCliente());
    }

    /**
     * Test of remove method, of class LocacaoDao.
     */
    @Test
    public void testRemove() {
        final Locacao locacao = createLocacao();
        locacaoDao.remove(locacao);
        assertNull(getEntityManager().find(Locacao.class, locacao.getId()));
    }

    private Locacao createLocacao() {
        final Locacao locacao = new Locacao();
        locacao.setCliente(createCliente());
        locacao.setValor(300F);
        getEntityManager().getTransaction().begin();
        getEntityManager().persist(locacao);
        getEntityManager().getTransaction().commit();
        return locacao;
    }

    private Cliente createCliente() {
        final Cliente cliente = new Cliente();
        cliente.setNome("Carlos Henrique Nonnemacher");
        cliente.setCpf("01041158076");
        cliente.setCelular("9999999999");
        getEntityManager().getTransaction().begin();
        getEntityManager().persist(cliente);
        getEntityManager().getTransaction().commit();
        return cliente;
    }

}
