using Microsoft.VisualStudio.TestTools.UnitTesting;
using ProdutoraCrescer.Dominio.Entidades;
using System;

namespace ProdutoraCrescer.Api.Testes
{
    [TestClass]
    public class ClienteUnitTest
    {
        [TestMethod]
        public void Deve_Criar_Entidade_Cliente_Valida()
        {
            var data = new DateTime();
            var cliente = new Cliente("Giovani","Rua X Bairro Y" ,"12345678956","Masculino", data, "giovani@cwi.com.br");
            Assert.IsTrue(cliente.Validar());
            Assert.IsFalse(cliente.Mensagens.Count > 0);
        }

        [TestMethod]
        public void Nao_Deve_Validar_Entidade_Cliente_Sem_Nome()
        {
            var data = new DateTime();
            var cliente = new Cliente("", "Rua X Bairro Y", "12345678956", "Masculino", data, "giovani@cwi.com.br");
            Assert.IsFalse(cliente.Validar());
            Assert.IsTrue(cliente.Mensagens.Count > 0);
            Assert.IsTrue(cliente.Mensagens[0] == "Nome é inválido.");
        }

        [TestMethod]
        public void Nao_Deve_Validar_Entidade_Cliente_Sem_Email()
        {
            var data = new DateTime();
            var cliente = new Cliente("Giovani", "Rua X Bairro Y", "12345678956", "Masculino", data, "");
            Assert.IsFalse(cliente.Validar());
            Assert.IsTrue(cliente.Mensagens.Count > 0);
            Assert.IsTrue(cliente.Mensagens[0] == "Email é inválido.");
        }

        [TestMethod]
        public void Nao_Deve_Validar_Entidade_Cliente_Sem_CPF()
        {
            var data = new DateTime();
            var cliente = new Cliente("Giovani", "Rua X Bairro Y", "", "Masculino", data, "giovani@cwi.com.br");
            Assert.IsFalse(cliente.Validar());
            Assert.IsTrue(cliente.Mensagens.Count > 0);
            Assert.IsTrue(cliente.Mensagens[0] == "CPF é inválido.");
        }
        [TestMethod]
        public void Nao_Deve_Validar_Entidade_Cliente_Com_CPF_De_12_Caracteres()
        {
            var data = new DateTime();
            var cliente = new Cliente("Giovani", "Rua X Bairro Y", "123456789123", "Masculino", data, "giovani@cwi.com.br");
            Assert.IsFalse(cliente.Validar());
            Assert.IsTrue(cliente.Mensagens.Count > 0);
            Assert.IsTrue(cliente.Mensagens[0] == "CPF é inválido.");
        }

        [TestMethod]
        public void Nao_Deve_Validar_Entidade_Cliente_Sem_Endereco()
        {
            var data = new DateTime();
            var cliente = new Cliente("Giovani", "", "12345678956", "Masculino", data, "giovani@cwi.com.br");
            Assert.IsFalse(cliente.Validar());
            Assert.IsTrue(cliente.Mensagens.Count > 0);
            Assert.IsTrue(cliente.Mensagens[0] == "Endereco é inválido.");
        }

        [TestMethod]
        public void Nao_Deve_Validar_Cliente_Sem_Genero()
        {
            var data = new DateTime();
            var cliente = new Cliente("Giovani", "Rua X Bairro Y", "12345678956", "", data, "giovani@cwi.com.br");
            Assert.IsFalse(cliente.Validar());
            Assert.IsTrue(cliente.Mensagens.Count > 0);
            Assert.IsTrue(cliente.Mensagens[0] == "Genero é inválido.");
        }
    }
}
