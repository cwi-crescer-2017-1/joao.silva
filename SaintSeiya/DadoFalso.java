public class DadoFalso implements Sorteador{
    int sorteFalsa;
    public DadoFalso(int sorteFalsa){
        this.sorteFalsa = sorteFalsa;
    }
    public int sortear(){
        return sorteFalsa;
    }
}
