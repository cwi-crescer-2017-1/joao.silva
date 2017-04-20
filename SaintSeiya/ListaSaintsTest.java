import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

public class ListaSaintsTest{
    private Saint saint1, saint2, saint3,saint4,saint5,saint6;
    private ListaSaints lista,lista2,lista3,lista4;
    private ArrayList<Saint> listDeSaints;
    private final String quebraLinha = System.lineSeparator();

  //´Número de testes: 41 - Total: 69
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
  public void aoBuscarSaintPorNomeComListaSaintsVaziaRetornaNull() throws Exception{
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
  public void aoBuscarPorCategoriaComListaSaintsVazia() throws Exception{
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
  public void aoBuscarPorStatusComListaSaintsVazia() throws Exception{
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
  public void aoBuscarSaintComMaiorVidaListaSaintsComApenasUmSaint() throws Exception{
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
      this.saint3 = new OuroSaint("Shaka", new Armadura(new Constelacao("Virgem"), Categoria.OURO));
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
  public void aoBuscarSaintComMaiorVidaComListaSaintsVazia() throws Exception{
      //ARRANGE
      this.lista = new ListaSaints();
      //ACT
      //ASSERT
      assertNull(this.lista.getSaintMaiorVida());
  }
  //GET SAINT COM MENOR VIDA
  @Test
  public void aoBuscarSaintComMenorVidaListaSaintsComApenasUmSaint() throws Exception{
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
      this.saint3 = new OuroSaint("Shaka", new Armadura(new Constelacao("Virgem"), Categoria.OURO));
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
  public void aoBuscarSaintComMenorVidaComListaSaintsVazia() throws Exception{
      //ARRANGE
      this.lista = new ListaSaints();
      //ACT
      //ASSERT
      assertNull(this.lista.getSaintMenorVida());
  }
  //ORDENAR por vida(Ordem ascendente)
  @Test
  public void aoOrdenarListaSaintsComSeisSaints() throws Exception{
      //ARRANGE
      this.lista = new ListaSaints();
      this.saint1 = new BronzeSaint("Ikki", new Armadura(new Constelacao("Fênix"), Categoria.BRONZE));//Inicializa com 100 de vida
      this.saint2 = new BronzeSaint("Seiya", new Armadura(new Constelacao("Pegasos"), Categoria.BRONZE));
      this.saint3 = new OuroSaint("Shaka", new Armadura(new Constelacao("Virgem"), Categoria.OURO));
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
  public void aoOrdenarListaSaintsVazia() throws Exception{
      //ARRANGE
      this.lista = new ListaSaints();
      //ACT
      this.lista.ordenar();
      //ASSERT
      assertEquals(0,lista.getTamanho());
  }
  @Test
  public void aoOrdenarListaSaintsComUmSaint() throws Exception{
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
  @Test
  public void aoOrdenarDeFormaDescendenteListaSaintsComSeisSaints() throws Exception{
      //ARRANGE
      this.lista = new ListaSaints();
      this.saint1 = new BronzeSaint("Ikki", new Armadura(new Constelacao("Fênix"), Categoria.BRONZE));//Inicializa com 100 de vida
      this.saint2 = new BronzeSaint("Seiya", new Armadura(new Constelacao("Pegasos"), Categoria.BRONZE));
      this.saint3 = new OuroSaint("Shaka", new Armadura(new Constelacao("Virgem"), Categoria.OURO));
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
      this.lista.ordenar(TipoOrdenacao.DESCENDENTE);
      //ASSERT
      assertEquals(this.saint1,this.lista.get(0));
      assertEquals(this.saint2,this.lista.get(1));
      assertEquals(this.saint4,this.lista.get(2));
      assertEquals(this.saint6,this.lista.get(3));
      assertEquals(this.saint5,this.lista.get(4));
      assertEquals(this.saint3,this.lista.get(5));
      assertEquals(6,this.lista.getTamanho());
  }
  @Test
  public void aoOrdenarDeFormaAscendenteListaSaintsComSeisSaints() throws Exception{
      //ARRANGE
      this.lista = new ListaSaints();
      this.saint1 = new BronzeSaint("Ikki", new Armadura(new Constelacao("Fênix"), Categoria.BRONZE));//Inicializa com 100 de vida
      this.saint2 = new BronzeSaint("Seiya", new Armadura(new Constelacao("Pegasos"), Categoria.BRONZE));
      this.saint3 = new OuroSaint("Shaka", new Armadura(new Constelacao("Virgem"), Categoria.OURO));
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
      this.lista.ordenar(TipoOrdenacao.ASCENDENTE);
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
  public void aoOrdenarAscendenteListaSaintsVazia() throws Exception{
      //ARRANGE
      this.lista = new ListaSaints();
      //ACT
      this.lista.ordenar(TipoOrdenacao.ASCENDENTE);
      //ASSERT
      assertEquals(0,lista.getTamanho());
  }
  @Test
  public void aoOrdenarAscendenteListaSaintsComUmSaint() throws Exception{
      //ARRANGE
      this.lista = new ListaSaints();
      this.saint1 = new BronzeSaint("Ikki", new Armadura(new Constelacao("Fênix"), Categoria.BRONZE));
      //ACT
      this.lista.adicionar(this.saint1);
      this.lista.ordenar(TipoOrdenacao.ASCENDENTE);
      //ASSERT
      assertEquals(this.saint1,this.lista.get(0));
      assertEquals(1,this.lista.getTamanho());
  } 
  @Test
  public void aoOrdenarDescendenteListaSaintsVazia() throws Exception{
      //ARRANGE
      this.lista = new ListaSaints();
      //ACT
      this.lista.ordenar(TipoOrdenacao.DESCENDENTE);
      //ASSERT
      assertEquals(0,lista.getTamanho());
  }
  @Test
  public void aoOrdenarDescendenteListaSaintsComUmSaint() throws Exception{
      //ARRANGE
      this.lista = new ListaSaints();
      this.saint1 = new BronzeSaint("Ikki", new Armadura(new Constelacao("Fênix"), Categoria.BRONZE));
      //ACT
      this.lista.adicionar(this.saint1);
      this.lista.ordenar(TipoOrdenacao.DESCENDENTE);
      //ASSERT
      assertEquals(this.saint1,this.lista.get(0));
      assertEquals(1,this.lista.getTamanho());
  }
  //UNIR
  @Test
  public void aoUnirDuasListasSaintsComTresElementosCada() throws Exception{
      //ARRANGE
      this.lista = new ListaSaints();
      this.lista2 = new ListaSaints();
      this.saint1 = new BronzeSaint("Ikki", new Armadura(new Constelacao("Fênix"), Categoria.BRONZE));
      this.saint2 = new BronzeSaint("Seiya", new Armadura(new Constelacao("Pegasos"), Categoria.BRONZE));
      this.saint3 = new OuroSaint("Shaka", new Armadura(new Constelacao("Virgem"), Categoria.OURO));
      this.saint4 = new PrataSaint("Dio", new Armadura(new Constelacao("Mosca"), Categoria.PRATA));
      this.saint5 = new OuroSaint("Mu", new Armadura(new Constelacao("Áries"), Categoria.OURO));
      this.saint6 = new PrataSaint("Argor", new Armadura(new Constelacao("Perseu"), Categoria.PRATA));
      //ACT
      this.lista.adicionar(saint1);
      this.lista.adicionar(saint2);
      this.lista.adicionar(saint3);
      this.lista2.adicionar(saint4);
      this.lista2.adicionar(saint5);
      this.lista2.adicionar(saint6);
      this.lista3 = this.lista.unir(this.lista2);
      //ASSERT
      assertEquals(saint1,this.lista3.get(0));
      assertEquals(saint2,this.lista3.get(1));
      assertEquals(saint3,this.lista3.get(2));
      assertEquals(saint4,this.lista3.get(3));
      assertEquals(saint5,this.lista3.get(4));
      assertEquals(saint6,this.lista3.get(5));
      assertEquals(6,this.lista3.getTamanho());
  }
  @Test
  public void aoUnirDuasListasSaintsSendoUmaVazia() throws Exception{
      //ARRANGE
      this.lista = new ListaSaints();
      this.lista2 = new ListaSaints();
      this.saint1 = new BronzeSaint("Ikki", new Armadura(new Constelacao("Fênix"), Categoria.BRONZE));
      this.saint2 = new BronzeSaint("Seiya", new Armadura(new Constelacao("Pegasos"), Categoria.BRONZE));
      this.saint3 = new OuroSaint("Shaka", new Armadura(new Constelacao("Virgem"), Categoria.OURO));
      //ACT
      this.lista.adicionar(saint1);
      this.lista.adicionar(saint2);
      this.lista.adicionar(saint3);
      this.lista3 = this.lista.unir(this.lista2);
      //ASSERT
      assertEquals(saint1,this.lista3.get(0));
      assertEquals(saint2,this.lista3.get(1));
      assertEquals(saint3,this.lista3.get(2));
      assertEquals(3,this.lista3.getTamanho());
  }
  @Test
  public void aoUnirTresListasSaintsVazias() throws Exception{
      //ARRANGE
      this.lista = new ListaSaints();
      this.lista2 = new ListaSaints();
      this.lista3 = new ListaSaints();
      this.lista4 = new ListaSaints();
      //ACT
      this.lista4 = this.lista.unir(this.lista2.unir(lista3));
      //ASSERT
      assertEquals(0,this.lista3.getTamanho());
  }
  @Test
  public void aoUnirTresListasSaintsComDoisElementosCada() throws Exception{
      //ARRANGE
      this.lista = new ListaSaints();
      this.lista2 = new ListaSaints();
      this.lista3 = new ListaSaints();
      this.lista4 = new ListaSaints();
      this.saint1 = new BronzeSaint("Ikki", new Armadura(new Constelacao("Fênix"), Categoria.BRONZE));
      this.saint2 = new BronzeSaint("Seiya", new Armadura(new Constelacao("Pegasos"), Categoria.BRONZE));
      this.saint3 = new OuroSaint("Shaka", new Armadura(new Constelacao("Virgem"), Categoria.OURO));
      this.saint4 = new PrataSaint("Dio", new Armadura(new Constelacao("Mosca"), Categoria.OURO));
      this.saint5 = new OuroSaint("Mu", new Armadura(new Constelacao("Áries"), Categoria.OURO));
      this.saint6 = new PrataSaint("Argor", new Armadura(new Constelacao("Perseu"), Categoria.PRATA));
   
      //ACT
      this.lista.adicionar(saint1);
      this.lista.adicionar(saint2);
      this.lista2.adicionar(saint3);
      this.lista2.adicionar(saint4);
      this.lista3.adicionar(saint5);
      this.lista3.adicionar(saint6);
      this.lista4 = this.lista.unir(this.lista2.unir(lista3));
      //ASSERT
      assertEquals(saint1,this.lista4.get(0));
      assertEquals(saint2,this.lista4.get(1));
      assertEquals(saint3,this.lista4.get(2));
      assertEquals(saint4,this.lista4.get(3));
      assertEquals(saint5,this.lista4.get(4));
      assertEquals(saint6,this.lista4.get(5));
      assertEquals(6,this.lista4.getTamanho());
  }
  //DIFF
  @Test
  public void aoDiffUmaListaSaintsComOutraListaSaintsDe3Elementos() throws Exception{
      //comparar duas listas e retornar a os valores da primeira lista que não se repetem na segunda
      //ARRANGE
      this.lista = new ListaSaints();
      this.lista2 = new ListaSaints();
      this.lista3 = new ListaSaints();
      this.saint1 = new BronzeSaint("Ikki", new Armadura(new Constelacao("Fênix"), Categoria.BRONZE));
      this.saint2 = new BronzeSaint("Seiya", new Armadura(new Constelacao("Pegasos"), Categoria.BRONZE));
      this.saint3 = new OuroSaint("Shaka", new Armadura(new Constelacao("Virgem"), Categoria.OURO));
      this.saint4 = new PrataSaint("Dio", new Armadura(new Constelacao("Mosca"), Categoria.PRATA));
      this.saint5 = new BronzeSaint("Seiya", new Armadura(new Constelacao("Pegasos"), Categoria.BRONZE));//=saint2
      this.saint6 = new OuroSaint("Shaka", new Armadura(new Constelacao("Virgem"), Categoria.OURO));//=saint3
      //ACT
      this.lista.adicionar(saint1);
      this.lista.adicionar(saint2);
      this.lista.adicionar(saint3);
      this.lista2.adicionar(saint4);
      this.lista2.adicionar(saint2);
      //this.lista2.adicionar(saint5);
      this.lista2.adicionar(saint3);
      //this.lista2.adicionar(saint6);
      this.lista3 = lista.diff(lista2);
      //ASSERT
      assertEquals(saint1,this.lista3.get(0));
      assertEquals(1,this.lista3.getTamanho());
  }
  @Test
  public void aoDiffUmaListaSaintsComOutraListaSaintsVazia() throws Exception{
      //comparar duas listas e retornar a os valores da primeira lista que não se repetem na segunda
      //ARRANGE
      this.lista = new ListaSaints();
      this.lista2 = new ListaSaints();
      this.lista3 = new ListaSaints();
      this.saint1 = new BronzeSaint("Ikki", new Armadura(new Constelacao("Fênix"), Categoria.BRONZE));
      this.saint2 = new BronzeSaint("Seiya", new Armadura(new Constelacao("Pegasos"), Categoria.BRONZE));
      this.saint3 = new OuroSaint("Shaka", new Armadura(new Constelacao("Virgem"), Categoria.OURO));
      //ACT
      this.lista.adicionar(saint1);
      this.lista.adicionar(saint2);
      this.lista.adicionar(saint3);
      this.lista3 = lista.diff(lista2);
      //ASSERT
      assertEquals(saint1,this.lista3.get(0));
      assertEquals(saint2,this.lista3.get(1));
      assertEquals(saint3,this.lista3.get(2));
      assertEquals(3,this.lista3.getTamanho());
  }
  //INTERSEC
  @Test
  public void aoIntersectarDuasListasSaintsComTresElementosCadaSendoDoisIguais() throws Exception{
      //ARRANGE
      this.lista = new ListaSaints();
      this.lista2 = new ListaSaints();
      this.lista3 = new ListaSaints();
      this.saint1 = new BronzeSaint("Ikki", new Armadura(new Constelacao("Fênix"), Categoria.BRONZE));
      this.saint2 = new BronzeSaint("Seiya", new Armadura(new Constelacao("Pegasos"), Categoria.BRONZE));
      this.saint3 = new OuroSaint("Shaka", new Armadura(new Constelacao("Virgem"), Categoria.OURO));
      this.saint4 = new PrataSaint("Dio", new Armadura(new Constelacao("Mosca"), Categoria.PRATA));
      this.saint5 = new BronzeSaint("Seiya", new Armadura(new Constelacao("Pegasos"), Categoria.BRONZE));//=saint2
      this.saint6 = new OuroSaint("Shaka", new Armadura(new Constelacao("Virgem"), Categoria.OURO));//=saint3
      //ACT
      this.lista.adicionar(saint1);
      this.lista.adicionar(saint2);
      this.lista.adicionar(saint3);
      this.lista2.adicionar(saint4);
      this.lista2.adicionar(saint2);
      //this.lista2.adicionar(saint5);
      this.lista2.adicionar(saint3);
      //this.lista2.adicionar(saint6);
      this.lista3 = lista.intersec(lista2);
      //ASSERT
      assertEquals(saint2,this.lista3.get(0));
      assertEquals(saint3,this.lista3.get(1));
      assertEquals(2,this.lista3.getTamanho());
  }
  @Test
  public void aoIntersectarDuasListasSaintsSendoUmaDelasVazia() throws Exception{
      //ARRANGE
      this.lista = new ListaSaints();
      this.lista2 = new ListaSaints();
      this.lista3 = new ListaSaints();
      this.saint1 = new BronzeSaint("Ikki", new Armadura(new Constelacao("Fênix"), Categoria.BRONZE));
      this.saint2 = new BronzeSaint("Seiya", new Armadura(new Constelacao("Pegasos"), Categoria.BRONZE));
      this.saint3 = new OuroSaint("Shaka", new Armadura(new Constelacao("Virgem"), Categoria.OURO));
      this.saint4 = new PrataSaint("Dio", new Armadura(new Constelacao("Mosca"), Categoria.PRATA));
      //ACT
      this.lista.adicionar(saint1);
      this.lista.adicionar(saint2);
      this.lista.adicionar(saint3);
      this.lista3 = lista.intersec(lista2);
      //ASSERT
      assertEquals(0,this.lista3.getTamanho());
  }
  @Test
  public void aoIntersectarDuasListasSaintsSendoAsDuasVazias() throws Exception{
      //ARRANGE
      this.lista = new ListaSaints();
      this.lista2 = new ListaSaints();
      this.lista3 = new ListaSaints();
      //ACT
      this.lista3 = lista.intersec(lista2);
      //ASSERT
      assertEquals(0,this.lista3.getTamanho());
  }
  //CSV
  @Test
  public void aoPegarCSVDaListaSaintsComDoisSaints() throws Exception{
      //ARRANGE
      this.lista = new ListaSaints();
      this.saint1 = new BronzeSaint("Ikki", new Armadura(new Constelacao("Fênix"), Categoria.BRONZE));
      this.saint2 = new BronzeSaint("Seiya", new Armadura(new Constelacao("Pegasos"), Categoria.BRONZE));
      saint1.setGenero(Genero.MASCULINO);
      saint1.perderVida(50);
      saint2.perderVida(100);
      saint2.vestirArmadura();
      //ACT
      this.lista.adicionar(saint1);
      this.lista.adicionar(saint2);
      String csv = lista.getCSV();
      //ASSERT
      assertEquals("Ikki,50.0,Fênix,BRONZE,VIVO,MASCULINO,false"+quebraLinha+"Seiya,0.0,Pegasos,BRONZE,MORTO,NAO_INFORMADO,true"+quebraLinha, csv);
  }
  @Test
  public void aoPegarCSVDaListaSaintsComDoisSaintsSendoUmNulo() throws Exception{
      //ARRANGE
      this.lista = new ListaSaints();
      this.saint1 = new BronzeSaint("Ikki", new Armadura(new Constelacao("Fênix"), Categoria.BRONZE));
      this.saint2 = null;
      saint1.setGenero(Genero.MASCULINO);
      saint1.perderVida(50);
      //ACT
      this.lista.adicionar(saint1);
      this.lista.adicionar(saint2);
      String csv = lista.getCSV();
      //ASSERT
      assertEquals("Ikki,50.0,Fênix,BRONZE,VIVO,MASCULINO,false"+quebraLinha, csv);
  }
  @Test
  public void aoPegarCSVDaListaSaintsComDoisSaintsNulos() throws Exception{
      //ARRANGE
      this.lista = new ListaSaints();
      this.saint1 = null;
      this.saint2 = null;
      //ACT
      this.lista.adicionar(saint1);
      this.lista.adicionar(saint2);
      String csv = lista.getCSV();
      //ASSERT
      assertEquals("", csv);
  }
  @Test
  public void aoPegarCSVDaListaSaintsComSeisSaintsSendoTresNulos() throws Exception{
      //ARRANGE
      this.lista = new ListaSaints();
      this.saint1 = new BronzeSaint("Ikki", new Armadura(new Constelacao("Fênix"), Categoria.BRONZE));
      this.saint2 = new BronzeSaint("Seiya", new Armadura(new Constelacao("Pegasos"), Categoria.BRONZE));
      this.saint3 = new PrataSaint("Shaina", new Armadura(new Constelacao("Ofiúco"), Categoria.PRATA));
      this.saint4 = null;
      this.saint5 = null;
      this.saint6 = null;
      saint1.setGenero(Genero.MASCULINO);
      saint1.perderVida(50);
      saint2.perderVida(100);
      saint2.vestirArmadura();
      saint3.setGenero(Genero.FEMININO);
      saint3.perderVida(10);
      //ACT
      this.lista.adicionar(saint1);
      this.lista.adicionar(saint2);
      this.lista.adicionar(saint3);
      this.lista.adicionar(saint4);
      this.lista.adicionar(saint5);
      this.lista.adicionar(saint6);
      String csv = lista.getCSV();
      //ASSERT
      assertEquals("Ikki,50.0,Fênix,BRONZE,VIVO,MASCULINO,false"+quebraLinha+"Seiya,0.0,Pegasos,BRONZE,MORTO,NAO_INFORMADO,true"+quebraLinha+"Shaina,90.0,Ofiúco,PRATA,VIVO,FEMININO,false"+quebraLinha, csv);
  }
}
