using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Repositorio
{
    class FuncionarioResumido
    {
        public string NomeFuncionario { get; private set; }
        public string TituloCargo { get; set; }

        public FuncionarioResumido(string nomeFuncionario, string tituloCargo)
        {
            this.NomeFuncionario = nomeFuncionario;
            this.TituloCargo = tituloCargo;
        }
    }
}
