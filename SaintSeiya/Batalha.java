public class Batalha{
    private Saint lutadorUm, lutadorDois ;
    
    public Batalha(Saint lutadorUm, Saint lutadorDois){
        this.lutadorUm = lutadorUm;
        this.lutadorDois = lutadorDois;
    }
    public void iniciar(){
      int valorCategoria1= this.lutadorUm.getArmadura().getCategoria().getValor();
      int valorCategoria2= this.lutadorDois.getArmadura().getCategoria().getValor();
      if(valorCategoria2>valorCategoria1){ //Se a Categoria do lutador 2 for maior que a do 1 o lutador 1 perde vida
          this.lutadorUm.perderVida(10.0);
      }else{ //Caso a categoria seja a mesma ou a do lutador 1 for maior o lutador 2 perde vida
          this.lutadorDois.perderVida(10.0);
      }
    }
}