using System;
using System.Collections.Generic;
using System.Linq;

namespace ProdutoraCrescer.Dominio.Entidades
{
    public class Cliente
    {
        public int Id { get; private set; }
        public string Nome { get; private set; }
        public string Endereco { get; private set; }
        public string CPF { get; private set; }
        public string Genero { get; private set; }
        public DateTime DataNascimento { get; private set; }//DATATIME.UTCNOW - Horario Universal
        public string Email { get; private set; }
        private List<string> Mensagens { get; set; }

        protected Cliente() { } //Construtor para o EF

        public Cliente(string nome, string endereco, string cpf, string genero, DateTime dataNascimento, string email)
        {
            Id = 0;
            Nome = nome;
            Endereco = endereco;
            CPF = cpf;
            Genero = genero;
            DataNascimento = dataNascimento;
            Email = email;
        }

        public bool Validar()
        {
            Mensagens.Clear();

            if (string.IsNullOrWhiteSpace(Nome))
                Mensagens.Add("Nome é inválido.");

            if(Nome.Length > 100)
                Mensagens.Add("Nome é inválido.");

            if (string.IsNullOrWhiteSpace(Endereco))
                Mensagens.Add("Endereco é inválido.");

            if(Endereco.Length > 500)
                Mensagens.Add("Endereco muito grande");

            if (string.IsNullOrWhiteSpace(CPF) || CPF.Length != 11)
                Mensagens.Add("CPF é inválido.");

            if (string.IsNullOrWhiteSpace(Genero))
                Mensagens.Add("Genero é inválido.");

            if (string.IsNullOrWhiteSpace(Email))
                Mensagens.Add("Email é inválido.");

            return Mensagens.Count == 0;
        }
    }
}
