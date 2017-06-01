using CWI.EditoraCresccer;
using CWI.EditoraCresccer.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplicationTeste
{
    class Program
    {
        static void Main(string[] args)
        {
            var autor1 = new Autor() { Nome = "Tolkien" };
            // var autor2 = new Autor() { Nome = "Machado de Assis" };
            var revisor1 = new Revisor() { Nome = "Machado de Assis" };
            using (var contexto = new Contexto())
            {
                //Inclusão
                contexto.Autores.Add(autor1);
                contexto.Revisores.Add(revisor1);
                contexto.SaveChanges();

                var livro = new Livro()
                {
                    Autor = autor1,
                    Revisor = revisor1,
                    IdAutor = autor1.Id,
                    IdRevisor = revisor1.Id,
                    Titulo = "O senhor dos anéis",
                    Descricao = "Um livro bem legal",
                    Genero = "Aventura",
                    DataPublicacao = DateTime.Now,
                    DataRevisao = DateTime.Now,
                    Capa = "Capa de alta qualidade"
                };

                contexto.Livros.Add(livro);
                contexto.SaveChanges();
            }
        }
    }
}
