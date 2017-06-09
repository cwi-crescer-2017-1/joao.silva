using ProdutoraCrescer.Dominio.Entidades;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;

namespace ProdutoraCrescer.Infraestrutura.Repositorio
{
    public class ReservaRepositorio : IDisposable
    {
        private Contexto contexto;

        public ReservaRepositorio()
        {
            contexto = new Contexto();
        }

        public Reserva ObterPorId(int id)
        {
            return contexto.Reservas.FirstOrDefault(reserva => reserva.Id == id);
        }

        public Reserva ObterPorCPF(string cpf)
        {
            return contexto.Reservas.FirstOrDefault(reserva => reserva.Cliente.CPF == cpf);
        }

        public List<Reserva> ObterListaPorIdCliente(int id)
        {
            return contexto.Reservas.Where(reserva => reserva.Cliente.Id == id).ToList();
        }

        public List<Reserva> ObterLista()
        {
            return contexto.Reservas
                                .Include(x => x.Pacote)
                                .Include(x => x.Opcional)
                                .Include(x => x.Usuario)
                                .Include(x => x.Festa)
                                .Include(x=>x.Cliente)
                                .ToList();
        }

        public List<Reserva> ObterListaNaoDevolvidos()
        {
            return contexto.Reservas
                                .Where(reserva=>reserva.DataDevolucao_Real == null)
                                .Include(x => x.Pacote)
                                .Include(x => x.Opcional)
                                .Include(x => x.Usuario)
                                .Include(x => x.Festa)
                                .Include(x => x.Cliente)
                                .ToList();
        }

        public object Criar(dynamic c)
        {
            if (c.IdOpcional == null)
            {
                c.IdOpcional = -1;
            }
            if(c.IdCliente==null||c.IdUsuario==null||c.IdFesta==null||c.TempoReservaEmDias==null||c.IdPacote == null)
            {
                return null;
            }
            int idCliente = c.IdCliente;
            int idUsuario = c.IdUsuario;
            int idFesta = c.IdFesta;
            int tempoReservaEmDias = c.TempoReservaEmDias;
            int idOpcional = c.IdOpcional;
            int idPacote = c.IdPacote;
            Itens itens = ObterItensReserva(idCliente,idUsuario,idOpcional,idPacote, idFesta);
            decimal valor = GerarOrcamento(itens.Pacote, itens.Festa, itens.Opcional, tempoReservaEmDias);
            Reserva reserva = new Reserva(valor, tempoReservaEmDias, itens.Pacote, itens.Festa, itens.Usuario, itens.Cliente, itens.Opcional);
            //Se a quantidade de opcional não diminuir fazer isso a mão aqui
            if (reserva.Validar())
            {
                contexto.Reservas.Add(reserva);
                contexto.SaveChanges();
                return reserva;
            }
            return null;
        }

        public List<string> Alterar(dynamic c)
        {
            Cliente cliente = new Cliente(c.Nome, c.Endereco, c.CPF, c.Genero, c.DataNascimento, c.Email);

            if (cliente.Validar())
            {
                contexto.Entry(cliente).State = EntityState.Modified;
                contexto.SaveChanges();
                return null;
            }
            return cliente.Mensagens;
        }

        public void Excluir(int id)
        {
            Cliente cliente = contexto.Clientes.FirstOrDefault(x => x.Id == id);
            if (cliente != null)
            {
                contexto.Clientes.Remove(cliente);
                contexto.SaveChanges();
            }
        }

        public Itens ObterItensReserva(int idCliente, int idUsuario, int idOpcional, int idPacote, int idFesta)
        {
            Cliente cliente = contexto.Clientes.FirstOrDefault(x => x.Id == idCliente);
            Usuario usuario = contexto.Usuarios.FirstOrDefault(x => x.Id == idUsuario);
            Opcional opcional = contexto.Opcionais.FirstOrDefault(x => x.Id == idOpcional);
            Pacote pacote = contexto.Pacotes.FirstOrDefault(x => x.Id == idPacote);
            Festa festa = contexto.Festas.FirstOrDefault(x => x.Id == idFesta);

            return new Itens(pacote, festa, opcional, usuario, cliente);
        }

        public bool Devolver(int idReserva)
        {
            Reserva reserva = contexto.Reservas
                                .Include(x => x.Pacote)
                                .Include(x => x.Opcional)
                                .Include(x => x.Usuario)
                                .Include(x => x.Festa)
                                .Include(x => x.Cliente)
                                .FirstOrDefault(x => x.Id == idReserva);
            if(reserva != null)
            {
                bool resultado = reserva.Devolver();
                contexto.SaveChanges();
                return resultado;
            }
            return false;
        }

        public decimal PegarValorDevolucao(int idReserva)
        {
            Reserva reserva = contexto.Reservas
                                .Include(x => x.Pacote)
                                .Include(x => x.Opcional)
                                .Include(x => x.Usuario)
                                .Include(x => x.Festa)
                                .Include(x => x.Cliente)
                                .FirstOrDefault(x => x.Id == idReserva);
            if (reserva != null)
            {
                decimal valorDevolucao = reserva.CalcularDevolucao();
                return valorDevolucao;
            }
            return -1;
        }

        public object ObterRelatorioLocacaoMensal(DateTime dataFinal)
        {
            DateTime dataInicial = dataFinal.AddDays(-30);
            dataFinal = dataFinal.AddDays(1);
            List<Reserva> reservas = contexto.Reservas
                                .Include(x => x.Pacote)
                                .Include(x => x.Opcional)
                                .Include(x => x.Usuario)
                                .Include(x => x.Festa)
                                .Include(x => x.Cliente)
                                .Where(x => x.DataDevolucao_Real >= dataInicial && x.DataDevolucao_Real <= dataFinal)
                                .ToList();
            decimal valorTotal = reservas.Sum(reserva => reserva.Valor);

            return new { Reservas = reservas, Valor = valorTotal };
        }

        public List<Reserva> ObterRelatorioAtrasos()
        {
            DateTime hoje = DateTime.UtcNow;
            List<Reserva> reservas = contexto.Reservas
                                .Include(x => x.Pacote)
                                .Include(x => x.Opcional)
                                .Include(x => x.Usuario)
                                .Include(x => x.Festa)
                                .Include(x => x.Cliente)
                                .Where(x => x.DataDevolucao_Prevista < hoje && x.DataDevolucao_Real == null)
                                .OrderBy(x=> x.DataDevolucao_Prevista)
                                .ToList();
            return reservas;
        }
        private decimal GerarOrcamento(Pacote pacote, Festa festa, Opcional opcional, int tempoReservaEmDias)
        {
            decimal custoDiariaOpcional;
            if (opcional == null)
            {
               custoDiariaOpcional = 0;
            }
            else
            {
                custoDiariaOpcional = opcional.CustoDiaria;
            }
            decimal valor = (custoDiariaOpcional + pacote.CustoDiaria + festa.CustoDiaria) * tempoReservaEmDias;
            return valor;
        }

        public void Dispose()
        {
            contexto.Dispose();
        }
    }
}
