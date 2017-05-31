using CWI.EditoraCresccer.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CWI.EditoraCresccer.Repositorios
{
    class RevisorRepositorio
    {
        private Contexto contexto = new Contexto();

        public RevisorRepositorio()
        {
        }
        public List<Revisor> Obter()
        {
            return contexto.Revisores.ToList();
        }
        //POST   api/Livros (apenas cria, não altera)
        public void Criar(Revisor revisor)
        {
            contexto.Revisores.Add(revisor);
            contexto.SaveChanges();
        }
        public void Delete(int revisorId)
        {
            Revisor revisor = (contexto.Revisores.Where(x => x.Id == revisorId)).FirstOrDefault();
            contexto.Revisores.Remove(revisor);
            contexto.SaveChanges();
        }
    }
}
