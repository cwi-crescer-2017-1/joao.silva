

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SaintTest{
    @Test
    public void vestirArmaduraDeixaArmaduraVestida(){
        // AAA
        // Arrange - Montagem de dados de teste
        Armadura churrasqueira = new Armadura("Churrasqueira elétrica",Categoria.OURO);
        Saint marcolino = new Saint("Marcolino Pereira", churrasqueira);
        // Act - Invocar a ação a ser testada
        marcolino.vestirArmadura();
        // Assert - Verificar os resultados do teste
        boolean resultado = marcolino.getArmaduraVestida();
        assertEquals(true,resultado);
    }
    @Test
    public void naoVestirArmaduraDeixaArmaduraNaoVestida(){
        // Arrange
        Saint marcolino2 = new Saint("Marcolino Pereira", new Armadura("Churrasqueira elétrica",Categoria.BRONZE));
        // Act
        // Assert
        assertEquals(false,marcolino2.getArmaduraVestida());
    }
    @Test
    public void aoCriarSaintGeneroENaoInformado(){
        Saint shaka = new Saint("Shaka", new Armadura("Virgem", Categoria.OURO));
        assertEquals(Genero.NAO_INFORMADO,shaka.getGenero());
    }
    @Test
    public void AlterarSaintGenero(){
        Saint cara = new Saint("Cara", new Armadura("Alguma", Categoria.PRATA));
        cara.setGenero(Genero.FEMININO);
        assertEquals(Genero.FEMININO,cara.getGenero());
    }
    
}
