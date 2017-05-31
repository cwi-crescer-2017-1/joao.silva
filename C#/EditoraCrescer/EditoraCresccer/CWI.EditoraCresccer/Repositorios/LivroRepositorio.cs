using CWI.EditoraCresccer.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CWI.EditoraCresccer.Repositorios
{
    public class LivroRepositorio : IDisposable
    {
        private Contexto contexto;

        public LivroRepositorio(){
            contexto = new Contexto();
        }

        public List<Livro> Obter()
        {
            return contexto.Livros.ToList();
        }
        public void Criar(Livro livro)
        {
            contexto.Livros.Add(livro);
            contexto.SaveChanges();
        }
        public void Delete(int isbn)
        {
            Livro livro = contexto.Livros.FirstOrDefault(x => x.Isbn == isbn);
            contexto.Livros.Remove(livro);
            contexto.SaveChanges();
        }
        protected override void Dispose(bool disposing)
        {
            contexto.Dispose();
            base.Dispose(disposing);
        }
    }
}
