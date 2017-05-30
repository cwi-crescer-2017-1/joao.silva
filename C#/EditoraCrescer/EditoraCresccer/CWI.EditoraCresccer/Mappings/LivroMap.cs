using System.Data.Entity.ModelConfiguration;
using CWI.EditoraCresccer.Entidades;

namespace CWI.EditoraCresccer
{
    internal class LivroMap : EntityTypeConfiguration<Livro>
    {
        public LivroMap()
        {
            ToTable("Livros");

            HasKey(x => x.Isbn);

            HasRequired(x => x.Autor)
                .WithMany()
                .HasForeignKey(x => x.IdAutor);
        }
    }
}