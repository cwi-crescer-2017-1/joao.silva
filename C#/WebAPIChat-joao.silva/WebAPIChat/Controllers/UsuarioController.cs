using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Http;
using WebAPIChat.Exceptions;
using WebAPIChat.Models;

namespace WebAPIChat.Controllers
{
    public class UsuarioController : ApiController
    {
        private static List<Usuario> usuarios = new List<Usuario>();
        private static object @lock = new object();

        public Usuario Get(string nomeDeUsuario, string senha)
        {
            Usuario usuario = encontrarUsuarioPorNomeDeUsuario(nomeDeUsuario);
            if (usuario!=null)
            {
                if (senhaCorreta(usuario, senha))
                {
                    return usuario;
                }
            }
            return null;
        }

        public bool Post(string nomeDeUsuario,string nome, string senha, string imgUrl)
        {
            if(nomeDeUsuarioJaExiste(nomeDeUsuario))
            {
                return false;
            }
            else
            {
                lock (@lock)
                {
                    Usuario novoUsuario = new Usuario(nomeDeUsuario, nome, senha, imgUrl);
                    usuarios.Add(novoUsuario);
                }
                return true;
            }
        }

        private IHttpActionResult Ok()
        {
            throw new OkException();
        }

        private IHttpActionResult BadRequest()
        {
            throw new UsuarioJaExisteException();
        }

        public bool senhaCorreta(Usuario usuario, string senha)
        {
            if (usuario.VerificarSenha(senha))
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        public bool nomeDeUsuarioJaExiste(string nomeDeUsuario)
        {
            foreach (Usuario usuario in usuarios)
            {
                if (usuario.NomeDeUsuario == nomeDeUsuario)
                {
                    return true;
                }
            }
            return false;
        }
        public Usuario encontrarUsuarioPorNomeDeUsuario(string nomeDeUsuario)
        {
            foreach (Usuario usuario in usuarios)
            {
                if (usuario.NomeDeUsuario == nomeDeUsuario)
                {
                    return usuario;
                }
            }
            return null;
        }
    }
}