/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author joao.silva
 */
public class RunCreateTable {

    public static void main(String[] args) {
        final String url = "jdbc:oracle:thin:@localhost:1521:xe";
        final String user = "Modulo8";
        final String pass = "Modulo8";

        final String ddl = "CREATE TABLE PESSOA ("
                + " ID_PESSOA NUMBER(19,0) NOT NULL, "
                + " NOME VARCHAR2(50) NOT NULL, "
                + " CIDADE NUMBER(7) DEFAULT NULL,"
                + " PRIMARY KEY (ID_PESSOA) "
                + ")";
        try (final Connection connection = DriverManager.getConnection(url, user, pass)) {
            try (final Statement statement = connection.createStatement()) {
                statement.executeUpdate(ddl);
            } catch (final SQLException e) {
                System.err.format("SQLException: %s", e);
            }
        } catch (SQLException e) {
            System.err.format("SQLException: %s", e);
        }
    }
}
