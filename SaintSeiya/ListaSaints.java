import java.util.ArrayList;
import java.util.stream.Collectors;

public class ListaSaints{
    private ArrayList<Saint> lista = new ArrayList<Saint>();
    private final String quebraLinha = System.getProperty("line.separator");
    public ListaSaints(){}
    public void adicionar(Saint saint){
        this.lista.add(saint);
    }
    public void adicionar(ArrayList<Saint> listaSaint){
        this.lista.addAll(listaSaint);
    }
     /*Implementar para adicionar mais de um saint*/
    public void adicionarSaintViaCSV(String csv) throws Exception{ 
        //Formato: NomeSaint,Vida,Constelação,CategoriaDaArmadura,Status,Genero,Boolean armaduraVestida
        String[] saintCSV = csv.split(",");
        Categoria categoria;
        Genero genero;
        boolean armaduraVestida = saintCSV[6].equals("true");
        String nome;
        Armadura armadura;
        if(saintCSV[5].equals("FEMININO")){
            genero = Genero.FEMININO;
        }else if(saintCSV[5].equals("MASCULINO")){
            genero = Genero.MASCULINO;
        }else{
            genero = Genero.NAO_INFORMADO;
        }
        nome=saintCSV[0];
        Saint novoSaint;
        if(saintCSV[3].equals("BRONZE")){
            novoSaint = new BronzeSaint(nome,saintCSV[2]);
        }else if(saintCSV[3].equals("PRATA")){
            novoSaint = new PrataSaint(nome,saintCSV[2]);
        }else{
            novoSaint = new OuroSaint(nome,saintCSV[2]);
        }
        novoSaint.perderVida(100-Double.parseDouble(saintCSV[1]));
        if(armaduraVestida){
            novoSaint.vestirArmadura();
        }
        novoSaint.setGenero(genero);
        this.lista.add(novoSaint);
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
    public int getTamanho(){
        return this.lista.size();
    }
    public Saint buscarPorNome(String nome){
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
    public void ordenar(){ //Ordem Ascendente
        ordenar(TipoOrdenacao.ASCENDENTE);
    }
    //ORDENACAO POR PARAMETRO TIPOORDENACAO
    public void ordenar(TipoOrdenacao tipoOrdenacao){
        boolean descendente = tipoOrdenacao==TipoOrdenacao.DESCENDENTE,
                posicoesSendoTrocadas;
        do{
            posicoesSendoTrocadas=false;
            for(int i =0; i<this.lista.size()-1;i++){
                Saint atual = this.lista.get(i);
                Saint proximo = this.lista.get(i+1);
                boolean precisaTrocar =  
                    descendente ? atual.getVida() < proximo.getVida() 
                    :
                    atual.getVida() > proximo.getVida();
                if(precisaTrocar){
                   this.lista.set(i,proximo);
                   this.lista.set(i+1,atual);
                   posicoesSendoTrocadas=true;
                }       
            }
        }while(posicoesSendoTrocadas);
    }
    public ListaSaints unir(ListaSaints listaSaints){
        ListaSaints resultado = new ListaSaints();
        /*resultado.adicionar(this.lista);
         *resultado.adicionar(listaSaints.todos());
         */
        
        for(Saint saint : this.lista){
            resultado.adicionar(saint);
        }
        for(Saint saint : listaSaints.todos()){
            resultado.adicionar(saint);
        }
        
        return resultado;
    }
    public ListaSaints diff(ListaSaints listaSaints){
        ListaSaints retorno = new ListaSaints();
        /*
        ArrayList<Saint> arrayResultado = new ArrayList<Saint>();
        arrayResultado = this.lista;
        arrayResultado.removeAll(listaSaints.todos());
        retorno.adicionar(arrayResultado);
        */
        boolean saintsIguais;
        retorno.adicionar(this.lista);
        for(Saint saint : this.lista){
            for(Saint saint2 : listaSaints.todos()){
                saintsIguais = saint.equals(saint2);
                if(saintsIguais){
                    retorno.remover(saint2);
                }
            }
        }
        return retorno;
    }
    public ListaSaints intersec(ListaSaints listaSaints){
        ListaSaints retorno = new ListaSaints();
        /*
        ArrayList<Saint> arrayResultado = new ArrayList<Saint>();
        arrayResultado.retainAll(listaSaints.todos());
        retorno.adicionar(arrayResultado);
        */
        boolean saintsIguais;
        for(Saint saint : this.lista){
            for(Saint saint2 : listaSaints.todos()){
                saintsIguais = saint.equals(saint2);
                if(saintsIguais){
                    retorno.adicionar(saint);
                }
            }
        }
        return retorno;
    }
    public String getCSV(){
        String retorno;
        StringBuilder builder = new StringBuilder(512);
        if(this.lista.isEmpty()){
            return "";
        }
        builder.append(this.lista.get(0).getCSV());
        for(int i=1;i<this.lista.size();i++){
            builder.append(this.quebraLinha+this.lista.get(i).getCSV());
        }
        return builder.toString();
    }
}