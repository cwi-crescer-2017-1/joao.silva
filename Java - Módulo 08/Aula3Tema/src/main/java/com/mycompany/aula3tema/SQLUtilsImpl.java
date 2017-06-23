/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.aula3tema;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import static java.util.stream.Collectors.toList;

/**
 *
 * @author jpedr
 */
public class SQLUtilsImpl implements SQLUtils {

    final String quebraLinha = System.getProperty("line.separator");
    final String tipoArquivoLido = ".sql";

    @Override
    public void runFile(String filename) {
        try (final Statement statement = ConnectionUtils.getStatement()) {
            if (filename.endsWith(tipoArquivoLido)) {
                String arquivo = read(filename);
                String[] querys = arquivo.split(";");
                for (String query : querys) {
                    if (!query.contains("--") && !query.replaceAll(" ", "").isEmpty()) {
                        statement.executeQuery(query);
                    }
                }
            } else {
                throw new RuntimeException("Tipo de arquivo inválido");
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Arquivo inválido");
        }
    }

    @Override
    public String executeQuery(String query) {
        try (final Statement statement = ConnectionUtils.getStatement();
                final ResultSet resultSet = statement.executeQuery(query);) {
            return gerarCSVResultSet(resultSet);
        } catch (final SQLException e) {
            throw new RuntimeException("Query inválida");
        }
    }

    @Override
    public void importCSV(File file) {
        StringBuilder resultado = new StringBuilder();
        String[] colunas;
        String nomeColunas;
        String delimitador = ";"; /*Arquivo CSV utilizado e gerado pelo Excel utilizava ; para separar os valores, troca se necessário*/
        String valores;
        if (file.exists() && file.isFile()) {
            String nomeFile = file.getName();
            if (nomeFile.endsWith(".csv")) {
                String tabela = nomeFile.replace(".csv", "");
                try (final Reader reader = new FileReader(file);
                        final BufferedReader bufferedReader = new BufferedReader(reader);) {
                    String readLine = bufferedReader.readLine();
                    colunas = readLine.split(delimitador);
                    nomeColunas = readLine.replaceAll(delimitador, ",").replace("ï»¿", "");
                    while (true) {
                        try (final Statement statement = ConnectionUtils.getStatement()) {
                            readLine = bufferedReader.readLine();
                            if (readLine == null) {
                                break;
                            }
                            valores = "'" + readLine.replaceAll(delimitador, "','") + "'";

                            String query = "INSERT INTO " + tabela + " (" + nomeColunas + ") VALUES (" + valores + ")";

                            statement.executeQuery(query);
                        } catch (SQLException ex) {
                            Logger.getLogger(SQLUtilsImpl.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                } catch (FileNotFoundException ex) {
                    throw new RuntimeException("Arquivo não encontrado");
                } catch (IOException ex) {
                    throw new RuntimeException("Arquivo inválido");
                }
            }
        }
    }

    @Override
    public File exportCSV(String query) {
        final File file = new File("C:\\Users\\joao.silva\\Desktop\\Teste\\csv.csv");
        try (final Statement statement = ConnectionUtils.getStatement();
                final ResultSet resultSet = statement.executeQuery(query);) {
            String csv = gerarCSVResultSet(resultSet);
            try ( final FileWriter fileWriter = new FileWriter(file, true);
                BufferedWriter bufferWriter = new BufferedWriter(fileWriter);) {
                bufferWriter.append(csv);
                bufferWriter.newLine();
                bufferWriter.flush();
            } catch (NullPointerException n) {
                throw new NullPointerException("Diretório nulo");
            } catch (IOException ex) {
                //
            }
        } catch (final SQLException e) {
            throw new RuntimeException("Query inválida");
        }
        return file;
    }

    private String gerarCSVResultSet(ResultSet resultSet) throws SQLException {
        StringBuilder dados = new StringBuilder();
        String separadorDados = ";";
        ResultSetMetaData resultado = resultSet.getMetaData();
        ArrayList<String> coluna = new ArrayList<>();
        int colunas = resultado.getColumnCount();
        for (int i = 1; i <= colunas; i++) {
            dados.append(resultado.getColumnName(i)).append(separadorDados);
            coluna.add(resultado.getColumnName(i));
        }
        dados.deleteCharAt(dados.lastIndexOf(separadorDados)).append(quebraLinha);
        while (resultSet.next()) {
            for (int i = 0; i < colunas; i++) {
                dados.append(resultSet.getString(coluna.get(i))).append(separadorDados);
            }
            dados.deleteCharAt(dados.lastIndexOf(separadorDados)).append(quebraLinha);
        }
        return dados.toString();
    }

    public String read(String file) {
        try (final BufferedReader b = new BufferedReader(new FileReader(file))) {
            return String.join(" ", b.lines().collect(toList()));
        } catch (Exception e) {
            throw new RuntimeException("Arquivo inválido");
        }
    }

}
