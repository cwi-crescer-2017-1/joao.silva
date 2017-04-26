public class Jogo{
    public static void main(String args[]){
        System.out.println("Iniciando o jogo");
        Jogo.imprimir(args);
           
    }
    public static void imprimir(String args[]){
       try{
           System.out.println(args[0]);
       }catch(Exception e){
           System.out.println("Ops... algo falhou");
           System.out.println(e.toString());
       }
    }
}