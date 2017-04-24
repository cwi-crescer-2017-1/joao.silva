public class Batalha{
    private Saint lutadorUm, lutadorDois ;
    public Batalha(Saint lutadorUm, Saint lutadorDois){
        this.lutadorUm = lutadorUm;
        this.lutadorDois = lutadorDois;
    }
    public void iniciar() throws Exception{
      int valorCategoria1= this.lutadorUm.getArmadura().getCategoria().getValor();
      int valorCategoria2= this.lutadorDois.getArmadura().getCategoria().getValor();
      Saint[] golpeador = new Saint[2];
      boolean aindaEstaoVivos;
      int turno = 0;// - Irá variar entre 0 e 1 no calculo turno%2
      int proximoTurno = 1;
      if(valorCategoria2>valorCategoria1){ //Se a Categoria do lutador 2 for maior que a do 1 o lutador 2 inicia golpeando
          golpeador[0]=lutadorDois; //LutadorDois golpeia primeiro
          golpeador[1]=lutadorUm;
      }else{ //Caso a categoria seja a mesma ou a do lutador 1 for maior o lutador1 inicia golpeando
          golpeador[0]=lutadorUm; // LutadorUm golpeia primeiro
          golpeador[1]=lutadorDois;
      }
      if(golpeador[0].getMovimentos().isEmpty()){ //Caso não possua movimentos
          golpeador[0].adicionarMovimento(new Nada()); //Ganha um movimento de fazer nada
      }
      if(golpeador[1].getMovimentos().isEmpty()){ //Caso não possua movimentos
          golpeador[1].adicionarMovimento(new Nada()); //Ganha um movimento de fazer nada
      }
      do{
          golpeador[turno%2].getProximoMovimento().executar();
          aindaEstaoVivos = golpeador[proximoTurno%2].getStatus() == Status.VIVO;
          turno=proximoTurno;
          proximoTurno++;
      }while(aindaEstaoVivos && turno<1000);//A luta está virando a Guerra dos mil dias = empate
    }
    
}