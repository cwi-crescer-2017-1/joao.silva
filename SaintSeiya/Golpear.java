public class Golpear implements Movimento{
    private Saint golpeador,golpeado;
    private int dano = 0;
    public void executar(){
       if(this.golpeador!=null){ //Só inicia se houver um golpeador
           Golpe proximoGolpe = this.golpeador.getProximoGolpe();
           if(proximoGolpe!=null){ //Só valida o dano se existir um proximoGolpe
               this.dano = proximoGolpe.getFatorDano();
               boolean armaduraVestida = this.golpeador.getArmaduraVestida();
               if(armaduraVestida){
                   this.dano = dano * (1+golpeador.getArmadura().getCategoria().getValor()); 
                   //O dano bruto do golpe é multiplicado por: 1 + Valor da Categoria da Armadura caso a armadura esteja vestida
               }
           }
       }
       if(golpeado!=null){ //Caso o golpeado não exista o golpe não é realizado mas tem seu dano salvo
           if(golpeado.getContraAtaque()){ //Ativou o ContraAtaque do Golpeado
                GolpeSimples golpe = new GolpeSimples(golpeado,golpeador); //O golpeado passa a ser o golpeador e o golpeador o golpeado
                golpe.executar();
                golpeado.desativarContraAtaque();
           }else{
              this.golpeado.perderVida(dano);
           }
       }
    }
    public Golpear(Saint golpeador, Saint golpeado){
        this.golpeador = golpeador;
        this.golpeado = golpeado;
    }
    public int getDano(){
        return this.dano;
    }
}
