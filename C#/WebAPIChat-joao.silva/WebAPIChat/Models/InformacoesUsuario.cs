using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace WebAPIChat.Models
{
    public class InformacoesUsuario
    {
        public string Nome { get; private set; }
        public int Id { get; private set; }
        public string ImgUrl { get; set; }
        public InformacoesUsuario(string nome,int id, string imgUrl)
        {
            Nome = nome;
            Id = id;
            ImgUrl = imgUrl;
        }
    }
}