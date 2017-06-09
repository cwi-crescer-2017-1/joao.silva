using System.Collections.Generic;

namespace ProdutoraCrescer.Dominio.Entidades
{
    public class Pacote
    {
        public int Id { get; private set; }
        public string Nome { get; private set; }
        public bool Decoracao { get; private set; }
        public bool Instalacao { get; private set; }
        public bool Equipe { get; private set; }
        public decimal CustoDiaria { get; private set; }
        public decimal CustoMulta { get; private set; }
        public List<string> Mensagens { get; set; }

        protected Pacote() { Mensagens = new List<string>(); }
        
        public Pacote(string nome, bool decoracao, bool instalacao, bool equipe, decimal custoDiaria, decimal custoMulta)
        {
            Id = 0;
            Nome = nome;
            Decoracao = decoracao;
            Instalacao = instalacao;
            Equipe = equipe;
            CustoDiaria = custoDiaria;
            CustoMulta = custoMulta;
            Mensagens = new List<string>();
        }
        public bool Validar()
        {
            Mensagens.Clear();

            if (string.IsNullOrWhiteSpace(Nome) || Nome.Length > 100)
            {
                Mensagens.Add("Nome é inválido.");
            }

            if (CustoDiaria <= 0)
            {
                Mensagens.Add("Custo diário é inválido.");
            }

            if (CustoMulta <= 0)
            {
                Mensagens.Add("Custo da multa é inválido.");
            }

            return Mensagens.Count == 0;
        }
    }
}
