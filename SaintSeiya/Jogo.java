public class Jogo{
    public static void main(String args[]){//Ordem de execução 1º
        try{
            System.out.println("Iniciando o jogo");
            Jogo.imprimirArgumentos(args);
        }catch (Exception e){
            System.out.println("Erro");
        }
    }
    public static void imprimirInternamente(String args[]){//3º
        System.out.println(args[0]);
    }
    public static void imprimirArgumentos(String args[]) throws Exception{//2º
       try{
           imprimirInternamente(args);
       }catch(ArrayIndexOutOfBoundsException ae){
           System.out.println("Ops... algo falhou");
           ae.printStackTrace();
           throw new Exception(ae);     
       }catch(Exception e){
           System.out.println("Erro inesperado! Sorry :(");
           e.printStackTrace();
       }finally{
           System.out.println("Imprimiu argumento");
       }
    }
}