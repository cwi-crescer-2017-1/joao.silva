using CWI.EditoraCresccer.Entidades;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CWI.EditoraCresccer.Repositorios
{
    public class RevisorRepositorio
    {
        private Contexto contexto = new Contexto();

        public List<Revisor> ObterTodos()
        {
            return contexto.Revisores.ToList();
        }
        public Revisor ObterPorId(int id)
        {
            Revisor revisor = contexto.Revisores.FirstOrDefault(x => x.Id == id);
            contexto.Revisores.Add(revisor);
            contexto.SaveChanges();
            return revisor;
        }
        public void Criar(Revisor revisor)
        {
            contexto.Revisores.Add(revisor);
            contexto.SaveChanges();
        }
        public void Delete(int revisorId)
        {
            Revisor revisor = contexto.Revisores.FirstOrDefault(x => x.Id == revisorId);
            contexto.Revisores.Remove(revisor);
            contexto.SaveChanges();
        }
        public Revisor Modificar(int id, Revisor revisorModificado)
        {
            Revisor revisor = contexto.Revisores.FirstOrDefault(x => x.Id == id);
            contexto.Entry(revisorModificado).State = EntityState.Modified; //Se der erro trocar por Livro
            contexto.SaveChanges();
            return contexto.Revisores.FirstOrDefault(x => x.Id == id);
        }
    }
}
