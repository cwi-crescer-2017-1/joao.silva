/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercicio1;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author joao.silva
 */
public class Main {
    public static void main(String[] args) { 
        String resultado;
	try (final Scanner scanner = new Scanner(System.in)) {
            String dataDigitada;
            int diasSomados;
            System.out.println("Digite uma data no formato (dd/MM/yyyy):");
            dataDigitada = scanner.nextLine();
            System.out.println("Digite o número de dias a ser somado");
            diasSomados = scanner.nextInt();
            try{
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
                Date dataFormatada;
                Calendar calendar = Calendar.getInstance();
                dataFormatada = simpleDateFormat.parse(dataDigitada);
                calendar.setTime(dataFormatada);
                calendar.add(Calendar.DAY_OF_YEAR, diasSomados);
                resultado = calendar.getTime().toString();
            }catch(Exception e){
                resultado = "data inválida!";
            }
        } catch (Exception e) {
            resultado = "Quantidade de dias inválida.";
        }
        System.out.println("Resultado: "+ resultado);
    }
}
