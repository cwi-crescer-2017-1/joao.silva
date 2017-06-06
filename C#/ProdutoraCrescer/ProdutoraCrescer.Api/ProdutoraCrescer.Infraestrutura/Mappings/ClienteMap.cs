using ProdutoraCrescer.Dominio.Entidades;
using System.Data.Entity.ModelConfiguration;

namespace ProdutoraCrescer.Infraestrutura.Mappings
{
    internal class ClienteMap : EntityTypeConfiguration<Cliente>
    {
        public ClienteMap()
        {
            ToTable("Cliente");

            HasKey(x => x.Id);

            Property(x => x.Nome).HasMaxLength(100);
            Property(x => x.Email).HasMaxLength(100);
            Property(x => x.Genero).HasMaxLength(100);
            Property(x => x.CPF).HasMaxLength(11);
        }
    }
}
