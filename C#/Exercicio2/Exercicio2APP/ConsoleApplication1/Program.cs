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
            List<int> entradasList = new List<int>();
            bool continua = true;
            int intNovoValor;
            int erros = 0;
            while (continua) {
                Console.WriteLine("Digite algo (exit para sair)");
                var novoValor = Console.ReadLine();
                if(novoValor == "exit")
                {
                    continua = false;
                }else
                {
                    if (int.TryParse(novoValor, out intNovoValor))
                    {
                        entradasList.Add(intNovoValor);
                    }else
                    {
                        erros++;
                    }
                }
            }
            foreach (var entrada in entradasList)
            {
                Console.WriteLine(entrada);
            }
            Console.WriteLine($"Foram encontradas {erros} digitações inválidas que não foram salvas");
            Console.ReadKey();
        }
    }
}
