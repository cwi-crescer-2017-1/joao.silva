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
 * @author carloshenrique
 */
public class FuncionarioDaoTest{

    private final FuncionarioDao funcionarioDao;

    public FuncionarioDaoTest() {
        this.funcionarioDao = new FuncionarioDao(ConnectionUtils.getEntityManager());
    }

    /**
     * Test of findAll method, of class FuncionarioDao.
     */
    @Test
    public void testFindAll() {
        final Funcionario funcionario = this.createFuncionario();
        final List<Funcionario> funcionarios = funcionarioDao.findAll();
        assertTrue(funcionarios.stream()
                .map(Funcionario::getCpf)
                .anyMatch(funcionario.getCpf()::equals));
    }

    /**
     * Test of loadById method, of class FuncionarioDao.
     */
    @Test
    public void testLoadById() {
        final Funcionario funcionario = this.createFuncionario();
        assertEquals(funcionario.getCpf(), funcionarioDao.loadById(funcionario.getId()).getCpf());
    }

    /**
     * Test of save method, of class FuncionarioDao.
     */
    @Test
    public void testSave() {
        final Funcionario funcionario = new Funcionario();
        funcionario.setNome("Carlos Henrique Nonnemacher");
        funcionario.setCpf("01041158076");
        funcionario.setCelular("9999999999");
        funcionario.setRg("1087927683");
        funcionarioDao.save(funcionario);
        assertEquals(funcionario.getCpf(), getEntityManager().find(Funcionario.class, funcionario.getId()).getCpf());
    }

    /**
     * Test of remove method, of class FuncionarioDao.
     */
    @Test
    public void testRemove() {
        final Funcionario funcionario = createFuncionario();
        funcionarioDao.remove(funcionario);
        assertNull(getEntityManager().find(Funcionario.class, funcionario.getId()));
    }

    private Funcionario createFuncionario() {
        final Funcionario funcionario = new Funcionario();
        funcionario.setNome("Carlos Henrique Nonnemacher");
        funcionario.setCpf("01041158076");
        funcionario.setCelular("9999999999");
        funcionario.setRg("1087927683");
        getEntityManager().getTransaction().begin();
        getEntityManager().persist(funcionario);
        getEntityManager().getTransaction().commit();
        return funcionario;
    }

}
