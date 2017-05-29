using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Demo1.WebApi.Models
{
    public class Produto
    {
        public int id { get; set; }
        public string nome { get; set; }
        public decimal preco { get; set; }
        public int estoque { get; set; }
    }
}