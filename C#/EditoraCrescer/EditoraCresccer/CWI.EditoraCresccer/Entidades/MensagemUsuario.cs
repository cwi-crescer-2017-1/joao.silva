using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;

namespace CWI.EditoraCresccer.Entidades
{
    public class MensagemUsuario
    {
        public Usuario Usuario { get; set; }
        public List<string> Mensagens { get; set; }
        public bool Resultado { get; set; }

        public MensagemUsuario(Usuario usuario, List<string> mensagens, bool resultado)
        {
            Usuario = usuario;
            Mensagens = mensagens;
            Resultado = resultado;
        }
    }
}