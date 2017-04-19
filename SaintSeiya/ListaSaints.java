import java.util.ArrayList;
import java.util.stream.Collectors;

public class ListaSaints{
    private ArrayList<Saint> lista = new ArrayList<Saint>();;
    public ListaSaints(){}
    public void adicionar(Saint saint){
        this.lista.add(saint);
    }
    public Saint get(int indice){
        return this.lista.get(indice);
    }
    public ArrayList<Saint> todos(){
        return this.lista;
    }
    public void remover(Saint saint){
        this.lista.remove(saint);
    }
 	
    public Saint buscarPorNome(String nome){
		/*
		for(Saint saint : this.lista){
			if(saint.getNome().equals(nome)){
				return saint;
			}
		}
		return null;
		*///Método alternativo (válido em java 8 +)
		return this.lista.stream()
			.filter(s -> s.getNome().equals(nome))
			.findFirst()
			.orElse(null);
    }
    public ArrayList<Saint> buscarPorCategoria(Categoria categoria){
     	return (ArrayList<Saint>)this.lista.stream()
		   .filter(s -> s.getArmadura().getCategoria()==categoria)
           .collect(Collectors.toList());
		
    }
    public ArrayList<Saint> buscarPorStatus(Status status){
        ArrayList<Saint> retorno = new ArrayList<Saint>();
        for(Saint saint : lista){
            if(saint.getStatus() == status){
                retorno.add(saint);
            }
        }
        return retorno;
    }
    public Saint getSaintMaiorVida(){
        Saint saintMaiorVida=null;
        double maior = 0;
        for(Saint saint : lista){
            if(saint.getVida() > maior){
                saintMaiorVida = saint;
                maior=saint.getVida();
            }
        }
        return saintMaiorVida;
    }
    public Saint getSaintMenorVida(){
        Saint saintMenorVida=null;
        double menor = 999999999;
        for(Saint saint : lista){
            if(saint.getVida() < menor){
                saintMenorVida = saint;
                menor = saint.getVida();
            }
        }
        return saintMenorVida;
    }
    public void ordenar(){
        double menor;
        for(int x=0;x<this.lista.size();x++){ 
            Saint saintTemp = null;
            menor = 999999999;
            for(int i=x;i<this.lista.size();i++){
                if(this.get(i).getVida() < menor){
                    menor=this.lista.get(i).getVida();
                    saintTemp=this.get(x);
                    lista.set(x,this.get(i));
                    lista.set(i,saintTemp);
                }
            }
        }
    }
}