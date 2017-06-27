/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer;

import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author carloshenrique
 */
public class ClienteDaoTest{

    private final ClienteDao clienteDao;

    public ClienteDaoTest() {
        this.clienteDao = new ClienteDao(ConnectionUtils.getEntityManager());
    }

    /**
     * Test of findAll method, of class ClienteDao.
     */
    @Test
    public void testFindAll() {
        final Cliente cliente = this.createCliente();
        final List<Cliente> clientes = clienteDao.findAll();
        assertTrue(clientes.stream()
                .map(Cliente::getCpf)
                .anyMatch(cliente.getCpf()::equals));
    }

    /**
     * Test of loadById method, of class ClienteDao.
     */
    @Test
    public void testLoadById() {
        final Cliente cliente = this.createCliente();
        assertEquals(cliente.getCpf(), clienteDao.loadById(cliente.getId()).getCpf());
    }

    /**
     * Test of save method, of class ClienteDao.
     */
    @Test
    public void testSave() {
        final Cliente cliente = new Cliente();
        cliente.setNome("Carlos Henrique Nonnemacher");
        cliente.setCpf("01041158076");
        cliente.setCelular("9999999999");
        clienteDao.save(cliente);
        assertEquals(cliente.getCpf(), ConnectionUtils.getEntityManager().find(Cliente.class, cliente.getId()).getCpf());
    }

    /**
     * Test of remove method, of class ClienteDao.
     */
    @Test
    public void testRemove() {
        final Cliente cliente = createCliente();
        clienteDao.remove(cliente);
        assertNull(ConnectionUtils.getEntityManager().find(Cliente.class, cliente.getId()));
    }

    private Cliente createCliente() {
        final Cliente cliente = new Cliente();
        cliente.setNome("Carlos Henrique Nonnemacher");
        cliente.setCpf("01041158076");
        cliente.setCelular("9999999999");
        ConnectionUtils.getEntityManager().getTransaction().begin();
        ConnectionUtils.getEntityManager().persist(cliente);
        ConnectionUtils.getEntityManager().getTransaction().commit();
        return cliente;
    }

}
