using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Exercicio3
{
    public class aliquotaIRRF
    {
        public aliquotaIRRF(double totalProventos, double inss)
        {
            TotalProventos = totalProventos;
            INSS = inss;
        }
        private double TotalProventos;
        private double INSS;
        public double Valor()
        {
            double faixa = TotalProventos - INSS;
            if (faixa <= 1710.78)
            {
                return 0;
            }else if (faixa <= 2563.91)
            {
                return 0.075;
            }else if (faixa <= 3418.59)
            {
                return 0.15;
            }else if (faixa <= 4271.59)
            {
                return 0.225;
            }
            else
            {
                return 0.275;
            }
        }
    }
}
