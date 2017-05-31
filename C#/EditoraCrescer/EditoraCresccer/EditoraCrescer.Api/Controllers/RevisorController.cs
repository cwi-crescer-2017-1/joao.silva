using CWI.EditoraCresccer.Repositorios;
using CWI.EditoraCresccer.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Http;

namespace EditoraCrescer.Api.Controllers
{
    [RoutePrefix("api/Revisor")]
    public class RevisorController : ApiController
    {
        private RevisorRepositorio repositorio = new RevisorRepositorio();

        [HttpGet]
        [Route()]
        public IHttpActionResult Get()
        {
            var revisores = repositorio.Obter();

            return Ok(new { dados = revisores });
        }

        [HttpPost]
        [Route()]
        public void Post(Revisor revisor)
        {
            repositorio.Criar(revisor);
        }

        [HttpDelete]
        [Route("{idRevisor:int}")]
        public void Remove(int idRevisor)
        {
            repositorio.Delete(idRevisor);
        }
    }
}