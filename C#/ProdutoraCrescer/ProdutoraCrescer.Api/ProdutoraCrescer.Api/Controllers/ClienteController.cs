using ProdutoraCrescer.Infraestrutura.Repositorio;
using System.Net.Http;
using System.Threading;
using System.Web.Http;
using ProdutoraCrescer.Api.App_Start;
using System.Collections.Generic;
using ProdutoraCrescer.Dominio.Entidades;

namespace ProdutoraCrescer.Api.Controllers
{
    [AllowAnonymous]
    [RoutePrefix("api/cliente")]
    public class ClienteController : ControllerBasica
    {
        readonly ClienteRepositorio repositorio;

        public ClienteController()
        {
            repositorio = new ClienteRepositorio();
        }

        [HttpPost, BasicAuthorization]
        [Route("registrar")]
        public HttpResponseMessage Post(dynamic cliente) //Nome, Endereco, CPF, Genero, DataNascimento, Email
        {
            List<string> resposta = repositorio.Criar(cliente);
            if (resposta != null)
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
        public HttpResponseMessage ObterLista()
        {
            List<Cliente> clientes = repositorio.ObterLista();

            return ResponderOK(new { clientes });
        }

        [HttpGet, BasicAuthorization]
        [Route("{id:int}")]
        public HttpResponseMessage ObterPorId(int id)
        {
            Cliente cliente = repositorio.ObterPorId(id);

            if (cliente == null)
            {
                return ResponderErro("Usuário não encontrado.");
            }
            return ResponderOK(cliente);
        }

        [HttpGet, BasicAuthorization]
        [Route("nome/{nome}")]
        public HttpResponseMessage ObterPorNome(string nome)
        {
            List<Cliente> clientes = repositorio.ObterPorNome(nome);

            if (clientes == null)
            {
                return ResponderErro("Usuário não encontrado.");
            }
            return ResponderOK(clientes);
        }


    }
}