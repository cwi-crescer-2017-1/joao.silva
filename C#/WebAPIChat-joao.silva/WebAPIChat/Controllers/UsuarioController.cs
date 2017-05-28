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

        public string Get(string nome, string senha)
        {
            Usuario usuario = encontrarUsuarioPorNome(nome);
            if (usuario != null)
            {
                if (senhaCorreta(usuario, senha))
                {
                    return usuario.Nome;
                }
            }
            return null;
        }

        public IHttpActionResult Post(string nome, string senha)
        {
            Usuario usuario = encontrarUsuarioPorNome(nome);
            if(usuario == null)
            {
                lock (@lock)
                {
                    Usuario novoUsuario = new Usuario(nome, senha);
                    usuarios.Add(usuario);

                }
                return Ok();
            }
            else
            {
                return BadRequest();
            }
        }

        private IHttpActionResult Ok(object novoUsuario)
        {
            throw new NotImplementedException();
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
        public Usuario encontrarUsuarioPorNome(string nome)
        {
            foreach (Usuario usuario in usuarios)
            {
                if (usuario.Nome == nome)
                {
                    return usuario;
                }
            }
            return null;
        }
    }
}