using Demo1.Dominio.Entidades;
using Demo1.Infraestrutura.Repositorios;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Http;

namespace Demo1.WebApi.Controllers
{
    public class PedidoController : ApiController
    {
        PedidoRepositorio _pedidoRepositorio = new PedidoRepositorio();
        public IHttpActionResult Post(Pedido pedido)
        {
            var mensagens = new List<string>();
            if (!pedido.Validar(out mensagens))
            {
                return BadRequest(string.Join(" - ", mensagens));
            }

            _pedidoRepositorio.Criar(pedido);

            return Ok(pedido);
        }
    }
}