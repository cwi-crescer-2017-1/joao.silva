using CWI.EditoraCresccer.Entidades;
using CWI.EditoraCresccer.Mappings;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CWI.EditoraCresccer
{
    public class Contexto : DbContext
    {
        public Contexto() : base("name=ExemploEFSP") {}

        public DbSet<Autor> Autores { get; set; }
        public DbSet<Revisor> Revisores { get; set; }
        public DbSet<Livro> Livros { get; set; }
        public DbSet<Permissao> Permissoes { get; set; }
        public DbSet<Usuario> Usuarios { get; set; }

        protected override void OnModelCreating(DbModelBuilder modelBuilder)
        {
            modelBuilder.Configurations.Add(new AutorMap());
            modelBuilder.Configurations.Add(new RevisorMap());
            modelBuilder.Configurations.Add(new LivroMap());
            modelBuilder.Configurations.Add(new PermissaoMap());
            modelBuilder.Configurations.Add(new UsuarioMap());
        }

    }
}
