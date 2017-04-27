-- Aula 1 de Banco de Dados I

create table Carro (
        placa           varchar(7) ,
        cor             varchar(20),
        marca           varchar(30),
        modelo          varchar(30),
        proprietario    varchar(150),
        email           varchar(100),
        telefone        varchar(100)
);

insert into Carro 
      (placa, 
       cor, 
       marca,
       modelo,
       proprietario,
       email,
       telefone) 
   values
      ('ABC3401', 
       'branco',
       'fiat', 
       'palio',
       'carlos da silva', 
       'carlos.silva@company.com', 
       '9987-0102');
	  
	Select * from Carro;

	Select * from Carro where marca = 'fiat';

	Select c.telefone from Carro c;

	Select c.modelo as 'Modelo', c.marca as 'Marca' from Carro c;

	insert into Carro (
	   placa, 
       cor, 
       marca,
       modelo,
       proprietario,
       email,
       telefone)
	   values(
	   'FFF0000',
	   'Vermelho',
	   'Mongo',
	   'DB',
	   'Whatever',
	   'mongoDB@whatever.com.br',
	   '66666666');

	   Select * From Carro;
	   Select top 1 * From Carro c;

	   ALTER TABLE CARRO ALTER COLUMN PLACA VARCHAR(8);
	   DROP TABLE Pais;
	   Create table Pais( 
	   IDPais int not null,
	   Nome varchar(50) not null,
	   Sigla varchar(3),
	   constraint PK_Pais primary key(IDPais) -- chave primária
	   )
	   insert into Pais(IDPais, Nome, Sigla)
	   values (1,'Brazil' , 'BRA');

	   SELECT * FROM Pais;

	   ALTER TABLE Pais ADD DDI varchar(5);

	   insert into Pais(IDPais, Nome, Sigla, DDI)
	   values (2,'Brazil' , 'BRA', '041');
	   
	   DROP TABLE Pais;
	   CREATE TABLE Pais(
	   IDPais INT IDENTITY(1,1) PRIMARY KEY  not null,
	   Nome VARCHAR(50) not null,
	   Sigla VARCHAR(3),
	   )
	   INSERT INTO PaisAuto(Nome, Sigla)
	   VALUES ('Brazil', 'BRA');

	   SELECT * FROM PaisAuto;

	   DROP TABLE PaisAuto;

	   ALTER TABLE PaisAuto ALTER COLUMN Sigla VARCHAR(4);

	   INSERT INTO PaisAuto(Nome, Sigla)
	   VALUES ('Brazil', 'BRA2');

	   DROP TABLE Pais;
	    
       CREATE TABLE Pais(
	   IDPais INT IDENTITY(1,1) not null,
	   Nome VARCHAR(50) not null,
	   Sigla VARCHAR(3),
	   CONSTRAINT PK_Pais PRIMARY KEY (IDPais),
	   CONSTRAINT UK_Nome UNIQUE (Nome),
	   )

	   INSERT INTO Pais(Nome,Sigla)
	   VALUES
	   ('Brasil','BR'),
	   ('Argentina','AR'),
	   ('China','CH'),
	   ('Estados Unidos','US');

	   SELECT * FROM Pais;

	   DROP TABLE Pais;

	   CREATE TABLE Pais(
	   IDPais INT IDENTITY(1,1) NOT NULL,
	   Nome VARCHAR(25) NOT NULL,
	   Sigla VARCHAR(3) NOT NULL,
	   ServidorAtivo VARCHAR(1)  NOT NULL, -- SEMPRE 'S' OU 'N'
	   CONSTRAINT SERVIDOR_SITUACAO CHECK (ServidorAtivo in('S', 'N')),
	   CONSTRAINT PK_IDPais PRIMARY KEY (IDPais),
	   );

	   INSERT INTO Pais(Nome,Sigla, ServidorAtivo)
	   VALUES
	   ('Brasil','BR','S'),
	   ('Argentina','AR','N'),
	   ('China','CH','S'),
	   ('Estados Unidos','US','S');

	   SELECT * FROM Pais p WHERE p.ServidorAtivo = 'S'; 