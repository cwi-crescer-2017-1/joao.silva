using ProdutoraCrescer.Dominio.Entidades;
using ProdutoraCrescer.Infraestrutura.Mappings;
using System.Data.Entity;

namespace ProdutoraCrescer.Infraestrutura
{
    public class Contexto : DbContext
    {
        public Contexto() : base("name=BancoSP") {
            //Configuration.ProxyCreationEnabled = true; //Necessário para o LazyLoading
            //Configuration.LazyLoadingEnabled = true; //default -- busca só o básico, para pegar outros valores é necessário o include
            // se definir public virtual Festa('classe(tabela(chave)) estrangeira') na classe a ser chamada o ef pode realizar um "include" automático
            //Ex: lá na Reserva a Festa é setada como public virtual
            //Lembrar que o EF só realiza as consultas a banco quando o ToList é realizado
            //AsNoTracking() -- Utilize quando a consulta for apenas para exibição de dados e não para modificação 
        }

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
