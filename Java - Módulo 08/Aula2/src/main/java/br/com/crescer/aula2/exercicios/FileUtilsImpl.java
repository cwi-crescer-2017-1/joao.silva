/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula2.exercicios;

import br.com.crescer.aula1.exercicios.StringUtils;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

/**
 *
 * @author jpedr
 */
public class FileUtilsImpl implements FileUtis{
    
    @Override
    public boolean mk(String string){
        try {
            File file = new File(string); 
            if(!file.exists()){
                if(!file.getParentFile().exists()){
                    file.getParentFile().mkdir();
                }   
                return new File(string).createNewFile();
            }
        }catch(IOException e){
            System.out.println("Diretório inválido");
        }
        return false;
    }

    @Override
    public boolean rm(String string) {
        try {
            final File file = new File(string); 
            if (file.isFile()) {
                return new File(string).delete();
            }
            if (file.isDirectory()) {
                System.out.println("Arquivo inválido");
            }
        }catch(Exception e){
            System.out.println("Diretório inválido");
        }
        return false;
    }

    @Override
    public String ls(String string) {
        try {
            final File file = new File(string); 
            if (file.isFile()) {
                return file.getAbsolutePath();
            }
            if (file.isDirectory()) {
                final String[] list = file.list();
                StringBuilder stringArquivos = new StringBuilder("Arquivos: ");
                for(String f : list){
                    stringArquivos.append(f).append(" ");
                }
                return stringArquivos.toString();
            }
        }catch(Exception e){
            System.out.println("Diretório inválido");
        }
        return null;
    }

    @Override
    public boolean mv(String in, String out) {
        try{
            final Reader reader = new FileReader(in);
            final File file = new File(in);
            final BufferedReader bufferReader = new BufferedReader(reader);
            mk(out);
            final Writer writer = new FileWriter(out+"\\"+file.getName());
            final BufferedWriter bufferWriter = new BufferedWriter(writer);
            String readLine;
            do{
                readLine = bufferReader.readLine();
                if(readLine!=null) {
                    bufferWriter.append(readLine);
                    bufferWriter.newLine();
                }
            }while(readLine!=null);
            bufferWriter.flush();
            bufferReader.close();
            rm(in);
        }catch(IOException e){
            //
        }catch(NullPointerException n){
            throw new NullPointerException("Diretório nulo");
        }
        //
        return false;
    }
}
