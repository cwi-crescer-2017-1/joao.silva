public class ExercitoQueAtacaEmOrdemAlternada implements ExercitoDeSaints{
    ListaSaints exercitoAlternado = new ListaSaints();
    int proximoSaint=0;
    public void alistar(Saint saint){
        this.exercitoAlternado.adicionar(saint);
        this.exercitoAlternado.ordenar(TipoOrdenacao.ALTERNADA);
    }

    public Saint getProximoSaintDoExercito(){
        int proximo;
        if(this.proximoSaint<this.exercitoAlternado.getTamanho() && this.exercitoAlternado.get(this.proximoSaint).getStatus() == Status.VIVO){
            proximo = this.proximoSaint;
            this.proximoSaint++;
            return this.exercitoAlternado.get(proximo);
        }else if(this.exercitoAlternado.getTamanho()>0){
            this.exercitoAlternado.removerOsMortos();
            this.exercitoAlternado.ordenar(TipoOrdenacao.ALTERNADA);
            this.proximoSaint = 0;
            proximo = this.proximoSaint;
            if(this.exercitoAlternado.getTamanho()>0){
                return this.exercitoAlternado.get(proximo);
            }else{
                return null;
            }
        }else{
            return null; //Caso não haja mais Saints
        }
    }

    public void zerarProximoSaint(){
        this.proximoSaint = 0;
    }

    public int getTamanho(){
        return this.exercitoAlternado.getTamanho();
    }
}
