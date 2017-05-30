using CWI.EditoraCresccer.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CWI.EditoraCresccer.Repositorios
{
    public class LivroRepositorio
    {
        private Contexto contexto = new Contexto();

        public LivroRepositorio()
        {
        }
        public List<Livro> Obter()
        {
            return contexto.Livros.ToList();
        }
    }
}
