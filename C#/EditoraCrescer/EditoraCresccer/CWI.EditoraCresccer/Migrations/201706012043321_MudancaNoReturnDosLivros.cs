namespace CWI.EditoraCresccer.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class MudancaNoReturnDosLivros : DbMigration
    {
        public override void Up()
        {
            AlterColumn("dbo.Livro", "DataPublicacao", c => c.DateTime());
        }
        
        public override void Down()
        {
            AlterColumn("dbo.Livro", "DataPublicacao", c => c.DateTime(nullable: false));
        }
    }
}
