using Microsoft.VisualStudio.TestTools.UnitTesting;
using ProdutoraCrescer.Dominio.Entidades;

namespace ProdutoraCrescer.Api.Testes
{
    [TestClass]
    public class FestaUnitTest
    {
        [TestMethod]
        public void Deve_Criar_Entidade_Festa_Valida()
        {
            var festa = new Festa("Festa infantil", 100, 150);
            Assert.IsTrue(festa.Validar());
            Assert.IsFalse(festa.Mensagens.Count > 0);
        }
        [TestMethod]
        public void Nao_Deve_Criar_Entidade_Festa_Sem_Nome()
        {
            var festa = new Festa("", 100, 150);
            Assert.IsFalse(festa.Validar());
            Assert.IsTrue(festa.Mensagens.Count > 0);
            Assert.IsTrue(festa.Mensagens[0] == "Nome é inválido.");
        }
        [TestMethod]
        public void Nao_Deve_Criar_Entidade_Festa_Sem_CustoDiaria()
        {
            var festa = new Festa("Festa infantil",0, 150);
            Assert.IsFalse(festa.Validar());
            Assert.IsTrue(festa.Mensagens.Count > 0);
            Assert.IsTrue(festa.Mensagens[0]== "Custo diário é inválido.");
        }
        [TestMethod]
        public void Nao_Deve_Criar_Entidade_Festa_Com_CustoDiaria_Negativo()
        {
            var festa = new Festa("Festa infantil", -100, 150);
            Assert.IsFalse(festa.Validar());
            Assert.IsTrue(festa.Mensagens.Count > 0);
            Assert.IsTrue(festa.Mensagens[0] == "Custo diário é inválido.");
        }
        [TestMethod]
        public void Nao_Deve_Criar_Entidade_Festa_Sem_CustoMulta()
        {
            var festa = new Festa("Festa infantil", 100, 0);
            Assert.IsFalse(festa.Validar());
            Assert.IsTrue(festa.Mensagens.Count > 0);
            Assert.IsTrue(festa.Mensagens[0] == "Custo da multa é inválido.");
        }
        [TestMethod]
        public void Nao_Deve_Criar_Entidade_Festa_Com_CustoMulta_Negativo()
        {
            var festa = new Festa("Festa infantil", 100, -100);
            Assert.IsFalse(festa.Validar());
            Assert.IsTrue(festa.Mensagens.Count > 0);
            Assert.IsTrue(festa.Mensagens[0] == "Custo da multa é inválido.");
        }

    }
}
