using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace WebAPIChat.Exceptions
{
    public class UsuarioJaExisteException : Exception
    {
        public UsuarioJaExisteException() : base("Esse usuário já existe!")
        {
        }
    }
}