using Demo1.Dominio.Entidades;
using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Demo1.Infraestrutura.Repositorios
{
    public class ProdutoRepositorio
    {
        string stringConexao =
                @"Server=13.65.101.67;
                  User id=joao.silva;
                  Password=123456;
                  Database=aluno22db";

        public void Criar(Produto produto)
        {
            using (var conexao = new SqlConnection(stringConexao))
            {
                conexao.Open();
                //Executa o INSERT
                using (var comando = conexao.CreateCommand())
                {
                    comando.CommandText =
                    @"INSERT INTO Produto(Nome, Preco, Estoque) 
                      VALUES(@nome, @preco, @estoque)";

                    comando.Parameters.AddWithValue("@nome", produto.Nome);
                    comando.Parameters.AddWithValue("@preco", produto.Preco);
                    comando.Parameters.AddWithValue("@estoque", produto.Estoque);

                    //Executa o comando e retorna a quantidade de linhas afetadas
                    comando.ExecuteNonQuery();
                    //Lê o resultado de um SELECT
                    //comando.ExecuteReader();
                    //Lê e retorna a primeira coluna na primeira linha do resultado
                    //comando.ExecuteScalar();

                }

                //Obtem o último id criado
                using (var comando = conexao.CreateCommand())
                {
                    comando.CommandText = "SELECT @@IDENTITY";
                    var result = (decimal)comando.ExecuteScalar();
                    produto.Id = (int)result;
                }
            };
        }
        public List<Produto> Listar()
        {
            var produtos = new List<Produto>();
            using (var conexao = new SqlConnection(stringConexao)){
                conexao.Open();
                using (var comando = conexao.CreateCommand())
                {
                    comando.CommandText =
                        @"SELECT Id, Nome, Preco, Estoque FROM Produto";

                    var dataReader = comando.ExecuteReader();
                    while (dataReader.Read())
                    {
                        var produto = new Produto();

                        produto.Id = (int)dataReader["Id"];
                        produto.Nome = (string)dataReader["Nome"];
                        produto.Preco = (decimal)dataReader["Preco"];
                        produto.Estoque = (int)dataReader["Estoque"];

                        produtos.Add(produto);
                    }
                }
            }
                return produtos;
        }
    }
}
