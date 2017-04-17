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
       //ACT -- teste de pré definição
       //ASSERT
       assertEquals(false,allMight.getArmaduraVestida());
   }
   //GENERO
   @Test
   public void aoCriarSaintGeneroENaoInformado(){
       //ARRANGE
       allMight = new Saint("Shaka", new Armadura("Virgem", Categoria.OURO));
       //ACT -- teste de pré definição
       //ASSERT
       assertEquals(Genero.NAO_INFORMADO, allMight.getGenero());
   }
   @Test 
   public void alterarSaintGenero(){
       allMight = new Saint("Seiya", new Armadura("Pegaso",Categoria.BRONZE));
       allMight.setGenero(Genero.MASCULINO);
       assertEquals(Genero.MASCULINO, allMight.getGenero());
       allMight.setGenero(Genero.FEMININO);
       assertEquals(Genero.FEMININO, allMight.getGenero());
   }
   //STATUS DE VIDA
   @Test
   public void aoCriarSaintStatusDeVidaEVivo(){
       //ARRANGE
       allMight = new Saint("YOLO", new Armadura("Vida", Categoria.OURO));
       //ACT -- teste de pré definição
       //ASSERT
       assertEquals(Status.VIVO, allMight.getStatus());
    }
   //VIDA
   @Test
   public void aoCriarSaintVidaIgualCem(){
       //ARRANGE
       allMight = new Saint("Monstro", new Armadura("Whey", Categoria.BRONZE));
       //ACT - teste de pré definição
       //ASSERT
       assertEquals(100.0, allMight.getVida(), 0);
   }
   @Test
   public void aoPerderCemDeVida(){
       //ARRANGE
       allMight = new Saint("Aioros", new Armadura("Sagitário", Categoria.OURO));
       //ACT
       vidaAnterior=allMight.getVida();
       allMight.perderVida(100.0);
       //ASSERT
       assertEquals(vidaAnterior-100.0, allMight.getVida(), 0);
   }
   @Test
   public void aoPerderDuzendoDeVida(){ //Atributo vida sem contenção para limitar número minimo de vida a zero
       //ARRANGE
       allMight = new Saint("Aioros", new Armadura("Sagitário", Categoria.OURO));
       //ACT
       vidaAnterior=allMight.getVida();
       allMight.perderVida(200.0);
       //ASSERT
       assertEquals(vidaAnterior-200.0, allMight.getVida(), 0);
   }
   @Test
   public void aoPerderNumeroQuebradoDeVida(){
       //ARRANGE
       allMight = new Saint("Aioros", new Armadura("Sagitário", Categoria.OURO));
       //ACT
       vidaAnterior=allMight.getVida();
       allMight.perderVida(3.141592);
       //ASSERT
       assertEquals(vidaAnterior-3.141592, allMight.getVida(), 0);
   }
   @Test
   public void aoPerderNumeroNegativoDeVida(){
       //ARRANGE
       allMight = new Saint("Aioros", new Armadura("Sagitário", Categoria.OURO));
       //ACT
       vidaAnterior=allMight.getVida();
       allMight.perderVida(-100.0);
       //ASSERT
       assertEquals(vidaAnterior+100.0, allMight.getVida(), 0);
   }
    
}