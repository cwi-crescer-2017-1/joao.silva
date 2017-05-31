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

        [HttpGet]
        public IHttpActionResult Get()
        {
            var autores = repositorio.Obter();

            return Ok(new{dados= autores});
        }
        public void Post(Autor autor)
        {
            repositorio.Criar(autor);
        }
        [Route("{idAutor:int}")]
        public void Remove(int idAutor)
        {
            repositorio.Delete(idAutor);
        }
    }
}