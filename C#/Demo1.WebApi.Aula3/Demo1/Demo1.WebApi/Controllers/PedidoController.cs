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
        ProdutoRepositorio _produtoRepositorio = new ProdutoRepositorio();
        ItemPedidoRepositorio _itemPedidoRepositorio = new ItemPedidoRepositorio();
        public IHttpActionResult Post(Pedido pedido)
        {
            var mensagens = new List<string>();
            if (pedido == null)
            {
                return BadRequest("O Pedido não pode ser nulo");
            }
            if (!pedido.Validar(out mensagens))
            {
                return BadRequest(string.Join(" - ", mensagens));
            }
            var mensagem = "";
            foreach(ItemPedido item in pedido.Itens)
            {
                if (!item.Validar(out mensagem))
                {
                    mensagens.Add(mensagem);
                }
                Produto produto = _produtoRepositorio.Obter(item.ProdutoId);
                if (produto!=null)
                {
                    var novoEstoque = produto.Estoque - item.Quantidade;
                    if (novoEstoque >= 0)
                    {
                        Produto produtoAlterado = new Produto(produto.Id, produto.Nome, produto.Preco, novoEstoque);
                        _produtoRepositorio.Alterar(produtoAlterado);
                    }
                    else
                    {
                        mensagens.Add("Estoque com quantidade insuficiente do produto de ID " + produto.Id);
                    }
                }
                else
                {
                    mensagens.Add("Produto de Id "+item.ProdutoId+" é inválido");
                }
            }
            if (mensagens.Count > 0)
            {
                return BadRequest(string.Join(" - ", mensagens));
            }
            _pedidoRepositorio.Criar(pedido);
            return Ok(pedido);
        }
        public IHttpActionResult Get()
        {
            var pedidos = _pedidoRepositorio.Listar();

            return Ok(pedidos);
        }
        public IHttpActionResult Put(Pedido pedido)
        {
            var mensagens = new List<string>();
            if (pedido == null)
            {
                return BadRequest("O Pedido não pode ser nulo");
            }
            if (!pedido.Validar(out mensagens))
            {
                return BadRequest(string.Join(" - ", mensagens));
            }
            var mensagem = "";
            foreach (ItemPedido item in pedido.Itens)
            {
                if (!item.Validar(out mensagem))
                {
                    mensagens.Add(mensagem);
                }
                Produto produto = _produtoRepositorio.Obter(item.ProdutoId);
                if (produto != null)
                {
                    ItemPedido itemPedidoAntigo = _itemPedidoRepositorio.Obter(item.Id);

                    var novoEstoque = produto.Estoque + (itemPedidoAntigo.Quantidade - item.Quantidade);
                    //Pega a quantidade do pedido antigo e subtrai da nova Quantidade, 
                    //esta diferença, sendo positiva ou negativa é descontada/adicionada 
                    // no estoque do produto

                    if (novoEstoque >= 0)
                    {
                        Produto produtoAlterado = new Produto(produto.Id, produto.Nome, produto.Preco, novoEstoque);
                        _produtoRepositorio.Alterar(produtoAlterado);
                    }
                    else
                    {
                        mensagens.Add("Estoque com quantidade insuficiente do produto de ID " + produto.Id);
                    }
                }
                else
                {
                    mensagens.Add("Produto de Id " + item.ProdutoId + " é inválido");
                }
            }
            if (mensagens.Count > 0)
            {
                return BadRequest(string.Join(" - ", mensagens));
            }
            _pedidoRepositorio.Alterar(pedido);
            return Ok(pedido);
        }
        public IHttpActionResult Get(int id)
        {
            return Ok(_pedidoRepositorio.Obter(id));
        }
        public IHttpActionResult Delete(int id)
        {
            _pedidoRepositorio.Excluir(id);

            return Ok();
        }
    }
}