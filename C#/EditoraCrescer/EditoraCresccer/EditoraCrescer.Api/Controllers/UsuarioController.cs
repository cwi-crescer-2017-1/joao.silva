using CWI.EditoraCresccer.Entidades;
using CWI.EditoraCresccer.Repositorios;
using System.Web.Http;

namespace EditoraCrescer.Api.Controllers
{
    [AllowAnonymous]
    [RoutePrefix("api/usuarios")]
    public class UsuarioController : ApiController
    {
        readonly UsuarioRepositorio repositorio;

        public UsuarioController()
        {
            repositorio = new UsuarioRepositorio();
        }

        [HttpPost]
        [Route("registrar")]
        public IHttpActionResult Post(Usuario usuario)
        {
            var resposta = repositorio.Criar(usuario);
            if (resposta == null)
            {
                return Ok(new { dados = usuario });
            }
            else
            {
                return BadRequest(string.Join(" - ", resposta));
            }
        }
        [BasicAuthorization]
        [HttpGet, BasicAuthorization(Roles = "Administrador")]
        [Route()]
        public IHttpActionResult GetTodosUsuarios()
        {
            var usuarios = repositorio.Listar();
            return Ok(new { dados = usuarios });
        }
        [HttpGet, BasicAuthorization(Roles = "Administrador")]
        [Route("{email}")]
        public IHttpActionResult GetUsuarioPorEmail(string email)
        {
            var usuarios = repositorio.Obter(email);
            return Ok(new { dados = usuarios });
        }
        [HttpDelete, BasicAuthorization(Roles = "Administrador")]
        [Route("{id:int}")]
        public void Delete(int id)
        {
            repositorio.Excluir(id);
        }
        [HttpPut, BasicAuthorization(Roles = "Colaborador")]
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