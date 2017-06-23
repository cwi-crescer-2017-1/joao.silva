/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author joao.silva
 */
public class Run {

    public static void main(String[] args) {
        // Oracle Thin 
        // jdbc:oracle:thin:@<HOST>:<PORT>:<SID>
        // oracle.jdbc.driver.OracleDriver

        final String url = "jdbc:oracle:thin:@localhost:1521:xe";
        final String user = "Modulo8";
        final String pass = "Modulo8";

        final String query = "Select c.ID,c.Nome as Nome_Cidade ,e.Nome as Nome_Estado From Cidade c Inner Join Estado e On c.Estado = e.ID";
        //final String query = "SELECT NOME, ESTADO FROM CIDADE GROUP BY NOME, ESTADO HAVING COUNT(CIDADE.ID)>1 ORDER BY NOME";
        //final String query2 = "Select * From Cidade Where Nome = 'Curvelândia'";
        try (   final Connection connection = DriverManager.getConnection(url, user, pass);
                final Statement statement = connection.createStatement();
                final ResultSet resultSet = statement.executeQuery(query)) {
           
                while(resultSet.next()){
                    System.out.println(resultSet.getInt("ID")+" - "+resultSet.getString("Nome_Cidade")+" - "+resultSet.getString("Nome_Estado"));
                }
        } catch (final SQLException e) {
            System.err.format("SQLException: %s", e);
        }
    }
}
