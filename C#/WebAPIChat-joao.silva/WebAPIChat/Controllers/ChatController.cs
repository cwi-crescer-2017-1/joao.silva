using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Net.Http.Headers;
using System.Text.RegularExpressions;
using System.Web.Http;
using WebAPIChat.Exceptions;
using WebAPIChat.Models;

namespace WebAPIChat.Controllers
{
    public class ChatController : ApiController
    {
        private static List<Mensagem> mensagens = new List<Mensagem>();
        private static object @lock = new object();
        public List<Mensagem> Get()
        {
            if (mensagens.Count() > 20) {
                List<Mensagem> listaRetorno = new List<Mensagem>();
                for (var i = mensagens.Count() - 1; i > mensagens.Count - 20; i--)
                {
                    listaRetorno.Add(mensagens[i]);
                }
                return listaRetorno;
            }
            return mensagens;
        }

        public bool Post(string texto,string nomeRemetente,int idRemetente,string imgRemetente)
        {
            lock (@lock)
            {
                if(imgRemetente == "")
                {
                    imgRemetente = "http://www.guiaconfia.com/img/usuario/sin_img.jpg";
                }
                var textoAprimorado = ProcurarNunes(texto);
                Mensagem mensagem = new Mensagem(textoAprimorado, new InformacoesUsuario(nomeRemetente, idRemetente, imgRemetente));
                mensagens.Add(mensagem);
                return true;
            }
        }
        public string ProcurarNunes(string texto)
        {
            if (texto != null)
            {
                string pattern = @"Nunes";
                string replacement = "$$$$$$$$$ $$$$$$$$$";
                string textoAprimorado = Regex.Replace(texto, pattern, replacement, RegexOptions.IgnoreCase);
                return textoAprimorado;
            }
            return texto;
        }
    }
}