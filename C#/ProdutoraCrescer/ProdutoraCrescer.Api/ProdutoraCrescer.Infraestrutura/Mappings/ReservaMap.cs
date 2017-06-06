using ProdutoraCrescer.Dominio.Entidades;
using System.Data.Entity.ModelConfiguration;

namespace ProdutoraCrescer.Infraestrutura.Mappings
{
    internal class ReservaMap : EntityTypeConfiguration<Reserva>
    {
        public ReservaMap()
        {
            ToTable("Reserva");

            HasKey(x => x.Id);

            HasRequired(x => x.Cliente)
               .WithMany()
               .Map(x => x.MapKey("IdCliente"));

            HasRequired(x => x.Usuario)
                .WithMany()
                .Map(x => x.MapKey("IdUsuario"));

            HasOptional(x => x.Pacote)
                .WithMany()
                .Map(x => x.MapKey("IdPacote"));

            HasRequired(x => x.Festa)
                .WithMany()
                .Map(x => x.MapKey("IdFesta"));

            HasOptional(x => x.Opcional)
                .WithMany()
                .Map(x => x.MapKey("IdOpcional"));
        }
    }
}
