import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GolpeDuploTest{
    private Saint saint1, saint2, saint3;
    private GolpeDuplo golpeDuplo1;
    private double vidaInicial1, vidaInicial2, vidaInicial3;
    @Test
    public void aoUsarGolpeDuploComSucessoDanoDuploOuSemSucessoDanoComumEPerdaDeVida() throws Exception{
        double objetivo1,objetivo2;
        boolean dentroDoEsperado = false;
        for(int i=0; i<100; i++){ //Repete o teste base 100 vezes para ter certeza de testar todos os casos da sorte
        //ARRANGE
        this.saint1 = new BronzeSaint("Ikki","Fênix"); 
        this.saint1.aprenderGolpe(new Golpe("Soco",5));

        this.saint2 = new PrataSaint("Dio","Mosca"); 

        this.vidaInicial1 = this.saint1.getVida();
        this.vidaInicial2 = this.saint2.getVida();

        this.golpeDuplo1 = new GolpeDuplo(this.saint1, this.saint2);
        //ACT
        this.golpeDuplo1.executar();
        
        //ASSERT
        if(golpeDuplo1.getSorte() == true){
            objetivo1 = vidaInicial2-10;
            objetivo2 = vidaInicial1;
        }else{ //golpeDuplo1.getSorte() == false
            double cincoPorCento= vidaInicial1*0.05;
            objetivo1 = vidaInicial2-5;
            objetivo2 = vidaInicial1-cincoPorCento;
        }
        if(objetivo1 == this.saint2.getVida() && objetivo2 == this.saint1.getVida()){
            dentroDoEsperado = true;
        }else{
            dentroDoEsperado = false;
            break;
        }
    }
        assertEquals(true,dentroDoEsperado);
    }
}
