/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula2.exercicios;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jpedr
 */
public class WriterUtilsImpl implements WriterUtils{

    @Override
    public void write(String file, String conteudo) {
        try (
             final FileWriter fileWriter = new FileWriter(file, true);
             BufferedWriter bufferWriter = new BufferedWriter(fileWriter);) 
        {
            final File arquivo = new File(file); 
            if (arquivo.getName().endsWith(".txt")) {
                bufferWriter.append(conteudo);           
                bufferWriter.newLine();
                bufferWriter.flush();
            }else{
                throw new FileNotFoundException("Arquivo não encontrado ");
            }
        }catch(NullPointerException n){
            throw new NullPointerException("Diretório nulo");
        }catch (IOException ex) {
            //
        }
    }
    
}
