using CWI.EditoraCresccer.Entidades;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CWI.EditoraCresccer.Repositorios
{
    public class LivroRepositorio : IDisposable
    {
        private Contexto contexto = new Contexto();

        
        public object ObterTodos()
        {
            return contexto.Livros
                            .Select(livro => new
                            {
                                Isbn = livro.Isbn,
                                Titulo = livro.Titulo,
                                NomeAutor = livro.Autor.Nome,
                                Genero = livro.Genero,
                                Capa = livro.Capa
                            }).ToList();
        }
        public Livro ObterPorIsbn(int isbn)
        {
            Livro livro = contexto.Livros.FirstOrDefault(x => x.Isbn == isbn);
            contexto.Livros.Add(livro);
            contexto.SaveChanges();
            return livro;
        }
        public object ObterPorGenero(string genero)
        {
            List<Livro> livros = contexto.Livros.Where(x => x.Genero == genero).ToList();
            return livros
                     .Select(livro => new
                     {
                         Isbn = livro.Isbn,
                         Titulo = livro.Titulo,
                         NomeAutor = livro.Autor.Nome,
                         Genero = livro.Genero,
                         Capa = livro.Capa
                     }).ToList();
        }
        public object ObterLancamentos()
        {
            List<Livro> livros = contexto.Livros.Where(livro => DbFunctions.DiffDays(livro.DataPublicacao, DateTime.Now) <= 7).ToList();
            livros
                            .Select(livro => new
                            {
                                Isbn = livro.Isbn,
                                Titulo = livro.Titulo,
                                NomeAutor = livro.Autor.Nome,
                                Genero = livro.Genero,
                                Capa = livro.Capa
                            }).ToList();
            return livros;
        }
        public List<Livro> ObterPorAutor(int idAutor)
        {
            List<Livro> livros = contexto.Livros.Where(x => x.Autor.Id == idAutor).ToList();
            return livros;
        }
        public List<Livro> ObterListaLimitada(int quantidade, int skip)
        {
            List<Livro> livros;
            livros = contexto.Livros.
                OrderBy(x => x.Isbn)
                .Skip(skip)
                .Take(quantidade)
                .Include(l => l.Autor)
                .Include(r => r.Revisor)
                .ToList();

            return livros;
        }
        public Livro Criar(Livro livro)
        {
            contexto.Livros.Add(livro);
            livro.Autor = contexto.Autores.FirstOrDefault(x => x.Id == livro.IdAutor);
            livro.Revisor = contexto.Revisores.FirstOrDefault(x => x.Id == livro.IdRevisor);
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
        public Livro Modificar(int isbn, Livro livro)
        {
            //Livro livro = contexto.Livros.FirstOrDefault(x => x.Isbn == isbn);
            contexto.Entry(livro).State = EntityState.Modified;
            contexto.SaveChanges();
            return contexto.Livros.FirstOrDefault(x => x.Isbn == isbn);
        }
        public void Dispose()
        {
            contexto.Dispose();
        }
    }
}
