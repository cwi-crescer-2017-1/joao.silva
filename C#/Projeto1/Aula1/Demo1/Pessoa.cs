using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Demo1
{
    class Pessoa
    {
        public const double PI = 3.14;
        public readonly double PIreadonly;
        private double PropPrivate; //Não pode-se ler fora da classe, nem na herança
        protected double PropProtected; //Pode ser lida na herança
        public double PropPublic;
        internal double PropInternal;//Visivel apenas dentro do Assembly

        public Pessoa(string nome, int id, DateTime nascimento, Endereco endereco)
        {
            this.Nome = nome;
            this.Id = id;
            this.Nascimento = nascimento;
            this.Endereco = endereco;
            //prop cria variavel publica com set e get public
            //propg cria varialve com set private e get public
            //ctor tab tab = construtor
            PIreadonly = 3.14; //readOnly pode ser setada no construtor, mas nunca em um método
        }
        public Pessoa()
        {
            PIreadonly = 3.14; //readOnly pode ser setada no construtor, mas nunca em um método
        }
        public string Nome { get; set; }
        public int? Id { get; set; }
        public DateTime Nascimento { get; set; }
        public Endereco Endereco { get; set; }
        public void setPropPrivated(double valor)
        {
            this.PropPrivate = valor;
        }
        public double getPropPrivated()
        {
            return this.PropPrivate;
        }
    }
}
