using ProdutoraCrescer.Dominio.Entidades;
using ProdutoraCrescer.Infraestrutura.Mappings;
using System.Data.Entity;

namespace ProdutoraCrescer.Infraestrutura
{
    public class Contexto : DbContext
    {
        public Contexto() : base("name=BancoSP") { }

        public DbSet<Cliente> Clientes { get; set; }
        public DbSet<Festa> Festas { get; set; }
        public DbSet<Opcional> Opcionais { get; set; }
        public DbSet<Usuario> Usuarios { get; set; }
        public DbSet<Pacote> Pacotes { get; set; }
        public DbSet<Reserva> Reservas { get; set; }

        protected override void OnModelCreating(DbModelBuilder modelBuilder)
        {
            modelBuilder.Configurations.Add(new ClienteMap());
            modelBuilder.Configurations.Add(new FestaMap());
            modelBuilder.Configurations.Add(new OpcionalMap());
            modelBuilder.Configurations.Add(new UsuarioMap());
            modelBuilder.Configurations.Add(new PacoteMap());
            modelBuilder.Configurations.Add(new ReservaMap());
        }

    }
}
