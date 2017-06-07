using ProdutoraCrescer.Api.App_Start;
using ProdutoraCrescer.Dominio.Entidades;
using ProdutoraCrescer.Infraestrutura.Repositorio;
using System.Collections.Generic;
using System.Net.Http;
using System.Web.Http;

namespace ProdutoraCrescer.Api.Controllers
{
    [AllowAnonymous]
    [RoutePrefix("api/festa")]
    public class FestaController : ControllerBasica
    {
        readonly FestaRepositorio repositorio;

        public FestaController()
        {
            repositorio = new FestaRepositorio();
        }

        [HttpGet, BasicAuthorization]
        [Route()]
        public HttpResponseMessage ObterLista()
        {
            List<Festa> festas = repositorio.ObterLista();

            return ResponderOK(new { festas });
        }

        [HttpGet, BasicAuthorization]
        [Route("{id:int}")]
        public HttpResponseMessage ObterPorId(int id)
        {
            Festa festa = repositorio.ObterPorId(id);

            if (festa == null)
            {
                return ResponderErro("Festa não encontrada.");
            }
            return ResponderOK(festa);
        }
    }
}