import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ExercitoQueAtacaEmOrdemHierarquicaTest{
    @Test
    public void aoCriarExercitoHierarquicoEInserir6SaintsOrdemFicaAlterada() throws Exception{
        ExercitoDeSaints impostores = new ExercitoQueAtacaEmOrdemHierarquica();
        impostores.alistar(new PrataSaint("Misty", "Lagarto"));
        impostores.alistar(new OuroSaint("Máscara da Morte", "Câncer"));
        impostores.alistar(new BronzeSaint("Ikki", "Fênix"));
        impostores.alistar(new OuroSaint("Saga", "Gêmeos"));
        impostores.alistar(new PrataSaint("Algol", "Perseu"));
        impostores.alistar(new OuroSaint("Afrodite", "Peixes"));
        
        impostores.zerarProximoSaint();
        assertEquals(Categoria.BRONZE,impostores.getProximoSaintDoExercito().getCategoria());
        assertEquals(Categoria.PRATA,impostores.getProximoSaintDoExercito().getCategoria());
        assertEquals(Categoria.PRATA,impostores.getProximoSaintDoExercito().getCategoria());
        assertEquals(Categoria.OURO,impostores.getProximoSaintDoExercito().getCategoria());
        assertEquals(Categoria.OURO,impostores.getProximoSaintDoExercito().getCategoria());
        assertEquals(Categoria.OURO,impostores.getProximoSaintDoExercito().getCategoria());
        impostores.zerarProximoSaint();
        assertEquals(6, impostores.getTamanho());
    }

    @Test
    public void aoCriarExercitoHierarquicoInserir7SaintsOrdemFicaAlternada() throws Exception{
        ExercitoDeSaints impostores = new ExercitoQueAtacaEmOrdemHierarquica();
        impostores.alistar(new PrataSaint("Misty", "Lagarto"));
        impostores.alistar(new OuroSaint("Máscara da Morte", "Câncer"));
        impostores.alistar(new BronzeSaint("Ikki", "Fênix"));
        impostores.alistar(new OuroSaint("Saga", "Gêmeos"));
        impostores.alistar(new PrataSaint("Algol", "Perseu"));
        impostores.alistar(new OuroSaint("Afrodite", "Peixes"));
        impostores.alistar(new BronzeSaint("Seiya", "Pégasos"));
        
        impostores.zerarProximoSaint();
        assertEquals(Categoria.BRONZE,impostores.getProximoSaintDoExercito().getCategoria());
        assertEquals(Categoria.BRONZE,impostores.getProximoSaintDoExercito().getCategoria());
        assertEquals(Categoria.PRATA,impostores.getProximoSaintDoExercito().getCategoria());
        assertEquals(Categoria.PRATA,impostores.getProximoSaintDoExercito().getCategoria());
        assertEquals(Categoria.OURO,impostores.getProximoSaintDoExercito().getCategoria());
        assertEquals(Categoria.OURO,impostores.getProximoSaintDoExercito().getCategoria());
        assertEquals(Categoria.OURO,impostores.getProximoSaintDoExercito().getCategoria());
        impostores.zerarProximoSaint();
        assertEquals(7, impostores.getTamanho());
    }
    @Test
    public void aoCriarExercitoHierarquicoInserir8SaintsOrdemFicaAlternada() throws Exception{
        ExercitoDeSaints impostores = new ExercitoQueAtacaEmOrdemHierarquica();
        impostores.alistar(new PrataSaint("Misty", "Lagarto"));
        impostores.alistar(new OuroSaint("Máscara da Morte", "Câncer"));
        impostores.alistar(new BronzeSaint("Ikki", "Fênix"));
        impostores.alistar(new OuroSaint("Saga", "Gêmeos"));
        impostores.alistar(new PrataSaint("Algol", "Perseu"));
        impostores.alistar(new OuroSaint("Afrodite", "Peixes"));
        impostores.alistar(new BronzeSaint("Seiya", "Pégasos"));
        impostores.alistar(new PrataSaint("Marin","Águia"));
        
        impostores.zerarProximoSaint();
        assertEquals(Categoria.BRONZE,impostores.getProximoSaintDoExercito().getCategoria());
        assertEquals(Categoria.BRONZE,impostores.getProximoSaintDoExercito().getCategoria());
        assertEquals(Categoria.PRATA,impostores.getProximoSaintDoExercito().getCategoria());
        assertEquals(Categoria.PRATA,impostores.getProximoSaintDoExercito().getCategoria());
        assertEquals(Categoria.PRATA,impostores.getProximoSaintDoExercito().getCategoria());
        assertEquals(Categoria.OURO,impostores.getProximoSaintDoExercito().getCategoria());
        assertEquals(Categoria.OURO,impostores.getProximoSaintDoExercito().getCategoria());
        assertEquals(Categoria.OURO,impostores.getProximoSaintDoExercito().getCategoria());
        impostores.zerarProximoSaint();
        assertEquals(8, impostores.getTamanho());
    }
}
