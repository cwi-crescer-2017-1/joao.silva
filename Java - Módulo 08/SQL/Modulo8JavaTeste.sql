SELECT * FROM CIDADE;
SELECT * FROM ESTADO;
SELECT * FROM CIDADE WHERE NOME = 'Curvelândia';
Select c.ID,c.Nome as Nome_Cidade ,e.Nome as Nome_Estado From Cidade c Inner Join Estado e On c.Estado = e.ID;
Select * From Teste;
CREATE TABLE PESSOA ( 
    ID NUMBER(8) NOT NULL,
    NOME VARCHAR2(60) DEFAULT NULL,
CONSTRAINT PESSOA_PK PRIMARY KEY (ID)  ENABLE 
)

Select * From Pais;
Select * From Estado;
Delete Estado Where ID=100;
UPDATE Pais Set Nome='Argentina', Sigla='AR' Where ID = 1;
commit;
Select ID,NOME,ESTADO From Cidade Where ID = 1;