import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SorteDoDiaTest{
    /*Testes arriscados, envolvem muita probabilidade - mas sao legais porque brincam a probabilidade
    @Test
    public void sorteDoDiaPodeSerTrueOuFalse(){
        SorteDoDia sorteDoDia = new SorteDoDia(new DadoD6());
        boolean deuTrue = false;
        boolean deuFalse = false;
        for(int i=0; i<100000; i++){
            boolean tiveSorte = sorteDoDia.getSorteDoDia();
            if(tiveSorte==true){
                deuTrue = true;
            }else if(tiveSorte==false){
                deuFalse = true;
            }
        }
        assertEquals(true, deuTrue);
        assertEquals(true, deuFalse);
    }
    @Test
    public void sorteDoDiaPossuiAproximadamente50PorcentoDeChanceDeSerTrueEDeSerFalse(){
        SorteDoDia sorteDoDia = new SorteDoDia(new DadoD6());
        boolean verificacao = false;
        for(int o=0; o<100; o++){
            int qtdTrue=0;
            boolean tiveSorte = false;
            //1000000000
            for(int i=0; i<100000; i++){
                 tiveSorte = sorteDoDia.getSorteDoDia();
                if(tiveSorte==true){
                    qtdTrue++;
                }
            }
            if(qtdTrue>49500&&qtdTrue<50500){
                 verificacao = true;
            }else{
                verificacao=false;
                break;
            }
        }
        assertEquals(true, verificacao);
    }
    */
    @Test
    public void sorteDoDiaETrueQuandoSorteadorEPar(){
        SorteDoDia sorteDoDia = new SorteDoDia(new DadoFalso(2));
        boolean tiveSorte = false;
        tiveSorte = sorteDoDia.getSorteDoDia();
        assertEquals(true, tiveSorte);
    }
    @Test
    public void sorteDoDiaEFalseQuandoSorteadorEImpar(){
        SorteDoDia sorteDoDia = new SorteDoDia(new DadoFalso(1));
        boolean tiveSorte = true;
        tiveSorte = sorteDoDia.getSorteDoDia();
        assertEquals(false, tiveSorte);
    }
    
}