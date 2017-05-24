using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Demo1
{
    class Program
    {
        static void Main(string[] args)
        {
            var pessoa = new Pessoa();
            pessoa.Id = null;
            if (pessoa.Id == null)
            {
                Console.WriteLine("ID não tem valor");
            }
            else
            {
                Console.WriteLine($"Tem valor: {pessoa.Id}");
            }
            pessoa.Nascimento = new DateTime(1982, 10, 29);
            pessoa.Nome = "Giovani Decusati";
            char letra = 'C';
            var palavra = $"C#{letra}";
            Console.WriteLine($"Letra: {letra}");
            pessoa.Nome = $"{pessoa.Nome}, Palavra{palavra}";
            //Aspas duplas para string e aspas simples para letras
            var endereco = new Endereco();
            endereco.CEP = "92222666";
            endereco.Rua = "RuaRua";
            endereco.Numero = 555;
            pessoa.Endereco = endereco;
            var pessoa2 = new Pessoa("Construtor", 1, new DateTime(1982, 10, 29), endereco);
            Console.WriteLine($"Pessoa2: {pessoa2.Nome}{pessoa2.Id}{pessoa2.Nascimento}{pessoa2.Endereco.CEP}{pessoa2.Endereco.Rua}{pessoa2.Endereco.Numero}");
            Console.WriteLine($"Nome pessoa: {pessoa.Nome}");
            Console.WriteLine($"ID da pessoa: {pessoa.Id}");
            Console.WriteLine($"Nascimento da pessoa: {pessoa.Nascimento}");
            Console.WriteLine("CEP da pessoa" + pessoa.Endereco.CEP);
            Console.WriteLine("Rua da pessoa" + pessoa.Endereco.Rua);
            Console.WriteLine("Numero da casa da pessoa" + pessoa.Endereco.Numero);
            Console.WriteLine("Endereço completo: " + $"{pessoa.Endereco.CEP} - {pessoa.Endereco.Rua}, {pessoa.Endereco.Numero}");
            pessoa.setPropPrivated(3.14);
            Console.WriteLine(pessoa.getPropPrivated());
            Console.WriteLine("Informe seu peso");
            var entradaPeso = Console.ReadLine();
            Console.WriteLine("Informe sua altura (cm)");
            var entradaAltura = Console.ReadLine();
            double peso;//o D faz o tipo ser considerado double
            if (!double.TryParse(entradaPeso, out peso))
            {
                Console.WriteLine("Entrada inválida para peso");
            }
            double altura;
            if (!double.TryParse(entradaAltura, out altura))
            {
                Console.WriteLine("Entrada inválida para altura");
            }
            var calculoIMC = new CalculoIMC(altura, peso);
            var imc = calculoIMC.CalcularIMC();
            Console.WriteLine($"Seu imc: {imc}");
            Console.ReadKey();
        }
    }
}
