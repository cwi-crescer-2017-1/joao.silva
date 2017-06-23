/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula3.refactor;

import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author joao.silva
 */
public final class ConnectionUtils {

    final static String url = "jdbc:oracle:thin:@localhost:1521:xe";
    final static String user = "Modulo8";
    final static String pass = "Modulo8";

    public final static java.sql.Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, pass);
    }
}
