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
            FolhaPagamento calc = new FolhaPagamento();
            Demonstrativo result = calc.GerarDemonstrativo(200, 1000, 50, 10);

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
            FolhaPagamento calc = new FolhaPagamento();
            Demonstrativo result = calc.GerarDemonstrativo(170, 2000, 10, 50);

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
            FolhaPagamento calc = new FolhaPagamento();
            Demonstrativo result = calc.GerarDemonstrativo(170, 9697.99, 90.8, 60.6);

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
        //TESTE_INSTRUTOR
        [TestMethod]
        public void Validar_Demonstrativo_Industria_Salario_1000()
        {
            int horasCategoria = 200;
            double salarioBase = 1000;
            double horasExtras = 0;
            double horasDescontadas = 0;

            var folhaPagamento = new FolhaPagamento();
            var demonstrativo = folhaPagamento.GerarDemonstrativo(horasCategoria, salarioBase, horasExtras, horasDescontadas);

            var quantidadeHorasExtrasEsperado = 0;
            var valorTotalHorasExtrasEsperado = 0;
            var quantidadeHorasDescontadasEsperado = 0;
            var valorTotalHorasDescontadasEsperado = 0;
            var totalProventosEsperado = 1000;
            var inssAliquotaEsperado = 0.08;
            var inssValorEsperado = 80;
            var irrfAliquotaEsperado = 0;
            var irrfValorEsperado = 0;
            var totalDescontosEsperado = 80;
            var totalLiquidoEsperado = 920;
            var fgtsAliquotaEsperado = 0.11;
            var fgtsValorEsperado = 110;

            Assert.AreEqual(demonstrativo.SalarioBase, salarioBase);
            Assert.AreEqual(demonstrativo.HorasExtras.QtdHoras, quantidadeHorasExtrasEsperado);
            Assert.AreEqual(demonstrativo.HorasExtras.ValorTotalHoras, valorTotalHorasExtrasEsperado);
            Assert.AreEqual(demonstrativo.HorasDescontadas.QtdHoras, quantidadeHorasDescontadasEsperado);
            Assert.AreEqual(demonstrativo.HorasDescontadas.ValorTotalHoras, valorTotalHorasDescontadasEsperado);
            Assert.AreEqual(demonstrativo.TotalProventos, totalProventosEsperado);
            Assert.AreEqual(demonstrativo.Inss.Aliquota, inssAliquotaEsperado);
            Assert.AreEqual(demonstrativo.Inss.Valor, inssValorEsperado);
            Assert.AreEqual(demonstrativo.Irrf.Aliquota, irrfAliquotaEsperado);
            Assert.AreEqual(demonstrativo.Irrf.Valor, irrfValorEsperado);
            Assert.AreEqual(demonstrativo.TotalDescontos, totalDescontosEsperado);
            Assert.AreEqual(demonstrativo.TotalLiquido, totalLiquidoEsperado);
            Assert.AreEqual(demonstrativo.Fgts.Aliquota, fgtsAliquotaEsperado);
            Assert.AreEqual(demonstrativo.Fgts.Valor, fgtsValorEsperado);
        }

        [TestMethod]
        public void Validar_Demonstrativo_Industria_Salario_139944()
        {
            int horasCategoria = 200;
            double salarioBase = 1399.44;
            double horasExtras = 0;
            double horasDescontadas = 0;

            var folhaPagamento = new FolhaPagamento();
            var demonstrativo = folhaPagamento.GerarDemonstrativo(horasCategoria, salarioBase, horasExtras, horasDescontadas);

            var quantidadeHorasExtrasEsperado = 0;
            var valorTotalHorasExtrasEsperado = 0;
            var quantidadeHorasDescontadasEsperado = 0;
            var valorTotalHorasDescontadasEsperado = 0;
            var totalProventosEsperado = 1399.44;
            var inssAliquotaEsperado = 0.09;
            var inssValorEsperado = 125.94;
            var irrfAliquotaEsperado = 0;
            var irrfValorEsperado = 0;
            var totalDescontosEsperado = 125.94;
            var totalLiquidoEsperado = 1273.5;
            var fgtsAliquotaEsperado = 0.11;
            var fgtsValorEsperado = 153.93;

            Assert.AreEqual(demonstrativo.SalarioBase, salarioBase);
            Assert.AreEqual(demonstrativo.HorasExtras.QtdHoras, quantidadeHorasExtrasEsperado);
            Assert.AreEqual(demonstrativo.HorasExtras.ValorTotalHoras, valorTotalHorasExtrasEsperado);
            Assert.AreEqual(demonstrativo.HorasDescontadas.QtdHoras, quantidadeHorasDescontadasEsperado);
            Assert.AreEqual(demonstrativo.HorasDescontadas.ValorTotalHoras, valorTotalHorasDescontadasEsperado);
            Assert.AreEqual(demonstrativo.TotalProventos, totalProventosEsperado);
            Assert.AreEqual(demonstrativo.Inss.Aliquota, inssAliquotaEsperado);
            Assert.AreEqual(demonstrativo.Inss.Valor, inssValorEsperado);
            Assert.AreEqual(demonstrativo.Irrf.Aliquota, irrfAliquotaEsperado);
            Assert.AreEqual(demonstrativo.Irrf.Valor, irrfValorEsperado);
            Assert.AreEqual(demonstrativo.TotalDescontos, totalDescontosEsperado);
            Assert.AreEqual(demonstrativo.TotalLiquido, totalLiquidoEsperado);
            Assert.AreEqual(demonstrativo.Fgts.Aliquota, fgtsAliquotaEsperado);
            Assert.AreEqual(demonstrativo.Fgts.Valor, fgtsValorEsperado);
        }

        [TestMethod]
        public void Validar_Demonstrativo_Industria_Salario_161287()
        {
            int horasCategoria = 200;
            double salarioBase = 1612.87;
            double horasExtras = 0;
            double horasDescontadas = 0;

            var folhaPagamento = new FolhaPagamento();
            var demonstrativo = folhaPagamento.GerarDemonstrativo(horasCategoria, salarioBase, horasExtras, horasDescontadas);

            var quantidadeHorasExtrasEsperado = 0;
            var valorTotalHorasExtrasEsperado = 0;
            var quantidadeHorasDescontadasEsperado = 0;
            var valorTotalHorasDescontadasEsperado = 0;
            var totalProventosEsperado = 1612.87;
            var inssAliquotaEsperado = 0.1;
            var inssValorEsperado = 161.28;
            var irrfAliquotaEsperado = 0;
            var irrfValorEsperado = 0;
            var totalDescontosEsperado = 161.28;
            var totalLiquidoEsperado = 1451.59;
            var fgtsAliquotaEsperado = 0.11;
            var fgtsValorEsperado = 177.41;

            Assert.AreEqual(demonstrativo.SalarioBase, salarioBase);
            Assert.AreEqual(demonstrativo.HorasExtras.QtdHoras, quantidadeHorasExtrasEsperado);
            Assert.AreEqual(demonstrativo.HorasExtras.ValorTotalHoras, valorTotalHorasExtrasEsperado);
            Assert.AreEqual(demonstrativo.HorasDescontadas.QtdHoras, quantidadeHorasDescontadasEsperado);
            Assert.AreEqual(demonstrativo.HorasDescontadas.ValorTotalHoras, valorTotalHorasDescontadasEsperado);
            Assert.AreEqual(demonstrativo.TotalProventos, totalProventosEsperado);
            Assert.AreEqual(demonstrativo.Inss.Aliquota, inssAliquotaEsperado);
            Assert.AreEqual(demonstrativo.Inss.Valor, inssValorEsperado);
            Assert.AreEqual(demonstrativo.Irrf.Aliquota, irrfAliquotaEsperado);
            Assert.AreEqual(demonstrativo.Irrf.Valor, irrfValorEsperado);
            Assert.AreEqual(demonstrativo.TotalDescontos, totalDescontosEsperado);
            Assert.AreEqual(demonstrativo.TotalLiquido, totalLiquidoEsperado);
            Assert.AreEqual(demonstrativo.Fgts.Aliquota, fgtsAliquotaEsperado);
            Assert.AreEqual(demonstrativo.Fgts.Valor, fgtsValorEsperado);
        }

        [TestMethod]
        public void Validar_Demonstrativo_Industria_Salario_181234()
        {
            int horasCategoria = 200;
            double salarioBase = 1812.34;
            double horasExtras = 0;
            double horasDescontadas = 0;

            var folhaPagamento = new FolhaPagamento();
            var demonstrativo = folhaPagamento.GerarDemonstrativo(horasCategoria, salarioBase, horasExtras, horasDescontadas);

            var quantidadeHorasExtrasEsperado = 0;
            var valorTotalHorasExtrasEsperado = 0;
            var quantidadeHorasDescontadasEsperado = 0;
            var valorTotalHorasDescontadasEsperado = 0;
            var totalProventosEsperado = 1812.34;
            var inssAliquotaEsperado = 0.1;
            var inssValorEsperado = 181.23;
            var irrfAliquotaEsperado = 0;
            var irrfValorEsperado = 0;
            var totalDescontosEsperado = 181.23;
            var totalLiquidoEsperado = 1631.11;
            var fgtsAliquotaEsperado = 0.11;
            var fgtsValorEsperado = 199.35;

            Assert.AreEqual(demonstrativo.SalarioBase, salarioBase);
            Assert.AreEqual(demonstrativo.HorasExtras.QtdHoras, quantidadeHorasExtrasEsperado);
            Assert.AreEqual(demonstrativo.HorasExtras.ValorTotalHoras, valorTotalHorasExtrasEsperado);
            Assert.AreEqual(demonstrativo.HorasDescontadas.QtdHoras, quantidadeHorasDescontadasEsperado);
            Assert.AreEqual(demonstrativo.HorasDescontadas.ValorTotalHoras, valorTotalHorasDescontadasEsperado);
            Assert.AreEqual(demonstrativo.TotalProventos, totalProventosEsperado);
            Assert.AreEqual(demonstrativo.Inss.Aliquota, inssAliquotaEsperado);
            Assert.AreEqual(demonstrativo.Inss.Valor, inssValorEsperado);
            Assert.AreEqual(demonstrativo.Irrf.Valor, irrfValorEsperado);
            Assert.AreEqual(demonstrativo.TotalDescontos, totalDescontosEsperado);
            Assert.AreEqual(demonstrativo.TotalLiquido, totalLiquidoEsperado);
            Assert.AreEqual(demonstrativo.Fgts.Aliquota, fgtsAliquotaEsperado);
            Assert.AreEqual(demonstrativo.Fgts.Valor, fgtsValorEsperado);
            Assert.AreEqual(demonstrativo.Irrf.Aliquota, irrfAliquotaEsperado);

        }

        [TestMethod]
        public void Validar_Demonstrativo_Industria_Salario_201337()
        {
            int horasCategoria = 200;
            double salarioBase = 2013.37;
            double horasExtras = 0;
            double horasDescontadas = 0;

            var folhaPagamento = new FolhaPagamento();
            var demonstrativo = folhaPagamento.GerarDemonstrativo(horasCategoria, salarioBase, horasExtras, horasDescontadas);

            var quantidadeHorasExtrasEsperado = 0;
            var valorTotalHorasExtrasEsperado = 0;
            var quantidadeHorasDescontadasEsperado = 0;
            var valorTotalHorasDescontadasEsperado = 0;
            var totalProventosEsperado = 2013.37;
            var inssAliquotaEsperado = 0.1;
            var inssValorEsperado = 201.33;
            var irrfAliquotaEsperado = 0.075;
            var irrfValorEsperado = 135.9;
            var totalDescontosEsperado = 337.23;
            var totalLiquidoEsperado = 1676.14;
            var fgtsAliquotaEsperado = 0.11;
            var fgtsValorEsperado = 221.47;

            Assert.AreEqual(demonstrativo.SalarioBase, salarioBase);
            Assert.AreEqual(demonstrativo.HorasExtras.QtdHoras, quantidadeHorasExtrasEsperado);
            Assert.AreEqual(demonstrativo.HorasExtras.ValorTotalHoras, valorTotalHorasExtrasEsperado);
            Assert.AreEqual(demonstrativo.HorasDescontadas.QtdHoras, quantidadeHorasDescontadasEsperado);
            Assert.AreEqual(demonstrativo.HorasDescontadas.ValorTotalHoras, valorTotalHorasDescontadasEsperado);
            Assert.AreEqual(demonstrativo.TotalProventos, totalProventosEsperado);
            Assert.AreEqual(demonstrativo.Inss.Aliquota, inssAliquotaEsperado);
            Assert.AreEqual(demonstrativo.Inss.Valor, inssValorEsperado);
            Assert.AreEqual(demonstrativo.Irrf.Aliquota, irrfAliquotaEsperado);
           
            
            Assert.AreEqual(demonstrativo.Fgts.Aliquota, fgtsAliquotaEsperado);
            Assert.AreEqual(demonstrativo.Fgts.Valor, fgtsValorEsperado);

            Assert.AreEqual(demonstrativo.Irrf.Valor, irrfValorEsperado);
            Assert.AreEqual(demonstrativo.TotalDescontos, totalDescontosEsperado);
            Assert.AreEqual(demonstrativo.TotalLiquido, totalLiquidoEsperado);
        }

        [TestMethod]
        public void Validar_Demonstrativo_Industria_Salario_5000_HrE50_HrD10()
        {
            int horasCategoria = 200;
            double salarioBase = 5000;
            double horasExtras = 50;
            double horasDescontadas = 10;

            var folhaPagamento = new FolhaPagamento();
            var demonstrativo = folhaPagamento.GerarDemonstrativo(horasCategoria, salarioBase, horasExtras, horasDescontadas);

            var quantidadeHorasExtrasEsperado = 50;
            var valorTotalHorasExtrasEsperado = 1250;
            var quantidadeHorasDescontadasEsperado = 10;
            var valorTotalHorasDescontadasEsperado = 250;
            var totalProventosEsperado = 6000;
            var inssAliquotaEsperado = 0.10;
            var inssValorEsperado = 600;
            var irrfAliquotaEsperado = 0.275;
            var irrfValorEsperado = 1485;
            var totalDescontosEsperado = 2085;
            var totalLiquidoEsperado = 3915;
            var fgtsAliquotaEsperado = 0.11;
            var fgtsValorEsperado = 660;

            Assert.AreEqual(demonstrativo.SalarioBase, salarioBase);
            Assert.AreEqual(demonstrativo.HorasExtras.QtdHoras, quantidadeHorasExtrasEsperado);
            Assert.AreEqual(demonstrativo.HorasExtras.ValorTotalHoras, valorTotalHorasExtrasEsperado);
            Assert.AreEqual(demonstrativo.HorasDescontadas.QtdHoras, quantidadeHorasDescontadasEsperado);
            Assert.AreEqual(demonstrativo.HorasDescontadas.ValorTotalHoras, valorTotalHorasDescontadasEsperado);
            Assert.AreEqual(demonstrativo.TotalProventos, totalProventosEsperado);
            Assert.AreEqual(demonstrativo.Inss.Aliquota, inssAliquotaEsperado);
            Assert.AreEqual(demonstrativo.Inss.Valor, inssValorEsperado);
            Assert.AreEqual(demonstrativo.Irrf.Aliquota, irrfAliquotaEsperado);
            Assert.AreEqual(demonstrativo.Irrf.Valor, irrfValorEsperado);
            Assert.AreEqual(demonstrativo.TotalDescontos, totalDescontosEsperado);
            Assert.AreEqual(demonstrativo.TotalLiquido, totalLiquidoEsperado);
            Assert.AreEqual(demonstrativo.Fgts.Aliquota, fgtsAliquotaEsperado);
            Assert.AreEqual(demonstrativo.Fgts.Valor, fgtsValorEsperado);
        }
    }
}
