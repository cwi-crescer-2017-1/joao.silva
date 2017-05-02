import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ExercitoQueAtacaEmOrdemAlternadaTest{
    @Test
    public void aoCriarExercitoAlternadoEInserir6SaintsOrdemFicaAlterada() throws Exception{
        ExercitoDeSaints impostores = new ExercitoQueAtacaEmOrdemAlternada();
        impostores.alistar(new PrataSaint("Misty", "Lagarto"));
        impostores.alistar(new OuroSaint("Máscara da Morte", "Câncer"));
        impostores.alistar(new BronzeSaint("Ikki", "Fênix"));
        impostores.alistar(new OuroSaint("Saga", "Gêmeos"));
        impostores.alistar(new PrataSaint("Algol", "Perseu"));
        impostores.alistar(new OuroSaint("Afrodite", "Peixes"));
        
        impostores.zerarProximoSaint();
        assertEquals(Categoria.BRONZE,impostores.getProximoSaintDoExercito().getCategoria());
        assertEquals(Categoria.PRATA,impostores.getProximoSaintDoExercito().getCategoria());
        assertEquals(Categoria.OURO,impostores.getProximoSaintDoExercito().getCategoria());
        assertEquals(Categoria.PRATA,impostores.getProximoSaintDoExercito().getCategoria());
        assertEquals(Categoria.OURO,impostores.getProximoSaintDoExercito().getCategoria());
        assertEquals(Categoria.OURO,impostores.getProximoSaintDoExercito().getCategoria());
        impostores.zerarProximoSaint();
        assertEquals(6, impostores.getTamanho());
    }

    @Test
    public void aoCriarExercitoAlternadoInserir7SaintsOrdemFicaAlternada() throws Exception{
        ExercitoDeSaints impostores = new ExercitoQueAtacaEmOrdemAlternada();
        impostores.alistar(new PrataSaint("Misty", "Lagarto"));
        impostores.alistar(new OuroSaint("Máscara da Morte", "Câncer"));
        impostores.alistar(new BronzeSaint("Ikki", "Fênix"));
        impostores.alistar(new OuroSaint("Saga", "Gêmeos"));
        impostores.alistar(new PrataSaint("Algol", "Perseu"));
        impostores.alistar(new OuroSaint("Afrodite", "Peixes"));
        impostores.alistar(new BronzeSaint("Seiya", "Pégasos"));
        
        impostores.zerarProximoSaint();
        assertEquals(Categoria.BRONZE,impostores.getProximoSaintDoExercito().getCategoria());
        assertEquals(Categoria.PRATA,impostores.getProximoSaintDoExercito().getCategoria());
        assertEquals(Categoria.OURO,impostores.getProximoSaintDoExercito().getCategoria());
        assertEquals(Categoria.BRONZE,impostores.getProximoSaintDoExercito().getCategoria());
        assertEquals(Categoria.PRATA,impostores.getProximoSaintDoExercito().getCategoria());
        assertEquals(Categoria.OURO,impostores.getProximoSaintDoExercito().getCategoria());
        assertEquals(Categoria.OURO,impostores.getProximoSaintDoExercito().getCategoria());
        impostores.zerarProximoSaint();
        assertEquals(7, impostores.getTamanho());
    }
    @Test
    public void aoCriarExercitoAlternadoInserir8SaintsOrdemFicaAlternada() throws Exception{
        ExercitoDeSaints impostores = new ExercitoQueAtacaEmOrdemAlternada();
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
        assertEquals(Categoria.PRATA,impostores.getProximoSaintDoExercito().getCategoria());
        assertEquals(Categoria.OURO,impostores.getProximoSaintDoExercito().getCategoria());
        assertEquals(Categoria.BRONZE,impostores.getProximoSaintDoExercito().getCategoria());
        assertEquals(Categoria.PRATA,impostores.getProximoSaintDoExercito().getCategoria());
        assertEquals(Categoria.OURO,impostores.getProximoSaintDoExercito().getCategoria());
        assertEquals(Categoria.PRATA,impostores.getProximoSaintDoExercito().getCategoria());
        assertEquals(Categoria.OURO,impostores.getProximoSaintDoExercito().getCategoria());
        impostores.zerarProximoSaint();
        assertEquals(8, impostores.getTamanho());
    }
}
