/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula2.exercicios;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/**
 *
 * @author jpedr
 */
public class ReaderUtilsImpl implements ReaderUtils{

    @Override
    public String read(String string) {
        try{
            final File file = new File(string); 
            if (file.isFile() && file.exists() && file.getName().endsWith(".txt")) {
                final Reader reader = new FileReader(string);
                final BufferedReader bufferReader = new BufferedReader(reader);
                String readLine;
                StringBuilder resposta = new StringBuilder();
                final String quebraLinha = System.getProperty("line.separator");
                do{
                    readLine = bufferReader.readLine();
                    if(readLine!=null) {
                        resposta.append(readLine).append(quebraLinha);
                    }
                }while(readLine!=null);
                return resposta.toString();
            }else{
                throw new FileNotFoundException("Arquivo não encontrado ");
                // "Arquivo não encontrado";
            }
        }catch(IOException e){
            //
        }catch(NullPointerException n){
            throw new NullPointerException("Diretório nulo");
            //return "Endereço nulo";
        }
        return null;
    }
    
}
