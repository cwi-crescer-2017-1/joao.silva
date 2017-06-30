/*
create tablespace SeedShare
   datafile 'C:\Oracle\oraclexe\app\oracle\oradata\XE\SEEDSHARE.DBF'
   size 100m
   autoextend on
   next 100m
   maxsize 2048m;

Create user Seed identified by Seed default tablespace SeedShare;
grant connect, resource, create view to Seed;
*/   
CREATE TABLE Usuario (
	ID INTEGER NOT NULL,
	Email Varchar2(50) NOT NULL,
	Senha Varchar2(100) NOT NULL,
	ID_Perfil INTEGER,
	constraint USUARIO_PK PRIMARY KEY (ID),
    constraint UK_Usuario_Email unique (Email),
    constraint UK_Usuario_Perfil unique (ID_Perfil)
);

CREATE TABLE Perfil (
	ID INTEGER NOT NULL,
	Nome Varchar2(50) NOT NULL,
    Foto_Url Varchar(2000) NOT NULL,
	Interesses Varchar2(300),
	Status Varchar2(100),
	Sexo Varchar2(20) NOT NULL,
	Data_Nascimento DATE NOT NULL,
	ID_Estado INTEGER NOT NULL,
	constraint PERFIL_PK PRIMARY KEY (ID)
);

    
CREATE TABLE Estado (
	ID INTEGER NOT NULL,
	Nome varchar2(50) NOT NULL,
	Pais varchar2(50) NOT NULL,
	constraint ESTADO_PK PRIMARY KEY (ID),
    constraint UK_Estado_Pais unique (Nome,Pais)
);

CREATE TABLE Alteracao_Senha (
	ID INTEGER NOT NULL,
	Email Varchar2(50) NOT NULL,
	Codigo Varchar2(25) NOT NULL,
	Prazo DATE NOT NULL,
	constraint ALTERACAO_SENHA_PK PRIMARY KEY (ID),
    constraint UK_Alteracao_Email unique (Email)
);


CREATE TABLE Relacionamento (
	ID INTEGER NOT NULL,
	ID_Perfil_Solicitante INTEGER NOT NULL,
	ID_Perfil_Solicitado INTEGER NOT NULL,
	Data_Solicitacao DATE NOT NULL,
	Data_Resposta DATE,
	Pendente NUMBER(1) NOT NULL,
	Resposta NUMBER(1),
	constraint RELACIONAMENTO_PK PRIMARY KEY (ID),
    constraint UK_Solicitante_Solicitado unique (ID_Perfil_Solicitante,ID_Perfil_Solicitado)
);

    
CREATE TABLE Postagem (
	ID INTEGER NOT NULL,
    ID_Perfil INTEGER NOT NULL,
	Url_Img Varchar2(2000),
	Descricao Varchar2(500),
	DataPostagem Date NOT NULL,
	constraint POSTAGEM_PK PRIMARY KEY (ID)
);

CREATE TABLE Curtida (
	ID INTEGER NOT NULL,
	DataCurtida Date NOT NULL,
	ID_Postagem INTEGER NOT NULL,
	ID_Perfil INTEGER NOT NULL,
    constraint UK_Curtida_Postagem_Perfil Unique(ID_Postagem,ID_Perfil),
	constraint CURTIDA_PK PRIMARY KEY (ID)
);


CREATE SEQUENCE SEQ_CURTIDA
    MINVALUE 1 
    MAXVALUE 999999999999999999999999999 
    INCREMENT BY 1 
    START WITH 1 
    CACHE 50 
    NOORDER  
    NOCYCLE;

CREATE TABLE Comentario(
	ID INTEGER NOT NULL,
	Texto Varchar2(300) NOT NULL,
	ID_Postagem INTEGER NOT NULL,
	ID_Perfil INTEGER NOT NULL,
  DataComentario Date NOT NULL,
	constraint COMENTARIO_PK PRIMARY KEY ("ID")
);

CREATE SEQUENCE SEQ_COMENTARIO
    MINVALUE 1 
    MAXVALUE 999999999999999999999999999 
    INCREMENT BY 1 
    START WITH 1 
    CACHE 50 
    NOORDER  
    NOCYCLE;

CREATE SEQUENCE SEQ_POSTAGEM
    MINVALUE 1 
    MAXVALUE 999999999999999999999999999 
    INCREMENT BY 1 
    START WITH 1 
    CACHE 50 
    NOORDER  
    NOCYCLE;

CREATE SEQUENCE SEQ_RELACIONAMENTO
    MINVALUE 1 
    MAXVALUE 999999999999999999999999999 
    INCREMENT BY 1 
    START WITH 1 
    CACHE 25 
    NOORDER  
    NOCYCLE;

CREATE SEQUENCE SEQ_ALTERACAO_SENHA
    MINVALUE 1 
    MAXVALUE 999999999999999999999999999 
    INCREMENT BY 1 
    START WITH 1 
    CACHE 10 
    NOORDER  
    NOCYCLE;

CREATE SEQUENCE SEQ_ESTADO
    MINVALUE 1 
    MAXVALUE 999999999999999999999999999 
    INCREMENT BY 1 
    START WITH 1 
    CACHE 10 
    NOORDER  
    NOCYCLE;

CREATE SEQUENCE SEQ_PERFIL
    MINVALUE 1 
    MAXVALUE 999999999999999999999999999 
    INCREMENT BY 1 
    START WITH 1 
    CACHE 10 
    NOORDER  
    NOCYCLE;

CREATE SEQUENCE SEQ_USUARIO
    MINVALUE 1 
    MAXVALUE 999999999999999999999999999 
    INCREMENT BY 1 
    START WITH 1 
    CACHE 10 
    NOORDER  
    NOCYCLE;
    
ALTER TABLE Usuario ADD CONSTRAINT FK_Usuario FOREIGN KEY (ID_Perfil) REFERENCES Perfil(ID);

ALTER TABLE Perfil ADD CONSTRAINT FK_Perfil FOREIGN KEY (ID_Estado) REFERENCES Estado(ID);


ALTER TABLE Alteracao_Senha ADD CONSTRAINT FK_Alteracao_Senha FOREIGN KEY (Email) REFERENCES Usuario(Email);

ALTER TABLE Relacionamento ADD CONSTRAINT FK_Relacionamento_Solicitante FOREIGN KEY (ID_Perfil_Solicitante) REFERENCES Perfil(ID);


ALTER TABLE Relacionamento ADD CONSTRAINT FK_Relacionamento_Solicitado FOREIGN KEY (ID_Perfil_Solicitado) REFERENCES Perfil(ID);

ALTER TABLE Postagem ADD CONSTRAINT FK_Postagem_Perfil FOREIGN KEY (ID_Perfil) REFERENCES Perfil(ID);

ALTER TABLE Curtida ADD CONSTRAINT FK_Curtida_Postagem FOREIGN KEY (ID_Postagem) REFERENCES Postagem(ID);

ALTER TABLE Curtida ADD CONSTRAINT FK_Curtida_Perfil FOREIGN KEY (ID_Perfil) REFERENCES Perfil(ID);

ALTER TABLE Comentario ADD CONSTRAINT FK_Comentario_Postagem FOREIGN KEY (ID_Postagem) REFERENCES Postagem(ID);

ALTER TABLE Comentario ADD CONSTRAINT FK_Comentario_Perfil FOREIGN KEY (ID_Perfil) REFERENCES Perfil(ID);

CREATE INDEX IX_Comentario_ID_Perfil ON Comentario(ID_PeCREATE INDEX IX_Comentario_ID_Postagem ON Comentario(ID_Postagem);
CREATE INDEX IX_Curtida_ID_Perfil ON Curtida(ID_Perfil);
CREATE INDEX IX_Curtida_ID_Postagem ON Curtida(ID_Postagem);
CREATE INDEX IX_Postagem_ID_Perfil ON Postagem(ID_Perfil);
CREATE INDEX IX_Relacionamento_Solicitado ON Relacionamento(ID_Perfil_Solicitado);
CREATE INDEX IX_Pefil_Estado ON Perfil(ID_Estado);
CREATE INDEX IX_Relacionamento_Solicitante ON Relacionamento(ID_Perfil_Solicitante);

/*
CREATE trigger BI_COMENTARIO
  before insert on COMENTARIO
  for each row
begin
  select COMENTARIO_SEQ.nextval into :NEW.ID from dual;
end;
*/
/*
CREATE trigger "BI_CURTIDA"
  before insert on "CURTIDA"
  for each row
begin
  select "CURTIDA_SEQ".nextval into :NEW."ID" from dual;
end;
*/
/*
CREATE trigger "BI_POSTAGEM"
  before insert on "POSTAGEM"
  for each row
begin
  select "POSTAGEM_SEQ".nextval into :NEW."ID" from dual;
end;
*/
/*
CREATE trigger "BI_RELACIONAMENTO"
  before insert on "RELACIONAMENTO"
  for each row
begin
  select "RELACIONAMENTO_SEQ".nextval into :NEW."ID" from dual;
end;
*/
/*
CREATE trigger "BI_ALTERACAO_SENHA"
  before insert on "ALTERACAO_SENHA"
  for each row
begin
  select "ALTERACAO_SENHA_SEQ".nextval into :NEW."ID" from dual;
end;
*/
/*
CREATE trigger "BI_ESTADO"
  before insert on "ESTADO"
  for each row
begin
  select "ESTADO_SEQ".nextval into :NEW."ID" from dual;
end;
*/
/*
CREATE trigger BI_PERFIL
  before insert on PERFIL
  for each row
begin
  select "PERFIL_SEQ".nextval into :NEW."ID" from dual;
end;
*/
/*
CREATE trigger BI_USUARIO
  before insert on USUARIO
  for each row
begin
  Select USUARIO_SEQ.nextval into :NEW.ID from dual;
end;*/
/*
DROP TABLE Comentario;
DROP TABLE Alteracao_Senha;
DROP TABLE Curtida;
DROP TABLE Postagem;
DROP TABLE Relacionamento;
DROP TABLE Usuario;
DROP TABLE Perfil;
DROP TABLE Estado;

DROP SEQUENCE SEQ_USUARIO;
DROP SEQUENCE SEQ_CURTIDA;
DROP SEQUENCE SEQ_ESTADO;
DROP SEQUENCE SEQ_PERFIL;
DROP SEQUENCE SEQ_POSTAGEM;
DROP SEQUENCE SEQ_RELACIONAMENTO;
DROP SEQUENCE SEQ_ALTERACAO_SENHA;
DROP SEQUENCE SEQ_COMENTARIO;
*/