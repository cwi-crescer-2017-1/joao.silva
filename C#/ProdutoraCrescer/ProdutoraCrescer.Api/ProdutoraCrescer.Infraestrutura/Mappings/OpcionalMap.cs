using ProdutoraCrescer.Dominio.Entidades;
using System.Data.Entity.ModelConfiguration;

namespace ProdutoraCrescer.Infraestrutura.Mappings
{
    internal class OpcionalMap : EntityTypeConfiguration<Opcional>
    {
        public OpcionalMap()
        {
            ToTable("Opcional");

            HasKey(x => x.Id);

            Property(x => x.Nome).HasMaxLength(100);

        }
    }
}
