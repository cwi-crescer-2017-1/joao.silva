public class Golpe{
   private String nome;
   private int fatorDano;
   public Golpe(String nome, int fatorDano){
       this.nome = nome;
       this.fatorDano = fatorDano;
   }
   public String getNome(){
       return this.nome;
   }
   public int getFatorDano(){
       return this.fatorDano;
   }
   public boolean equals(Object object){//Verifica se um objeto possui os mesmos valores que outro objeto
       Golpe outroGolpe = (Golpe) object;//"Conversão" do object do tipo Object para o tipo Golpe
       return this.nome.equals(outroGolpe.nome) && this.fatorDano == outroGolpe.fatorDano;
       //no java os atributos private são acessíveis diretamente em sua classe, em outras linguagens não
       //instaceof - verifica se um objeto é uma extensão de outra classe retornando "true" ou "false"
   }
}
