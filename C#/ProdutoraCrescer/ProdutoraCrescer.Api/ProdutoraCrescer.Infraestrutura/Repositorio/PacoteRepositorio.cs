using ProdutoraCrescer.Dominio.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ProdutoraCrescer.Infraestrutura.Repositorio
{
    public class PacoteRepositorio : IDisposable
    {
        private Contexto contexto;

        public PacoteRepositorio()
        {
            contexto = new Contexto();
        }

        public Pacote ObterPorId(int id)
        {
            return contexto.Pacotes.FirstOrDefault(pacote => pacote.Id == id);
        }

        public List<Pacote> ObterLista()
        {
            return contexto.Pacotes.ToList();
        }

        public void Dispose()
        {
            contexto.Dispose();
        }
    }
}
