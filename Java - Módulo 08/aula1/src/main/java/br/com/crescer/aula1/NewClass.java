/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import static java.util.stream.Collectors.toList;

/**
 *
 * @author joao.silva
 */
public class NewClass{
  public static void main(String[] args) { 
    StringBuilder resposta = new StringBuilder("Estados: ");
    ArrayList<String> estados = new ArrayList<String>();    
    for(Estados es : Estados.values()){
       estados.add(es.getNome());
    }
    Collections.sort(estados);
    for(String es : estados){
        resposta.append(es).append(", ");
    }
    resposta.replace(resposta.length()-2, resposta.length()-1, ";");
    System.out.println(resposta);    
  }
}
