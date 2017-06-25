/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jpedr
 */
public class CrudDaoImplTest {

    public CrudDaoImplTest() {
    }

    @Test
    public void testLoadById() {
        System.out.println("loadById Funcionario");
        Funcionario funcionario = new Funcionario("Leandro Teste loadById", "856985698");
        CrudDao<Funcionario, Long> funcionarioDao = new CrudDaoImpl<>(Funcionario.class);
        ConnectionUtils.openConnections();
        funcionarioDao.save(funcionario);
        Long id = funcionario.getId();
        Funcionario result = funcionarioDao.loadById(id);

        assertEquals(funcionario.getId(), result.getId());
        assertEquals(funcionario.getNome(), result.getNome());
        assertEquals(funcionario.getRg(), result.getRg());
        assertEquals(funcionario.getBairro(), result.getBairro());
        assertEquals(funcionario.getCelular(), result.getCelular());
        assertEquals(funcionario.getCidade(), result.getCidade());
        assertEquals(funcionario.getCpf(), result.getCpf());
        assertEquals(funcionario.getEmail(), result.getEmail());
        assertEquals(funcionario.getFuncao(), result.getFuncao());
        assertEquals(funcionario.getNascimento(), result.getNascimento());
        assertEquals(funcionario.getNumeroCasa(), result.getNumeroCasa());
        assertEquals(funcionario.getRua(), result.getRua());
        assertEquals(funcionario.getSalario(), result.getSalario());
        assertEquals(funcionario.getTelefone(), result.getTelefone());

        funcionarioDao.remove(result);
        ConnectionUtils.closeConnections();
    }

    @Test
    public void testSaveFuncionario() {
        CrudDao<Funcionario, Long> funcionarioDao = new CrudDaoImpl<>(Funcionario.class);
        ConnectionUtils.openConnections();

        System.out.println("save funcionário");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.YEAR, -25);

        Funcionario funcionario = new Funcionario("Leandro Teste Save", "856985698");
        funcionario.setBairro("Andrades");
        funcionario.setCelular("985632563");
        funcionario.setCidade("Porto Alegre");
        funcionario.setCpf("11111111111");
        funcionario.setEmail("gmail@gmail");
        funcionario.setFuncao("Gerente");
        funcionario.setNascimento(calendar.getTime());
        funcionario.setNumeroCasa("645");
        funcionario.setRua("AndradesRua");
        funcionario.setSalario(2500.00F);
        funcionario.setTelefone("563256325");

        funcionarioDao.save(funcionario);
        Long id = funcionario.getId();
        Funcionario result = funcionarioDao.loadById(id);

        String nome = "Leandro Teste Save";
        String rg = "856985698";
        String bairro = "Andrades";
        String celular = "985632563";
        String cidade = "Porto Alegre";
        String cpf = "11111111111";
        String email = "gmail@gmail";
        String funcao = "Gerente";
        Date nascimento = calendar.getTime();
        String numeroCasa = "645";
        String rua = "AndradesRua";
        Float salario = 2500.00F;
        String telefone = "563256325";

        assertEquals(id, result.getId());
        assertEquals(nome, result.getNome());
        assertEquals(rg, result.getRg());
        assertEquals(bairro, result.getBairro());
        assertEquals(celular, result.getCelular());
        assertEquals(cidade, result.getCidade());
        assertEquals(cpf, result.getCpf());
        assertEquals(email, result.getEmail());
        assertEquals(funcao, result.getFuncao());
        assertEquals(nascimento, result.getNascimento());
        assertEquals(numeroCasa, result.getNumeroCasa());
        assertEquals(rua, result.getRua());
        assertEquals(salario, result.getSalario());
        assertEquals(telefone, result.getTelefone());

        funcionarioDao.remove(result);
        ConnectionUtils.closeConnections();
    }

    @Test
    public void testSaveAndUpdateFuncionario() {
        CrudDao<Funcionario, Long> funcionarioDao = new CrudDaoImpl<>(Funcionario.class);
        ConnectionUtils.openConnections();

        System.out.println("update funcionário");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.YEAR, -25);

        Funcionario funcionario = new Funcionario("Leandro Teste Update", "856985698");
        funcionario.setBairro("Andrades");
        funcionario.setCelular("985632563");
        funcionario.setCidade("Porto Alegre");
        funcionario.setCpf("11111111111");
        funcionario.setEmail("gmail@gmail");
        funcionario.setFuncao("Gerente");
        funcionario.setNascimento(calendar.getTime());
        funcionario.setNumeroCasa("645");
        funcionario.setRua("AndradesRua");
        funcionario.setSalario(2500.00F);
        funcionario.setTelefone("563256325");

        funcionarioDao.save(funcionario);

        String nomeNovo = "Nome Modificado";
        String emailNovo = "mudou@mudou";
        String celularNovo = "99999999";
        funcionario.setNome(nomeNovo);
        funcionario.setEmail(emailNovo);
        funcionario.setCelular(celularNovo);
        Long id = funcionario.getId();
        
        Funcionario result = funcionarioDao.loadById(id);

        String nome = "Leandro Teste update";
        String rg = "856985698";
        String bairro = "Andrades";
        String celular = "985632563";
        String cidade = "Porto Alegre";
        String cpf = "11111111111";
        String email = "gmail@gmail";
        String funcao = "Gerente";
        Date nascimento = calendar.getTime();
        String numeroCasa = "645";
        String rua = "AndradesRua";
        Float salario = 2500.00F;
        String telefone = "563256325";

        assertEquals(id, result.getId());
        assertEquals(nomeNovo, result.getNome());
        assertNotSame(nome, result.getNome());
        assertEquals(rg, result.getRg());
        assertEquals(bairro, result.getBairro());
        assertNotSame(celular, result.getCelular());
        assertEquals(celularNovo, result.getCelular());
        assertEquals(cidade, result.getCidade());
        assertEquals(cpf, result.getCpf());
        assertEquals(emailNovo, result.getEmail());
        assertNotSame(email, result.getEmail());
        assertEquals(funcao, result.getFuncao());
        assertEquals(nascimento, result.getNascimento());
        assertEquals(numeroCasa, result.getNumeroCasa());
        assertEquals(rua, result.getRua());
        assertEquals(salario, result.getSalario());
        assertEquals(telefone, result.getTelefone());

        funcionarioDao.remove(result);
        ConnectionUtils.closeConnections();
    }

    @Test
    public void testRemove() {
        System.out.println("remove funcionario");
        CrudDao<Funcionario, Long> funcionarioDao = new CrudDaoImpl<>(Funcionario.class);
        ConnectionUtils.openConnections();
        Funcionario funcionario = new Funcionario("Leandro Teste remove", "856985698");
        funcionarioDao.save(funcionario);
        Long id = funcionario.getId();
        funcionarioDao.remove(funcionario);
        Funcionario result = funcionarioDao.loadById(id);

        assertNull(result);

        ConnectionUtils.closeConnections();
    }

    @Test
    public void testFindAll() {
        CrudDao<Funcionario, Long> funcionarioDao = new CrudDaoImpl<>(Funcionario.class);
        ConnectionUtils.openConnections();
        List<Funcionario> funcionarios = funcionarioDao.findAll();
        final String url = "jdbc:oracle:thin:@localhost:1521:xe";
        final String user = "crescer";
        final String pass = "crescer";

        final String query = "SELECT * FROM PAIS";

        try (final Connection connection = DriverManager.getConnection(url, user, pass);
                final Statement statement = connection.createStatement();
                final ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                System.out.println(resultSet.getString("SIGLA"));
                Long idResultSet = resultSet.getLong("ID");
                assertNotNull(funcionarios.stream().anyMatch(f->f.getId().equals(idResultSet)));
            }

        } catch (final SQLException e) {
            System.err.format("SQLException: %s", e);
        }
        ConnectionUtils.closeConnections();
    }
}
