/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.aula3tema;


import java.io.File;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author jpedr
 */
public class SQLUtilsImpl implements SQLUtils{

    final static String quebraLinha = System.getProperty("line.separator");
    @Override
    public void runFile(String filename) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String executeQuery(String query) {        
        StringBuilder dados = new StringBuilder(); 
        String separadorDados = ",";
        try (final Statement statement = ConnectionUtils.getConnection().createStatement();
                final ResultSet resultSet = statement.executeQuery(query);){
                ResultSetMetaData resultado = resultSet.getMetaData();
                ArrayList<String> coluna = new ArrayList<>();
                int colunas = resultado.getColumnCount();
                for(int i=1;i<=colunas;i++){
                    dados.append(resultado.getColumnName(i)).append(separadorDados);
                    coluna.add(resultado.getColumnName(i));
                }
                dados.deleteCharAt(dados.lastIndexOf(separadorDados)).append(quebraLinha);
                while(resultSet.next()){
                    for(int i=0;i<colunas;i++){
                        dados.append(resultSet.getString(coluna.get(i))).append(separadorDados);
                    }
                    dados.deleteCharAt(dados.lastIndexOf(separadorDados)).append(quebraLinha);
                }
        } catch (final SQLException e) {
            System.err.format("SQLException: %s", e);
        }
        return dados.toString();
    }

    @Override
    public void importCSV(File file) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public File importCSV(String query) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private String gerarCSVResultSet(ResultSet resultSet){
        
    }
    
}
