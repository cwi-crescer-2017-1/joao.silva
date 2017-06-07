using System.Collections.Generic;

namespace ProdutoraCrescer.Dominio.Entidades
{
    public class Opcional : ProdutoBasico
    {
        public int Quantidade { get; private set; }

        protected Opcional() { Mensagens = new List<string>(); }

        public Opcional(string nome, decimal custoDiaria, decimal custoMulta, int quantidade)
        {
            Id = 0;
            Nome = nome;
            CustoDiaria = custoDiaria;
            CustoMulta = custoMulta;
            Quantidade = quantidade;
            Mensagens = new List<string>();
        }

        public bool ReservarOpcional()
        {
            if (Quantidade > 1)
            {
                Quantidade = Quantidade - 1;
                return true;
            }
            return false;
        }
        public override bool Validar()
        {
            Mensagens.Clear();

            if (string.IsNullOrWhiteSpace(Nome) || Nome.Length > 100)
            {
                Mensagens.Add("Nome é inválido.");
            }

            if (CustoDiaria < 0)
            {
                Mensagens.Add("Custo diário inválido.");
            }

            if (CustoMulta < 0)
            {
                Mensagens.Add("Custo da multa inválido.");
            }

            if (Quantidade < 0)
            {
                Mensagens.Add("Quantidade inválida.");
            }

            return Mensagens.Count == 0;
        }
    }
}
