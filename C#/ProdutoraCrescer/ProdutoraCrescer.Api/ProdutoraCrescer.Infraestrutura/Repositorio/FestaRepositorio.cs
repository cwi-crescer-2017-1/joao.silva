using ProdutoraCrescer.Dominio.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;

namespace ProdutoraCrescer.Infraestrutura.Repositorio
{
    public class FestaRepositorio : IDisposable
    {
        private Contexto contexto;

        public FestaRepositorio()
        {
            contexto = new Contexto();
        }

        public Festa ObterPorId(int id)
        {
            return contexto.Festas.FirstOrDefault(festa => festa.Id == id);
        }

        public List<Festa> ObterLista()
        {
            return contexto.Festas.ToList();
        }

        public void Dispose()
        {
            contexto.Dispose();
        }
    }
}
