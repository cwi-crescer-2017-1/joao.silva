using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace ExemploWebAPI.Controllers
{
    public class ExemploController : ApiController
    {
        public List<string> Get()
        {
            var herois = new List<string>()
        {
            "Goku",
            "Batman",
            "Ryu",
        };
            return herois;
        }
    }
    
}
