using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication1
{
    class Program
    {
        static void Main(string[] args)
        {
            var entradas = new int[0];
            bool continua = true;
            while (continua)
            {
                Console.WriteLine("Digite um valor");
                var novaEntrada = Console.ReadLine();
                if (novaEntrada == "exit")
                {
                    continua = false;
                }
                else
                {
                    var nrEntradas = entradas.Length;
                    var arrayAux = new int[nrEntradas + 1];
                    for (int i = 0; i < nrEntradas; i++)
                    {
                        arrayAux[i] = entradas[i];
                    }
                    arrayAux[nrEntradas] = int.Parse(novaEntrada);
                    entradas = arrayAux;
                }
            }
            foreach (var entrada in entradas)
            {
                Console.WriteLine(entrada);
            }
            Console.ReadKey();
            //List<int> entradasList = new List<int>();
        }
    }
}

