using ProdutoraCrescer.Dominio.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;

namespace ProdutoraCrescer.Infraestrutura.Repositorio
{
    public class ClienteRepositorio : IDisposable
    {
        private Contexto contexto;

        public ClienteRepositorio()
        {
            contexto = new Contexto();
        }

        public Cliente ObterPorId(int id)
        {
            return contexto.Clientes.FirstOrDefault(cliente => cliente.Id == id);
        }

        public Cliente ObterPorCPF(string cpf)
        {
            return contexto.Clientes.FirstOrDefault(cliente => cliente.CPF == cpf);
        }

        public List<Cliente> ObterLista()
        {
            return contexto.Clientes.ToList();
        }

        public List<string> Criar(dynamic c)
        {
            try
            {
            DateTime dataNascimento = c.DataNascimento;
            string endereco = c.Endereco;
            string cpf = c.CPF;
            string genero = c.Genero;
            string email = c.Email;
            string nome = c.Nome;

            Cliente cliente = new Cliente(nome, endereco, cpf, genero, dataNascimento, email);
            if (cliente.Validar())
            {
                contexto.Clientes.Add(cliente);
                contexto.SaveChanges();
                return null;
            }
            return cliente.Mensagens;
            }
            catch (FormatException)
            {
                List<string> erro = new List<string>();
                erro.Add("Data inválida");
                return erro;
            }
        }

        public void Dispose()
        {
            contexto.Dispose();
        }
    }
}
