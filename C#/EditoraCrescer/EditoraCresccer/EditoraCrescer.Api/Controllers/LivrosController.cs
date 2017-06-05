using CWI.EditoraCresccer.Entidades;
using CWI.EditoraCresccer.Repositorios;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Http;

namespace EditoraCrescer.Api.Controllers
{
    [AllowAnonymous]
    [RoutePrefix("api/livros")]
    public class LivrosController : ApiController
    {
        private readonly LivroRepositorio repositorio = new LivroRepositorio();

        [HttpGet]
        [Route("publicados")]
        public IHttpActionResult GetTodosPublicados()
        {
            var livros = repositorio.ObterTodosPublicados();
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
        [HttpGet]
        [Route("Lancamentos")]
        public IHttpActionResult GetLancamentos()
        {
            var livros = repositorio.ObterLancamentos();

            return Ok(new { dados = livros });
        }
        [HttpGet]
        [Route("ListaLimitada/{quantidade}/{skip}")]
        public IHttpActionResult GetListaLimitada(int quantidade, int skip)
        {
            var livros = repositorio.ObterListaLimitada(quantidade, skip);
            return Ok(new { dados = livros });
        }
        [BasicAuthorization]
        [HttpPost]
        [Route()]
        public IHttpActionResult Post(Livro livro)
        {
            Livro retorno = repositorio.Criar(livro);
            return Ok(new { dados = retorno });
        }
        [BasicAuthorization]
        [HttpGet]
        [Route()]
        public IHttpActionResult GetTodos()
        {
            var livros = repositorio.ObterTodos();
            return Ok(new { dados = livros });
        }
        [BasicAuthorization]
        [HttpGet]
        [Route("ListaLimitadaCompleta/{quantidade}/{skip}")]
        public IHttpActionResult GetListaLimitadaCompleta(int quantidade, int skip)
        {
            var livros = repositorio.ObterListaLimitadaCompleta(quantidade, skip);
            return Ok(new { dados = livros });
        }
        [HttpDelete, BasicAuthorization(Roles = "Administrador")]
        [Route("{isbn:int}")]
        public IHttpActionResult Delete(int isbn)
        {
            Livro retorno = repositorio.Delete(isbn);
            return Ok(new {dados = retorno});
        }
        [HttpPut, BasicAuthorization(Roles = "Administrador,Revisor")]
        [Route("revisar/{idRevisor:int}/{isbn:int}")]
        public IHttpActionResult RevisarLivro(int idRevisor, int isbn)
        {
             Livro retorno = repositorio.RevisarLivro(idRevisor, isbn);
             return Ok(new { dados = retorno });
        }
        [HttpPut, BasicAuthorization(Roles = "Administrador,Publicador")]
        [Route("publicar/{isbn:int}")]
        public IHttpActionResult PublicarLivro(int isbn)
        {
            Livro retorno = repositorio.PublicarLivro(isbn);
            return Ok(new { dados = retorno });
        }
        [HttpPut, BasicAuthorization(Roles = "Administrador,Publicador")]
        [Route("novaRevisao/{isbn:int}")]
        public IHttpActionResult PedirNovaRevisao(int isbn)
        {
            Livro retorno = repositorio.PedirNovaRevisao(isbn);
            return Ok(new { dados = retorno });
        }
        [HttpPut, BasicAuthorization(Roles = "Administrador,Revisor,Publicador")]
        [Route("{isbn:int}")]
        public IHttpActionResult Put(int isbn,Livro livro)
        {
            if(livro!=null && livro.Isbn == isbn)
            {
                Livro retorno = repositorio.Modificar(isbn, livro);
                return Ok(new { dados = retorno });
            }
            else
            {
                return BadRequest("O isbn a ser modificado não corresponde ao isbn do objeto modificado");
            }
        }
        protected override void Dispose(bool disposing)
        {
            repositorio.Dispose();
            base.Dispose(disposing);
        }
    }
}