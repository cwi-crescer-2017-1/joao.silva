using ProdutoraCrescer.Dominio.Entidades;
using System.Data.Entity.ModelConfiguration;

namespace ProdutoraCrescer.Infraestrutura.Mappings
{
    internal class UsuarioMap : EntityTypeConfiguration<Usuario>
    {
        public UsuarioMap()
        {
            ToTable("Usuario");

            HasKey(x => x.Id);

            Property(x => x.Nome).HasMaxLength(100);
            Property(x => x.Email).HasMaxLength(100);
            Property(x => x.Permissao).HasMaxLength(100);
        }
    }
}
