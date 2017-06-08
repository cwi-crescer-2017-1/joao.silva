using ProdutoraCrescer.Infraestrutura.Repositorio;
using System.Net.Http;
using System.Threading;
using System.Web.Http;
using ProdutoraCrescer.Api.App_Start;
using System.Collections.Generic;

namespace ProdutoraCrescer.Api.Controllers
{
    [AllowAnonymous]
    [RoutePrefix("api/usuario")]
    public class UsuarioController : ControllerBasica
    {
        readonly UsuarioRepositorio repositorio;

        public UsuarioController()
        {
            repositorio = new UsuarioRepositorio();
        }

        [HttpPost, BasicAuthorization(Roles = "Gerente")]
        [Route("registrar")]
        public HttpResponseMessage Post(dynamic usuario) //Nome,Senha,Email,Cargo
        {
            List<string> resposta = repositorio.Criar(usuario);
            if (resposta == null)
            {
                return ResponderOK(resposta);
            }
            else
            {
                return ResponderErro(null);
            }
        }

        [HttpGet, BasicAuthorization]
        [Route()]
        public HttpResponseMessage Obter()
        {
            var usuario = repositorio.Obter(Thread.CurrentPrincipal.Identity.Name);

            if (usuario == null)
            {
                return ResponderErro("Usuário não encontrado.");
            }
            return ResponderOK(new { usuario.Id, usuario.Nome, usuario.Permissao, usuario.Email });
        }
    }
}