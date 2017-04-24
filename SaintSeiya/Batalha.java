public class Batalha{
    private Saint lutadorUm, lutadorDois ;
    public Batalha(Saint lutadorUm, Saint lutadorDois){
        this.lutadorUm = lutadorUm;
        this.lutadorDois = lutadorDois;
    }
    public void iniciar() throws Exception{
      int valorCategoria1= this.lutadorUm.getArmadura().getCategoria().getValor();
      int valorCategoria2= this.lutadorDois.getArmadura().getCategoria().getValor();
      boolean aindaEstaoVivos;
      boolean lutadorUmSemMovimentos= lutadorUm.getMovimentos().size()==0;
      boolean lutadorDoisSemMovimentos = lutadorDois.getMovimentos().size()==0;
      Saint golpeadorDoTurno;
      int dano=0;
      
      //Verificação de movimento existente
      if(lutadorUmSemMovimentos && lutadorDoisSemMovimentos){
          return; //Ambos lutadores não possuem movimentos
      }
      //Seleciona o primeiro golpeador por categoria, APENAS quando este possui movimentos
      if(valorCategoria2>valorCategoria1 && lutadorDoisSemMovimentos==false){ 
          //Se a Categoria do lutador 2 for maior que a do 1 o lutador 2 inicia golpeando
          golpeadorDoTurno=lutadorDois; //LutadorDois golpeia primeiro
      }else if(valorCategoria1>=valorCategoria2 && lutadorUmSemMovimentos==false){ 
          //Caso a categoria seja a mesma ou a do lutador 1 for maior o lutador1 inicia golpeando
          golpeadorDoTurno=lutadorUm; // LutadorUm golpeia primeiro
      }else{//Caso lutadorUm possua a categoria maior mas lutadorUm não possua movimentos
          golpeadorDoTurno=lutadorDois;
      }
      //Verificação de dano existente
      for(int i=0;i<lutadorUm.getGolpes().size();i++){
         dano=lutadorUm.getProximoGolpe().getFatorDano()+dano;
      }
      for(int i=0;i<lutadorDois.getGolpes().size();i++){
         dano=lutadorDois.getProximoGolpe().getFatorDano()+dano;
      }
      if(dano==0){
          return; //Lutadores não possuem dano
      }
      //Realização da troca de golpes
      do{
          golpeadorDoTurno.getProximoMovimento().executar();
          aindaEstaoVivos=lutadorUm.getStatus() == Status.VIVO && lutadorDois.getStatus() == Status.VIVO;
          //Só trocará o golpeadorDoTurno se o próximo possuir um movimento
          if(golpeadorDoTurno==lutadorUm && lutadorDoisSemMovimentos==false){
              golpeadorDoTurno=lutadorDois;
            }else if(golpeadorDoTurno==lutadorDois && lutadorUmSemMovimentos==false){
                golpeadorDoTurno=lutadorUm;
            }
      }while(aindaEstaoVivos);
      /* Código antigo, antes da simplificação e de outras melhoras
      Saint[] golpeador = new Saint[2];
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
      }while(aindaEstaoVivos && turno<1000);//A luta está virando a Guerra dos mil dias = empate*/
    }
    
}