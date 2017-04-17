public class Batalha{
    private Saint lutadorUm, lutadorDois ;
    public Batalha(Saint lutadorUm, Saint lutadorDois){
        this.lutadorUm = lutadorUm;
        this.lutadorDois = lutadorDois;
    }
    public void iniciar(){
      int valorCategoria1= this.lutadorUm.getArmadura().getCategoria().getValor();
      int valorCategoria2= this.lutadorDois.getArmadura().getCategoria().getValor();
      final double dano = 10.0; 
      /*o final garante que o valor não será alterado de forma indesejável durante o código e 
      ao ler o código o desenvolvedor já entende que o valor não deve ser alterado*/
      if(valorCategoria2>valorCategoria1){ //Se a Categoria do lutador 2 for maior que a do 1 o lutador 1 perde vida
          this.lutadorUm.perderVida(dano);
      }else{ //Caso a categoria seja a mesma ou a do lutador 1 for maior o lutador 2 perde vida
          this.lutadorDois.perderVida(dano);
      }
    }
}