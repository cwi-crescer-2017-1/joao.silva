using CWI.EditoraCresccer.Entidades;
using CWI.EditoraCresccer.Repositorios;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Http;

namespace EditoraCrescer.Api.Controllers
{
    [RoutePrefix("api/Autores")]
    public class AutoresController : ApiController
    {
        private AutorRepositorio repositorio = new AutorRepositorio();
        private LivroRepositorio repositorioLivro = new LivroRepositorio();
        [HttpGet]
        [Route()]
        public IHttpActionResult GetTodosAutores()
        {
            var autores = repositorio.ObterTodos();

            return Ok(new{dados= autores});
        }
        [HttpGet]
        [Route("{id:int}")]
        public IHttpActionResult GetAutorPorId(int id)
        {
            var autor = repositorio.ObterPorId(id);
            return Ok(new { dados = autor });
        }
        [HttpGet]
        [Route("{id:int}/Livros")]
        public IHttpActionResult GetLivrosPorAutor(int id)
        {
            var livros = repositorioLivro.ObterPorAutor(id);
            return Ok(new { dados = livros });
        }
        [HttpPost]
        [Route()]
        public void Post(Autor autor)
        {
            repositorio.Criar(autor);
        }
        [HttpDelete]
        [Route("{idAutor:int}")]
        public void Delete(int idAutor)
        {
            repositorio.Remover(idAutor);

        }
        [HttpPut]
        [Route("{id:int}")]
        public IHttpActionResult Put(int id, Autor autor)
        {
            if (autor.Id == id)
            {
                Autor autorNovo = repositorio.Modificar(id, autor);
                return Ok(new { dados = autor });
            }
            else
            {
                return BadRequest("O id a ser modificado não corresponde ao id do objeto modificado");
            }
        }
        protected override void Dispose(bool disposing)
        {
            repositorio.Dispose();
            repositorioLivro.Dispose();
            base.Dispose(disposing);
        }
    }
}