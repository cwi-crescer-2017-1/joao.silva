using CWI.EditoraCresccer.Entidades;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CWI.EditoraCresccer.Repositorios
{
    public class RevisorRepositorio : IDisposable
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
            if (revisor != null)
            {
                contexto.Revisores.Remove(revisor);
                contexto.SaveChanges();
            }
            
        }
        public Revisor Modificar(int id, Revisor revisor)
        {
            contexto.Entry(revisor).State = EntityState.Modified;
            contexto.SaveChanges();
            return contexto.Revisores.FirstOrDefault(x => x.Id == id);
        }
        public void Dispose()
        {
            contexto.Dispose();
        }
    }
}
