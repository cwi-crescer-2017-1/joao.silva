namespace CWI.EditoraCresccer.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class AjusteNoLivroRevisor : DbMigration
    {
        public override void Up()
        {
            DropForeignKey("dbo.Livro", "Usuario_Id", "dbo.Usuarios");
            DropIndex("dbo.Livro", new[] { "Usuario_Id" });
            CreateTable(
                "dbo.LivroUsuarioAssinante",
                c => new
                    {
                        IdUsuario = c.Int(nullable: false),
                        IsbnLivro = c.Int(nullable: false),
                    })
                .PrimaryKey(t => new { t.IdUsuario, t.IsbnLivro })
                .ForeignKey("dbo.Usuarios", t => t.IdUsuario, cascadeDelete: true)
                .ForeignKey("dbo.Livro", t => t.IsbnLivro, cascadeDelete: true)
                .Index(t => t.IdUsuario)
                .Index(t => t.IsbnLivro);
            
            DropColumn("dbo.Livro", "Usuario_Id");
        }
        
        public override void Down()
        {
            AddColumn("dbo.Livro", "Usuario_Id", c => c.Int());
            DropForeignKey("dbo.LivroUsuarioAssinante", "IsbnLivro", "dbo.Livro");
            DropForeignKey("dbo.LivroUsuarioAssinante", "IdUsuario", "dbo.Usuarios");
            DropIndex("dbo.LivroUsuarioAssinante", new[] { "IsbnLivro" });
            DropIndex("dbo.LivroUsuarioAssinante", new[] { "IdUsuario" });
            DropTable("dbo.LivroUsuarioAssinante");
            CreateIndex("dbo.Livro", "Usuario_Id");
            AddForeignKey("dbo.Livro", "Usuario_Id", "dbo.Usuarios", "Id");
        }
    }
}
