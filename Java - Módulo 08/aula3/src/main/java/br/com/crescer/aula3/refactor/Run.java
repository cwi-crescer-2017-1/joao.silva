/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula3.refactor;

import static br.com.crescer.aula3.refactor.ConnectionUtils.getConnection;
import static br.com.crescer.aula3.refactor.TesteDAO.create;
import static br.com.crescer.aula3.refactor.TesteDAO.drop;
import static br.com.crescer.aula3.refactor.TesteDAO.insert;
import java.sql.SQLException;
import java.sql.Connection;

/**
 *
 * @author joao.silva
 */
public class Run {

    public static void main(String[] args) {
        try (Connection connection = getConnection()) {
            drop(connection);
            create(connection);
            insert(connection);
        } catch (SQLException ex) {
            throw new RuntimeException("Erro na conexão", ex);
        }
    }
}
