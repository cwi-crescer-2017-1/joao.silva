using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Exercicio3.Entidades
{
    public class FolhaPagamento:IFolhaPagamento
    {
        public FolhaPagamento()
        { }
        public Demonstrativo GerarDemonstrativo(int horasCategoria, double salarioBase, double horasExtras, double horasDescontadas)
        {
            double salarioPorHora = calcularSalarioPorHora(salarioBase,horasCategoria);
            double totalHorasDescontadas = calcularTotalHorasDescontadas(salarioPorHora, horasDescontadas);
            double totalHorasExtras = calcularTotalHorasExtras(salarioPorHora, horasExtras);
            HorasCalculadas horasExtrasCalculadas = new HorasCalculadas(horasExtras, totalHorasExtras);
            HorasCalculadas horasDescontadasCalculadas = new HorasCalculadas(horasDescontadas, totalHorasDescontadas);
            double totalProventos = arredondar(calcularTotalProventos(salarioBase,totalHorasExtras,totalHorasDescontadas));
            double aliquotaINSS = new aliquotaINSS(totalProventos).Valor();
            double totalINSS = arredondar(aliquotaINSS * totalProventos);
            Desconto inss = new Desconto(aliquotaINSS, totalINSS);
            double aliquotaIRRF = new aliquotaIRRF(totalProventos, totalINSS).Valor();
            double totalIRRF = arredondar((totalProventos-totalINSS)*aliquotaIRRF);
            Desconto irrf = new Desconto(aliquotaIRRF, totalIRRF);
            double totalDescontos = irrf.Valor+inss.Valor;
            double totalLiquido = totalProventos - totalDescontos;
            double totalFGTS = calcularFGTS(totalProventos);
            Desconto fgts = new Desconto(0.11,totalFGTS); 
            return new Demonstrativo(salarioBase, horasCategoria, horasExtrasCalculadas, horasDescontadasCalculadas,totalProventos,inss,irrf,totalDescontos,totalLiquido,fgts);
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
        private double calcularTotalProventos(double salarioBase, double totalHorasExtras, double totalHorasDescontadas)
        {
            return salarioBase + totalHorasExtras - totalHorasDescontadas;
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
