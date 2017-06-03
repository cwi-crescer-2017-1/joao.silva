using System.Data.Entity.ModelConfiguration;
using CWI.EditoraCresccer.Entidades;

namespace CWI.EditoraCresccer.Mappings
{
    class UsuarioMap : EntityTypeConfiguration<Usuario>
    {
        public UsuarioMap()
        {
            HasMany(x => x.Permissoes).WithMany().Map(x =>
            {
                x.MapLeftKey("IdUsuario");
                x.MapRightKey("IdPermissao");
                x.ToTable("UsuarioPermissao");
            });
        }
    }
}