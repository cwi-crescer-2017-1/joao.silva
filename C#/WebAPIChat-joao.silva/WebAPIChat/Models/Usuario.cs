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
        public string NomeDeUsuario { get; private set; }
        private string Senha { get; set; }
        public string ImgUrl { get; set; }

        private static int id = 0;

        public Usuario(string nomeDeUsuario,string nome, string senha, string imgUrl)
        {
            Id = id++;
            NomeDeUsuario = nomeDeUsuario;
            Nome = nome;
            Senha = senha;
            ImgUrl = imgUrl;
        }

        public bool VerificarSenha(string senha)
        {
            var comparacao = String.Compare(senha, this.Senha,false);
            return comparacao == 0 && true;
        }

        public bool mudarNome(string senha, string novoNome)
        {
            if (VerificarSenha(senha))
            {
                this.Nome = novoNome;
                return true;
            }
            else
            {
                return false;
            }
        }
        public bool mudarImg(string senha, string url)
        {
            if (VerificarSenha(senha))
            {
                this.ImgUrl = url;
                return true;
            }
            else
            {
                return false;
            }
        }
    }
}