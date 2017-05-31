using CWI.EditoraCresccer.Entidades;
using CWI.EditoraCresccer.Repositorios;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Http;

namespace EditoraCrescer.Api.Controllers
{
    public class LivrosController : ApiController
    {
        private LivroRepositorio repositorio = new LivroRepositorio();

        public IHttpActionResult Get()
        {
            var livros = repositorio.Obter();

            return Ok(livros);
        }
        public void Post(Livro livro)
        {
            repositorio.Criar(livro);
        }
        public void Remove(int idLivro)
        {
            repositorio.Delete(idLivro);
        }
    }
}