/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.aula3tema;

import java.io.File;

/**
 *
 * @author jpedr
 */
public class Main {
    public static void main(String[] args){
        String query = "Select * From Estado";
        SQLUtils sqlUtil= new SQLUtilsImpl();
        System.out.println(sqlUtil.executeQuery(query));
        String arquivoSQL = "C:\\Users\\joao.silva\\Desktop\\Teste\\Teste.sql";
        sqlUtil.runFile(arquivoSQL);
        String arquivoCSV = "C:\\Users\\joao.silva\\Desktop\\Teste\\Pais.csv";
        File file = new File(arquivoCSV);
        sqlUtil.importCSV(file);
        sqlUtil.exportCSV("Select * From Estado");
    }
}
