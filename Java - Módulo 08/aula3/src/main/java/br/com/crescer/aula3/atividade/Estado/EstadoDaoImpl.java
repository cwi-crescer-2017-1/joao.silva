/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula3.atividade.Estado;

import br.com.crescer.aula3.refactor.ConnectionUtils;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author joao.silva
 */
public class EstadoDaoImpl implements EstadoDao{

    private static final String INSERT_ESTADOS = "Insert Into Estado (ID, NOME, UF, PAIS) Values (?,?,?,?)";
    private static final String UPDATE_ESTADOS = "Update Estado Set NOME=?, UF=?, PAIS=? Where ID=?";
    private static final String DELETE_ESTADOS = "Delete From Estado Where ID = ?";
    private static final String LOAD_ESTADOS = "Select ID,NOME,UF,PAIS From Estado Where ID = ?";
    
    
    @Override
    public void insert(Estado estado) {
        try (final PreparedStatement preparedStatement
                = ConnectionUtils.getConnection().prepareStatement(INSERT_ESTADOS)) {
            preparedStatement.setLong(1, estado.getId());
            preparedStatement.setString(2, estado.getNome());
            preparedStatement.setString(3, estado.getUf());
            preparedStatement.setLong(4, estado.getPais());
            preparedStatement.executeUpdate();
        } catch (final SQLException e) {
            System.err.format("SQLException: %s", e);
        }
    }
    @Override
    public void update(Estado estado) {
        try (final PreparedStatement preparedStatement
             = ConnectionUtils.getConnection().prepareStatement(UPDATE_ESTADOS)) {
            preparedStatement.setString(1, estado.getNome());
            preparedStatement.setString(2, estado.getUf());
            preparedStatement.setLong(3, estado.getPais());
            preparedStatement.setLong(4, estado.getId());
            preparedStatement.executeUpdate();
        } catch (final SQLException e) {
            System.err.format("SQLException: %s", e);
        }
    }

    @Override
    public void delete(Estado estado) {
        try (final PreparedStatement preparedStatement
                = ConnectionUtils.getConnection().prepareStatement(DELETE_ESTADOS)) {
            preparedStatement.setLong(1, estado.getId());
            preparedStatement.executeUpdate();
        } catch (final SQLException e) {
            System.err.format("SQLException: %s", e);
        }
    }

    @Override
    public Estado loadBy(Long id) {
        final Estado estado = new Estado();
        try (final PreparedStatement preparedStatement
                = ConnectionUtils.getConnection().prepareStatement(LOAD_ESTADOS)) {
            preparedStatement.setLong(1, id);
            try (final ResultSet resultSet = preparedStatement.executeQuery()) {

                while (resultSet.next()) {
                    estado.setId(resultSet.getLong("ID"));
                    estado.setNome(resultSet.getString("NOME"));
                    estado.setUf(resultSet.getString("UF"));
                    estado.setPais(resultSet.getLong("PAIS"));
                }
            } catch (final SQLException e) {
                System.err.format("SQLException: %s", e);
            }
        } catch (final SQLException e) {
            System.err.format("SQLException: %s", e);
        }
        return estado;
    }
}
