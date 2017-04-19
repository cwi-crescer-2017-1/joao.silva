import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

public class ListaSaintsTest{
    private Saint saint1, saint2, saint3,saint4,saint5,saint6;
    private ListaSaints lista;
    private ArrayList<Saint> listDeSaints;

  //´Número de testes: 5
  //BUSCA SAINT POR NOME
  @Test
  public void aoBuscarSaintPorNome() throws Exception{
      //ARRANGE
      this.lista = new ListaSaints();
      this.saint1 = new BronzeSaint("Ikki", new Armadura(new Constelacao("Fênix"), Categoria.BRONZE));
      this.saint2 = new PrataSaint("Dio", new Armadura(new Constelacao("Mosca"), Categoria.PRATA));
      this.saint3 = new OuroSaint("Mu", new Armadura(new Constelacao("Áries"), Categoria.OURO));
      //ACT
      this.lista.adicionar(this.saint1);
      this.lista.adicionar(this.saint2);
      this.lista.adicionar(this.saint3);
      //ASSERT
      assertEquals(this.saint1,this.lista.buscarPorNome("Ikki"));
      assertEquals(this.saint2,this.lista.buscarPorNome("Dio"));
      assertEquals(this.saint3,this.lista.buscarPorNome("Mu"));
  }
  @Test
  public void aoBuscarSaintPorNomeComNomesRepetidos() throws Exception{
      //ARRANGE
      this.lista = new ListaSaints();
      this.saint1 = new BronzeSaint("Ikki", new Armadura(new Constelacao("Fênix"), Categoria.BRONZE));
      this.saint2 = new PrataSaint("Ikki", new Armadura(new Constelacao("Mosca"), Categoria.PRATA));
      //ACT
      this.lista.adicionar(this.saint1);
      this.lista.adicionar(this.saint2);
      //ASSERT
      assertEquals(this.saint1,this.lista.buscarPorNome("Ikki"));
      assertEquals(this.saint1,this.lista.buscarPorNome("Ikki"));
  }
  @Test
  public void aoBuscarSaintInexistentePorNomeRetornaNull() throws Exception{
      //ARRANGE
      this.lista = new ListaSaints();
      this.saint1 = new BronzeSaint("Ikki", new Armadura(new Constelacao("Fênix"), Categoria.BRONZE));
      this.saint2 = new PrataSaint("Dio", new Armadura(new Constelacao("Mosca"), Categoria.PRATA));
      //ACT
      this.lista.adicionar(this.saint1);
      this.lista.adicionar(this.saint2);
      //ASSERT
      assertNull(this.lista.buscarPorNome("Mu"));
  }
  @Test
  public void aoBuscarSaintPorNomeComListaVaziaRetornaNull() throws Exception{
      //ARRANGE
      this.lista = new ListaSaints();
      //ACT
      //ASSERT
      assertNull(this.lista.buscarPorNome("Ikki"));
  }
  //BUSCA POR CATEGORIA
  @Test
  public void aoBuscarPorCategoriaBronze() throws Exception{
      //ARRANGE
      this.lista = new ListaSaints();
      this.saint1 = new BronzeSaint("Ikki", new Armadura(new Constelacao("Fênix"), Categoria.BRONZE));
      this.saint2 = new BronzeSaint("Seiya", new Armadura(new Constelacao("Pegasos"), Categoria.BRONZE));
      this.saint3 = new OuroSaint("Shaka", new Armadura(new Constelacao("Virgem"), Categoria.OURO));
      this.saint4 = new PrataSaint("Argor", new Armadura(new Constelacao("Perseu"), Categoria.PRATA));
      //ACT
      this.lista.adicionar(this.saint1);
      this.lista.adicionar(this.saint2);
      this.lista.adicionar(this.saint3);
      this.lista.adicionar(this.saint4);
      this.listDeSaints = this.lista.buscarPorCategoria(Categoria.BRONZE);
      //ASSERT
      assertEquals(this.saint1,this.listDeSaints.get(0));//Verifica se os valores estão certos
      assertEquals(this.saint2,this.listDeSaints.get(1));
      assertEquals(2,this.listDeSaints.size());//Verifica se o tamanho esta igual ao número de fatores certos
  }
  @Test
  public void aoBuscarPorCategoriaPrata() throws Exception{
      //ARRANGE
      this.lista = new ListaSaints();
      this.saint1 = new BronzeSaint("Ikki", new Armadura(new Constelacao("Fênix"), Categoria.BRONZE));
      this.saint2 = new PrataSaint("Dio", new Armadura(new Constelacao("Mosca"), Categoria.PRATA));
      this.saint3 = new OuroSaint("Mu", new Armadura(new Constelacao("Áries"), Categoria.OURO));
      this.saint4 = new PrataSaint("Argor", new Armadura(new Constelacao("Perseu"), Categoria.PRATA));
      //ACT
      this.lista.adicionar(this.saint1);
      this.lista.adicionar(this.saint2);
      this.lista.adicionar(this.saint3);
      this.lista.adicionar(this.saint4);
      this.listDeSaints = this.lista.buscarPorCategoria(Categoria.PRATA);
      //ASSERT
      assertEquals(this.saint2,this.listDeSaints.get(0));
      assertEquals(this.saint4,this.listDeSaints.get(1));
      assertEquals(2,this.listDeSaints.size());
  }
  @Test
  public void aoBuscarPorCategoriaOuro() throws Exception{
      //ARRANGE
      this.lista = new ListaSaints();
      this.saint1 = new BronzeSaint("Ikki", new Armadura(new Constelacao("Fênix"), Categoria.BRONZE));
      this.saint2 = new OuroSaint("Shaka", new Armadura(new Constelacao("Virgem"), Categoria.OURO));
      this.saint3 = new PrataSaint("Dio", new Armadura(new Constelacao("Mosca"), Categoria.PRATA));
      this.saint4 = new OuroSaint("Mu", new Armadura(new Constelacao("Áries"), Categoria.OURO));
      
      //ACT
      this.lista.adicionar(this.saint1);
      this.lista.adicionar(this.saint2);
      this.lista.adicionar(this.saint3);
      this.lista.adicionar(this.saint4);
      this.listDeSaints = this.lista.buscarPorCategoria(Categoria.OURO);
      //ASSERT
      assertEquals(this.saint2,this.listDeSaints.get(0));
      assertEquals(this.saint4,this.listDeSaints.get(1));
      assertEquals(2,this.listDeSaints.size());
  }
  @Test
  public void aoBuscarPorCategoriaComZeroSaintsNaCategoria() throws Exception{
      //ARRANGE
      this.lista = new ListaSaints();
      this.saint1 = new BronzeSaint("Ikki", new Armadura(new Constelacao("Fênix"), Categoria.BRONZE));
      this.saint2 = new PrataSaint("Dio", new Armadura(new Constelacao("Mosca"), Categoria.PRATA));
      this.saint3 = new PrataSaint("Argor", new Armadura(new Constelacao("Perseu"), Categoria.PRATA));
      //ACT
      this.lista.adicionar(this.saint1);
      this.lista.adicionar(this.saint2);
      this.lista.adicionar(this.saint3);
	  this.listDeSaints = this.lista.buscarPorCategoria(Categoria.OURO);
      //ASSERT
      assertEquals(0,this.listDeSaints.size());
  }
  @Test
  public void aoBuscarPorCategoriaComListaVazia() throws Exception{
      //ARRANGE
      this.lista = new ListaSaints();
      //ACT
	  this.listDeSaints = this.lista.buscarPorCategoria(Categoria.BRONZE);
      //ASSERT
      assertEquals(0,this.listDeSaints.size());
  }
  //BUSCA POR STATUS
  @Test
  public void aoBuscarPorStatus() throws Exception{
      //ARRANGE
      this.lista = new ListaSaints();
      this.saint1 = new BronzeSaint("Ikki", new Armadura(new Constelacao("Fênix"), Categoria.BRONZE));
      this.saint2 = new BronzeSaint("Seiya", new Armadura(new Constelacao("Pegasos"), Categoria.BRONZE));
      this.saint3 = new OuroSaint("Shaka", new Armadura(new Constelacao("Virgem"), Categoria.OURO));
      this.saint4 = new PrataSaint("Dio", new Armadura(new Constelacao("Mosca"), Categoria.PRATA));
      this.saint5 = new OuroSaint("Mu", new Armadura(new Constelacao("Áries"), Categoria.OURO));
      this.saint6 = new PrataSaint("Argor", new Armadura(new Constelacao("Perseu"), Categoria.PRATA));
      //ACT
      this.saint1.perderVida(100);
      this.saint3.perderVida(100);
      this.saint5.perderVida(100);
      this.lista.adicionar(this.saint1);
      this.lista.adicionar(this.saint2);
      this.lista.adicionar(this.saint3);
      this.lista.adicionar(this.saint4);
      this.lista.adicionar(this.saint5);
      this.lista.adicionar(this.saint6);
      this.listDeSaints = this.lista.buscarPorStatus(Status.VIVO);
      //ASSERT
      assertEquals(this.saint2,this.listDeSaints.get(0));
      assertEquals(this.saint4,this.listDeSaints.get(1));
      assertEquals(this.saint6,this.listDeSaints.get(2));
  }
  @Test
  public void aoBuscarPorStatusComListaVazia() throws Exception{
      //ARRANGE
      this.lista = new ListaSaints();
      //ACT
	  this.listDeSaints = this.lista.buscarPorStatus(Status.VIVO);
      //ASSERT
      assertEquals(0,this.listDeSaints.size());
  }
  @Test
  public void aoBuscarPorStatusMortoTendoZeroSaintsMortos() throws Exception{
      //ARRANGE
      this.lista = new ListaSaints();
      this.saint1 = new BronzeSaint("Ikki", new Armadura(new Constelacao("Fênix"), Categoria.BRONZE));
      this.saint2 = new PrataSaint("Dio", new Armadura(new Constelacao("Mosca"), Categoria.PRATA));
      this.saint3 = new PrataSaint("Argor", new Armadura(new Constelacao("Perseu"), Categoria.PRATA));
      //ACT
	  this.lista.adicionar(this.saint1);
      this.lista.adicionar(this.saint2);
      this.lista.adicionar(this.saint3); 
      this.listDeSaints = this.lista.buscarPorStatus(Status.MORTO);
      //ASSERT
      assertEquals(0,this.listDeSaints.size());
  }
  @Test
  public void aoBuscarPorStatusVivoTendoZeroSaintsVivos() throws Exception{
      //ARRANGE
      this.lista = new ListaSaints();
      this.saint1 = new BronzeSaint("Ikki", new Armadura(new Constelacao("Fênix"), Categoria.BRONZE));
      this.saint2 = new PrataSaint("Dio", new Armadura(new Constelacao("Mosca"), Categoria.PRATA));
      this.saint3 = new PrataSaint("Argor", new Armadura(new Constelacao("Perseu"), Categoria.PRATA));
      //ACT
	  this.saint1.perderVida(100);
      this.saint2.perderVida(100);
      this.saint3.perderVida(100);
 	  this.lista.adicionar(this.saint1);
      this.lista.adicionar(this.saint2);
      this.lista.adicionar(this.saint3);
      this.listDeSaints = this.lista.buscarPorStatus(Status.VIVO);
      //ASSERT
      assertEquals(0,this.listDeSaints.size());
  }
  //GET SAINT COM MAIOR VIDA
  @Test
  public void aoBuscarSaintComMaiorVidaListaComApenasUmSaint() throws Exception{
      //ARRANGE
      this.lista = new ListaSaints();
      this.saint1 = new BronzeSaint("Ikki", new Armadura(new Constelacao("Fênix"), Categoria.BRONZE));//Inicializa com 100 de vida
      //ACT
      this.lista.adicionar(this.saint1);
      //ASSERT
      assertEquals(this.saint1,this.lista.getSaintMaiorVida());
  }
  @Test
  public void aoBuscarSaintComMaiorVida() throws Exception{
      //ARRANGE
      this.lista = new ListaSaints();
      this.saint1 = new BronzeSaint("Ikki", new Armadura(new Constelacao("Fênix"), Categoria.BRONZE));//Inicializa com 100 de vida
      this.saint2 = new BronzeSaint("Seiya", new Armadura(new Constelacao("Pegasos"), Categoria.BRONZE));
      this.saint3 = new BronzeSaint("Shaka", new Armadura(new Constelacao("Virgem"), Categoria.BRONZE));
      //ACT
      this.saint1.perderVida(10);//Maior
      this.saint2.perderVida(30);
      this.saint3.perderVida(100);//Menor
      this.lista.adicionar(this.saint1);
      this.lista.adicionar(this.saint2);
      this.lista.adicionar(this.saint3);
      //ASSERT
      assertEquals(this.saint1,this.lista.getSaintMaiorVida());
  }
  @Test
  public void aoBuscarSaintComMaiorVidaComListaVazia() throws Exception{
      //ARRANGE
      this.lista = new ListaSaints();
      //ACT
      //ASSERT
      assertNull(this.lista.getSaintMaiorVida());
  }
  //GET SAINT COM MENOR VIDA
  @Test
  public void aoBuscarSaintComMenorVidaListaComApenasUmSaint() throws Exception{
      //ARRANGE
      this.lista = new ListaSaints();
      this.saint1 = new BronzeSaint("Ikki", new Armadura(new Constelacao("Fênix"), Categoria.BRONZE));//Inicializa com 100 de vida
      //ACT
      this.lista.adicionar(this.saint1);
      //ASSERT
      assertEquals(this.saint1,this.lista.getSaintMenorVida());
  }
  @Test
  public void aoBuscarSaintComMenorVidaDentreTresSaints() throws Exception{
      //ARRANGE
      this.lista = new ListaSaints();
      this.saint1 = new BronzeSaint("Ikki", new Armadura(new Constelacao("Fênix"), Categoria.BRONZE));//Inicializa com 100 de vida
      this.saint2 = new BronzeSaint("Seiya", new Armadura(new Constelacao("Pegasos"), Categoria.BRONZE));
      this.saint3 = new BronzeSaint("Shaka", new Armadura(new Constelacao("Virgem"), Categoria.BRONZE));
      //ACT
      this.saint1.perderVida(10);//Maior
      this.saint2.perderVida(30);
      this.saint3.perderVida(100);//Menor
      this.lista.adicionar(this.saint1);
      this.lista.adicionar(this.saint2);
      this.lista.adicionar(this.saint3);
      //ASSERT
      assertEquals(this.saint3,this.lista.getSaintMenorVida());
  }
  @Test
  public void aoBuscarSaintComMenorVidaComListaVazia() throws Exception{
      //ARRANGE
      this.lista = new ListaSaints();
      //ACT
      //ASSERT
      assertNull(this.lista.getSaintMenorVida());
  }
  //ORDENAR por vida(Ordem ascendente)
  @Test
  public void aoOrdenarListaComSeisSaints() throws Exception{
      //ARRANGE
      this.lista = new ListaSaints();
      this.saint1 = new BronzeSaint("Ikki", new Armadura(new Constelacao("Fênix"), Categoria.BRONZE));//Inicializa com 100 de vida
      this.saint2 = new BronzeSaint("Seiya", new Armadura(new Constelacao("Pegasos"), Categoria.BRONZE));
      this.saint3 = new BronzeSaint("Shaka", new Armadura(new Constelacao("Virgem"), Categoria.BRONZE));
      this.saint4 = new PrataSaint("Dio", new Armadura(new Constelacao("Mosca"), Categoria.PRATA));
      this.saint5 = new OuroSaint("Mu", new Armadura(new Constelacao("Áries"), Categoria.OURO));
      this.saint6 = new PrataSaint("Argor", new Armadura(new Constelacao("Perseu"), Categoria.PRATA));
      //ACT
      this.saint1.perderVida(10);//6º - MaiorVida
      this.saint2.perderVida(15);//5º
      this.saint3.perderVida(77);//1º - MenorVida
      this.saint4.perderVida(25);//4º
      this.saint5.perderVida(55);//2º
      this.saint6.perderVida(37);//3º
      this.lista.adicionar(this.saint1);
      this.lista.adicionar(this.saint2);
      this.lista.adicionar(this.saint3);
      this.lista.adicionar(this.saint4);
      this.lista.adicionar(this.saint5);
      this.lista.adicionar(this.saint6);
      this.lista.ordenar();
      //ASSERT
      assertEquals(this.saint3,this.lista.get(0));
      assertEquals(this.saint5,this.lista.get(1));
      assertEquals(this.saint6,this.lista.get(2));
      assertEquals(this.saint4,this.lista.get(3));
      assertEquals(this.saint2,this.lista.get(4));
      assertEquals(this.saint1,this.lista.get(5));
	  assertEquals(6,this.lista.getTamanho());
  }
  @Test
  public void aoOrdenarListaVazia() throws Exception{
      //ARRANGE
      this.lista = new ListaSaints();
      //ACT
      this.lista.ordenar();
      //ASSERT
      assertEquals(0,lista.getTamanho());
  }
  @Test
  public void aoOrdenarListaComUmSaint() throws Exception{
      //ARRANGE
      this.lista = new ListaSaints();
      this.saint1 = new BronzeSaint("Ikki", new Armadura(new Constelacao("Fênix"), Categoria.BRONZE));
      //ACT
      this.lista.adicionar(this.saint1);
      this.lista.ordenar();
      //ASSERT
      assertEquals(this.saint1,this.lista.get(0));
	  assertEquals(1,this.lista.getTamanho());
  }
}
