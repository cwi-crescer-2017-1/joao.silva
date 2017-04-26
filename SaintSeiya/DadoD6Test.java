import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DadoD6Test{
    @Test
    public void aoSorteadorDadoD6MaiorNumero6EMenorNumero1(){
        Sorteador test = new DadoD6();
        boolean passouDosLimites = false;
        for(int i=0; i<100000; i++){
            int numeroSorteado=test.sortear();
            if(numeroSorteado<1 || numeroSorteado>6){
                passouDosLimites = true;
            }
        }
        assertEquals(false, passouDosLimites);
    }
}
