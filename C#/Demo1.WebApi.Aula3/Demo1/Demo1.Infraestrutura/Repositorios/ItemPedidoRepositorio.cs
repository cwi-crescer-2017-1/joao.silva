using Demo1.Dominio.Entidades;
using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Demo1.Infraestrutura.Repositorios
{
    public class ItemPedidoRepositorio
    {
        string stringConexao =
                @"Server=13.65.101.67;
                  User id=joao.silva;
                  Password=123456;
                  Database=aluno22db";
        public ItemPedido Obter(int id)
        {
            ItemPedido itemPedido = null;
            using (var conexao = new SqlConnection(stringConexao))
            {
                conexao.Open();
                using (var comando = conexao.CreateCommand())
                {
                    comando.CommandText =
                        @"SELECT Id, PedidoId, ProdutoId, Quantidade 
                                   FROM ItemPedido WHERE Id = @id";

                    comando.Parameters.AddWithValue("@id", id);

                    var dataReader = comando.ExecuteReader();
                    while (dataReader.Read())
                    {
                        itemPedido = new ItemPedido();

                        itemPedido.Id = (int)dataReader["Id"];
                        itemPedido.ProdutoId = (int)dataReader["ProdutoId"];
                        itemPedido.Quantidade = (int)dataReader["Quantidade"];
                        return itemPedido;
                    }
                }
            }
            return itemPedido;
        }
    }
}
