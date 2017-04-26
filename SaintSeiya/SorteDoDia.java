public class SorteDoDia{
    private Sorteador sorteador;
    public SorteDoDia(Sorteador sorteador){
        this.sorteador = sorteador;
    }
    public boolean getSorteDoDia(){
        return this.sorteador.sortear()%2==0;
    }
}
