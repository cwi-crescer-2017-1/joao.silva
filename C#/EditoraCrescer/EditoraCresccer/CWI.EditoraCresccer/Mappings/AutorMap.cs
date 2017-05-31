using CWI.EditoraCresccer.Entidades;
using System.Data.Entity.ModelConfiguration;

namespace CWI.EditoraCresccer
{
    internal class AutorMap : EntityTypeConfiguration<Autor>
    {
        public AutorMap()
        {
            ToTable("Autor");
            Property(a => a.Nome)
                    .HasMaxLength(300);
        }
    }
}