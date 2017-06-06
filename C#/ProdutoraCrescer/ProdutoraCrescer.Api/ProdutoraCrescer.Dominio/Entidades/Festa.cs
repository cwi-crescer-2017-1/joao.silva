namespace ProdutoraCrescer.Dominio.Entidades
{
    public class Festa : ProdutoBasico
    {
        protected Festa() { }

        public Festa(string nome, decimal custoDiaria, decimal custoMulta)
        {
            Id = 0;
            Nome = nome;
            CustoDiaria = custoDiaria;
            CustoMulta = custoMulta;
        }

        public override bool Validar()
        {
            Mensagens.Clear();

            if (string.IsNullOrWhiteSpace(Nome))
                Mensagens.Add("Nome é inválido.");

            if (Nome.Length > 100)
                Mensagens.Add("Nome é inválido.");

            if (CustoDiaria<0)
                Mensagens.Add("Custo diário é inválido.");

            if (CustoMulta<0)
                Mensagens.Add("Custo da multa é inválido.");

            return Mensagens.Count == 0;
        }
    }
}
