public class Batalha{
    private Saint[] lutador = new Saint[2];
    private int valorCategoria1,valorCategoria2;
    public Batalha(Saint lutadorUm, Saint lutadorDois){
        this.lutador[0] = lutadorUm;
        this.lutador[1] = lutadorDois;
    }
    public void iniciar(){
      valorCategoria1= this.lutador[0].getArmadura().getCategoria().getValor();
      valorCategoria2= this.lutador[1].getArmadura().getCategoria().getValor();
      if(valorCategoria2>valorCategoria1){ //Se a Categoria do lutador 2 for maior que a do 1 o lutador 1 perde vida
          this.lutador[0].perderVida(10.0);
      }else{ //Caso a categoria seja a mesma ou a do lutador 1 for maior o lutador 2 perde vida
          this.lutador[1].perderVida(10.0);
      }
    }
}