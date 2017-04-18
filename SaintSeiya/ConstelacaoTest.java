import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class ConstelacaoTest{
   private Constelacao capricornio;
   //Número de testes: 2
   @Test
   public void aoAdicionar3GolpesRetornaOs3GolpesCorretos(){
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
           assertEquals(golpes[indice].getNome(), capricornio.getGolpes()[indice].getNome()); //Compara o nome de cada casa do array com o nome realmente adicionado
           assertEquals(golpes[indice].getFatorDano(), capricornio.getGolpes()[indice].getFatorDano()); // Compara o fatore de dano de cada casa do array com o fator de dano realmente adicionado
       }
   }
   @Test
   public void aoAdicionar4GolpesOQuartoGolpeReescreveOPrimeiroGolpeAdicionado(){
       //ARRANGE
       capricornio = new Constelacao("Capricórnio");
       //ACT
       Golpe[] golpes = new Golpe[4]; //Cria um array com os três golpes a serem adicionados
       golpes[0] = new Golpe("Soco", 5);
       golpes[1] = new Golpe("Chute", 10);
       golpes[2] = new Golpe("Excalibur", 50);
       golpes[3] = new Golpe("Tapa", 5);
       for(int indice = 0; indice<golpes.length; indice++){ //Adiciona todos os golpes registrados no array golpes para a constelação criada
           capricornio.adicionarGolpe(golpes[indice]);
       }
       //ASSERT
       assertEquals(golpes[golpes.length-1].getNome(), capricornio.getGolpes()[0].getNome()); //Compara os nomes
       assertEquals(golpes[golpes.length-1].getFatorDano(), capricornio.getGolpes()[0].getFatorDano()); // Compara o fatorDano
   }
}
