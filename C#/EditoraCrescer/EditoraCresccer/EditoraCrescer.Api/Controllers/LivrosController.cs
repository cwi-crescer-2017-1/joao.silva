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
        [Route()]
        public IHttpActionResult GetTodos()
        {
            var livros = repositorio.ObterTodos();
            return Ok(new { dados = livros });
        }
        [HttpGet]
        [Route("{isbn:int}")]
        public IHttpActionResult GetPorISBN(int isbn)
        {
            var livro = repositorio.ObterPorIsbn(isbn);

            return Ok(new { dados = livro });
        }
        [HttpGet]
        [Route("{genero}")]
        public IHttpActionResult GetPorGenero(string genero)
        {
            var livros = repositorio.ObterPorGenero(genero);

            return Ok(new { dados = livros });
        }
        [HttpPost]
        [Route()]
        public IHttpActionResult Post(Livro livro)
        {
            Livro retorno = repositorio.Criar(livro);
            return Ok(new { dados = retorno });
        }
        [HttpDelete]
        [Route("{isbn:int}")]
        public IHttpActionResult Delete(int isbn)
        {
            Livro retorno = repositorio.Delete(isbn);
            return Ok(new {dados = retorno});
        }
        [HttpPut]
        [Route("{isbn:int}")]
        public IHttpActionResult Put(int isbn,Livro livro)
        {
            if(livro.Isbn == isbn)
            {
                Livro retorno = repositorio.Modificar(isbn, livro);
                return Ok(new { dados = retorno });
            }
            else
            {
                return BadRequest("O isbn a ser modificado não corresponde ao isbn do objeto modificado");
            }
        }


        //protected override void Dispose(bool disposing)
        //{
        //    repositorio.Dispose();
        //    base.Dispose(disposing);
        //}
    }
}