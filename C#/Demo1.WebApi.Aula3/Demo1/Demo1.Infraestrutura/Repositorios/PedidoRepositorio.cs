using Demo1.Dominio.Entidades;
using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Demo1.Infraestrutura.Repositorios
{
    public class PedidoRepositorio : IPedidoRepositorio
    {
        string stringConexao =
                @"Server=13.65.101.67;
                  User id=joao.silva;
                  Password=123456;
                  Database=aluno22db";

        public void Alterar(Pedido pedido)
        {
            throw new NotImplementedException();
        }

        public void Criar(Pedido pedido)
        {
            using (var conexao = new SqlConnection(stringConexao))
            {
                conexao.Open();
                //Executa o INSERT
                using (var comando = conexao.CreateCommand())
                {
                    comando.CommandText =
                    @"INSERT INTO Pedido(NomeCliente) 
                      VALUES(@nomeCliente)";

                    comando.Parameters.AddWithValue("@nomeCliente", pedido.NomeCliente);

                    comando.ExecuteNonQuery();
                }

                //Obtem o último id criado
                using (var comando = conexao.CreateCommand())
                {
                    comando.CommandText = "SELECT @@IDENTITY";
                    var result = (decimal)comando.ExecuteScalar();
                    pedido.Id = (int)result;
                }

                foreach (ItemPedido item in pedido.Itens)
                {
                    //Executa o INSERT
                    using (var comando = conexao.CreateCommand())
                    {

                        comando.CommandText =
                            @"INSERT INTO ItemPedido(PedidoId,ProdutoId,Quantidade) 
                              VALUES(@PedidoId,@ProdutoId,@Quantidade)";

                        comando.Parameters.AddWithValue("@PedidoId", pedido.Id);
                        comando.Parameters.AddWithValue("@ProdutoId", item.ProdutoId);
                        comando.Parameters.AddWithValue("@Quantidade", item.Quantidade);

                        comando.ExecuteNonQuery();
                        using (var comandoInterno = conexao.CreateCommand())
                        {
                            comandoInterno.CommandText = "SELECT @@IDENTITY";
                            var result = (decimal)comandoInterno.ExecuteScalar();
                            item.Id = (int)result;
                        }
                    }

                }
            }
        }

        public void Excluir(int id)
        {
            throw new NotImplementedException();
        }

        public IEnumerable<Pedido> Listar()
        {
            throw new NotImplementedException();
        }

        public Pedido Obter(int id)
        {
            throw new NotImplementedException();
        }
    }
}
