using ProdutoraCrescer.Api.App_Start;
using ProdutoraCrescer.Dominio.Entidades;
using ProdutoraCrescer.Infraestrutura.Repositorio;
using System.Collections.Generic;
using System.Net.Http;
using System.Web.Http;

namespace ProdutoraCrescer.Api.Controllers
{
    [AllowAnonymous]
    [RoutePrefix("api/opcional")]
    public class OpcionalController : ControllerBasica
    {
        readonly OpcionalRepositorio repositorio;

        public OpcionalController()
        {
            repositorio = new OpcionalRepositorio();
        }

        [HttpGet, BasicAuthorization]
        [Route()]
        public HttpResponseMessage ObterLista()
        {
            List<Opcional> opcionais = repositorio.ObterLista();

            return ResponderOK(new { opcionais });
        }

        [HttpGet, BasicAuthorization]
        [Route("{id:int}")]
        public HttpResponseMessage ObterPorId(int id)
        {
            Opcional opcional = repositorio.ObterPorId(id);

            if (opcional == null)
            {
                return ResponderErro("Opcional não encontrado.");
            }
            return ResponderOK(opcional);
        }
    }
}