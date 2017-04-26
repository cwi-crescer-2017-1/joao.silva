import java.util.Random;
public class DadoD6 implements Sorteador{
    public int sortear(){
        final Random random = new Random();//random não poderá ser re-instanciado (new Random()). Porém seus valores são mutaveis
        final int min = 1, max=6;
        return random.nextInt(max-min+1)+min;
    }
}
