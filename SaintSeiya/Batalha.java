public class Batalha{
    private Saint lutadorUm, lutadorDois ;
    public Batalha(Saint lutadorUm, Saint lutadorDois){
        this.lutadorUm = lutadorUm;
        this.lutadorDois = lutadorDois;
    }
    public void iniciar() throws Exception{
      int valorCategoria1= this.lutadorUm.getArmadura().getCategoria().getValor();
      int valorCategoria2= this.lutadorDois.getArmadura().getCategoria().getValor();
      boolean aindaEstaoVivos = this.lutadorUm.getStatus() == Status.VIVO && this.lutadorDois.getStatus() == Status.VIVO;
      boolean lutadorUmSemMovimentos= this.lutadorUm.getMovimentos().size()==0;
      boolean lutadorDoisSemMovimentos = this.lutadorDois.getMovimentos().size()==0;
      Saint golpeadorDoTurno;
      int dano=0;
      
      //Verificação de movimento existente
      if(lutadorUmSemMovimentos && lutadorDoisSemMovimentos){
          return; //Ambos lutadores não possuem movimentos
      }
      //Seleciona o primeiro golpeador por categoria
      if(valorCategoria2>valorCategoria1){ 
          //Se a Categoria do lutador 2 for maior que a do 1 o lutador 2 inicia golpeando
          golpeadorDoTurno=this.lutadorDois; //LutadorDois golpeia primeiro
      }else{ //Caso a categoria seja a mesma ou a do lutador 1 for maior o lutador1 inicia golpeando
          golpeadorDoTurno=this.lutadorUm; // LutadorUm golpeia primeiro
      }
      //Verificação de dano existente
      for(int i=0;i<this.lutadorUm.getGolpes().size();i++){
         dano=this.lutadorUm.getProximoGolpe().getFatorDano()+dano;
      }
      for(int i=0;i<this.lutadorDois.getGolpes().size();i++){
         dano=this.lutadorDois.getProximoGolpe().getFatorDano()+dano;
      }
      if(dano==0){
          return; //Lutadores não possuem dano
      }
      //Realização da troca de golpes
      while(aindaEstaoVivos){
		  //Realiza o próximo movimento, se o mesmo existir
          if(golpeadorDoTurno.getProximoMovimento() != null){
              golpeadorDoTurno.getProximoMovimento().executar();
          }
		  //Verifica se os saints estão vivos
          aindaEstaoVivos=this.lutadorUm.getStatus() == Status.VIVO && this.lutadorDois.getStatus() == Status.VIVO;
          //Definindo quem irá atuar no próximo round
	      golpeadorDoTurno = golpeadorDoTurno == this.lutadorUm ? this.lutadorDois : this.lutadorUm;
      }
    }
}