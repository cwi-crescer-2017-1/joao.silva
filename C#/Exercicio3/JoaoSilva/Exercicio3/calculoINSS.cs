using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Exercicio3
{
    public class aliquotaINSS
    {
        public aliquotaINSS(double totalProventos){
            TotalProventos = totalProventos;
        }
        private double TotalProventos;
        public double Valor(){
            if (TotalProventos <= 1000)
            {
                return 0.08;
            }else if (TotalProventos<=1500)
            {
                return 0.09;
            }
            else
            {
                return 0.1;
            }
        }
    }
}
