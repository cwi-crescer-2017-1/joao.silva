using CWI.EditoraCresccer.Entidades;
using CWI.EditoraCresccer.Repositorios;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Http;

namespace EditoraCrescer.Api.Controllers
{
    [RoutePrefix("api/Livros")]
    public class LivrosController : ApiController
    {
        private readonly LivroRepositorio repositorio = new LivroRepositorio();

        [HttpGet]
        public IHttpActionResult Get()
        {
            var livros = repositorio.Obter();

            return Ok(new { dados = livros });
        }
        public void Post(Livro livro)
        {
            repositorio.Criar(livro);
        }
        [Route("{idLivro:int}")]
        public void Remove(int idLivro)
        {
            repositorio.Delete(idLivro);
        }

        protected override void Dispose(bool disposing)
        {
            repositorio.Dispose();
            base.Dispose(disposing);
        }
    }
}