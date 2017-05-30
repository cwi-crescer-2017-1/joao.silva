using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Demo1.Dominio.Entidades
{
    public class ItemPedido
    {
        public int Id { get; set; }
        public int ProdutoId { get; set; }
        public int Quantidade { get; set; }

        public bool Validar(out string mensagem)
        {
            mensagem = "";
            if (Quantidade <= 0)
            {
                mensagem = "Quantidade de produtos inválida no item de id "+ProdutoId;
            }
            return mensagem.Length == 0;
        }
    }
}
