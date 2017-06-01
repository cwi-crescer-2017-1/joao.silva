using CWI.EditoraCresccer.Repositorios;
using CWI.EditoraCresccer.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Http;

namespace EditoraCrescer.Api.Controllers
{
    [RoutePrefix("api/Revisor/")]
    public class RevisorController : ApiController
    {
        private RevisorRepositorio repositorio = new RevisorRepositorio();

        [HttpGet]
        [Route()]
        public IHttpActionResult GetTodos()
        {
            var revisores = repositorio.ObterTodos();

            return Ok(new { dados = revisores });
        }

        [HttpGet]
        [Route("{id:int}")]
        public IHttpActionResult GetAutorPorId(int id)
        {
            var revisor = repositorio.ObterPorId(id);
            return Ok(new { dados = revisor });
        }

        [HttpPost]
        [Route()]
        public void Post(Revisor revisor)
        {
            repositorio.Criar(revisor);
        }

        [HttpPut]
        [Route("{id:int}")]
        public IHttpActionResult Put(int id, Revisor revisor)
        {
            if (revisor.Id == id)
            {
                Revisor revisorNovo = repositorio.Modificar(id, revisor);
                return Ok(new { dados = revisorNovo });
            }
            else
            {
                return BadRequest("O id a ser modificado não corresponde ao id do objeto modificado");
            }
        }

        [HttpDelete]
        [Route("{idRevisor:int}")]
        public void Remove(int idRevisor)
        {
            repositorio.Delete(idRevisor);
        }
    }
}