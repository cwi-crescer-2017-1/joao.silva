namespace CWI.EditoraCresccer.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class ModificacoesNoLivroQuantoAPublicacaoERevisao : DbMigration
    {
        public override void Up()
        {
            AddColumn("dbo.Livro", "Usuario_Id", c => c.Int());
            AlterColumn("dbo.Livro", "DataRevisao", c => c.DateTime());
            CreateIndex("dbo.Livro", "Usuario_Id");
            AddForeignKey("dbo.Livro", "Usuario_Id", "dbo.Usuarios", "Id");
        }
        
        public override void Down()
        {
            DropForeignKey("dbo.Livro", "Usuario_Id", "dbo.Usuarios");
            DropIndex("dbo.Livro", new[] { "Usuario_Id" });
            AlterColumn("dbo.Livro", "DataRevisao", c => c.DateTime(nullable: false));
            DropColumn("dbo.Livro", "Usuario_Id");
        }
    }
}
