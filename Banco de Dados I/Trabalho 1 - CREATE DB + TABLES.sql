CREATE DATABASE EmprestimoCelular;
USE [EmprestimoCelular];
USE [Crescer17];

-- Gerado por Oracle SQL Developer Data Modeler 4.2.0.932
--   em:        2017-05-04 00:22:42 BRT
--   site:      SQL Server 2012
--   tipo:      SQL Server 2012



CREATE TABLE Celular 
    (
     IDCelular VARCHAR (50) NOT NULL , 
     IDModeloCelular INTEGER NOT NULL 
    )
    ON "default"
GO

ALTER TABLE Celular ADD CONSTRAINT PK_Celular PRIMARY KEY CLUSTERED (IDCelular)
     WITH (
     ALLOW_PAGE_LOCKS = ON , 
     ALLOW_ROW_LOCKS = ON )
     ON "default" 
    GO

CREATE TABLE Chip 
    (
     IDChip INTEGER NOT NULL , 
     Numero VARCHAR (13) NOT NULL , 
     Operadora VARCHAR (30) NOT NULL 
    )
    ON "default"
GO

ALTER TABLE Chip ADD CONSTRAINT PK_Chip PRIMARY KEY CLUSTERED (IDChip)
     WITH (
     ALLOW_PAGE_LOCKS = ON , 
     ALLOW_ROW_LOCKS = ON )
     ON "default" 
    GO

CREATE TABLE Cliente 
    (
     IDCliente INTEGER NOT NULL , 
     Nome VARCHAR (50) NOT NULL 
    )
    ON "default"
GO

ALTER TABLE Cliente ADD CONSTRAINT PK_Cliente PRIMARY KEY CLUSTERED (IDCliente)
     WITH (
     ALLOW_PAGE_LOCKS = ON , 
     ALLOW_ROW_LOCKS = ON )
     ON "default" 
    GO

CREATE TABLE Colaborador 
    (
     IDColaborador INTEGER NOT NULL , 
     Nome VARCHAR (50) NOT NULL 
    )
    ON "default"
GO

ALTER TABLE Colaborador ADD CONSTRAINT PK_Colaborador PRIMARY KEY CLUSTERED (IDColaborador)
     WITH (
     ALLOW_PAGE_LOCKS = ON , 
     ALLOW_ROW_LOCKS = ON )
     ON "default" 
    GO

CREATE TABLE Emprestimo 
    (
     IDEmprestimo INTEGER NOT NULL , 
     DataInicio DATE NOT NULL , 
     DataFinal DATE NOT NULL , 
     IDCelular VARCHAR (50) NOT NULL , 
     IDProjeto INTEGER NOT NULL , 
     IDColaborador INTEGER NOT NULL 
    )
    ON "default"
GO

ALTER TABLE Emprestimo ADD CONSTRAINT PK_Emprestimo PRIMARY KEY CLUSTERED (IDEmprestimo)
     WITH (
     ALLOW_PAGE_LOCKS = ON , 
     ALLOW_ROW_LOCKS = ON )
     ON "default" 
    GO

CREATE TABLE EmprestimoChip 
    (
     IDEmprestimo INTEGER NOT NULL , 
     IDChip INTEGER NOT NULL 
    )
    ON "default"
GO

ALTER TABLE EmprestimoChip ADD CONSTRAINT PK_EmprestimoChip PRIMARY KEY CLUSTERED (IDEmprestimo, IDChip)
     WITH (
     ALLOW_PAGE_LOCKS = ON , 
     ALLOW_ROW_LOCKS = ON )
     ON "default" 
    GO

CREATE TABLE Ligacao 
    (
     IDLigacao INTEGER NOT NULL , 
     Data DATE NOT NULL , 
     Duracao TIME NOT NULL , 
     Custo NUMERIC (10,2) NOT NULL , 
     IDChip INTEGER NOT NULL 
    )
    ON "default"
GO

ALTER TABLE Ligacao ADD CONSTRAINT PK_Ligacao PRIMARY KEY CLUSTERED (IDLigacao)
     WITH (
     ALLOW_PAGE_LOCKS = ON , 
     ALLOW_ROW_LOCKS = ON )
     ON "default" 
    GO

CREATE TABLE ModeloCelular 
    (
     IDModeloCelular INTEGER NOT NULL , 
     Marca VARCHAR (30) NOT NULL , 
     Tipo VARCHAR (50) NOT NULL , 
     Codigo VARCHAR (20) NOT NULL 
    )
    ON "default"
GO

ALTER TABLE ModeloCelular ADD CONSTRAINT PK_ModeloCelular PRIMARY KEY CLUSTERED (IDModeloCelular)
     WITH (
     ALLOW_PAGE_LOCKS = ON , 
     ALLOW_ROW_LOCKS = ON )
     ON "default" 
    GO

CREATE TABLE Projeto 
    (
     IDProjeto INTEGER NOT NULL , 
     Nome VARCHAR (50) NOT NULL , 
     IDCliente INTEGER NOT NULL 
    )
    ON "default"
GO

ALTER TABLE Projeto ADD CONSTRAINT PK_Projeto PRIMARY KEY CLUSTERED (IDProjeto)
     WITH (
     ALLOW_PAGE_LOCKS = ON , 
     ALLOW_ROW_LOCKS = ON )
     ON "default" 
    GO

ALTER TABLE Celular 
    ADD CONSTRAINT FK_Celular_ModeloCelular FOREIGN KEY 
    ( 
     IDModeloCelular
    ) 
    REFERENCES ModeloCelular 
    ( 
     IDModeloCelular 
    ) 
    ON DELETE NO ACTION 
    ON UPDATE NO ACTION 
GO

ALTER TABLE Emprestimo 
    ADD CONSTRAINT FK_Emprestimo_Celula FOREIGN KEY 
    ( 
     IDCelular
    ) 
    REFERENCES Celular 
    ( 
     IDCelular 
    ) 
    ON DELETE NO ACTION 
    ON UPDATE NO ACTION 
GO

ALTER TABLE Emprestimo 
    ADD CONSTRAINT FK_Emprestimo_Colaborador FOREIGN KEY 
    ( 
     IDColaborador
    ) 
    REFERENCES Colaborador 
    ( 
     IDColaborador 
    ) 
    ON DELETE NO ACTION 
    ON UPDATE NO ACTION 
GO

ALTER TABLE Emprestimo 
    ADD CONSTRAINT FK_Emprestimo_Projeto FOREIGN KEY 
    ( 
     IDProjeto
    ) 
    REFERENCES Projeto 
    ( 
     IDProjeto 
    ) 
    ON DELETE NO ACTION 
    ON UPDATE NO ACTION 
GO

ALTER TABLE EmprestimoChip 
    ADD CONSTRAINT FK_EmprestimoChip_Chip FOREIGN KEY 
    ( 
     IDChip
    ) 
    REFERENCES Chip 
    ( 
     IDChip 
    ) 
    ON DELETE NO ACTION 
    ON UPDATE NO ACTION 
GO

ALTER TABLE EmprestimoChip 
    ADD CONSTRAINT FK_EmprestimoChip_Emprestimo FOREIGN KEY 
    ( 
     IDEmprestimo
    ) 
    REFERENCES Emprestimo 
    ( 
     IDEmprestimo 
    ) 
    ON DELETE NO ACTION 
    ON UPDATE NO ACTION 
GO

ALTER TABLE Ligacao 
    ADD CONSTRAINT FK_Ligacao_Chip FOREIGN KEY 
    ( 
     IDChip
    ) 
    REFERENCES Chip 
    ( 
     IDChip 
    ) 
    ON DELETE NO ACTION 
    ON UPDATE NO ACTION 
GO

ALTER TABLE Projeto 
    ADD CONSTRAINT FK_Projeto_Cliente FOREIGN KEY 
    ( 
     IDCliente
    ) 
    REFERENCES Cliente 
    ( 
     IDCliente 
    ) 
    ON DELETE NO ACTION 
    ON UPDATE NO ACTION 
GO



-- Relatório do Resumo do Oracle SQL Developer Data Modeler: 
-- 
-- CREATE TABLE                             9
-- CREATE INDEX                             0
-- ALTER TABLE                             17
-- CREATE VIEW                              0
-- ALTER VIEW                               0
-- CREATE PACKAGE                           0
-- CREATE PACKAGE BODY                      0
-- CREATE PROCEDURE                         0
-- CREATE FUNCTION                          0
-- CREATE TRIGGER                           0
-- ALTER TRIGGER                            0
-- CREATE DATABASE                          0
-- CREATE DEFAULT                           0
-- CREATE INDEX ON VIEW                     0
-- CREATE ROLLBACK SEGMENT                  0
-- CREATE ROLE                              0
-- CREATE RULE                              0
-- CREATE SCHEMA                            0
-- CREATE SEQUENCE                          0
-- CREATE PARTITION FUNCTION                0
-- CREATE PARTITION SCHEME                  0
-- 
-- DROP DATABASE                            0
-- 
-- ERRORS                                   0
-- WARNINGS                                 0

