using System.Data.Entity.ModelConfiguration;
using CWI.EditoraCresccer.Entidades;

namespace CWI.EditoraCresccer
{
    internal class LivroMap : EntityTypeConfiguration<Livro>
    {
        public LivroMap()
        {
            ToTable("Livro");

            HasKey(x => x.Isbn);

            HasRequired(x => x.Autor)
                .WithMany()
                .HasForeignKey(x => x.IdAutor);

            HasOptional(x => x.Revisor)
                .WithMany()
                .HasForeignKey(x => x.IdRevisor);
        }
    }
}