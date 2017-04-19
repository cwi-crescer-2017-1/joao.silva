import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class ConstelacaoTest{
   private Constelacao capricornio;
   //Número de testes: 3
   @Test
   public void adicionarUmGolpe(){
       //ARRANGE
       this.capricornio = new Constelacao("Capricórnio");
       //ACT
       Golpe golpe = new Golpe("Soco", 5);
       capricornio.adicionarGolpe(golpe);
       
       //ASSERT
       assertEquals(golpe, capricornio.getGolpes().get(0));
       assertEquals(1, capricornio.getGolpes().size()); //tamanho ArrayList = quantidade de valores adicionados
   }
   @Test
   public void adicionarDoisGolpes(){
        //ARRANGE
       this.capricornio = new Constelacao("Capricórnio");
       //ACT
       Golpe golpe1 = new Golpe("Soco", 5);
       Golpe golpe2 = new Golpe("Chute",10);
       capricornio.adicionarGolpe(golpe1);
       capricornio.adicionarGolpe(golpe2);
       //ASSERT
       assertEquals(golpe1, capricornio.getGolpes().get(0));
       assertEquals(golpe2, capricornio.getGolpes().get(1));
       assertEquals(2, capricornio.getGolpes().size());
   }
   @Test
   public void aoAdicionarTresGolpes(){
       //ARRANGE
       this.capricornio = new Constelacao("Capricórnio");
       //ACT
       Golpe[] golpes = new Golpe[3]; //Cria um array com os três golpes a serem adicionados
       golpes[0] = new Golpe("Soco", 5);
       golpes[1] = new Golpe("Chute", 10);
       golpes[2] = new Golpe("Excalibur", 50);
       for(int indice = 0; indice<golpes.length; indice++){ //Adiciona todos os golpes registrados no array golpes para a constelação criada
           this.capricornio.adicionarGolpe(golpes[indice]);
       } 
       //ASSERT
       for(int indice = 0; indice<golpes.length; indice++){ //Realiza a comparação de Nome e fatorDeDano para cada golpe adicionado
           assertEquals(golpes[indice], this.capricornio.getGolpes().get(indice));
       }
   } 
}