using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Net.Http.Headers;
using System.Web.Http;
using WebAPIChat.Models;

namespace WebAPIChat.Controllers
{
    public class ChatController
    {
        private static List<Mensagem> mensagens = new List<Mensagem>();
        private static List<Usuario> usuarios = new List<Usuario>();
    }
}