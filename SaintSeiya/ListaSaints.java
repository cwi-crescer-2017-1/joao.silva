import java.util.ArrayList;
public class ListaSaints{
    private ArrayList<Saint> lista = new ArrayList<Saint>();
    public void adicionar(Saint saint){
        lista.add(saint);
    }
    public Saint get(int indice){
        return lista.get(indice);
    }
    public ArrayList<Saint> todos(){
        return lista;
    }
    public void remover(Saint saint){
        lista.remove(saint);
    }
    /*
    public Saint buscarPorNome(String nome){
        Saint retornar;
        for(int i=0;i<this.lista.size();i++){
           if(this.lista.get(i).getNome().equals(nome)){
                retornar = this.lista.get(i);
           }
        }
        return retornar;
    }
    */
}