using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace Exercicio3.Entidades
{
    [TestClass]
    public class UnitTest1
    {
        [TestMethod]
        public void Industria_Salario_1000()
        {
            CalculoFolhaPagamento calc = new CalculoFolhaPagamento(200, 1000, 50, 10);
            Demonstrativo result = calc.GerarDemonstrativo();

            Assert.IsNotNull(result);
            Assert.AreEqual(result.SalarioBase, 1000, 0.1);
            Assert.AreEqual(result.HrsConvencao, 200);
            Assert.AreEqual(result.HorasExtras.QtdHoras, 50, 0.1);
            Assert.AreEqual(result.HorasDescontadas.QtdHoras, 10, 0.1);

            Assert.AreEqual(result.HorasExtras.ValorTotalHoras, 250); //(1000/200) * 50
            Assert.AreEqual(result.HorasDescontadas.ValorTotalHoras,50, 0.1); //(1000/200) * 10
            //quantidade de horas extras ou descontadas multiplicados pelo Valor Hora.

            Assert.AreEqual(result.TotalProventos, 1200, 0.1);

            Assert.AreEqual(result.Inss.Aliquota, 0.09, 0.1);
            Assert.AreEqual(result.Inss.Valor, 108, 0.1); //1200*0.09
            //INSS: Até R$1000,00 utilize 8%, até R$1500,00 9% e acima disso 10% do Total de Provento

            Assert.AreEqual(result.Irrf.Aliquota, 0, 0.1);
            Assert.AreEqual(result.Irrf.Valor, 0, 0.1);//(1200-96)*0 = 0
            /*IRRF: Total de Proventos deduzido o INSS. Aliquota: até R$1710.78 isento, 
            * até R$2563.91 7,5%, até R$3418.59 15%, até R$4271.59 22,5% e acima disso 27,5%.*/

            Assert.AreEqual(result.TotalDescontos, 108, 0.1);
            //Soma do INSS e do IRRF

            Assert.AreEqual(result.TotalLiquido, 1092, 0.1); //1200-96
            //Soma do Total de Proventos - Total de Descontos.

            Assert.AreEqual(result.Fgts.Valor,110, 0.1); //1000*0.11
            //discriminado 11% fixo  
        }
        [TestMethod]
        public void Comercio_Salario_2000_Com_Numeros_Quebrados()
        {
            CalculoFolhaPagamento calc = new CalculoFolhaPagamento(170, 2000, 10, 50);
            Demonstrativo result = calc.GerarDemonstrativo();

            Assert.IsNotNull(result);
            Assert.AreEqual(result.SalarioBase, 2000, 0.1);
            Assert.AreEqual(result.HrsConvencao, 170);
            Assert.AreEqual(result.HorasExtras.QtdHoras, 10, 0.1);
            Assert.AreEqual(result.HorasDescontadas.QtdHoras, 50, 0.1);
            Assert.AreEqual(result.HorasExtras.ValorTotalHoras, 117.65, 0.1);
            Assert.AreEqual(result.HorasDescontadas.ValorTotalHoras, 588.24, 0.1);
            //quantidade de horas extras ou descontadas multiplicados pelo Valor Hora.

            Assert.AreEqual(result.TotalProventos, 1529.41, 0.1);

            Assert.AreEqual(result.Inss.Aliquota, 0.1, 0.1);
            Assert.AreEqual(result.Inss.Valor, 152.94, 0.1);
            //INSS: Até R$1000,00 utilize 8%, até R$1500,00 9% e acima disso 10% do Total de Provento

            Assert.AreEqual(result.Irrf.Aliquota, 0, 0.1);
            Assert.AreEqual(result.Irrf.Valor, 0, 0.1);
            /*IRRF: Total de Proventos deduzido o INSS. Aliquota: até R$1710.78 isento, 
            * até R$2563.91 7,5%, até R$3418.59 15%, até R$4271.59 22,5% e acima disso 27,5%.*/

            Assert.AreEqual(result.TotalDescontos, 152.94, 0.1);
            //Soma do INSS e do IRRF

            Assert.AreEqual(result.TotalLiquido, 1376.47, 0.1);
            //Soma do Total de Proventos - Total de Descontos.

            Assert.AreEqual(result.Fgts.Valor, 220, 0.1);
            //discriminado 11% fixo  
        }
        [TestMethod]
        public void Comercio_Salario_2000_Com_Muitos_Numeros_Quebrados_E_FGTS_Nao_Isento()
        {
            CalculoFolhaPagamento calc = new CalculoFolhaPagamento(170, 9697.99, 90.8, 60.6);
            Demonstrativo result = calc.GerarDemonstrativo();

            Assert.IsNotNull(result);
            Assert.AreEqual(result.SalarioBase, 9697.99, 0.1);
            Assert.AreEqual(result.HrsConvencao, 170);
            Assert.AreEqual(result.HorasExtras.QtdHoras, 90.8, 0.1);
            Assert.AreEqual(result.HorasDescontadas.QtdHoras, 60.6, 0.1);
            Assert.AreEqual(result.HorasExtras.ValorTotalHoras, 5179.86, 0.1);//5179,8676
            Assert.AreEqual(result.HorasDescontadas.ValorTotalHoras, 3457.04, 0.1);//3457,0482
            //quantidade de horas extras ou descontadas multiplicados pelo Valor Hora.

            Assert.AreEqual(result.TotalProventos,11420.8, 0.1);
            //Salário-base + Total Horas Extras - Total Horas Descontadas

            Assert.AreEqual(result.Inss.Aliquota,0.1, 0.1);
            Assert.AreEqual(result.Inss.Valor,1142.08, 0.1);//1142,081
            //INSS: Até R$1000,00 utilize 8%, até R$1500,00 9% e acima disso 10% do Total de Provento

            Assert.AreEqual(result.Irrf.Aliquota,0.275, 0.1);
            Assert.AreEqual(result.Irrf.Valor,3140.72, 0.1); //3140,72275
            /*IRRF: Total de Proventos deduzido o INSS. Aliquota: até R$1710.78 isento, 
            * até R$2563.91 7,5%, até R$3418.59 15%, até R$4271.59 22,5% e acima disso 27,5%.*/

            Assert.AreEqual(result.TotalDescontos,4282.8, 0.1);
            //Soma do INSS e do IRRF

            Assert.AreEqual(result.TotalLiquido,7138.01, 0.1);
            //Soma do Total de Proventos - Total de Descontos.

            Assert.AreEqual(result.Fgts.Valor,1066.77, 0.1); //1066,7789
            //discriminado 11% fixo  
        }
    }
}
