using Microsoft.VisualStudio.TestTools.UnitTesting;
using ProdutoraCrescer.Dominio.Entidades;
using System;


namespace ProdutoraCrescer.Api.Testes
{
    [TestClass]
    public class ReservaUnitTest
    {
        [TestMethod]
        public void Deve_Criar_Entidade_Reserva_Valida()
        {
            var data = new DateTime();
            var valor = 2000;
            var duracaoReservaEmDias = 10;
            var pacote = new Pacote("Pacote Premium",true,true,true,100,150);
            var festa = new Festa("Festa infantil", 100, 150);
            var opcional = new Opcional("Piscina de bolinhas", 100, 150, 10);
            var usuario = new Usuario("Giovani", "123456", "giovani@cwi.com.br", "Funcionario");
            var cliente = new Cliente("Giovani", "Rua X Bairro Y", "12345678956", "Masculino", data, "giovani@cwi.com.br");

            var reserva = new Reserva(valor,duracaoReservaEmDias,pacote,festa,usuario,cliente,opcional);

            Assert.IsTrue(reserva.Validar());
            Assert.IsFalse(reserva.Mensagens.Count > 0);
        }
        [TestMethod]
        public void Nao_Deve_Criar_Entidade_Reserva_Sem_Festa()
        {
            var data = new DateTime();
            var valor = 2000;
            var duracaoReservaEmDias = 10;
            var pacote = new Pacote("Pacote Premium", true, true, true, 100, 150);
            var opcional = new Opcional("Piscina de bolinhas", 100, 150, 10);
            var usuario = new Usuario("Giovani", "123456", "giovani@cwi.com.br", "Funcionario");
            var cliente = new Cliente("Giovani", "Rua X Bairro Y", "12345678956", "Masculino", data, "giovani@cwi.com.br");

            var reserva = new Reserva(valor, duracaoReservaEmDias, pacote, null, usuario, cliente, opcional);

            Assert.IsFalse(reserva.Validar());
            Assert.IsTrue(reserva.Mensagens.Count > 0);
            Assert.IsTrue(reserva.Mensagens[0] == "Festa inválida");
        }
        [TestMethod]
        public void Nao_Deve_Criar_Entidade_Reserva_Com_Valor_Negativo()
        {
            var data = new DateTime();
            var valor = -1000;
            var duracaoReservaEmDias = 10;
            var festa = new Festa("Festa infantil", 100, 150);
            var pacote = new Pacote("Pacote Premium", true, true, true, 100, 150);
            var opcional = new Opcional("Piscina de bolinhas", 100, 150, 10);
            var usuario = new Usuario("Giovani", "123456", "giovani@cwi.com.br", "Funcionario");
            var cliente = new Cliente("Giovani", "Rua X Bairro Y", "12345678956", "Masculino", data, "giovani@cwi.com.br");

            var reserva = new Reserva(valor, duracaoReservaEmDias, pacote, festa, usuario, cliente, opcional);

            Assert.IsFalse(reserva.Validar());
            Assert.IsTrue(reserva.Mensagens.Count > 0);
            Assert.IsTrue(reserva.Mensagens[0] == "Valor inválido.");
        }
        [TestMethod]
        public void Nao_Deve_Criar_Entidade_Reserva_Com_duracaoReservaEmDias_Negativa()
        {
            var data = new DateTime();
            var valor = 1000;
            var duracaoReservaEmDias = -1;
            var festa = new Festa("Festa infantil", 100, 150);
            var pacote = new Pacote("Pacote Premium", true, true, true, 100, 150);
            var opcional = new Opcional("Piscina de bolinhas", 100, 150, 10);
            var usuario = new Usuario("Giovani", "123456", "giovani@cwi.com.br", "Funcionario");
            var cliente = new Cliente("Giovani", "Rua X Bairro Y", "12345678956", "Masculino", data, "giovani@cwi.com.br");

            var reserva = new Reserva(valor, duracaoReservaEmDias, pacote, festa, usuario, cliente, opcional);

            Assert.IsFalse(reserva.Validar());
            Assert.IsTrue(reserva.Mensagens.Count > 0);
            Assert.IsTrue(reserva.Mensagens[0] == "Data devolução prevista inválida.");
        }
        [TestMethod]
        public void Nao_Deve_Criar_Entidade_Reserva_Sem_Cliente()
        {
            var valor = 1000;
            var duracaoReservaEmDias = 5;
            var festa = new Festa("Festa infantil", 100, 150);
            var pacote = new Pacote("Pacote Premium", true, true, true, 100, 150);
            var opcional = new Opcional("Piscina de bolinhas", 100, 150, 10);
            var usuario = new Usuario("Giovani", "123456", "giovani@cwi.com.br", "Funcionario");
            var reserva = new Reserva(valor, duracaoReservaEmDias, pacote, festa, usuario, null, opcional);

            Assert.IsFalse(reserva.Validar());
            Assert.IsTrue(reserva.Mensagens.Count > 0);
            Assert.IsTrue(reserva.Mensagens[0] == "Cliente inválido");
        }
        [TestMethod]
        public void Nao_Deve_Criar_Entidade_Reserva_Sem_Usuario()
        {
            var data = new DateTime();
            var valor = 1000;
            var duracaoReservaEmDias = 10;
            var festa = new Festa("Festa infantil", 100, 150);
            var pacote = new Pacote("Pacote Premium", true, true, true, 100, 150);
            var opcional = new Opcional("Piscina de bolinhas", 100, 150, 10);
            var cliente = new Cliente("Giovani", "Rua X Bairro Y", "12345678956", "Masculino", data, "giovani@cwi.com.br");

            var reserva = new Reserva(valor, duracaoReservaEmDias, pacote, festa, null, cliente, opcional);

            Assert.IsFalse(reserva.Validar());
            Assert.IsTrue(reserva.Mensagens.Count > 0);
            Assert.IsTrue(reserva.Mensagens[0] == "Usuario inválido");
        }
        [TestMethod]
        public void Nao_Deve_Criar_Entidade_Reserva_Com_Opcional_Sem_Quantidade_Necessaria()
        {
            var data = new DateTime();
            var valor = 1000;
            var duracaoReservaEmDias = 10;
            var festa = new Festa("Festa infantil", 100, 150);
            var pacote = new Pacote("Pacote Premium", true, true, true, 100, 150);
            var opcional = new Opcional("Piscina de bolinhas", 100, 150, 0);
            var usuario = new Usuario("Giovani", "123456", "giovani@cwi.com.br", "Funcionario");
            var cliente = new Cliente("Giovani", "Rua X Bairro Y", "12345678956", "Masculino", data, "giovani@cwi.com.br");

            var reserva = new Reserva(valor, duracaoReservaEmDias, pacote, festa, usuario, cliente, opcional);

            Assert.IsFalse(reserva.Validar());
            Assert.IsTrue(reserva.Mensagens.Count > 0);
            Assert.IsTrue(reserva.Mensagens[0] == "Quantidade de indísponível");
        }
    }
}
