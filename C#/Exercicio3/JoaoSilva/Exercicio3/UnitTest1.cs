using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace Exercicio3
{
    [TestClass]
    public class UnitTest1
    {
        [TestMethod]
        public void Industria_Salario_1000()
        {
            CalculoFolhaPagamento calc = new CalculoFolhaPagamento();
            var result = calc.GerarDesmonstrativo(200,1000,50,10);

            Assert.IsNotNull(result);
            Assert.AreEqual(result.HorasDescontadas.QtdHoras,10);
            Assert.AreEqual(result.HorasExtras.QtdHoras, 50);
            Assert.AreEqual(result.HorasExtras.ValorTotalHoras,500);
        }
    }
}
