namespace CWI.EditoraCresccer.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class RetornoResumidoDoLivroAutorERevisor : DbMigration
    {
        public override void Up()
        {
            AddColumn("dbo.Livro", "Capa", c => c.String());
        }
        
        public override void Down()
        {
            DropColumn("dbo.Livro", "Capa");
        }
    }
}
