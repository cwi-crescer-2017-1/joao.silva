/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.aula3tema;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author jpedr
 */
public class ConnectionUtils {
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String USER = "Modulo8";
    private static final String PASS = "Modulo8";

    private ConnectionUtils() {

    }

    /**
     * Retorna uma nova conexão para o usuario crescer.
     *
     * @return Connection
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }
    public static Statement getStatement() throws SQLException {
        return getConnection().createStatement();
    }
}
