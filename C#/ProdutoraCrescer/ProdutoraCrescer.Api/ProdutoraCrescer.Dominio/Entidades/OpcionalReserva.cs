//using System.Collections.Generic;

//namespace ProdutoraCrescer.Dominio.Entidades
//{
//    public class OpcionalReserva
//    {
//        public int Id { get; private set; }
//        public int Quantidade { get; private set; }
//        public Opcional Opcional { get; private set; }
//        public Reserva Reserva { get; private set; }
//        private List<string> Mensagens { get; set; }

//        protected OpcionalReserva() { }
//        public OpcionalReserva(int quantidade, Opcional opcional, Reserva reserva)
//        {
//            Id = 0;
//            Quantidade = quantidade;
//            Opcional = opcional;
//            Reserva = reserva;
//        }

//        public bool Validar()
//        {
//            Mensagens.Clear();

//            if (Quantidade<=0)
//                Mensagens.Add("Quantidade inválida.");
//            if(Opcional == null)
//                Mensagens.Add("Opcional inválido.");
//            if (Reserva == null)
//                Mensagens.Add("Reserva inválida.");

//            return Mensagens.Count == 0;
//        }
//    }
//}
