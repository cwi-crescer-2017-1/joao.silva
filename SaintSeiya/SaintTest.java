import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class SaintTest{
   private Saint allMight;
   private double vidaAnterior;
   //Número de testes: 10
   //ARMADURA
   @Test
   public void vestirArmaduraDeixaArmaduraVestida(){
       //ARRANGE
       allMight = new Saint("Ikki", new Armadura("Fênix", Categoria.BRONZE));
       //ACT
       allMight.vestirArmadura();
       //ASSERT
       assertEquals(true,allMight.getArmaduraVestida());
    }
   @Test
   public void naoVestirArmaduraDeixaArmaduraNaoVestida(){
       //ARRANGE
       allMight = new Saint("Irineu", new Armadura("Sabe de nada", Categoria.PRATA));
       //ACT - TESTE DE PRÉ DEFINIÇÃO
       //ASSERT
       assertEquals(false,allMight.getArmaduraVestida());
   }
   //GENERO
   @Test
   public void aoCriarSaintGeneroENaoInformado(){
       //ARRANGE
       allMight = new Saint("Shaka", new Armadura("Virgem", Categoria.OURO));
       //ACT - TESTE DE PRÉ DEFINIÇÃO
       //ASSERT
       assertEquals(Genero.NAO_INFORMADO, allMight.getGenero());
   }
   @Test 
   public void alterarSaintGenero(){
       //ARRANGE
       allMight = new Saint("Seiya", new Armadura("Pegaso",Categoria.BRONZE));
       //ACT
       allMight.setGenero(Genero.MASCULINO);
       //ASSERT
       assertEquals(Genero.MASCULINO, allMight.getGenero());
       //ACT
       allMight.setGenero(Genero.FEMININO);
       //ASSERT
       assertEquals(Genero.FEMININO, allMight.getGenero());
   }
   //STATUS //Dica de nome para o método: statusInicialDeveSerVivo, achei mais explicativo 
   @Test
   public void aoCriarSaintStatusDeVidaEVivo(){
       //ARRANGE
       allMight = new Saint("YOLO", new Armadura("Vida", Categoria.OURO));
       //ACT - TESTE DE PRÉ DEFINIÇÃO
       //ASSERT
       assertEquals(Status.VIVO, allMight.getStatus());
    }
   //VIDA
   @Test
   public void aoCriarSaintVidaIgualCem(){ //aVidaInicialDeveSer100 -> Dica de outro nome para o teste
       //ARRANGE
       allMight = new Saint("Monstro", new Armadura("Whey", Categoria.BRONZE));
       //ACT - TESTE DE PRÉ DEFINIÇÃO
       //ASSERT
       assertEquals(100.0, allMight.getVida(), 0.01);
   }
   //aoPerderVida
   @Test
   public void aoPerderVinteDeVida(){
       //ARRANGE
       allMight = new Saint("Aioros", new Armadura("Sagitário", Categoria.OURO));
       //ACT
       vidaAnterior=allMight.getVida();
       allMight.perderVida(20.0);
       //ASSERT
       assertEquals(vidaAnterior-20.0, allMight.getVida(), 0.01);
   }
   @Test
   public void aoPerderDuzendoDeVida(){ //Atributo vida sem contenção para limitar número minimo de vida a zero, ajustar caso seja criada uma conteção
       //ARRANGE
       allMight = new Saint("Aioros", new Armadura("Sagitário", Categoria.OURO));
       //ACT
       vidaAnterior=allMight.getVida();
       allMight.perderVida(200.0);
       //ASSERT
       assertEquals(vidaAnterior-200.0, allMight.getVida(), 0.01);
   }
   @Test
   public void aoPerderNumeroQuebradoDeVida(){
       //ARRANGE
       allMight = new Saint("Aioros", new Armadura("Sagitário", Categoria.OURO));
       //ACT
       vidaAnterior=allMight.getVida();
       allMight.perderVida(3.141592);
       //ASSERT
       assertEquals(vidaAnterior-3.141592, allMight.getVida(), 0.01);
   }
   @Test
   public void aoPerderNumeroNegativoDeVida(){ //Teste deve ser removido caso se evite números negativos no método PerderVida()
       //ARRANGE
       allMight = new Saint("Aioros", new Armadura("Sagitário", Categoria.OURO));
       //ACT
       vidaAnterior=allMight.getVida();
       allMight.perderVida(-100.0);
       //ASSERT
       assertEquals(vidaAnterior+100.0, allMight.getVida(), 0.01);
   }
   //SENTIDOS
   @Test
   public void aoCriarSaintNasceCom5SentidosDespertados(){
       //ARRANGE
       allMight = new Saint("Aioros", new Armadura("Sagitário", Categoria.OURO));
       //ACT - TESTE DE PRÉ DEFINIÇÃO
       //ASSERT
       assertEquals(5, allMight.getQtSentidosDespertados());
   }
    
}