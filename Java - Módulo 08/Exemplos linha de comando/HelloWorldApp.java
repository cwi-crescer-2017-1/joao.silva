import java.util.Scanner;

class HelloWorldApp {
  public static void main(String[] args) { 
    System.out.println("Hello World");
	try (final Scanner scanner = new Scanner(System.in)) {
            System.out.println("Hello World! - " + scanner.nextLine());
        } catch (Exception e) {
            //...
        }
  }
}