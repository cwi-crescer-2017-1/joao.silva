import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GolpearTest{
  Saint saint1, saint2, saint3;
  Movimento movimento1,movimento2;
  Golpear golpear1;
  double vidaInicial1, vidaInicial2, vidaInicial3;
  @Test
  public void umSaintSemArmaduraVestidaAplicaUmGolpeEmOutroSaint() throws Exception{
      //ARRANGE
      this.saint1 = new BronzeSaint("Ikki","Fênix"); 
      this.saint2 = new PrataSaint("Dio","Mosca");
      this.saint1.aprenderGolpe(new Golpe("Soco",5));
      vidaInicial2 = this.saint2.getVida();
      vidaInicial1 = this.saint1.getVida();
      this.movimento1 = new Golpear(saint1, saint2);
      //ACT
      this.movimento1.executar();
      //ASSERT
      assertEquals(vidaInicial2-5,this.saint2.getVida(),0.01);
      assertEquals(vidaInicial1,this.saint1.getVida(),0.01);
  }
  @Test
  public void umSaintBronzeComArmaduraVestidaAplicaUmGolpeEmOutroSaint() throws Exception{
      //ARRANGE
      this.saint1 = new BronzeSaint("Ikki","Fênix"); 
      this.saint2 = new PrataSaint("Dio","Mosca");
      this.saint1.aprenderGolpe(new Golpe("Soco",5));
      this.saint1.vestirArmadura();
      //vidaInicial guarda a vida do saint2 antes de tomar os golpes
      vidaInicial1 = this.saint1.getVida();
      vidaInicial2 = this.saint2.getVida();
      this.movimento1 = new Golpear(saint1, saint2);
      //ACT
      this.movimento1.executar();
      //ASSERT
      assertEquals(vidaInicial2-(5*2),this.saint2.getVida(),0.01);
      assertEquals(vidaInicial1,this.saint1.getVida(),0.01);
  }
  @Test
  public void umSaintOuroComArmaduraVestidaAplicaUmGolpeEmOutroSaint() throws Exception{
      //ARRANGE
      this.saint1 = new OuroSaint("Aioros","Sagitário"); 
      this.saint2 = new PrataSaint("Dio","Mosca");
      this.saint1.aprenderGolpe(new Golpe("Soco",5));
      this.saint1.vestirArmadura();
      vidaInicial1 = this.saint1.getVida();
      vidaInicial2 = this.saint2.getVida();
      this.movimento1 = new Golpear(saint1, saint2);
      //ACT
      this.movimento1.executar();
      //ASSERT
      assertEquals(vidaInicial2-(5*4),this.saint2.getVida(),0.01);
      assertEquals(vidaInicial1,this.saint1.getVida(),0.01);
  }
  @Test
  public void umSaintPrataComArmaduraVestidaAplicaUmGolpeEmOutroSaint() throws Exception{
      //ARRANGE
      this.saint1 = new PrataSaint("Dio","Mosca"); 
      this.saint2 = new BronzeSaint("Ikki","Fênix");
      this.saint1.aprenderGolpe(new Golpe("Soco",5));
      this.saint1.vestirArmadura();
      vidaInicial1 = this.saint1.getVida();
      vidaInicial2 = this.saint2.getVida();
      this.movimento1 = new Golpear(saint1, saint2);
      //ACT
      this.movimento1.executar();
      //ASSERT
      assertEquals(vidaInicial2-(5*3),this.saint2.getVida(),0.01);
      assertEquals(vidaInicial1,this.saint1.getVida(),0.01);
  }
  @Test
  public void doisSaintsComArmaduraVestidaAplicamUmGolpeCadaEmOutroSaint() throws Exception{
      //ARRANGE
      this.saint1 = new BronzeSaint("Ikki","Fênix"); 
      this.saint1.aprenderGolpe(new Golpe("Soco",5));
      this.saint1.vestirArmadura();
      
      this.saint2 = new PrataSaint("Dio","Mosca");
      this.saint2.aprenderGolpe(new Golpe("Chute",10));
      this.saint2.vestirArmadura();
      
      this.saint3 = new OuroSaint("Aioros","Sagitário");

      //vidaInicial guarda a vida do saint3 antes de tomar os golpes
      vidaInicial1 = this.saint1.getVida();
      vidaInicial2 = this.saint2.getVida();
      vidaInicial3 = this.saint3.getVida();
      //declara o golpe do saint1 no saint3
      this.movimento1 = new Golpear(saint1, saint3);
      //declara o golpe do saint2 no saint3
      this.movimento2 = new Golpear(saint2, saint3);
      //ACT
      //realiza o primeiro movimento
      this.movimento1.executar();
      //realiza o segundo movimento
      this.movimento2.executar();
      //ASSERT
      assertEquals(vidaInicial3-((5*2)+(10*3)),this.saint3.getVida(),0.01);
      assertEquals(vidaInicial2,this.saint2.getVida(),0.01);
      assertEquals(vidaInicial1,this.saint1.getVida(),0.01);
  }
  @Test
  public void umSaintsComArmaduraVestidaAplicamUmGolpeMortalEmOutroSaint() throws Exception{
      //ARRANGE
      this.saint1 = new BronzeSaint("Ikki","Fênix"); 
      this.saint1.aprenderGolpe(new Golpe("Super soco",99999999));
      this.saint1.vestirArmadura();
     
      this.saint2 = new PrataSaint("Dio","Mosca"); // Deve iniciar com 100 de vida
      
      vidaInicial1 = this.saint1.getVida();
      vidaInicial2 = this.saint2.getVida();
      this.movimento1 = new Golpear(saint1, saint2);
      //ACT
      this.movimento1.executar();
      //ASSERT
      assertEquals(vidaInicial2-((50*2)),this.saint2.getVida(),0.01);
      assertEquals(Status.MORTO,this.saint2.getStatus());
      assertEquals(vidaInicial1,this.saint1.getVida(),0.01);
  }
  @Test
  public void umSaintComArmaduraVestidaAplicamUmGolpeEmUmSaintVazio() throws Exception{
      //ARRANGE
      this.saint1 = new BronzeSaint("Ikki","Fênix"); 
      this.saint1.aprenderGolpe(new Golpe("Soco",5));
      this.saint1.vestirArmadura();

      this.golpear1 = new Golpear(saint1, saint2);
      
      //ACT
      this.golpear1.executar(); 
      
      //ASSERT
     assertEquals(10,this.golpear1.getDano()); //Movimento não implementa getDano, logo golpear não pode ser do tipo Movimento
  }
  @Test
  public void umSaintComArmaduraVestidaAplicaDoisGolpesEmOutroSaint() throws Exception{
      //ARRANGE
      this.saint1 = new BronzeSaint("Ikki","Fênix"); 
      this.saint1.aprenderGolpe(new Golpe("Soco",5));
      this.saint1.aprenderGolpe(new Golpe("Chute", 10));
      this.saint1.vestirArmadura();
      
      this.saint2 = new PrataSaint("Dio","Mosca"); 
     
      vidaInicial1 = this.saint1.getVida();
      vidaInicial2 = this.saint2.getVida();
      
      //O esperado é que seja dado por primeiro o primeiro golpe registrado e por segundo o segundo golpe registrado
      this.movimento1 = new Golpear(this.saint1, this.saint2);
      this.movimento2 = new Golpear(this.saint1, this.saint2);
      //ACT
      this.movimento1.executar();
      this.movimento2.executar();
      //ASSERT
      assertEquals(vidaInicial2-((5*2)+(10*2)),this.saint2.getVida(),0.01);
      assertEquals(vidaInicial1,this.saint1.getVida(),0.01);
  }
}
