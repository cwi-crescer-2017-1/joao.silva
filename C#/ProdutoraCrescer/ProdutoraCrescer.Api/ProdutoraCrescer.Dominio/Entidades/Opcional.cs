namespace ProdutoraCrescer.Dominio.Entidades
{
    public class Opcional : ProdutoBasico
    {
        public int Quantidade { get; private set; }

        protected Opcional() { }

        public Opcional(string nome, decimal custoDiaria, decimal custoMulta, int quantidade)
        {
            Id = 0;
            Nome = nome;
            CustoDiaria = custoDiaria;
            CustoMulta = custoMulta;
            Quantidade = quantidade;
        }

        public override bool Validar()
        {
            Mensagens.Clear();

            if (string.IsNullOrWhiteSpace(Nome))
                Mensagens.Add("Nome é inválido.");

            if (Nome.Length > 100)
                Mensagens.Add("Nome é inválido.");

            if (CustoDiaria < 0)
                Mensagens.Add("Custo diário inválido.");

            if (CustoMulta < 0)
                Mensagens.Add("Custo da multa inválido.");

            if (Quantidade < 0)
                Mensagens.Add("Quantidade inválida.");

            return Mensagens.Count == 0;
        }
    }
}
