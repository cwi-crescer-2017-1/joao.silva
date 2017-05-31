using CWI.EditoraCresccer.Repositorios;
using CWI.EditoraCresccer.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Http;

namespace EditoraCrescer.Api.Controllers
{
    public class RevisorController : ApiController
    {

        private RevisorRepositorio repositorio = new RevisorRepositorio();

        public IHttpActionResult Get()
        {
            var revisores = repositorio.Obter();

            return Ok(revisores);
        }

        public void Post(Revisor revisor)
        {
            repositorio.Criar(revisor);
        }
        public void Remove(int idRevisor)
        {
            repositorio.Delete(idRevisor);
        }
    }
}