import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

public class ListaSaintsTest{
    private Saint saint1, saint2, saint3,saint4,saint5,saint6;
    private ListaSaints lista;
    private ArrayList<Saint> listDeSaints;
  //ADICIONAR && GET
  @Test
  public void aoAdicionarUmSaintAListaRetornaGetOSaintCorreto() throws Exception{
       //ARRANGE
       this.lista = new ListaSaints();
       this.saint1 = new BronzeSaint("Ikki", new Armadura(new Constelacao("Fênix"), Categoria.BRONZE));
       //ACT
       this.lista.adicionar(this.saint1);
       //ASSERT
       assertEquals(this.saint1,this.lista.get(0));
  }
  @Test
  public void aoAdicionarTresSaintsAListaRetornaGetOsSaintsCorretos() throws Exception{
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
       assertEquals(this.saint1,this.lista.get(0));
       assertEquals(this.saint2,this.lista.get(1));
       assertEquals(this.saint3,this.lista.get(2));
  }
  //TODOS
  @Test
  public void aoRetornarTodos()throws Exception{
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
      assertEquals(this.saint1,this.lista.todos().get(0));
      assertEquals(this.saint2,this.lista.todos().get(1));
      assertEquals(this.saint3,this.lista.todos().get(2));
  }
  //REMOVER
  @Test
  public void aoRemoverUmSaint() throws Exception{
      //ARRANGE
      this.lista = new ListaSaints();
      this.saint1 = new BronzeSaint("Ikki", new Armadura(new Constelacao("Fênix"), Categoria.BRONZE));
      this.saint2 = new PrataSaint("Dio", new Armadura(new Constelacao("Mosca"), Categoria.PRATA));
      this.saint3 = new OuroSaint("Mu", new Armadura(new Constelacao("Áries"), Categoria.OURO));
      //ACT
      lista.adicionar(this.saint1);
      lista.adicionar(this.saint2);
      lista.adicionar(this.saint3);
      lista.remover(this.saint2);
      //ASSERT
      assertEquals(2,this.lista.todos().size());
      assertNull(this.lista.buscarPorNome("Dio"));
  }
  //BUSCA POR NOME
  @Test
  public void aoBuscarPorNome() throws Exception{
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
  //BUSCA POR CATEGORIA
  @Test
  public void aoBuscarPorCategoria() throws Exception{
      //ARRANGE
      this.lista = new ListaSaints();
      this.saint1 = new BronzeSaint("Ikki", new Armadura(new Constelacao("Fênix"), Categoria.BRONZE));
      this.saint2 = new BronzeSaint("Seiya", new Armadura(new Constelacao("Pegasos"), Categoria.BRONZE));
      this.saint3 = new OuroSaint("Shaka", new Armadura(new Constelacao("Virgem"), Categoria.OURO));
      this.saint4 = new PrataSaint("Dio", new Armadura(new Constelacao("Mosca"), Categoria.PRATA));
      this.saint5 = new OuroSaint("Mu", new Armadura(new Constelacao("Áries"), Categoria.OURO));
      this.saint6 = new PrataSaint("Argor", new Armadura(new Constelacao("Perseu"), Categoria.PRATA));
      //ACT
      this.lista.adicionar(this.saint1);
      this.lista.adicionar(this.saint2);
      this.lista.adicionar(this.saint3);
      this.lista.adicionar(this.saint4);
      this.lista.adicionar(this.saint5);
      this.lista.adicionar(this.saint6);
      this.listDeSaints = this.lista.buscarPorCategoria(Categoria.PRATA);
      //ASSERT
      assertEquals(this.saint4,this.listDeSaints.get(0));
      assertEquals(this.saint6,this.listDeSaints.get(1));
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
  //GET SAINT COM MAIOR VIDA
  @Test
  public void aoBuscarSaintComMaiorVidaEComMenorVida() throws Exception{
      //ARRANGE
      this.lista = new ListaSaints();
      this.saint1 = new BronzeSaint("Ikki", new Armadura(new Constelacao("Fênix"), Categoria.BRONZE));//Inicializa com 100 de vida
      this.saint2 = new BronzeSaint("Seiya", new Armadura(new Constelacao("Pegasos"), Categoria.BRONZE));
      this.saint3 = new BronzeSaint("Shaka", new Armadura(new Constelacao("Virgem"), Categoria.BRONZE));
      this.saint4 = new PrataSaint("Dio", new Armadura(new Constelacao("Mosca"), Categoria.PRATA));
      this.saint5 = new OuroSaint("Mu", new Armadura(new Constelacao("Áries"), Categoria.OURO));
      this.saint6 = new PrataSaint("Argor", new Armadura(new Constelacao("Perseu"), Categoria.PRATA));
      //ACT
      this.saint1.perderVida(10);//Maior
      this.saint2.perderVida(30);
      this.saint3.perderVida(100);//Menor
      this.saint4.perderVida(60);
      this.saint5.perderVida(40);
      this.saint6.perderVida(90);
      this.lista.adicionar(this.saint1);
      this.lista.adicionar(this.saint2);
      this.lista.adicionar(this.saint3);
      this.lista.adicionar(this.saint4);
      this.lista.adicionar(this.saint5);
      this.lista.adicionar(this.saint6);
      //ASSERT
      assertEquals(this.saint1,this.lista.getSaintMaiorVida());
      assertEquals(this.saint3,this.lista.getSaintMenorVida());
  }
  //ORDENAR por vida(Ordem ascendente)
  @Test
  public void aoOrdenar() throws Exception{
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
  }
}
