import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CategoriaTest{
   @Test
   public void categoriaRetornaOValorCorreto(){
       //ARRANGE, ACT, ASSERT -- teste de pré-definição
       assertEquals(3,Categoria.OURO.getValor());
       assertEquals(2,Categoria.PRATA.getValor());
       assertEquals(1,Categoria.BRONZE.getValor());
    }
    
}
