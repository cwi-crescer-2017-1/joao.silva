public class ContraAtaque implements Movimento{
    private Saint golpeador, golpeado;
    private boolean dadoFalso = false;
    public void executar(){
        Sorteador sorte = new DadoD6();
        if(golpeado.getVida()<50 && golpeado.getArmaduraVestida() == false){
            boolean resultadoSortear = sorte.sortear() <=3;
            if(this.dadoFalso){
                golpeado.ativarContraAtaque();
                this.dadoFalso=false;
            }else if(resultadoSortear){
                golpeado.ativarContraAtaque();
            }
        }
    }
    public ContraAtaque(Saint golpeador, Saint golpeado){
        this.golpeador = golpeador;
        this.golpeado = golpeado;
    }
    public void usarDadoFalso(){
        this.dadoFalso=true;
    }
}
