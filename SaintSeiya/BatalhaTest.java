import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BatalhaTest{
   private Saint seiya,marin,algol;
   private double vidaInicial1, vidaInicial2;
   //Número de testes: 3
   @Test
   public void aoBatalharCategoriaMaiorContraCategoriaMenor(){ //Categoria do Lutador 1 maior que a do Lutador 2
       //ARRANGE
       seiya = new Saint("Seiya", new Armadura("Pégaso", Categoria.BRONZE));
       marin = new Saint("Marin", new Armadura("Águia", Categoria.PRATA));
       vidaInicial1 = seiya.getVida();
       vidaInicial2 = marin.getVida();
       //ACT
       new Batalha(seiya,marin).iniciar();
       //ASSERT
       assertEquals(vidaInicial1-10.0, seiya.getVida(), 0.01);
       assertEquals(vidaInicial2, marin.getVida(), 0.01);
    }
   @Test 
   public void aoBatalharCategoriaMenorContraCategoriaMaior(){ //Cegoria do Lutador 2 maior que a do Lutador 1
       //ARRANGE
       seiya = new Saint("Seiya", new Armadura("Pégaso", Categoria.BRONZE));
       marin = new Saint("Marin", new Armadura("Águia", Categoria.PRATA));
       vidaInicial1 = seiya.getVida();
       vidaInicial2 = marin.getVida();
       //ACT
       new Batalha(marin,seiya).iniciar();
       //ASSERT
       assertEquals(vidaInicial1-10.0, seiya.getVida(), 0.01);
       assertEquals(vidaInicial2, marin.getVida(), 0.01);
    }
   @Test
   public void aoBatalharCategoriasIguais(){
       //ARRANGE
       marin = new Saint("Marin", new Armadura("Águia", Categoria.PRATA));
       algol = new Saint("Algol", new Armadura("Perseu", Categoria.PRATA));
       vidaInicial1 = algol.getVida();
       vidaInicial2 = marin.getVida();
       //ACT
       new Batalha(marin,algol).iniciar();
       //ASSERT
       assertEquals(vidaInicial1-10.0, algol.getVida(), 0.01);
       assertEquals(vidaInicial2, marin.getVida(), 0.01);
    }
}