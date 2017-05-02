import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GolpeSimplesTest{
   @Test
   public void aoRealizarGolpeSimplesDanoIgual25PorcentoDaVidaDoGolpeado() throws Exception{
       double vidaInicial;
       Saint saint1 = new BronzeSaint("Ikki","Fênix");
       saint1.ativarContraAtaque();
       Saint saint2 = new BronzeSaint("Seiya","Pégasos");
       vidaInicial = saint2.getVida();
       GolpeSimples golpe = new GolpeSimples(saint1,saint2);
       golpe.executar();
       assertEquals(vidaInicial*0.75, saint2.getVida(), 0.01); //Verifica se perder 25% da vida
   }
   @Test
   public void aoRealizarGolpeSimplesComGolpeadoMorto() throws Exception{
       Saint saint1 = new BronzeSaint("Ikki","Fênix");
       saint1.ativarContraAtaque();
       Saint saint2 = new BronzeSaint("Seiya","Pégasos");
       saint2.perderVida(100);
       GolpeSimples golpe = new GolpeSimples(saint1,saint2);
       golpe.executar();
       assertEquals(Status.MORTO, saint2.getStatus());
   }
}
