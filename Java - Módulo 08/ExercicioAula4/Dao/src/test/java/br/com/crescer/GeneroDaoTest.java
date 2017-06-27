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
public class GeneroDaoTest{

    private final GeneroDao generoDao;

    public GeneroDaoTest() {
        this.generoDao = new GeneroDao(ConnectionUtils.getEntityManager());
    }

    /**
     * Test of findAll method, of class GeneroDao.
     */
    @Test
    public void testFindAll() {
        final Genero genero = this.createGenero();
        final List<Genero> generos = generoDao.findAll();
        assertTrue(generos.stream()
                .map(Genero::getDescricao)
                .anyMatch(genero.getDescricao()::equals));
    }

    /**
     * Test of loadById method, of class GeneroDao.
     */
    @Test
    public void testLoadById() {
        final Genero genero = this.createGenero();
        assertEquals(genero.getDescricao(), generoDao.loadById(genero.getId()).getDescricao());
    }

    /**
     * Test of save method, of class GeneroDao.
     */
    @Test
    public void testSave() {
        final Genero genero = new Genero();
        genero.setDescricao("Teste");
        generoDao.save(genero);
        assertEquals(genero.getDescricao(), getEntityManager().find(Genero.class, genero.getId()).getDescricao());
    }

    /**
     * Test of remove method, of class GeneroDao.
     */
    @Test
    public void testRemove() {
        final Genero genero = createGenero();
        generoDao.remove(genero);
        assertNull(getEntityManager().find(Genero.class, genero.getId()));
    }

    private Genero createGenero() {
        final Genero genero = new Genero();
        genero.setDescricao("Teste");
        getEntityManager().getTransaction().begin();
        getEntityManager().persist(genero);
        getEntityManager().getTransaction().commit();
        return genero;
    }

}
