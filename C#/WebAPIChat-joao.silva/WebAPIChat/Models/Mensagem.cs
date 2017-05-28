using System;
using System.Collections.Generic;
using System.Globalization;
using System.Linq;
using System.Web;

namespace WebAPIChat.Models
{
    public class Mensagem
    {
        public string Texto { get; set; }
        public DateTime Horario { get; private set; }
        public int Id { get; private set; }
        public Usuario Remetente { get; private set; }

        private static int id=0;

        public Mensagem(string texto, Usuario remetente)
        {
            this.Id = id++;
            this.Texto = texto;
            this.Remetente = remetente;
            ConfigurarHora();
        }
        private void ConfigurarHora()
        {
            DateTime localDate = DateTime.Now;
            this.Horario = localDate;
        }
        public string HorarioToString()
        {
            return this.Horario
                       .ToString("dd-MM-yyyy HH:mm:ss.fff",CultureInfo.InvariantCulture);
        }
    }
}