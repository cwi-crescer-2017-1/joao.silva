using Microsoft.VisualStudio.TestTools.UnitTesting;
using ProdutoraCrescer.Dominio.Entidades;

namespace ProdutoraCrescer.Api.Testes
{
    [TestClass]
    public class OpcionalUnitTest
    {
        [TestMethod]
        public void Deve_Criar_Entidade_Opcional_Valida()
        {
            var opcional = new Opcional("Piscina de bolinhas", 100, 150, 10);
            Assert.IsTrue(opcional.Validar());
            Assert.IsFalse(opcional.Mensagens.Count > 0);

        }
        [TestMethod]
        public void Nao_Deve_Criar_Entidade_Opcional_Sem_CustoDiaria()
        {
            var opcional = new Opcional("Piscina de bolinhas", 0, 150, 10);
            Assert.IsFalse(opcional.Validar());
            Assert.IsTrue(opcional.Mensagens.Count > 0);
            Assert.IsTrue(opcional.Mensagens[0] == "Custo diário inválido.");
        }
        [TestMethod]
        public void Nao_Deve_Criar_Entidade_Opcional_Com_CustoDiaria_Negativo()
          {
            var opcional = new Opcional("Piscina de bolinhas", -10, 150, 10);
            Assert.IsFalse(opcional.Validar());
            Assert.IsTrue(opcional.Mensagens.Count > 0);
            Assert.IsTrue(opcional.Mensagens[0] == "Custo diário inválido.");
        }
        [TestMethod]
        public void Nao_Deve_Criar_Entidade_Opcional_Sem_CustoMulta()
        {
            var opcional = new Opcional("Piscina de bolinhas", 100, 0, 10);
            Assert.IsFalse(opcional.Validar());
            Assert.IsTrue(opcional.Mensagens.Count > 0);
            Assert.IsTrue(opcional.Mensagens[0] == "Custo da multa inválido.");
        }
        [TestMethod]
        public void Nao_Deve_Criar_Entidade_Opcional_Com_CustoMulta_Negativo()
        {
            var opcional = new Opcional("Piscina de bolinhas", 100, -10, 10);
            Assert.IsFalse(opcional.Validar());
            Assert.IsTrue(opcional.Mensagens.Count > 0);
            Assert.IsTrue(opcional.Mensagens[0] == "Custo da multa inválido.");
        }
        [TestMethod]
        public void Nao_Deve_Criar_Entidade_Opcional_Com_Quantidade_Negativa()
        {
            var opcional = new Opcional("Piscina de bolinhas", 100, 150, -10);
            Assert.IsFalse(opcional.Validar());
            Assert.IsTrue(opcional.Mensagens.Count > 0);
            Assert.IsTrue(opcional.Mensagens[0] == "Quantidade inválida.");
        }
    }
}
