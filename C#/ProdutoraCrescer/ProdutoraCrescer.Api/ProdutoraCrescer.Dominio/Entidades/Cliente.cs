using System;
using System.Collections.Generic;
using System.Text.RegularExpressions;

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
        public List<string> Mensagens { get; private set; }

        protected Cliente() { Mensagens = new List<string>(); } //Construtor para o EF

        public Cliente(string nome, string endereco, string cpf, string genero, DateTime dataNascimento, string email)
        {
            Id = 0;
            Nome = nome;
            Endereco = endereco;
            CPF = cpf;
            Genero = genero;
            DataNascimento = dataNascimento;
            Email = email;
            Mensagens = new List<string>();
        }

        public bool Validar()
        {
            Mensagens.Clear();

            if (string.IsNullOrWhiteSpace(Nome) || Nome.Length > 100)
            {
                Mensagens.Add("Nome é inválido.");
            }

            if (string.IsNullOrWhiteSpace(Endereco) || Endereco.Length > 500)
            {
                Mensagens.Add("Endereco é inválido.");
            }

            if (string.IsNullOrWhiteSpace(CPF) || CPF.Length != 11)
            {
                Mensagens.Add("CPF é inválido.");
            }

            if (string.IsNullOrWhiteSpace(Genero))
            {
                Mensagens.Add("Genero é inválido.");
            }

            if (string.IsNullOrWhiteSpace(Email) || EmailInvalido() || Email.Length > 100)
            {
                Mensagens.Add("Email é inválido.");
            }

            return Mensagens.Count == 0;
        }

        private bool EmailInvalido()
        {
            Regex rg = new Regex(@"^[A-Za-z0-9](([_\.\-]?[a-zA-Z0-9]+)*)@([A-Za-z0-9]+)(([\.\-]?[a-zA-Z0-9]+)*)\.([A-Za-z]{2,})$");

            if (rg.IsMatch(Email))
            {
                return false;
            }
            return true;
        }
    }
}
