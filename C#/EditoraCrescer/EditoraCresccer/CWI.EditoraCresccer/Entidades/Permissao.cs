using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;

namespace CWI.EditoraCresccer.Entidades
{
    public class Permissao
    {
        public int Id { get; set; }
        public string Nome { get; set; }

        protected Permissao(){}

        public Permissao(string nome){
            Nome = nome;
        }

    }
}