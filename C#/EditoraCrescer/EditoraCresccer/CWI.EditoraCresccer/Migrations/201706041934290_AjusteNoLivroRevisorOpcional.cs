namespace CWI.EditoraCresccer.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class AjusteNoLivroRevisorOpcional : DbMigration
    {
        public override void Up()
        {
            DropForeignKey("dbo.Livro", "IdRevisor", "dbo.Usuarios");
            DropIndex("dbo.Livro", new[] { "IdRevisor" });
            AlterColumn("dbo.Livro", "IdRevisor", c => c.Int());
            CreateIndex("dbo.Livro", "IdRevisor");
            AddForeignKey("dbo.Livro", "IdRevisor", "dbo.Usuarios", "Id");
        }
        
        public override void Down()
        {
            DropForeignKey("dbo.Livro", "IdRevisor", "dbo.Usuarios");
            DropIndex("dbo.Livro", new[] { "IdRevisor" });
            AlterColumn("dbo.Livro", "IdRevisor", c => c.Int(nullable: false));
            CreateIndex("dbo.Livro", "IdRevisor");
            AddForeignKey("dbo.Livro", "IdRevisor", "dbo.Usuarios", "Id", cascadeDelete: true);
        }
    }
}
