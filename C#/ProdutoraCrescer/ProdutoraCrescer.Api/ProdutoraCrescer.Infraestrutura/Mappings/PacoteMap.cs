using ProdutoraCrescer.Dominio.Entidades;
using System.Data.Entity.ModelConfiguration;

namespace ProdutoraCrescer.Infraestrutura.Mappings
{
    internal class PacoteMap : EntityTypeConfiguration<Pacote>
    {
        public PacoteMap()
        {
            ToTable("Pacote");

            HasKey(x => x.Id);

            Property(x => x.Nome).HasMaxLength(100);

        }
    }
}
