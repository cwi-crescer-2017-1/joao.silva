/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula3.refactor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import static java.util.stream.Collectors.toList;
import java.util.stream.LongStream;

/**
 *
 * @author joao.silva
 */
public final class TesteDAO {

    private TesteDAO() {}
    
    private static final String CREATE_TABLE = "CREATE TABLE TESTE ( \n"
            + "  ID NUMBER(8) NOT NULL,\n"
            + "  NOME VARCHAR2(60) DEFAULT NULL, \n"
            + "  CONSTRAINT TESTE_PK PRIMARY KEY (ID)  ENABLE \n"
            + ")";

    private static final String INSERT = " INSERT INTO TESTE (ID, NOME) VALUES (?,?)";

    private static final String DELETE = "DROP TABLE TESTE";
    public static void create(Connection connection) {
        try (final Statement statement = connection.createStatement()) {
            statement.executeQuery(CREATE_TABLE);
        } catch (SQLException e) {
            throw new RuntimeException("Erro no SQL", e);
        }
    }

    public static void insert(Connection connection) {
        try (final PreparedStatement preparedStatement = connection.prepareStatement(INSERT)) {
            final List<Long> list = LongStream.range(1, 1000).boxed().collect(toList());
            for (Long id : list) {
                preparedStatement.setLong(1, id);
                preparedStatement.setString(2, String.format("%s pessoa de 999", id));
                preparedStatement.executeUpdate();
            }
        } catch (final SQLException e) {
            throw new RuntimeException("Erro no SQL", e);
        }
    }

    public static void drop(Connection connection) {
        try (final Statement statement = connection.createStatement()) {
            statement.executeUpdate(DELETE);
        } catch (final SQLException e) {
            throw new RuntimeException("Erro no SQL", e);
        }
    }

}
