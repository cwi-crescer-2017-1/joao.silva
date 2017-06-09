using Microsoft.VisualStudio.TestTools.UnitTesting;
using ProdutoraCrescer.Dominio.Entidades;

namespace ProdutoraCrescer.Api.Testes
{
    [TestClass]
    public class PacoteUnitTest
    {
        [TestMethod]
        public void Deve_Criar_Entidade_Pacote_Valida()
        {
            var pacote = new Pacote("Pacote Premium", true, true, true, 100, 150);
            Assert.IsFalse(pacote.Mensagens.Count > 0);
        }
        [TestMethod]
        public void Nao_Deve_Criar_Entidade_Pacote_Sem_Nome()
        {
            var pacote = new Pacote("", true, true, true, 100, 150);
            Assert.IsFalse(pacote.Validar());
            Assert.IsTrue(pacote.Mensagens.Count > 0);
            Assert.IsTrue(pacote.Mensagens[0] == "Nome é inválido.");
        }
        [TestMethod]
        public void Nao_Deve_Criar_Entidade_Pacote_Sem_CustoDiaria()
        {
            var pacote = new Pacote("Pacote Premium", true, true, true, 0, 150);
            Assert.IsFalse(pacote.Validar());
            Assert.IsTrue(pacote.Mensagens.Count > 0);
            Assert.IsTrue(pacote.Mensagens[0] == "Custo diário é inválido.");
        }
        [TestMethod]
        public void Nao_Deve_Criar_Entidade_Pacote_Com_CustoDiaria_Negativo()
        {
            var pacote = new Pacote("Pacote Premium", true, true, true, -100, 150);
            Assert.IsFalse(pacote.Validar());
            Assert.IsTrue(pacote.Mensagens.Count > 0);
            Assert.IsTrue(pacote.Mensagens[0] == "Custo diário é inválido.");
        }
        [TestMethod]
        public void Nao_Deve_Criar_Entidade_Pacote_Sem_CustoMulta()
        {
            var pacote = new Pacote("Pacote Premium", true, true, true, 100, 0);
            Assert.IsFalse(pacote.Validar());
            Assert.IsTrue(pacote.Mensagens.Count > 0);
            Assert.IsTrue(pacote.Mensagens[0] == "Custo da multa é inválido.");
        }
        [TestMethod]
        public void Nao_Deve_Criar_Entidade_Pacote_Com_CustoMulta_Negativo()
        {
            var pacote = new Pacote("Pacote Premium", true, true, true, 100, -150);
            Assert.IsFalse(pacote.Validar());
            Assert.IsTrue(pacote.Mensagens.Count > 0);
            Assert.IsTrue(pacote.Mensagens[0] == "Custo da multa é inválido.");
        }
    }
}
