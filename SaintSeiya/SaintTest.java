

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class SaintTest{
   @Test
   public void vestirArmaduraDeixaArmaduraVestida(){
       //ARRANGE
       Armadura churrasqueira = new Armadura("Churrasqueira elétrica", Categoria.OURO);
       Saint marcolino = new Saint("Marcolino Pereira", churrasqueira);
       //ACT
       marcolino.vestirArmadura();
       //ASSERT
       assertEquals(true,marcolino.getArmaduraVestida());
    }
   @Test
   public void naoVestirArmaduraDeixaArmaduraNaoVestida(){
       //ARRANGE
       Saint irineu = new Saint("Irineu", new Armadura("Sabe de nada", Categoria.PRATA));
       //ACT -- não realizar nada
       //ASSERT
       assertEquals(false,irineu.getArmaduraVestida());
   }
   @Test
   public void aoCriarSaintGeneroENaoInformado(){
       //ARRANGE
       Saint shaka = new Saint("Shaka", new Armadura("Virgem", Categoria.OURO));
       //ASSERT
       assertEquals(Genero.NAO_INFORMADO, shaka.getGenero());
   }
   @Test 
   public void alterarSaintGenero(){
       Saint seiya = new Saint("Seiya", new Armadura("Pegaso",Categoria.BRONZE));
       seiya.setGenero(Genero.MASCULINO);
       assertEquals(Genero.MASCULINO, seiya.getGenero());
   }
}