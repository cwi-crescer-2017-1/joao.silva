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
      //Seleciona o primeiro golpeador por categoria
      if(valorCategoria2>valorCategoria1){ 
          //Se a Categoria do lutador 2 for maior que a do 1 o lutador 2 inicia golpeando
          golpeadorDoTurno=lutadorDois; //LutadorDois golpeia primeiro
      }else{ //Caso a categoria seja a mesma ou a do lutador 1 for maior o lutador1 inicia golpeando
          golpeadorDoTurno=lutadorUm; // LutadorUm golpeia primeiro
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
          if(golpeadorDoTurno.getProximoMovimento() != null){
              golpeadorDoTurno.getProximoMovimento().executar();
          }
          aindaEstaoVivos=lutadorUm.getStatus() == Status.VIVO && lutadorDois.getStatus() == Status.VIVO;
          //Só trocará o golpeadorDoTurno se o próximo possuir um movimento
          if(golpeadorDoTurno==lutadorUm){
              golpeadorDoTurno=lutadorDois;
            }else{ //golpeadorDoTurno==lutadorDois
                golpeadorDoTurno=lutadorUm;
            }
      }while(aindaEstaoVivos);
    }
}