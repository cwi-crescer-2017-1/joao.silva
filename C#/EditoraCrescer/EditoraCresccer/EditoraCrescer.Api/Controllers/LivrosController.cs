using CWI.EditoraCresccer;
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

    }
}