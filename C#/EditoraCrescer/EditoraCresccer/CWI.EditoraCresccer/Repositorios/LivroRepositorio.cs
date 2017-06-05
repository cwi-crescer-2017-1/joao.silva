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
        private Contexto contextoTeste = new Contexto();

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
        public object ObterTodosPublicados()
        {
            return contexto.Livros
                            .Where(livro=> livro.DataPublicacao != null)
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
            return contexto.Livros
                     .Where(x => x.Genero == genero)
                     .Where(livro => livro.DataPublicacao != null)
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
            DateTime dataLimiteLancamentos = DateTime.Now.AddDays(-7);
            return contexto.Livros
                    .Where(livro => livro.DataPublicacao != null && livro.DataPublicacao >= dataLimiteLancamentos)
                    .Select(livro => new
                    {
                        Isbn = livro.Isbn,
                        Titulo = livro.Titulo,
                        NomeAutor = livro.Autor.Nome,
                        Genero = livro.Genero,
                        Capa = livro.Capa
                    }).ToList();
        }
        public List<Livro> ObterPorAutor(int idAutor)
        {
            List<Livro> livros = contexto.Livros.Where(x => x.Autor.Id == idAutor).ToList();
            return livros;
        }
        public dynamic ObterListaLimitada(int quantidade, int skip)
        {
            var livros = contexto.Livros
                .Where(livro => livro.DataPublicacao != null)
                .OrderBy(x => x.Isbn)
                .Skip(skip)
                .Take(quantidade)
                .Include(l => l.Autor)
                .Include(r => r.Revisor);

            return new { livros = livros.ToList(), quantidade = contexto.Livros.Count() };
        }      
        public dynamic ObterListaLimitadaCompleta(int quantidade, int skip)
        {
            var livros = contexto.Livros
                .OrderBy(x => x.Isbn)
                .Skip(skip)
                .Take(quantidade)
                .Include(l => l.Autor)
                .Include(r => r.Revisor);

            return new { livros = livros.ToList(), quantidade = contexto.Livros.Count() };
        }
        public Livro Criar(Livro livro)
        {
            bool livroJaCadastrado = contexto.Livros.FirstOrDefault(l => l.Isbn == livro.Isbn) != null;
            if (livroJaCadastrado)
            {
                return null;
            }
            contexto.Livros.Add(livro);
            livro.Autor = contexto.Autores.FirstOrDefault(x => x.Id == livro.IdAutor);
            contexto.SaveChanges();
            return livro;
        }
        public Livro RevisarLivro(int idRevisor, int isbn)
        {
            Livro livro = contexto.Livros.FirstOrDefault(x => x.Isbn == isbn);
            Usuario revisor = contexto.Usuarios.FirstOrDefault(u => u.Id == idRevisor);
            bool livroExiste = livro != null;
            bool revisorExiste = revisor != null;
            if (livroExiste && revisorExiste)
            {         
                livro.IdRevisor = revisor.Id;
                livro.DataRevisao = DateTime.Now;
                contexto.Entry(livro).State = EntityState.Modified;
                contexto.SaveChanges();
                return livro;
            }
            return null;
        }
        public Livro PublicarLivro(int isbn)
        {
            Livro livro = contexto.Livros.FirstOrDefault(x => x.Isbn == isbn);
            bool livroExiste = livro != null;
            if (livroExiste)
            {
                if(livro.IdRevisor != null && livro.DataRevisao != null)
                {
                    livro.DataPublicacao = DateTime.Now;
                    contexto.Entry(livro).State = EntityState.Modified;
                    contexto.SaveChanges();
                    return livro;
                }
                return null;
            }
            return null;
        }
        public Livro PedirNovaRevisao(int isbn)
        {
            Livro livro = contexto.Livros.FirstOrDefault(x => x.Isbn == isbn);
            bool livroExiste = livro != null;
            if (livroExiste)
            {
                livro.IdRevisor = null;
                livro.DataRevisao = null;
                contexto.Entry(livro).State = EntityState.Modified;
                contexto.SaveChanges();
                return livro;
            }
            return null;
        }
        public Livro Delete(int isbn)
        {
            Livro livro = contexto.Livros.FirstOrDefault(x => x.Isbn == isbn);
            if (livro != null)
            {
                contexto.Livros.Remove(livro);
                contexto.SaveChanges();
                return livro;
            }
            return null;
        }
        public Livro Modificar(int isbn, Livro livro)
        {
            bool livroNaoExiste = contextoTeste.Livros.FirstOrDefault(l => l.Isbn == livro.Isbn) == null;
            if (livroNaoExiste)
            {
                return null;
            }
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
