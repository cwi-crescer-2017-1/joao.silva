using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Exercicio3.Entidades
{
    public class CalculoFolhaPagamento:IFolhaPagamento
    {
        public CalculoFolhaPagamento(int horasCategoria, double salarioBase, double horasExtras, double horasDescontadas)
        {
            HorasCategoria = horasCategoria;
            SalarioBase = salarioBase;
            HorasExtras = horasExtras;
            HorasDescontadas = horasDescontadas;
        }
        public int HorasCategoria { get; private set; }
        public double SalarioBase { get; private set; }
        public double HorasExtras { get; private set; }
        public double HorasDescontadas { get; private set; }

        public Demonstrativo GerarDemonstrativo()
        {
            double salarioPorHora = calcularSalarioPorHora(SalarioBase,HorasCategoria);
            double totalHorasDescontadas = calcularTotalHorasDescontadas(salarioPorHora, HorasDescontadas);
            double totalHorasExtras = calcularTotalHorasExtras(salarioPorHora, HorasExtras);
            HorasCalculadas horasExtras = new HorasCalculadas(HorasExtras, totalHorasExtras);
            HorasCalculadas horasDescontadas = new HorasCalculadas(HorasDescontadas, totalHorasDescontadas);
            double totalProventos = arredondar(calcularTotalProventos(totalHorasExtras,totalHorasDescontadas));
            double aliquotaINSS = new aliquotaINSS(totalProventos).Valor();
            double totalINSS = arredondar(aliquotaINSS * totalProventos);
            Desconto inss = new Desconto(aliquotaINSS, totalINSS);
            double aliquotaIRRF = new aliquotaIRRF(totalProventos, totalINSS).Valor();
            double totalIRRF = arredondar(aliquotaIRRF * totalProventos);
            Desconto irrf = new Desconto(aliquotaIRRF, totalIRRF);
            double totalDescontos = irrf.Valor+inss.Valor;
            double totalLiquido = totalProventos - totalDescontos;
            double totalFGTS = calcularFGTS(SalarioBase);
            Desconto fgts = new Desconto(0.11,totalFGTS); 
            return new Demonstrativo(SalarioBase, HorasCategoria, horasExtras, horasDescontadas,totalProventos,inss,irrf,totalDescontos,totalLiquido,fgts);
        }

        private double calcularSalarioPorHora(double salarioBase, double horasCategoria)
        {
            return salarioBase / horasCategoria;
        }
        private double calcularTotalHorasExtras(double salarioPorHora, double horasExtras)
        {
            return salarioPorHora * horasExtras;
        }
        private double calcularTotalHorasDescontadas(double salarioPorHora, double horasDescontadas)
        {
            return salarioPorHora * horasDescontadas;
        }
        private double calcularTotalProventos(double totalHorasExtras, double totalHorasDescontadas)
        {
            return SalarioBase + totalHorasExtras - totalHorasDescontadas;
        }
        private double calcularFGTS(double totalProventos)
        {
            return arredondar(totalProventos * 0.11);
        }
        private double arredondar(double valor)
        {
            return Math.Truncate(valor * 100) / 100;
        }
    }
}
