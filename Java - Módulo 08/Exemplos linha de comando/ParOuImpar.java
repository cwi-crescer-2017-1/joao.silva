import java.util.Scanner;

class ParOuImpar {
  public static void main(String[] args) { 
    System.out.println("Digite um numero:");
	String resultado = "Impar";
	try (final Scanner scanner = new Scanner(System.in)) {
			try{
				boolean isPar = Integer.parseInt(scanner.nextLine())%2 == 0 && true;
				if(isPar){ resultado = "Par"; }
			}catch(Exception e){
				resultado = "invalido";
			}
			System.out.println("O numero e "+resultado);
        } catch (Exception e) {
            //...
        }
  }
}