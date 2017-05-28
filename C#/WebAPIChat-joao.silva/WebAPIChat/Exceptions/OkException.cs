using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace WebAPIChat.Exceptions
{
    public class OkException : Exception
    {
        public OkException() : base("Conta criada com sucesso!")
        {
        }
    }
}