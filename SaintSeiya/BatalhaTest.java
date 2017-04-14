import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BatalhaTest{
   //ARMADURA
   private Saint seiya,marin,algol;
   private double vidaInicial;
   @Test
   public void aoBatalharCategoriaMaiorContraCategoriaMenor(){
       //ARRANGE
       seiya = new Saint("Seiya", new Armadura("Pégaso", Categoria.BRONZE));
       marin = new Saint("Marin", new Armadura("Águia", Categoria.PRATA));
       vidaInicial = seiya.getVida();
       //ACT
       new Batalha(seiya,marin).iniciar();
       //ASSERT
       assertEquals(vidaInicial-10.0, seiya.getVida(), 0);
    }
   @Test 
   public void aoBatalharCategoriaMenorContraCategoriaMaior(){
       //ARRANGE
       seiya = new Saint("Seiya", new Armadura("Pégaso", Categoria.BRONZE));
       marin = new Saint("Marin", new Armadura("Águia", Categoria.PRATA));
       vidaInicial = seiya.getVida();
       //ACT
       new Batalha(marin,seiya).iniciar();
       //ASSERT
       assertEquals(vidaInicial-10.0, seiya.getVida(), 0);
    }
   @Test
   public void aoBatalharCategoriasIguais(){
       //ARRANGE
       marin = new Saint("Marin", new Armadura("Águia", Categoria.PRATA));
       algol = new Saint("Algol", new Armadura("Perseu", Categoria.PRATA));
       vidaInicial = algol.getVida();
       //ACT
       new Batalha(marin,algol).iniciar();
       //ASSERT
       assertEquals(vidaInicial-10.0, algol.getVida(), 0);
    }
}