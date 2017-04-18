import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class SaintTest{
   private BronzeSaint allMightBronze;
   private PrataSaint allMightPrata;
   private OuroSaint allMightOuro;
   private double vidaAnterior;
   //Número de testes: 18
   //ARMADURA
   @Test
   public void vestirArmaduraDeixaArmaduraVestida() throws Exception{
       //ARRANGE
       allMightBronze = new BronzeSaint("Ikki", new Armadura(new Constelacao("Fênix"), Categoria.BRONZE));
       //ACT
       allMightBronze.vestirArmadura();
       //ASSERT
       assertEquals(true,allMightBronze.getArmaduraVestida());
    }
   @Test
   public void naoVestirArmaduraDeixaArmaduraNaoVestida() throws Exception{
       //ARRANGE
       allMightPrata = new PrataSaint("Irineu", new Armadura(new Constelacao("Perseu"), Categoria.PRATA));
       //ACT - TESTE DE PRÉ DEFINIÇÃO
       //ASSERT
       assertEquals(false,allMightPrata.getArmaduraVestida());
   }
   //GENERO
   @Test
   public void aoCriarSaintGeneroENaoInformado() throws Exception{
       //ARRANGE
       allMightOuro = new OuroSaint("Shaka", new Armadura(new Constelacao("Virgem"), Categoria.OURO));
       //ACT - TESTE DE PRÉ DEFINIÇÃO
       //ASSERT
       assertEquals(Genero.NAO_INFORMADO, allMightOuro.getGenero());
   }
   @Test 
   public void alterarSaintGenero() throws Exception{
       //ARRANGE
       allMightBronze = new BronzeSaint("Seiya", new Armadura(new Constelacao("Pégaso"),Categoria.BRONZE));
       //ACT
       allMightBronze.setGenero(Genero.MASCULINO);
       //ASSERT
       assertEquals(Genero.MASCULINO, allMightBronze.getGenero());
       //ACT
       allMightBronze.setGenero(Genero.FEMININO);
       //ASSERT
       assertEquals(Genero.FEMININO, allMightBronze.getGenero());
   }
   //STATUS //Dica de nome para o método: statusInicialDeveSerVivo, achei mais explicativo 
   @Test
   public void aoCriarSaintStatusDeVidaEVivo() throws Exception{
       //ARRANGE
       allMightOuro = new OuroSaint("YOLO", new Armadura(new Constelacao("Virgem"), Categoria.OURO));
       //ACT - TESTE DE PRÉ DEFINIÇÃO
       //ASSERT
       assertEquals(Status.VIVO, allMightOuro.getStatus());
    }
   //VIDA
   @Test
   public void aoCriarSaintVidaIgualCem() throws Exception{ //aVidaInicialDeveSer100 -> Dica de outro nome para o teste
       //ARRANGE
       allMightBronze = new BronzeSaint("Monstro", new Armadura(new Constelacao("Pégaso"), Categoria.BRONZE));
       //ACT - TESTE DE PRÉ DEFINIÇÃO
       //ASSERT
       assertEquals(100.0, allMightBronze.getVida(), 0.01);
   }
   //aoPerderVida
   @Test
   public void aoPerder20DeVida() throws Exception{
       //ARRANGE
       allMightOuro = new OuroSaint("Aioros", new Armadura(new Constelacao("Sagitário"), Categoria.OURO)); //Recem criado tem 100 de vida
       //ACT
       vidaAnterior=allMightOuro.getVida();
       allMightOuro.perderVida(20.0);
       //ASSERT
       assertEquals(vidaAnterior-20.0, allMightOuro.getVida(), 0.01);
   }
   @Test
   public void aoPerder200DeVida() throws Exception{ //Atributo vida sem contenção para limitar número minimo de vida a zero, ajustar caso seja criada uma conteção
       //ARRANGE
       allMightOuro = new OuroSaint("Aioros", new Armadura(new Constelacao("Sagitário"), Categoria.OURO));
       //ACT
       vidaAnterior=allMightOuro.getVida();
       allMightOuro.perderVida(200.0);
       //ASSERT
       assertEquals(0.0, allMightOuro.getVida(), 0.01); //Ao perder mais vida do que possui ou perder toda sua vida o valor da vida fica zero
   }
   @Test
   public void aoPerderNumeroQuebradoDeVida() throws Exception{
       //ARRANGE
       allMightOuro = new OuroSaint("Aioros", new Armadura(new Constelacao("Sagitário"), Categoria.OURO));
       //ACT
       vidaAnterior=allMightOuro.getVida();
       allMightOuro.perderVida(3.141592);
       //ASSERT
       assertEquals(vidaAnterior-3.141592, allMightOuro.getVida(), 0.01);
   }
   @Test(expected=Exception.class)
   public void aoPerderNumeroNegativoDeVida() throws Exception{ //Teste deve ser removido caso se evite números negativos no método PerderVida()
       //ARRANGE
       allMightOuro = new OuroSaint("Aioros", new Armadura(new Constelacao("Sagitário"), Categoria.OURO));
       //ACT
       allMightOuro.perderVida(-100.0);
       //ASSERT - O esperado é o retorno de um erro devido ao fato de ser proibido retirar um número negativo de vida
   }
   @Test
   public void aoPerderTodaVidaEsperadoQueStatusSejaMorto() throws Exception{
       //ARRANGE
       allMightOuro = new OuroSaint("Aioros", new Armadura(new Constelacao("Sagitário"), Categoria.OURO)); //Recem criado tem 100 de vida
       //ACT
       allMightOuro.perderVida(100.0);
       //ASSERT
       assertEquals(Status.MORTO, allMightOuro.getStatus());
   }
   //SENTIDOS
   @Test
   public void aoCriarSaintBronzeNasceCom5SentidosDespertados() throws Exception{
       //ARRANGE
       allMightBronze = new BronzeSaint("Ikki", new Armadura(new Constelacao("Fênix"), Categoria.BRONZE));
       //ACT - TESTE DE PRÉ DEFINIÇÃO
       //ASSERT
       assertEquals(5, allMightBronze.getQtSentidosDespertados());
   }
   @Test
   public void aoCriarSaintPrataNasceCom6SentidosDespertados() throws Exception{
       //ARRANGE
       allMightPrata = new PrataSaint("Irineu", new Armadura(new Constelacao("Perseu"), Categoria.PRATA));
       //ACT - TESTE DE PRÉ DEFINIÇÃO
       //ASSERT
       assertEquals(6, allMightPrata.getQtSentidosDespertados());
   }
   @Test
   public void aoCriarSaintOuroNasceCom7SentidosDespertados() throws Exception{
       //ARRANGE
       allMightOuro = new OuroSaint("Aioros", new Armadura(new Constelacao("Sagitário"), Categoria.OURO));
       //ACT - TESTE DE PRÉ DEFINIÇÃO
       //ASSERT
       assertEquals(7, allMightOuro.getQtSentidosDespertados());
   }
   //CONSTELAÇÃO
   @Test(expected=Exception.class)
   public void constelacaoInvalidaDeOuroDeveLancarErro() throws Exception{
       //ARRANGE
       allMightOuro = new OuroSaint("YOLO", new Armadura(new Constelacao("Errada"), Categoria.OURO));
       //ACT - TESTE DE PRÉ DEFINIÇÃO
       //ASSERT - TESTE DE DECLARAÇÃO DE VARIÁVEL
    }
   //GOLPES
   @Test
   public void aoAdicionar3GolpesOs3GolpesSaoAdicionadosCorretamente() throws Exception{
       //ARRANGE
       allMightOuro = new OuroSaint("Aioros", new Armadura(new Constelacao("Sagitário"), Categoria.OURO)); //Recem criado tem 100 de vida
       Golpe[] golpes = new Golpe[3];
       golpes[0] = new Golpe("Chute",10);
       golpes[1] = new Golpe("Soco",10);
       golpes[2] = new Golpe("Excalibur",50);
       //ACT
       for(int indice = 0; indice<golpes.length; indice++){ //Adiciona os 3 golpes
           allMightOuro.aprenderGolpe(golpes[indice]);
       }
       //ASSERT
       for(int indice = 0; indice<golpes.length; indice++){ //Verifica se os golpes foram adicionados corretamente
           assertEquals(golpes[indice].getNome(), allMightOuro.getGolpes()[indice].getNome()); //Verifica o nome
           assertEquals(golpes[indice].getFatorDano(), allMightOuro.getGolpes()[indice].getFatorDano()); //Verifica o FatorDano
       }
   }
   @Test
   public void aoAdicionar6GolpesOs3UltimosGolpesReescrevemOs3Primeiros() throws Exception{
       //ARRANGE
       allMightOuro = new OuroSaint("Aioros", new Armadura(new Constelacao("Sagitário"), Categoria.OURO));
       Golpe[] golpes = new Golpe[6];
       golpes[0] = new Golpe("Chute",10);
       golpes[1] = new Golpe("Soco",10);
       golpes[2] = new Golpe("Excalibur",50);
       golpes[3] = new Golpe("Chute Magnífico", 20);
       golpes[4] = new Golpe("Soco Magnífico",20);
       golpes[5] = new Golpe("Excalibur Esplêndida",100);
       //ACT
       for(int indice = 0; indice<golpes.length; indice++){ //Adiciona os 6 golpes, sendo que ficará gravado na classe os 3 últimos
           allMightOuro.aprenderGolpe(golpes[indice]);
       }
       //ASSERT
       for(int indice = 0; indice<allMightOuro.getGolpes().length; indice++){ //Verifica se os golpes foram adicionados corretamente
           assertEquals(golpes[indice+3].getNome(), allMightOuro.getGolpes()[indice].getNome()); //Verifica o nome
           assertEquals(golpes[indice+3].getFatorDano(), allMightOuro.getGolpes()[indice].getFatorDano()); //Verifica o FatorDano
       }
   }
   @Test
   public void aoPegarOValorDoProximoGolpeEleRetornaOValorDoProximoGolpe() throws Exception{
       //ARRANGE
       allMightOuro = new OuroSaint("Aioros", new Armadura(new Constelacao("Sagitário"), Categoria.OURO)); //Recem criado tem 100 de vida
       Golpe golpe;
       Golpe[] golpes = new Golpe[3];
       golpes[0] = new Golpe("Chute",10);
       golpes[1] = new Golpe("Soco",10);
       golpes[2] = new Golpe("Excalibur",50);
       //ACT
       for(int indice = 0; indice<golpes.length; indice++){ //Adiciona os 3 golpes
           allMightOuro.aprenderGolpe(golpes[indice]);
       }
       //ASSERT
       for(int i = 0; i<2; i++){ //Executa o segundo "for" duas vezes para passar mais de uma vez por todos os valores no getProximoGolpe()
           for(int indice = 0; indice<golpes.length; indice++){
               golpe = allMightOuro.getProximoGolpe();
               assertEquals(golpes[indice].getNome(), golpe.getNome()); //Verifica o nome
               assertEquals(golpes[indice].getFatorDano(), golpe.getFatorDano()); //Verifica o FatorDano
            }
        }
   }
   
    
}