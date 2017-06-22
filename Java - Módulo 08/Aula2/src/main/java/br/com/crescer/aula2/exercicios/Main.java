/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula2.exercicios;

/**
 *
 * @author jpedr
 */
public class Main {
    public static void main(String[] args){
        FileUtilsImpl fileUtils = new FileUtilsImpl();
        String link = "C:\\Users\\jpedr\\Desktop\\oi.txt";
        String link2 = "C:\\Users\\jpedr\\Desktop\\tchau.txt";
        String link3Diretorio = "C:\\Users\\jpedr\\Desktop";
        String link4 = "C:\\Users\\jpedr\\Desktop\\tchauSeFoiEOiTbm.txt";
        String moverPraCa = "C:\\Users\\jpedr\\Documents";
        fileUtils.mk(link);
        fileUtils.rm(link);
        fileUtils.mk(link2);
        fileUtils.mk(link4);
        System.out.println("Arquivo: "+fileUtils.ls(link2));
        System.out.println("Diretório: "+fileUtils.ls(link3Diretorio));
        fileUtils.mv(link2, moverPraCa);
        String textao = "eahihuhdiusadjiasn lhfkjijasdbhlsadjasd fhilsajndoansdas ndoaisndoansduias";
        WriterUtils writerUtils = new WriterUtilsImpl();
        writerUtils.write(link4, textao);
        ReaderUtils readerUtils = new ReaderUtilsImpl();
        System.out.println(readerUtils.read(link4));
        
    }
}
