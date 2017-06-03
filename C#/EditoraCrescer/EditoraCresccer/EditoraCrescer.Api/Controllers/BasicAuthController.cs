using EditoraCrescer.Api;
using System.Net.Http;
using System.Web.Http;

namespace EditoraCrescer.Api.Controllers
{
    [BasicAuthorization(Roles="Publicador")]

    public class BasicAuthController : ApiController
    {
        public HttpResponseMessage Get()
        {
            return Request.CreateResponse(System.Net.HttpStatusCode.OK);
        }

    }
}