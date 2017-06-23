/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula2.exercicios;

import java.io.File;
import java.io.IOException;

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
            File file = new File(in);
            File diretorio = new File(out);
            if(file.isFile()&&diretorio.isDirectory()){
                boolean arquivoMovido = file.renameTo(new File(out+file.getName()));
                if(arquivoMovido){
                    rm(in);
                    return true;
                }
            }
        }catch(Exception e){
            throw new RuntimeException("Arquivo ou diretório inválido");
        }
        return false;
    }
}
