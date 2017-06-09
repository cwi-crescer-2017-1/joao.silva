using System;
using System.Collections.Generic;

namespace ProdutoraCrescer.Dominio.Entidades
{
    public class Reserva
    {
        public int Id { get; private set; }
        public decimal Valor { get; private set; }
        public DateTime DataLocacao { get; private set; }
        public DateTime DataDevolucao_Prevista { get; private set; }
        public DateTime? DataDevolucao_Real { get; private set; }
        public Pacote Pacote { get; private set; }
        public Festa Festa { get; private set; }
        public Usuario Usuario { get; private set; }
        public Cliente Cliente { get; private set; }
        public Opcional Opcional { get; set; }

        public bool Devolvido { get { return DataDevolucao_Real != null; }}

        public List<string> Mensagens { get; set; }

        protected Reserva() { Mensagens = new List<string>();  }

        public Reserva(decimal valor, int duracaoReservaEmDias, Pacote pacote, Festa festa, Usuario usuario, Cliente cliente, Opcional opcional)
        {
            DateTime hoje = DateTime.UtcNow;

            Id = 0;
            Valor = valor;
            DataLocacao = hoje;
            DataDevolucao_Prevista = hoje.AddDays(duracaoReservaEmDias);
            Pacote = pacote;
            Festa = festa;
            Usuario = usuario;
            Cliente = cliente;

            if(opcional != null)
            {
                bool reservado = opcional.ReservarOpcional();
                if (reservado) Opcional = opcional;
            }

            Mensagens = new List<string>();
        }
        
        public bool Devolver()
        {
            if(DataDevolucao_Real == null)
            {
                DataDevolucao_Real = DateTime.UtcNow;
                if (DataDevolucao_Real > DataDevolucao_Prevista)
                {
                    decimal multa = CalcularMulta();
                    Valor = Valor + multa;
                }
                Opcional.DevolverOpcional();
                return true;
            }
            return false;
        }

        public decimal CalcularDevolucao()
        {
            if (DataDevolucao_Prevista < DataDevolucao_Real)
            {
                decimal valorMulta = CalcularMulta();
                return valorMulta + Valor;
            }
            return Valor;
        }

        private decimal CalcularMulta()
        {
            DateTime hoje = DateTime.UtcNow;
            TimeSpan atraso = (hoje - DataDevolucao_Prevista);
            int diasAtraso = atraso.Days;
            if (diasAtraso > 0)
            {
                decimal valorMulta = (Opcional.CustoMulta + Pacote.CustoMulta + Festa.CustoMulta) * diasAtraso;
                return valorMulta;
            }
            return 0;
        }

        public void SalvarValor(int valor)
        {
            Valor = valor;
        }

        public bool Validar()
        {
            Mensagens.Clear();

            if (Valor < 0)
            {
                Mensagens.Add("Valor inválido.");
            } 

            if (DataLocacao == null)
            {
                Mensagens.Add("Data locação inválida.");
            }
            
            if (DataDevolucao_Prevista == null)
            {
                Mensagens.Add("Data devolução prevista é inválida.");
            } 

            if (Festa == null)
            {
                Mensagens.Add("Festa inválida");
            }

            if (Usuario == null)
            {
                Mensagens.Add("Usuario inválido");
            }
            if (Cliente == null)
            {
                Mensagens.Add("Cliente inválido");
            }

            if (DataLocacao == null || DataLocacao == DataDevolucao_Prevista)
            {
                Mensagens.Add("Data devolução prevista inválida");
            }

            if (Opcional != null && Opcional.Quantidade < 0)
            {
                Mensagens.Add("Quantidade de indísponível");
            }

            return Mensagens.Count == 0;
        }
    }
}
