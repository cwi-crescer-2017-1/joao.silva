public class ExercitoQueAtacaEmOrdemHierarquica implements ExercitoDeSaints{
    ListaSaints exercitoHierarquico = new ListaSaints();
    int proximoSaint=0;
    public void alistar(Saint saint){
        this.exercitoHierarquico.adicionar(saint);
        this.exercitoHierarquico.ordenar(TipoOrdenacao.HIERARQUICA);
    }

    public Saint getProximoSaintDoExercito(){
        int proximo;
        if(this.proximoSaint<this.exercitoHierarquico.getTamanho() && this.exercitoHierarquico.get(this.proximoSaint).getStatus() == Status.VIVO){
            proximo = this.proximoSaint;
            this.proximoSaint++;
            return this.exercitoHierarquico.get(proximo);
        }else if(this.exercitoHierarquico.getTamanho()>0){
            this.exercitoHierarquico.removerOsMortos();
            this.exercitoHierarquico.ordenar(TipoOrdenacao.HIERARQUICA);
            this.proximoSaint = 0;
            proximo = this.proximoSaint;
            if(this.exercitoHierarquico.getTamanho()>0){
                return this.exercitoHierarquico.get(proximo);
            }else{
                return null;
            }
        }else{
            return null;
        }
    }

    public void zerarProximoSaint(){
        this.proximoSaint = 0;
    }

    public int getTamanho(){
        return this.exercitoHierarquico.getTamanho();
    }
}