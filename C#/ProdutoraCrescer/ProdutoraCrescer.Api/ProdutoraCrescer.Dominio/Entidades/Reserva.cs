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

        private List<string> Mensagens { get; set; }

        protected Reserva() { }

        public Reserva(decimal valor,DateTime dataLocacao, DateTime dataDevolucaoPrevista, Pacote pacote, Festa festa, Usuario usuario, Cliente cliente, Opcional opcional)
        {
            Id = 0;
            Valor = valor;
            DataLocacao = dataLocacao;
            DataDevolucao_Prevista = dataDevolucaoPrevista;
            Pacote = pacote;
            Festa = festa;
            Usuario = usuario;
            Cliente = cliente;
            Opcional = opcional;
        }
        
        public bool Devolver()
        {
            if(DataDevolucao_Real == null)
            {
                DataDevolucao_Real = DateTime.UtcNow;
                return true;
            }
            return false;
        }

        public void SalvarValor(int valor)
        {
            Valor = valor;
        }

        public bool Validar()
        {
            Mensagens.Clear();

            if (Valor<0)
                Mensagens.Add("Valor inválido.");

            if (DataLocacao == null)
                Mensagens.Add("Data locação inválida.");

            if (DataDevolucao_Prevista == null)
                Mensagens.Add("Data devolução prevista é inválida.");

            if (Festa == null)
                Mensagens.Add("Festa inválida");
            if (Usuario == null)
                Mensagens.Add("Usuario inválido");
            if (Cliente == null)
                Mensagens.Add("Cliente inválido");
            if (Opcional == null)
                Mensagens.Add("Opcional inválido");

            return Mensagens.Count == 0;
        }
    }
}
