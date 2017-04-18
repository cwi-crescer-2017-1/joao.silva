import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class ConstelacaoTest{
   private Constelacao capricornio;
   //Número de testes: 4
   @Test
   public void adicionarUmGolpe(){
       //ARRANGE
       capricornio = new Constelacao("Capricórnio");
       //ACT
       Golpe golpe = new Golpe("Soco", 5);
       capricornio.adicionarGolpe(golpe);
       
       //ASSERT
       assertEquals(golpe, capricornio.getGolpes()[0]);
       for(int i=1;i<capricornio.getGolpes().length;i++){
           assertNull(capricornio.getGolpes()[i]);
       }
   }
   @Test
   public void adicionarDoisGolpes(){
        //ARRANGE
       capricornio = new Constelacao("Capricórnio");
       //ACT
       Golpe golpe1 = new Golpe("Soco", 5);
       Golpe golpe2 = new Golpe("Chute",10);
       capricornio.adicionarGolpe(golpe1);
       capricornio.adicionarGolpe(golpe2);
       //ASSERT
       assertEquals(golpe1, capricornio.getGolpes()[0]);
       assertEquals(golpe2, capricornio.getGolpes()[1]);
       assertNull(capricornio.getGolpes()[2]);
   }
   @Test
   public void aoAdicionarTresGolpes(){
       //ARRANGE
       capricornio = new Constelacao("Capricórnio");
       //ACT
       Golpe[] golpes = new Golpe[3]; //Cria um array com os três golpes a serem adicionados
       golpes[0] = new Golpe("Soco", 5);
       golpes[1] = new Golpe("Chute", 10);
       golpes[2] = new Golpe("Excalibur", 50);
       for(int indice = 0; indice<golpes.length; indice++){ //Adiciona todos os golpes registrados no array golpes para a constelação criada
           capricornio.adicionarGolpe(golpes[indice]);
       } 
       //ASSERT
       for(int indice = 0; indice<golpes.length; indice++){ //Realiza a comparação de Nome e fatorDeDano para cada golpe adicionado
           assertEquals(golpes[indice], capricornio.getGolpes()[indice]);
       }
   }
   @Test(expected=ArrayIndexOutOfBoundsException.class)
   public void aoAdicionarQuatroGolpesUltimoGolpeNaoAdicionaEsperadoErro(){
       //ARRANGE
       capricornio = new Constelacao("Capricórnio");
       //ACT
       Golpe[] golpes = new Golpe[4]; //Cria um array com os três golpes a serem adicionados
       golpes[0] = new Golpe("Soco", 5);
       golpes[1] = new Golpe("Chute", 10);
       golpes[2] = new Golpe("Excalibur", 50);
       golpes[3] = new Golpe("Tapa", 5);
       for(int indice=0; indice<golpes.length;indice++){
       capricornio.adicionarGolpe(golpes[indice]);
       }
       //ASSERT - Erro esperado
       
       
    }
}