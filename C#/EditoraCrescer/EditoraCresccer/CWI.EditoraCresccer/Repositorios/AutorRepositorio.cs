using CWI.EditoraCresccer.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CWI.EditoraCresccer.Repositorios
{
    public class AutorRepositorio
    {
        private Contexto contexto = new Contexto();

        public AutorRepositorio()
        {
        }
        public List<Autor> Obter()
        {
            return contexto.Autores.ToList();
        }
        public void Criar(Autor autor)
        {
            contexto.Autores.Add(autor);
            contexto.SaveChanges();
        }
        public void Delete(int autorId)
        {
            Autor autor = contexto.Autores.FirstOrDefault(x => x.Id == autorId);
            contexto.Autores.Remove(autor);
            contexto.SaveChanges();
        }
    }
}
