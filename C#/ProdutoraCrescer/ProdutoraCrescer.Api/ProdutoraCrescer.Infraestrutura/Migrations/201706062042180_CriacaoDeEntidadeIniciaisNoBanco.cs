namespace ProdutoraCrescer.Infraestrutura.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class CriacaoDeEntidadeIniciaisNoBanco : DbMigration
    {
        public override void Up()
        {
            CreateTable(
                "dbo.Cliente",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Nome = c.String(maxLength: 100),
                        Endereco = c.String(),
                        CPF = c.String(maxLength: 11),
                        Genero = c.String(maxLength: 100),
                        DataNascimento = c.DateTime(nullable: false),
                        Email = c.String(maxLength: 100),
                    })
                .PrimaryKey(t => t.Id);
            
            CreateTable(
                "dbo.Festa",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Nome = c.String(maxLength: 100),
                        CustoDiaria = c.Decimal(nullable: false, precision: 18, scale: 2),
                        CustoMulta = c.Decimal(nullable: false, precision: 18, scale: 2),
                    })
                .PrimaryKey(t => t.Id);
            
            CreateTable(
                "dbo.Opcional",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Quantidade = c.Int(nullable: false),
                        Nome = c.String(maxLength: 100),
                        CustoDiaria = c.Decimal(nullable: false, precision: 18, scale: 2),
                        CustoMulta = c.Decimal(nullable: false, precision: 18, scale: 2),
                    })
                .PrimaryKey(t => t.Id);
            
            CreateTable(
                "dbo.Pacote",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Nome = c.String(maxLength: 100),
                        Decoracao = c.Boolean(nullable: false),
                        Instalacao = c.Boolean(nullable: false),
                        Equipe = c.Boolean(nullable: false),
                        CustoDiaria = c.Decimal(nullable: false, precision: 18, scale: 2),
                        CustoMulta = c.Decimal(nullable: false, precision: 18, scale: 2),
                    })
                .PrimaryKey(t => t.Id);
            
            CreateTable(
                "dbo.Reserva",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Valor = c.Decimal(nullable: false, precision: 18, scale: 2),
                        DataLocacao = c.DateTime(nullable: false),
                        DataDevolucao_Prevista = c.DateTime(nullable: false),
                        DataDevolucao_Real = c.DateTime(),
                        IdCliente = c.Int(nullable: false),
                        IdFesta = c.Int(nullable: false),
                        IdOpcional = c.Int(),
                        IdPacote = c.Int(),
                        IdUsuario = c.Int(nullable: false),
                    })
                .PrimaryKey(t => t.Id)
                .ForeignKey("dbo.Cliente", t => t.IdCliente, cascadeDelete: true)
                .ForeignKey("dbo.Festa", t => t.IdFesta, cascadeDelete: true)
                .ForeignKey("dbo.Opcional", t => t.IdOpcional)
                .ForeignKey("dbo.Pacote", t => t.IdPacote)
                .ForeignKey("dbo.Usuario", t => t.IdUsuario, cascadeDelete: true)
                .Index(t => t.IdCliente)
                .Index(t => t.IdFesta)
                .Index(t => t.IdOpcional)
                .Index(t => t.IdPacote)
                .Index(t => t.IdUsuario);
            
            CreateTable(
                "dbo.Usuario",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Nome = c.String(maxLength: 100),
                        Senha = c.String(),
                        Email = c.String(maxLength: 100),
                        Permissao = c.String(maxLength: 100),
                    })
                .PrimaryKey(t => t.Id);
            
        }
        
        public override void Down()
        {
            DropForeignKey("dbo.Reserva", "IdUsuario", "dbo.Usuario");
            DropForeignKey("dbo.Reserva", "IdPacote", "dbo.Pacote");
            DropForeignKey("dbo.Reserva", "IdOpcional", "dbo.Opcional");
            DropForeignKey("dbo.Reserva", "IdFesta", "dbo.Festa");
            DropForeignKey("dbo.Reserva", "IdCliente", "dbo.Cliente");
            DropIndex("dbo.Reserva", new[] { "IdUsuario" });
            DropIndex("dbo.Reserva", new[] { "IdPacote" });
            DropIndex("dbo.Reserva", new[] { "IdOpcional" });
            DropIndex("dbo.Reserva", new[] { "IdFesta" });
            DropIndex("dbo.Reserva", new[] { "IdCliente" });
            DropTable("dbo.Usuario");
            DropTable("dbo.Reserva");
            DropTable("dbo.Pacote");
            DropTable("dbo.Opcional");
            DropTable("dbo.Festa");
            DropTable("dbo.Cliente");
        }
    }
}
