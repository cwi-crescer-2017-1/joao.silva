using ProdutoraCrescer.Dominio.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;

namespace ProdutoraCrescer.Infraestrutura.Repositorio
{
    public class OpcionalRepositorio : IDisposable
    {
        private Contexto contexto;

        public OpcionalRepositorio()
        {
            contexto = new Contexto();
        }

        public Opcional ObterPorId(int id)
        {
            return contexto.Opcionais.FirstOrDefault(opcional => opcional.Id == id);
        }

        public List<Opcional> ObterLista()
        {
            return contexto.Opcionais.Where(opcional=>opcional.Quantidade>0).ToList();
        }

        public void Dispose()
        {
            contexto.Dispose();
        }
    }
}
