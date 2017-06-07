using ProdutoraCrescer.Api.App_Start;
using ProdutoraCrescer.Dominio.Entidades;
using ProdutoraCrescer.Infraestrutura.Repositorio;
using System.Collections.Generic;
using System.Net.Http;
using System.Web.Http;

namespace ProdutoraCrescer.Api.Controllers
{
    [AllowAnonymous]
    [RoutePrefix("api/pacote")]
    public class PacoteController : ControllerBasica
    {
        readonly PacoteRepositorio repositorio;

        public PacoteController()
        {
            repositorio = new PacoteRepositorio();
        }

        [HttpGet, BasicAuthorization]
        [Route()]
        public HttpResponseMessage ObterLista()
        {
            List<Pacote> pacotes = repositorio.ObterLista();

            return ResponderOK(new { pacotes });
        }

        [HttpGet, BasicAuthorization]
        [Route("{id:int}")]
        public HttpResponseMessage ObterPorId(int id)
        {
            Pacote pacote = repositorio.ObterPorId(id);

            if (pacote == null)
            {
                return ResponderErro("Pacote não encontrado.");
            }
            return ResponderOK(pacote);
        }
    }
}