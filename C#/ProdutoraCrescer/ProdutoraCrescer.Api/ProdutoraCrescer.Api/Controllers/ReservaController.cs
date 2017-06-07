using ProdutoraCrescer.Api.App_Start;
using ProdutoraCrescer.Dominio.Entidades;
using ProdutoraCrescer.Infraestrutura.Repositorio;
using System.Collections.Generic;
using System.Net.Http;
using System.Web.Http;


namespace ProdutoraCrescer.Api.Controllers
{
    [AllowAnonymous]
    [RoutePrefix("api/reserva")]
    public class ReservaController : ControllerBasica
    {
        readonly ReservaRepositorio repositorio;

        public ReservaController()
        {
            repositorio = new ReservaRepositorio();
        }

        [HttpPost, BasicAuthorization]
        [Route("registrar")]
        public HttpResponseMessage Post(dynamic reserva) //TempoReservaEmDias, IdCliente, IdUsuario, IdOpcional, IdPacote, IdFesta
        {
            List<string> resposta = repositorio.Criar(reserva);
            if (resposta == null)
            {
                return ResponderOK(reserva);
            }
            else
            {
                return ResponderErro(resposta.ToArray());
            }
        }

        [HttpGet, BasicAuthorization]
        [Route("valordevolucao/{id:int}")]
        public HttpResponseMessage PegarValorDevolucao(int id)
        {
            decimal valor = repositorio.PegarValorDevolucao(id);

            if(valor >= 0)
            {
                return ResponderOK(new { valor });
            }
            return ResponderErro("Esta reserva não existe");
        }

        [HttpGet, BasicAuthorization(Roles = "Gerente")]
        [Route()]
        public HttpResponseMessage ObterLista()
        {
            List<Reserva> reservas = repositorio.ObterLista();

            return ResponderOK(new { reservas });
        }

        [HttpGet, BasicAuthorization(Roles = "Gerente")]
        [Route("limitada")]
        public HttpResponseMessage ObterListaNaoDevolvidos()
        {
            List<Reserva> reservas = repositorio.ObterListaNaoDevolvidos();

            return ResponderOK(new { reservas });
        }

        [HttpGet, BasicAuthorization]
        [Route("{id:int}")]
        public HttpResponseMessage ObterPorId(int id)
        {
            Reserva reserva = repositorio.ObterPorId(id);

            if (reserva == null)
            {
                return ResponderErro("Usuário não encontrado.");
            }
            return ResponderOK(reserva);
        }

        [HttpGet, BasicAuthorization]
        [Route("cliente/{idCliente:int}")]
        public HttpResponseMessage ObterListaPorIdCliente(int idCliente)
        {
            List<Reserva> reservas = repositorio.ObterListaPorIdCliente(idCliente);

            if (reservas == null)
            {
                return ResponderErro("Usuário não encontrado.");
            }
            return ResponderOK(reservas);
        }

        [HttpPut, BasicAuthorization]
        [Route("{id:int}")]
        public HttpResponseMessage Devolver(int id)
        {
            Reserva reserva = repositorio.ObterPorId(id);
            if(reserva != null)
            {
                bool devolvido = repositorio.Devolver(id);
                if (devolvido)
                {
                    return ResponderOK(reserva);
                }
                else
                {
                    return ResponderErro("Reserva já devolvida");
                }
            }
            return ResponderErro("Reserva não existe.");
        }
    }
}