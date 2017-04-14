import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class SaintTest{
   //ARMADURA
   @Test
   public void vestirArmaduraDeixaArmaduraVestida(){
       //ARRANGE
       Saint marcolino = new Saint("Marcolino Pereira", new Armadura("Churrasqueira elétrica", Categoria.OURO));
       //ACT
       marcolino.vestirArmadura();
       //ASSERT
       assertEquals(true,marcolino.getArmaduraVestida());
    }
   @Test
   public void naoVestirArmaduraDeixaArmaduraNaoVestida(){
       //ARRANGE
       Saint irineu = new Saint("Irineu", new Armadura("Sabe de nada", Categoria.PRATA));
       //ACT -- teste de pré definição
       //ASSERT
       assertEquals(false,irineu.getArmaduraVestida());
   }
   //GENERO
   @Test
   public void aoCriarSaintGeneroENaoInformado(){
       //ARRANGE
       Saint shaka = new Saint("Shaka", new Armadura("Virgem", Categoria.OURO));
       //ACT -- teste de pré definição
       //ASSERT
       assertEquals(Genero.NAO_INFORMADO, shaka.getGenero());
   }
   @Test 
   public void alterarSaintGenero(){
       Saint seiya = new Saint("Seiya", new Armadura("Pegaso",Categoria.BRONZE));
       seiya.setGenero(Genero.MASCULINO);
       assertEquals(Genero.MASCULINO, seiya.getGenero());
   }
   //STATUS DE VIDA
   @Test
   public void aoCriarSaintStatusDeVidaEVivo(){
       //ARRANGE
       Saint yolo = new Saint("YOLO", new Armadura("Vida", Categoria.OURO));
       //ACT -- teste de pré definição
       //ASSERT
       assertEquals(StatusDeVida.VIVO, yolo.getStatusDeVida());
    }
   @Test
   public void alterarStatusDeVida(){
       //ARRANGE
       Saint yolodie = new Saint("YOLO", new Armadura("Vida", Categoria.OURO));
       //ACT
       yolodie.setStatusDeVida(StatusDeVida.MORTO);
       //ASSERT
       assertEquals(StatusDeVida.MORTO, yolodie.getStatusDeVida());
   }
   //VIDA
   @Test
   public void aoCriarSaintVidaIgualCem(){
       //ARRANGE
       Saint ikki = new Saint("Ikki", new Armadura("Fênix", Categoria.BRONZE));
       //ACT - teste de pré definição
       //ASSERT
       assertEquals(100.0, ikki.getVida(), 0);
   }
   @Test
   public void aoPerderVida(){
       //ARRANGE
       Saint aioros = new Saint("Aioros", new Armadura("Sagitário", Categoria.OURO));
       //ACT
       aioros.perderVida(100.0);
       //ASSERT
       assertEquals(0.0, aioros.getVida(), 0);
   }
    
}