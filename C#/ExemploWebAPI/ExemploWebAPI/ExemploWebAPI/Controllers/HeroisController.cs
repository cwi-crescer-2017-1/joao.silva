using ExemploWebAPI.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace ExemploWebAPI.Controllers
{
    public class HeroisController : ApiController
    {
        private static List<Heroi> Herois = new List<Heroi>();
        private static object lockObject = new object();
        public List<Heroi> Get(string nome = null, int? id = null)
        {
            if (Herois != null)
            {
                return Herois.Where(heroi => (id == null || heroi.Id == id) ||
                                     (nome == null || heroi.Nome == nome)).ToList();
            }else
            {
                return null;
            }
        }
        public IHttpActionResult Post(Heroi heroi)
        {
            if (heroi == null)
            {
                return BadRequest();
            }
            else
            {
                lock (lockObject)
                {
                    heroi.Id = Herois.Count + 1;
                }
            }
              Herois.Add(heroi);
              return Ok(heroi);
        }
    }
}
