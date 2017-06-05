using CWI.EditoraCresccer.Entidades;
using CWI.EditoraCresccer.Repositorios;
using System.Net.Http;
using System.Threading;
using System.Web.Http;

namespace EditoraCrescer.Api.Controllers
{
    [AllowAnonymous]
    [RoutePrefix("api/usuarios")]
    public class UsuarioController : ControllerBasica
    {
        readonly UsuarioRepositorio repositorio;

        public UsuarioController()
        {
            repositorio = new UsuarioRepositorio();
        }

        // Exige que o usuário se autentique
        [BasicAuthorization]
        [HttpGet, Route()]
        public HttpResponseMessage Obter()
        {
            // só pode obter as informações do usuário corrente (logado, autenticado)
            var usuario = repositorio.Obter(Thread.CurrentPrincipal.Identity.Name);

            if (usuario == null)
            {
                return ResponderErro("Usuário não encontrado.");
            }
            return ResponderOK(new {usuario.Id, usuario.Nome, usuario.Permissoes, usuario.Email });
        }
        [HttpPost]
        [Route("registrar")]
        public IHttpActionResult Post(Usuario usuario)
        {
            var resposta = repositorio.Criar(usuario);
            if (resposta == null)
            {
                return Ok(new { resultado = true, dados = usuario });
            }
            else
            {
                return BadRequest(string.Join(" - ", resposta));
            }
        }
        /*
        [BasicAuthorization]
        [HttpGet, BasicAuthorization(Roles = "Administrador")]
        [Route()]
        public IHttpActionResult GetTodosUsuarios()
        {
            var usuarios = repositorio.Listar();
            return Ok(new { dados = usuarios });
        }
        [BasicAuthorization]
        [HttpGet]
        [Route("{email}")]
        public IHttpActionResult GetUsuarioPorEmail(string email)
        {
            var usuarios = repositorio.Obter(email);
            return Ok(new { dados = usuarios });
        }
        */
        [HttpDelete, BasicAuthorization(Roles = "Administrador")]
        [Route("{id:int}")]
        public void Delete(int id)
        {
            repositorio.Excluir(id);
        }
        [HttpPut, BasicAuthorization(Roles = "Administrador,Revisor,Publicador,Colaborador")]
        [Route()]
        public IHttpActionResult Put(Usuario usuario)
        {
            MensagemUsuario resposta = repositorio.Alterar(usuario);
            if(resposta.Resultado == true)
            {
                return Ok(new { dados = resposta.Usuario });
            }
            else
            {
                return BadRequest(string.Join(" - ", resposta.Mensagens));
            } 
        }
    }
}