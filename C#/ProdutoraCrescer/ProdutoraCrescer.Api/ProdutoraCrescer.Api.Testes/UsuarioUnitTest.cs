using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using ProdutoraCrescer.Dominio.Entidades;

namespace ProdutoraCrescer.Api.Testes
{
    [TestClass]
    public class UsuarioUnitTest
    {
        [TestMethod]
        public void Deve_Criar_Entidade_Usuario_Valida()
        {
            var usuario = new Usuario("Giovani", "123456", "giovani@cwi.com.br", "Gerente");
            Assert.IsTrue(usuario.Validar());
            Assert.IsFalse(usuario.Mensagens.Count>0);
        }

        [TestMethod]
        public void Nao_Deve_Validar_Entidade_Usuario_Sem_Nome()
        {
            var usuario = new Usuario("", "123456", "giovani@cwi.com.br", "Gerente");
            Assert.IsFalse(usuario.Validar());
            Assert.IsTrue(usuario.Mensagens.Count>0);
            Assert.IsTrue(usuario.Mensagens[0] == "Nome é inválido.");
        }

        [TestMethod]
        public void Nao_Deve_Validar_Entidade_Usuario_Sem_Email()
        {
            var usuario = new Usuario("Giovani", "123456", "", "Gerente");
            Assert.IsFalse(usuario.Validar());
            Assert.IsTrue(usuario.Mensagens.Count>0);
            Assert.IsTrue(usuario.Mensagens[0] == "Email é inválido.");
        }

        [TestMethod]
        public void Nao_Deve_Validar_Entidade_Usuario_Sem_Senha()
        {
            var usuario = new Usuario("Giovani", "", "giovani@cwi.com.br", "Gerente");
            Assert.IsFalse(usuario.Validar());
            Assert.IsTrue(usuario.Mensagens.Count>0);
            Assert.IsTrue(usuario.Mensagens[0] == "Senha inválida.");
        }

        [TestMethod]
        public void Nao_Deve_Validar_Entidade_Usuario_Sem_Permissao()
        {
            var usuario = new Usuario("Giovani","123456", "giovani@cwi.com.br", "");
            Assert.IsFalse(usuario.Validar());
            Assert.IsTrue(usuario.Mensagens.Count > 0);
            Assert.IsTrue(usuario.Mensagens[0] == "Permissao é inválida.");
        }

        [TestMethod]
        public void Deve_Validar_Senha_Usuario_Correta()
        {
            var usuario = new Usuario("Giovani", "123456", "giovani@cwi.com.br",  "Gerente");
            Assert.IsTrue(usuario.ValidarSenha("123456"));
        }

        [TestMethod]
        public void Deve_Criptografar_Senha_Usuario()
        {
            var usuario = new Usuario("Giovani", "123456", "giovani@cwi.com.br", "Gerente");
            Assert.IsTrue(usuario.Senha != "123456");
        }

        [TestMethod]
        public void Deve_Criar_Usuario_Com_Permissoes_Gerente()
        {
            var usuario = new Usuario("Giovani", "123456", "giovani@cwi.com.br", "Gerente");
            Assert.IsTrue(usuario.Permissao == "Gerente");
        }

        [TestMethod]
        public void Deve_Adicionar_Permissao_Funcionario()
        {
            var usuario = new Usuario("Giovani", "123456", "giovani@cwi.com.br", "Funcionario");
            Assert.IsTrue(usuario.Permissao == "Funcionario");
        }
    }
}
