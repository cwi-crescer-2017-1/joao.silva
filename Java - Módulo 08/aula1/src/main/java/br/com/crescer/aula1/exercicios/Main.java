/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula1.exercicios;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;


/**
 *
 * @author jpedr
 */
public class Main {
    public static void main(String[] args) { 
        String stringVogais = "TESTE ã 3 V";
        String inverter = "carlos";
        String palindromo = "A sogra má e amargosa"; 
        String empty = " ";
        String empty2 = null;
        StringUtils stringUtils = new StringUtils(); 
        System.out.println("Empty: "+stringUtils.isEmpty(empty));
        System.out.println("Empty: "+stringUtils.isEmpty(empty2));
        System.out.println("No empty: "+stringUtils.isEmpty(inverter));
        System.out.println("Número de vogais(3): " +stringUtils.contaVogais(stringVogais));
        System.out.println("Invertida(carlos): "+stringUtils.inverter(inverter));
        System.out.println("Palindromo: "+stringUtils.isPalindromo(palindromo));
        Date date = new Date("06/20/2017");
        Date date2 = new Date("12/30/1800");
        CalendarUtils calendarUtils = new CalendarUtils();
        System.out.println("Terça: "+calendarUtils.diaSemana(date));
        System.out.println("Tempo decorrido desde 09/30/1800: "+calendarUtils.tempoDecorrido(date2));
        Parcelator parcelator = new Parcelator();
        Map<String, BigDecimal> parcelaVencimento;
        Date data = new Date("06/30/2016");
        parcelaVencimento = parcelator.calcular(new BigDecimal(1000), 10, 10, data);
        Calendar cVencimento = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy"); 
        parcelaVencimento.entrySet().forEach((entry) -> {
            cVencimento.setTime(new Date(entry.getKey()));
            String sVencimento = simpleDateFormat.format(cVencimento.getTime());
            System.out.println(sVencimento + " - " + entry.getValue());
        });   
    }
}
