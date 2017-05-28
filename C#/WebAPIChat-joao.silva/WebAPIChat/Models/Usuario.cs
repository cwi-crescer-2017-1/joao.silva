using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace WebAPIChat.Models
{
    public class Usuario
    {
        public int Id { get; private set; }
        public string Nome { get; private set; }
        private string Senha { get; set; }

        private static int id = 0;

        public Usuario(string nome, string senha)
        {
            this.Id = id++;
            this.Nome = nome;
            this.Senha = senha;
        }

        public bool VerificarSenha(string senha)
        {
            var comparacao = String.Compare(senha, this.Senha,false);
            return comparacao == 0 && true;
        }

        public bool mudarNomeUsuario(string nome, string senha)
        {
            if (VerificarSenha(senha))
            {
                this.Nome = nome;
                return true;
            }
            else
            {
                return false;
            }
        }
    }
}