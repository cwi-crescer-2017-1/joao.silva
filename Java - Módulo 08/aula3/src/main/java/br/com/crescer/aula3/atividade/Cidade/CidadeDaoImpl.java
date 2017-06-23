/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula3.atividade.Cidade;

import br.com.crescer.aula3.refactor.ConnectionUtils;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author joao.silva
 */
public class CidadeDaoImpl implements CidadeDao{
    
    private static final String INSERT_CIDADES = "Insert Into Cidade (ID, NOME, ESTADO) Values (?,?,?)";
    private static final String UPDATE_CIDADES = "Update Cidade Set NOME=?, ESTADO=? Where ID=?";
    private static final String DELETE_CIDADES = "Delete From Cidade Where ID = ?";
    private static final String LOAD_CIDADES = "Select ID,NOME,ESTADO From Cidade Where ID = ?";
    
    @Override
    public void insert(Cidade cidade) {
        try (final PreparedStatement preparedStatement
                = ConnectionUtils.getConnection().prepareStatement(INSERT_CIDADES)) {
            preparedStatement.setLong(1, cidade.getId());
            preparedStatement.setString(2, cidade.getNome());
            preparedStatement.setLong(3, cidade.getEstado());
            preparedStatement.executeUpdate();
        } catch (final SQLException e) {
            System.err.format("SQLException: %s", e);
        }
    }

    @Override
    public void update(Cidade cidade) {
        try (final PreparedStatement preparedStatement
             = ConnectionUtils.getConnection().prepareStatement(UPDATE_CIDADES)) {
            preparedStatement.setLong(3, cidade.getId());
            preparedStatement.setString(1, cidade.getNome());
            preparedStatement.setLong(2, cidade.getEstado());
            preparedStatement.executeUpdate();
        } catch (final SQLException e) {
            System.err.format("SQLException: %s", e);
        }
    }

    @Override
    public void delete(Cidade cidade) {
        try (final PreparedStatement preparedStatement
                = ConnectionUtils.getConnection().prepareStatement(DELETE_CIDADES)) {
            preparedStatement.setLong(1, cidade.getId());
            preparedStatement.executeUpdate();
        } catch (final SQLException e) {
            System.err.format("SQLException: %s", e);
        }
    }

    @Override
    public Cidade loadBy(Long id) {
        final Cidade cidade = new Cidade();
        try (final PreparedStatement preparedStatement
                = ConnectionUtils.getConnection().prepareStatement(LOAD_CIDADES)) {
            preparedStatement.setLong(1, id);
            try (final ResultSet resultSet = preparedStatement.executeQuery()) {

                while (resultSet.next()) {
                    cidade.setId(resultSet.getLong("ID"));
                    cidade.setNome(resultSet.getString("NOME"));
                    cidade.setEstado(resultSet.getLong("ESTADO"));
                }
            } catch (final SQLException e) {
                System.err.format("SQLException: %s", e);
            }
        } catch (final SQLException e) {
            System.err.format("SQLException: %s", e);
        }
        return cidade;
    }
    
}
