namespace CWI.EditoraCresccer.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class ModificacaoMaxLengthNomeAutor : DbMigration
    {
        public override void Up()
        {
            AlterColumn("dbo.Autores", "Nome", c => c.String(maxLength: 300));
        }
        
        public override void Down()
        {
            AlterColumn("dbo.Autores", "Nome", c => c.String());
        }
    }
}
