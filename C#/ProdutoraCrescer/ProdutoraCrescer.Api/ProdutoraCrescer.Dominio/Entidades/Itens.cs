namespace ProdutoraCrescer.Dominio.Entidades
{
    public class Itens
    {
        public Pacote Pacote { get; private set; }
        public Festa Festa { get; private set; }
        public Opcional Opcional { get; private set; }
        public Usuario Usuario { get; private set; }
        public Cliente Cliente { get; private set; }

        public Itens(Pacote pacote, Festa festa, Opcional opcional, Usuario usuario, Cliente cliente)
        {
            Pacote = pacote;
            Festa = festa;
            Opcional = opcional;
            Usuario = usuario;
            Cliente = cliente;
        }
    }
}