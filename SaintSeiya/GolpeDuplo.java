public class GolpeDuplo implements Movimento{
    private Saint golpeador,golpeado;
    private int dano = 0;
    private boolean sorte;
    public void executar(){
        if(this.golpeador!=null){ //Só inicia se houver um golpeador
            DadoD6 dado = new DadoD6();
            double vidaDoGolpeador;
            double tiroPelaCulatra;
            this.sorte=dado.sortear()<=2; // dado pode ser 1,2,3,4,5,6 - mas para a sorte ele deve ser 1 ou 2 (33,3% das possibilidades)
            Golpe proximoGolpe = this.golpeador.getProximoGolpe();
            if(proximoGolpe!=null){ //Só valida o dano se existir um proximoGolpe
                this.dano = proximoGolpe.getFatorDano();
                boolean armaduraVestida = this.golpeador.getArmaduraVestida();
                if(armaduraVestida){
                    this.dano = dano * (1+golpeador.getArmadura().getCategoria().getValor()); 
                    //O dano bruto do golpe é multiplicado por: 1 + Valor da Categoria da Armadura caso a armadura esteja vestida
                }
            }
            if(sorte){
                if(golpeado!=null){ //Caso o golpeado não exista o golpe não é realizado mas tem seu dano salvo
                    this.golpeado.perderVida(dano*2);//DANO DUPLO
                }
            }else{ //Não teve sorte :(
                if(golpeado!=null){
                    this.golpeado.perderVida(dano);
                }
                vidaDoGolpeador = golpeador.getVida();
                tiroPelaCulatra = vidaDoGolpeador*0.05; //5% da vida do Golpeador
                this.golpeador.perderVida(tiroPelaCulatra);
            }
        }
    }

    public GolpeDuplo(Saint golpeador, Saint golpeado){
        this.golpeador = golpeador;
        this.golpeado = golpeado;
    }

    public int getDano(){
        return this.dano;
    }
    public boolean getSorte(){
        return this.sorte;
    }
}
