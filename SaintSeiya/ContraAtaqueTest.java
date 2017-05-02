import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ContraAtaqueTest{
  @Test
  public void aoUsarContraAtaqueResultadoSaintContraAtaqueIgualATrue() throws Exception{
        Saint saint1 = new BronzeSaint("Ikki","Fênix");
        saint1.perderVida(51);
        Saint saint2 = new BronzeSaint("Seiya","Pégasos");
        ContraAtaque contraAtaque = new ContraAtaque(saint2,saint1);
        contraAtaque.usarDadoFalso();
        contraAtaque.executar();
        //assertEquals(false,saint1.getArmaduraVestida());
        assertEquals(true,saint1.getContraAtaque());
  }
}
