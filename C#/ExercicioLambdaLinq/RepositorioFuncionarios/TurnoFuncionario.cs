using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Repositorio
{
    class TurnoFuncionarios
    {

        public TurnoFuncionarios(TurnoTrabalho turno, List<int> funcionarios)
        {
            Turno = turno;
            Funcionarios = funcionarios;
        }

        public TurnoTrabalho Turno { get; private set; }
        public List<int> Funcionarios { get; set; }
        public int Quantidade { get { return Funcionarios.Count; }}
    }
}
