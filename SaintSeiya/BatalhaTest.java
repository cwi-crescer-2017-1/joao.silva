import static org.junit.Assert.*;
import org.junit.After; 
import org.junit.Before;
import org.junit.Test;

public class BatalhaTest{
   private BronzeSaint seiya;
   private PrataSaint marin, algol;
   private OuroSaint aiolos,shura;
   private Golpe golpear;
   //Número de testes: 3
   
   @Test
       public void aoBatalharCategoriaMenorContraCategoriaMaior() throws Exception{ //Categoria do Lutador 1 maior que a do Lutador 2
       //ARRANGE
       seiya = new BronzeSaint("Seiya", "Pégaso");
       seiya.aprenderGolpe(new Golpe("Soco",5));
       seiya.adicionarMovimento(new VestirArmadura(seiya));
       
       marin = new PrataSaint("Marin", "Águia");
       marin.aprenderGolpe(new Golpe("Soco",5));
       marin.adicionarMovimento(new VestirArmadura(marin));
       
       seiya.adicionarMovimento(new Golpear(seiya,marin));
       marin.adicionarMovimento(new Golpear(marin,seiya));
       
       //ACT
       new Batalha(seiya,marin).iniciar();
       
       //ASSERT
       assertEquals(0, seiya.getVida(), 0.01);
       assertEquals(Status.MORTO, seiya.getStatus());
       assertEquals(Status.VIVO, marin.getStatus());
   }
   @Test 
   public void aoBatalharCategoriaMaiorContraCategoriaMenor()throws Exception{ //Cegoria do Lutador 2 maior que a do Lutador 1
       //ARRANGE
       seiya = new BronzeSaint("Seiya", "Pégaso");
       seiya.aprenderGolpe(new Golpe("Soco",5));
       seiya.adicionarMovimento(new VestirArmadura(seiya));
       
       marin = new PrataSaint("Marin", "Águia");
       marin.aprenderGolpe(new Golpe("Soco",5));
       marin.adicionarMovimento(new VestirArmadura(marin));
       
       seiya.adicionarMovimento(new Golpear(seiya,marin));
       marin.adicionarMovimento(new Golpear(marin,seiya));
       
       //ACT
       new Batalha(marin,seiya).iniciar();
       
       //ASSERT
       assertEquals(0, seiya.getVida(), 0.01);
       assertEquals(Status.MORTO, seiya.getStatus());
       assertEquals(Status.VIVO, marin.getStatus());
    }
   @Test
   public void aoBatalharCategoriasIguais() throws Exception{
       //ARRANGE
       algol = new PrataSaint("Algol", "Perseu");
       algol.aprenderGolpe(new Golpe("Soco",5));
       algol.adicionarMovimento(new VestirArmadura(algol));
       
       marin = new PrataSaint("Marin", "Águia");
       marin.aprenderGolpe(new Golpe("Soco",5));
       marin.adicionarMovimento(new VestirArmadura(marin));
       
       algol.adicionarMovimento(new Golpear(algol,marin));
       marin.adicionarMovimento(new Golpear(marin,algol));
       
       //ACT
       new Batalha(algol,marin).iniciar();
       
       //ASSERT
       assertEquals(0, marin.getVida(), 0.01);
       assertEquals(Status.MORTO, marin.getStatus());
       assertEquals(Status.VIVO, algol.getStatus());
   }
   @Test
   public void aoBatalharSaintPrataContraSaintSemMovimentos() throws Exception{
       //ARRANGE
       algol = new PrataSaint("Algol", "");
       
       marin = new PrataSaint("Marin", "Águia");
       marin.aprenderGolpe(new Golpe("Soco",5));
       marin.adicionarMovimento(new VestirArmadura(marin));
       
       marin.adicionarMovimento(new Golpear(marin,algol));
       
       //ACT
       new Batalha(algol,marin).iniciar();
       
       //ASSERT
       assertEquals(0, algol.getVida(), 0.01);
       assertEquals(Status.MORTO, algol.getStatus());
       assertEquals(Status.VIVO, marin.getStatus());
   }
   @Test
   public void aoBatalharDoisSaintsDeOuroSemDanoNosMovimentos() throws Exception{
       //ARRANGE
       aiolos = new OuroSaint("Aiolos", "Sagitário");
       aiolos.aprenderGolpe(new Golpe("Saudação",0));
       aiolos.adicionarMovimento(new VestirArmadura(aiolos));
       
       shura = new OuroSaint("Shura", "Capricórnio");
       shura.aprenderGolpe(new Golpe("Saudação",0));
       shura.adicionarMovimento(new VestirArmadura(shura));
       
       shura.adicionarMovimento(new Golpear(shura,aiolos));
       aiolos.adicionarMovimento(new Golpear(aiolos,shura));
       
       //ACT
       new Batalha(aiolos,shura).iniciar();
       
       //ASSERT
       assertEquals(Status.VIVO, aiolos.getStatus());
       assertEquals(Status.VIVO, shura.getStatus());
   }
}
   