using CWI.EditoraCresccer.Entidades;
using System.Data.Entity.ModelConfiguration;

namespace CWI.EditoraCresccer.Mappings
{
    internal class PermissaoMap : EntityTypeConfiguration<Permissao>
    {
        public PermissaoMap()
        {
            ToTable("Permissao");
        }
    }
}