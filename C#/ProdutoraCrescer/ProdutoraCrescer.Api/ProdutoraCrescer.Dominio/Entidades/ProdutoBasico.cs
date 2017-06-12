using System.Collections.Generic;

namespace ProdutoraCrescer.Dominio.Entidades
{
    public abstract class ProdutoBasico
    {
        public int Id { get; protected set; }
        public string Nome { get; protected set; }
        public decimal CustoDiaria { get; protected set; }
        public decimal CustoMulta { get; protected set; }
        public List<string> Mensagens { get; set; }

        public ProdutoBasico()
        {
            Mensagens = new List<string>();
        }

        public abstract bool Validar();
    }
}
