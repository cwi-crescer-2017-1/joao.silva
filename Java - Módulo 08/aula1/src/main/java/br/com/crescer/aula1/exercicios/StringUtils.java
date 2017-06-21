/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula1.exercicios;

import br.com.crescer.aula1.exercicios.Interfaces.IStringUtils;
import java.text.Normalizer;
import java.util.Arrays;

/**
 *
 * @author jpedr
 */
public class StringUtils implements IStringUtils{

    public StringUtils(){}
    @Override
    public boolean isEmpty(String string) {
        return string == null || string.trim().isEmpty();      
    }

    @Override
    public String inverter(String string) {
        StringBuilder reversa = new StringBuilder(string);
        reversa.reverse();
        return reversa.toString();
    }

    @Override
    public int contaVogais(String string) {
        if(!isEmpty(string)){
            String strigPadronizada = padronizaString(string);
            return (int) Arrays
            	            .asList(strigPadronizada.split(""))
                            .stream()
                            .filter(s-> "AEIOU".contains(s))
                            .count();
        }
        return 0;
    }
    
    @Override
    public boolean isPalindromo(String string) {
        if(!isEmpty(string)){
            String strigPadronizadaSemEspaco = padronizaString(string).replaceAll(" ","");
            String stringInvertida = inverter(strigPadronizadaSemEspaco);
            if(strigPadronizadaSemEspaco.equals(stringInvertida)){
                return true;
            }
        }
        return false;
    }
    
    private String padronizaString(String string){
        return Normalizer
                    .normalize(string, Normalizer.Form.NFD)
                    .replaceAll("[^\\p{ASCII}]", "").toUpperCase();
    }
    
}
