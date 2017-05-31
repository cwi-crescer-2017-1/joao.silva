using CWI.EditoraCresccer.Entidades;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CWI.EditoraCresccer.Repositorios
{
    public class LivroRepositorio
    {
        private Contexto contexto = new Contexto();

        public List<Livro> ObterTodos()
        {
            return contexto.Livros.ToList();
        }
        public Livro ObterPorIsbn(int isbn)
        {
            Livro livro = contexto.Livros.FirstOrDefault(x => x.Isbn == isbn);
            contexto.Livros.Add(livro);
            contexto.SaveChanges();
            return livro;
        }
        public List<Livro> ObterPorGenero(string genero)
        {
            List<Livro> livros = contexto.Livros.Where(x => x.Genero == genero).ToList();
            return livros;
        }
        public List<Livro> ObterPorAutor(int idAutor)
        {
            List<Livro> livros = contexto.Livros.Where(x => x.Autor.Id == idAutor).ToList();
            return livros;
        }
        public Livro Criar(Livro livro)
        {
            contexto.Livros.Add(livro);
            contexto.SaveChanges();
            return livro;
        }
        public Livro Delete(int isbn)
        {
            Livro livro = contexto.Livros.FirstOrDefault(x => x.Isbn == isbn);
            contexto.Livros.Remove(livro);
            contexto.SaveChanges();
            return livro;
        }
        public Livro Modificar(int isbn, Livro livroModificado)
        {
            Livro livro = contexto.Livros.FirstOrDefault(x => x.Isbn == isbn);
            contexto.Entry(livroModificado).State = EntityState.Modified; //Se der erro trocar por Livro
            contexto.SaveChanges();
            return contexto.Livros.FirstOrDefault(x=>x.Isbn == isbn);
        }
        //protected override void Dispose(bool disposing)
        //{
        //    contexto.Dispose();
        //    base.Dispose(disposing);
        //}
    }
}
