import java.util.ArrayList;
import java.util.stream.Collectors;

public class ListaSaints{
    private ArrayList<Saint> lista = new ArrayList<Saint>();
    private ArrayList<Saint> mortos = new ArrayList<Saint>();
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
    public void removerOsMortos(){
        ArrayList<Saint> seraoRemovidos = new ArrayList<Saint>();
        for(Saint saint : this.lista){
            if(saint.getStatus()==Status.MORTO){
                seraoRemovidos.add(saint);
            }
        }
        for(Saint saint : seraoRemovidos){
            this.mortos.add(saint);
            this.remover(saint);
        }
    }
    public ArrayList<Saint> getMortosRetirados(){
        return this.mortos;
    }
    public Saint getMortosPorIndice(int i){
        return this.mortos.get(i);
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
        hierarquica = tipoOrdenacao==TipoOrdenacao.HIERARQUICA,
        alternada = tipoOrdenacao==TipoOrdenacao.ALTERNADA,
        posicoesSendoTrocadas;
        if(alternada){
            ArrayList<Saint> arrayBronze = new ArrayList<Saint>();
            ArrayList<Saint> arrayPrata = new ArrayList<Saint>();
            ArrayList<Saint> arrayOuro = new ArrayList<Saint>();
            int proximoBronze = 0, proximoPrata=0, proximoOuro=0;
            int proximo= 1; //1->Bronze 2->Prata 3->Ouro
            for(Saint saint : this.lista){
                switch (saint.getCategoria()) {
                    case BRONZE:
                    arrayBronze.add(saint);
                    break;
                    case PRATA:
                    arrayPrata.add(saint);
                    break;
                    case OURO:
                    arrayOuro.add(saint);
                    break;
                }
            }
            for(int i=0; i<this.lista.size(); i++){
                System.out.println("Foi: "+i);
                if(proximo==1){
                    if(proximoBronze<arrayBronze.size()){
                        this.lista.set(i,arrayBronze.get(proximoBronze));
                        proximoBronze++;
                        proximo=2;
                        continue;
                    }else{
                        proximo=2;
                    }
                }
                if(proximo==2){
                    if(proximoPrata<arrayPrata.size()){
                        this.lista.set(i,arrayPrata.get(proximoPrata));
                        proximoPrata++;
                        proximo=3;
                        continue;
                    }else{
                        proximo=3;
                    }
                }
                if(proximo==3){
                    if(proximoOuro<arrayOuro.size()){
                        this.lista.set(i,arrayOuro.get(proximoOuro));
                        proximoOuro++;
                        proximo=1;
                        continue;
                    }else{
                        proximo=1;
                    }
                }
            }
        }else{
            do{
                posicoesSendoTrocadas=false;
                for(int i =0; i<this.lista.size()-1;i++){
                    Saint atual = this.lista.get(i);
                    Saint proximo = this.lista.get(i+1);
                    boolean precisaTrocar =  
                        descendente ? atual.getVida() < proximo.getVida()
                        :
                        hierarquica ? 
                            (atual.getCategoria() == Categoria.OURO && (proximo.getCategoria() == Categoria.PRATA || proximo.getCategoria() == Categoria.BRONZE))
                            || 
                            (atual.getCategoria()==Categoria.PRATA && proximo.getCategoria() == Categoria.BRONZE)
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
    }

    public ListaSaints unir(ListaSaints listaSaints){
        ListaSaints resultado = new ListaSaints();
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