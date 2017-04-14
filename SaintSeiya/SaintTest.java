import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class SaintTest{
   private Saint allMight;
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
   }
   //STATUS DE VIDA
   @Test
   public void aoCriarSaintStatusDeVidaEVivo(){
       //ARRANGE
       allMight = new Saint("YOLO", new Armadura("Vida", Categoria.OURO));
       //ACT -- teste de pré definição
       //ASSERT
       assertEquals(StatusDeVida.VIVO, allMight.getStatusDeVida());
    }
   @Test
   public void alterarStatusDeVida(){
       //ARRANGE
       allMight = new Saint("Marcolino Pereira", new Armadura("Churrasqueira elétrica", Categoria.OURO));
       //ACT
       allMight.setStatusDeVida(StatusDeVida.MORTO);
       //ASSERT
       assertEquals(StatusDeVida.MORTO, allMight.getStatusDeVida());
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
   public void aoPerderVida(){
       //ARRANGE
       allMight = new Saint("Aioros", new Armadura("Sagitário", Categoria.OURO));
       //ACT
       allMight.perderVida(100.0);
       //ASSERT
       assertEquals(0.0, allMight.getVida(), 0);
   }
    
}