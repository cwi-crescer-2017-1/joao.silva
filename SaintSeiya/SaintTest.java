import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.security.InvalidParameterException;

public class SaintTest{
   private BronzeSaint allMightBronze;
   private PrataSaint allMightPrata;
   private OuroSaint allMightOuro;
   private double vidaAnterior;
   //Número de testes: 21
   //ARMADURA
   @Test
   public void vestirArmaduraDeixaArmaduraVestida() throws Exception{
       //ARRANGE
       this.allMightBronze = new BronzeSaint("Ikki", new Armadura(new Constelacao("Fênix"), Categoria.BRONZE));
       //ACT
       this.allMightBronze.vestirArmadura();
       //ASSERT
       assertEquals(true,this.allMightBronze.getArmaduraVestida());
    }
   @Test
   public void naoVestirArmaduraDeixaArmaduraNaoVestida() throws Exception{
       //ARRANGE
       this.allMightPrata = new PrataSaint("Irineu", new Armadura(new Constelacao("Perseu"), Categoria.PRATA));
       //ACT - TESTE DE PRÉ DEFINIÇÃO
       //ASSERT
       assertEquals(false,this.allMightPrata.getArmaduraVestida());
   }
   //GENERO
   @Test
   public void aoCriarSaintGeneroENaoInformado() throws Exception{
       //ARRANGE
       this.allMightOuro = new OuroSaint("Shaka", new Armadura(new Constelacao("Virgem"), Categoria.OURO));
       //ACT - TESTE DE PRÉ DEFINIÇÃO
       //ASSERT
       assertEquals(Genero.NAO_INFORMADO, this.allMightOuro.getGenero());
   }
   @Test 
   public void alterarSaintGenero() throws Exception{
       //ARRANGE
       this.allMightBronze = new BronzeSaint("Seiya", new Armadura(new Constelacao("Pégaso"),Categoria.BRONZE));
       //ACT
       this.allMightBronze.setGenero(Genero.MASCULINO);
       //ASSERT
       assertEquals(Genero.MASCULINO, this.allMightBronze.getGenero());
       //ACT
       this.allMightBronze.setGenero(Genero.FEMININO);
       //ASSERT
       assertEquals(Genero.FEMININO, this.allMightBronze.getGenero());
   }
   //STATUS //Dica de nome para o método: statusInicialDeveSerVivo, achei mais explicativo 
   @Test
   public void aoCriarSaintStatusDeVidaEVivo() throws Exception{
       //ARRANGE
       this.allMightOuro = new OuroSaint("YOLO", new Armadura(new Constelacao("Virgem"), Categoria.OURO));
       //ACT - TESTE DE PRÉ DEFINIÇÃO
       //ASSERT
       assertEquals(Status.VIVO, allMightOuro.getStatus());
    }
   //VIDA
   @Test
   public void aoCriarSaintVidaIgualCem() throws Exception{ //aVidaInicialDeveSer100 -> Dica de outro nome para o teste
       //ARRANGE
       this.allMightBronze = new BronzeSaint("Monstro", new Armadura(new Constelacao("Pégaso"), Categoria.BRONZE));
       //ACT - TESTE DE PRÉ DEFINIÇÃO
       //ASSERT
       assertEquals(100.0, allMightBronze.getVida(), 0.01);
   }
   //aoPerderVida
   @Test
   public void aoPerder20DeVida() throws Exception{
       //ARRANGE
       this.allMightOuro = new OuroSaint("Aioros", new Armadura(new Constelacao("Sagitário"), Categoria.OURO)); //Recem criado tem 100 de vida
       //ACT
       vidaAnterior=this.allMightOuro.getVida();
       this.allMightOuro.perderVida(20.0);
       //ASSERT
       assertEquals(vidaAnterior-20.0, this.allMightOuro.getVida(), 0.01);
   }
   @Test
   public void aoPerder200DeVida() throws Exception{ //Atributo vida sem contenção para limitar número minimo de vida a zero, ajustar caso seja criada uma conteção
       //ARRANGE
       this.allMightOuro = new OuroSaint("Aioros", new Armadura(new Constelacao("Sagitário"), Categoria.OURO));
       //ACT
       vidaAnterior=this.allMightOuro.getVida();
       this.allMightOuro.perderVida(200.0);
       //ASSERT
       assertEquals(0.0, this.allMightOuro.getVida(), 0.01); //Ao perder mais vida do que possui ou perder toda sua vida o valor da vida fica zero
   }
   @Test
   public void aoPerderNumeroQuebradoDeVida() throws Exception{
       //ARRANGE
       this.allMightOuro = new OuroSaint("Aioros", new Armadura(new Constelacao("Sagitário"), Categoria.OURO));
       //ACT
       vidaAnterior=this.allMightOuro.getVida();
       this.allMightOuro.perderVida(3.141592);
       //ASSERT
       assertEquals(vidaAnterior-3.141592, this.allMightOuro.getVida(), 0.01);
   }
   @Test(expected=InvalidParameterException.class)
   public void aoPerderNumeroNegativoDeVida() throws Exception{ //Teste deve ser removido caso se evite números negativos no método PerderVida()
       //ARRANGE
       this.allMightOuro = new OuroSaint("Aioros", new Armadura(new Constelacao("Sagitário"), Categoria.OURO));
       //ACT
       this.allMightOuro.perderVida(-100.0);
       //ASSERT - O esperado é o retorno de um erro devido ao fato de ser proibido retirar um número negativo de vida
   }
   @Test
   public void aoPerderTodaVidaEsperadoQueStatusSejaMorto() throws Exception{
       //ARRANGE
       this.allMightOuro = new OuroSaint("Aioros", new Armadura(new Constelacao("Sagitário"), Categoria.OURO)); //Recem criado tem 100 de vida
       //ACT
       this.allMightOuro.perderVida(100.0);
       //ASSERT
       assertEquals(Status.MORTO, this.allMightOuro.getStatus());
   }
   //SENTIDOS
   @Test
   public void aoCriarSaintBronzeNasceCom5SentidosDespertados() throws Exception{
       //ARRANGE
       this.allMightBronze = new BronzeSaint("Ikki", new Armadura(new Constelacao("Fênix"), Categoria.BRONZE));
       //ACT - TESTE DE PRÉ DEFINIÇÃO
       //ASSERT
       assertEquals(5, this.allMightBronze.getQtSentidosDespertados());
   }
   @Test
   public void aoCriarSaintPrataNasceCom6SentidosDespertados() throws Exception{
       //ARRANGE
       this.allMightPrata = new PrataSaint("Irineu", new Armadura(new Constelacao("Perseu"), Categoria.PRATA));
       //ACT - TESTE DE PRÉ DEFINIÇÃO
       //ASSERT
       assertEquals(6, this.allMightPrata.getQtSentidosDespertados());
   }
   @Test
   public void aoCriarSaintOuroNasceCom7SentidosDespertados() throws Exception{
       //ARRANGE
       this.allMightOuro = new OuroSaint("Aioros", new Armadura(new Constelacao("Sagitário"), Categoria.OURO));
       //ACT - TESTE DE PRÉ DEFINIÇÃO
       //ASSERT
       assertEquals(7, this.allMightOuro.getQtSentidosDespertados());
   }
   //CONSTELACAO
   @Test(expected=Exception.class)
   public void constelacaoInvalidaDeOuroDeveLancarErro() throws Exception{
       //ARRANGE
       this.allMightOuro = new OuroSaint("YOLO", new Armadura(new Constelacao("Errada"), Categoria.OURO));
       //ACT - TESTE DE PRÉ DEFINIÇÃO
       //ASSERT - TESTE DE DECLARAÇÃO DE VARIÁVEL
    }
   //GOLPES
   @Test
   public void aprenderUmGolpe() throws Exception{
       //ARRANGE
       this.allMightOuro = new OuroSaint("Aioros", new Armadura(new Constelacao("Sagitário"), Categoria.OURO)); //Recem criado tem 100 de vida
       Golpe golpe = new Golpe("Chute",10);
       
       //ACT
       this.allMightOuro.aprenderGolpe(golpe);
       
       //ASSERT
       assertEquals(golpe, this.allMightOuro.getGolpes().get(0));
       assertEquals(1,this.allMightOuro.getGolpes().size());
   }
   @Test
   public void aprenderDoisGolpe() throws Exception{
       //ARRANGE
       this.allMightOuro = new OuroSaint("Aioros", new Armadura(new Constelacao("Sagitário"), Categoria.OURO)); //Recem criado tem 100 de vida
       Golpe golpe1 = new Golpe("Chute",10);
       Golpe golpe2 = new Golpe("Soco", 10);
       
       //ACT
       this.allMightOuro.aprenderGolpe(golpe1);
       this.allMightOuro.aprenderGolpe(golpe2);
       //ASSERT
       assertEquals(golpe1, this.allMightOuro.getGolpes().get(0));
       assertEquals(golpe2, this.allMightOuro.getGolpes().get(1));
       assertEquals(2,this.allMightOuro.getGolpes().size()); //tamanho ArrayList = quantidade de valores adicionados
   }
   @Test
   public void aprenderTresGolpes() throws Exception{
       //ARRANGE
       this.allMightOuro = new OuroSaint("Aioros", new Armadura(new Constelacao("Sagitário"), Categoria.OURO)); //Recem criado tem 100 de vida
       Golpe[] golpes = new Golpe[3];
       golpes[0] = new Golpe("Chute",10);
       golpes[1] = new Golpe("Soco",10);
       golpes[2] = new Golpe("Excalibur",50);
       //ACT
       for(int indice = 0; indice<golpes.length; indice++){ //Adiciona os 3 golpes
           this.allMightOuro.aprenderGolpe(golpes[indice]);
       }
       //ASSERT
       for(int indice = 0; indice<golpes.length; indice++){ //Verifica se os golpes foram adicionados corretamente
           assertEquals(golpes[indice], this.allMightOuro.getGolpes().get(indice));  
       }
       assertEquals(3,this.allMightOuro.getGolpes().size());
   }
   @Test
   public void aprenderSeisGolpes() throws Exception{
       //ARRANGE
       this.allMightOuro = new OuroSaint("Aioros", new Armadura(new Constelacao("Sagitário"), Categoria.OURO));
       Golpe[] golpes = new Golpe[6];
       golpes[0] = new Golpe("Chute",10);
       golpes[1] = new Golpe("Soco",10);
       golpes[2] = new Golpe("Excalibur",50);
       golpes[3] = new Golpe("Chute Magnífico", 20);
       golpes[4] = new Golpe("Soco Magnífico",20);
       golpes[5] = new Golpe("Excalibur Esplêndida",100);
       //ACT
       for(int indice = 0; indice<golpes.length; indice++){ //Adiciona os 6 golpes, sendo que ficará gravado na classe os 3 últimos
           this.allMightOuro.aprenderGolpe(golpes[indice]);
       }
       //ASSERT - Esperado erro
       for(int indice = 0; indice<golpes.length; indice++){ //Adiciona os 6 golpes, sendo que ficará gravado na classe os 3 últimos
           assertEquals(golpes[indice].getNome(), this.allMightOuro.getGolpes().get(indice).getNome());
       }
       assertEquals(6,this.allMightOuro.getGolpes().size());
   }
   @Test
   public void aoPegarOValorDoProximoGolpeComDoisGolpes() throws Exception{
       //ARRANGE
       this.allMightOuro = new OuroSaint("Aioros", new Armadura(new Constelacao("Sagitário"), Categoria.OURO)); //Recem criado tem 100 de vida
       Golpe golpe;
       Golpe[] golpes = new Golpe[2];
       golpes[0] = new Golpe("Chute",10);
       golpes[1] = new Golpe("Soco",10);
       //ACT
       for(int indice = 0; indice<golpes.length; indice++){ //Adiciona os 3 golpes
           this.allMightOuro.aprenderGolpe(golpes[indice]);
       }
       //ASSERT
       for(int indice = 0; indice<golpes.length; indice++){
            golpe = this.allMightOuro.getProximoGolpe();
            assertEquals(golpes[indice], golpe); //Verifica o nome
       }
   }
   @Test
   public void aoPegarOValorDoProximoGolpeSeisVezesComTresGolpes() throws Exception{
       //ARRANGE
       this.allMightOuro = new OuroSaint("Aioros", new Armadura(new Constelacao("Sagitário"), Categoria.OURO)); //Recem criado tem 100 de vida
       Golpe golpe;
       Golpe[] golpes = new Golpe[3];
       golpes[0] = new Golpe("Chute",10);
       golpes[1] = new Golpe("Soco",10);
       golpes[2] = new Golpe("Excalibur",50);
       //ACT
       for(int indice = 0; indice<golpes.length; indice++){ //Adiciona os 3 golpes
           this.allMightOuro.aprenderGolpe(golpes[indice]);
       }
       //ASSERT
       for(int i = 0; i<2; i++){ //Executa o segundo "for" duas vezes para passar mais de uma vez por todos os valores no getProximoGolpe()
           for(int indice = 0; indice<golpes.length; indice++){
               golpe = this.allMightOuro.getProximoGolpe();
               assertEquals(golpes[indice], golpe); //Verifica o nome
            }
        }
   }
   //GET CSV
   @Test
   public void getCSVGeneroFeminino() throws Exception{
       Saint june = new Saint("June", new Armadura(new Constelacao("Camaleão"), Categoria.BRONZE));
       june.setGenero(Genero.FEMININO);
       june.perderVida(15.5);
       assertEquals("June,84.5,Camaleão,BRONZE,VIVO,FEMININO,false",june.getCSV());
   }
   @Test
   public void getCSVComArmaduraVestida() throws Exception{
       Saint dohko = new Saint("Dohko", new Armadura(new Constelacao(""), Categoria.OURO));
       dohko.perderVida(90);
       dohko.vestirArmadura();
       assertEquals("Dohko,10.0,,OURO,VIVO,NAO_INFORMADO,true",dohko.getCSV());
   }
    
}