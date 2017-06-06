using ProdutoraCrescer.Dominio.Entidades;
using System.Data.Entity.ModelConfiguration;

namespace ProdutoraCrescer.Infraestrutura.Mappings
{
    internal class FestaMap : EntityTypeConfiguration<Festa>
    {
        public FestaMap()
        {
            ToTable("Festa");

            HasKey(x => x.Id);

            Property(x => x.Nome).HasMaxLength(100);

        }
    }
}
