--Lista 04
--Exercicio 01
Create table LogAposta (
  IDLogAposta        integer not null,
  IDAposta_Antigo    integer,
  IDAposta_Novo      integer,
  IDConcurso_Antigo  integer,
  IDConcurso_Novo    integer,
  Operacao           char(1) not null,
  Usuario            varchar2(50),
  Data               date default sysdate not null,
    constraint PK_LogAposta
       primary key (IDLogAposta)
);
Create sequence sqLogAposta;
DESC LogAposta;

Create or Replace Trigger TR_AUD_APOSTA
    After Insert Or Update Or Delete On Aposta
    For Each Row
Declare
  v_idaposta_novo     Integer;
  v_idaposta_antigo   Integer;
  v_idconcurso_novo   Integer;
  v_idconcurso_antigo Integer;
  v_data              Date := sysdate;
  v_operacao          char(1);
  v_usuario           varchar2(50) := user;
Begin
  if INSERTING then
     v_operacao           := 'I';
     v_idaposta_novo      := :new.IDAposta;
     v_idaposta_antigo    := NULL;
     v_idconcurso_novo    := :new.IDConcurso;
     v_idconcurso_antigo  := NULL;
  elsif UPDATING then
     v_operacao := 'U';       
     v_idaposta_novo      := :new.IDAposta;
     v_idaposta_antigo    := :old.IDAposta;
     v_idconcurso_novo    := :new.IDConcurso;
     v_idconcurso_antigo  := :old.IDConcurso;
  else
     v_operacao := 'D';
     v_idaposta_novo      := NULL;
     v_idaposta_antigo    := :old.IDAposta;
     v_idconcurso_novo    := NULL;
     v_idconcurso_antigo  := :old.IDConcurso;  
  end if;

  Insert into LogAposta (IDLogAposta, IDConcurso_Novo, IDConcurso_Antigo, IDAposta_Novo, IDAposta_Antigo, Operacao, data, Usuario)
      values (sqLogAposta.nextval, v_idconcurso_novo, v_idconcurso_antigo, v_idaposta_novo, v_idconcurso_antigo, v_operacao, v_data, v_usuario);

End TR_AUD_APOSTA;

DESC APOSTA;

Create table LogNumero_Aposta (
  IDLogNumero_Aposta     integer not null,
  IDNumero_Aposta_Novo   integer,
  IDNumero_Aposta_Antigo integer,
  IDAposta_Novo          integer,
  IDAposta_Antigo        integer,
  Numero_Atual           number(2),
  Numero_Antigo          number(2),
  Operacao               char(1) not null,
  Data                   date default sysdate not null,
  Usuario                varchar2(50),
    constraint PK_LogNumero_Aposta
       primary key (IDLogNumero_Aposta)
);
Create sequence sqLogNumero_Aposta;
Desc Numero_Aposta;
DESC LogNumero_Aposta;

Create or Replace Trigger TR_AUD_NUMERO_APOSTA
    After Insert Or Update Or Delete On Numero_Aposta
    For Each Row
Declare
  v_idnumero_aposta_novo   Integer;
  v_idnumero_aposta_antigo Integer;
  v_idaposta_novo          Integer;
  v_idaposta_antigo        Integer;
  v_numero_atual           Integer;
  v_numero_antigo          Integer;
  v_data                   Date := sysdate;
  v_operacao               char(1);
  v_usuario                varchar2(50) := user;
Begin
  if INSERTING then
     v_operacao := 'I';
     v_idnumero_aposta_novo   := :new.IDNumero_Aposta;
     v_idnumero_aposta_antigo := NULL;
     v_idaposta_novo          := :new.IDAposta;
     v_idaposta_antigo        := NULL;
     v_numero_atual           := :new.Numero;
     v_numero_antigo          := NULL;
  elsif UPDATING then
     v_operacao := 'U';       
     v_idnumero_aposta_novo   := :new.IDNumero_Aposta;
     v_idnumero_aposta_antigo := :old.IDNumero_Aposta;
     v_idaposta_novo          := :new.IDAposta;
     v_idaposta_antigo        := :old.IDAposta;
     v_numero_atual           := :new.Numero;
     v_numero_antigo          := :old.Numero;
  else
     v_operacao               := 'D';
     v_idnumero_aposta_novo   := NULL;
     v_idnumero_aposta_antigo := :old.IDNumero_Aposta;
     v_idaposta_novo          := NULL;
     v_idaposta_antigo        := :old.IDAposta;
     v_numero_atual           := NULL;
     v_numero_antigo          := :old.Numero;  
  end if;

  Insert Into LogNumero_Aposta (IDLogNumero_Aposta, IDNumero_Aposta_Novo, IDNumero_Aposta_Antigo, IDAposta_Novo, IDAposta_Antigo, Numero_Atual, Numero_Antigo, Data, Operacao, Usuario)
      values (sqLogNumero_Aposta.nextval, v_idnumero_aposta_novo, v_idnumero_aposta_antigo, v_idaposta_novo, v_idaposta_antigo, v_numero_atual, v_numero_antigo, v_data, v_operacao, v_usuario);

End TR_AUD_NUMERO_APOSTA;

DESC APOSTA;
SELECT MAX(IDCIDADE) FROM CIDADE;

INSERT INTO APOSTA (IDAPOSTA, IDCONCURSO, IDCIDADE, DATA_HORA,QUANTIDADE_NUMEROS,VALOR,BOLAO) VALUES(1999999456,1824,5575,sysdate,1,10,0);
UPDATE APOSTA SET QUANTIDADE_NUMEROS = 2 WHERE IDAPOSTA = 1999999456;
DELETE APOSTA WHERE IDAPOSTA = 1999999456;
Select * From LogAposta;

DESC NUMERO_APOSTA;

INSERT INTO APOSTA (IDAPOSTA, IDCONCURSO, IDCIDADE, DATA_HORA,QUANTIDADE_NUMEROS,VALOR,BOLAO) VALUES(1999999456,1824,5575,sysdate,1,10,0);
INSERT INTO Numero_Aposta (IDNumero_Aposta, IDAposta, Numero) VALUES(1999999456,1999999456, 10);
UPDATE Numero_Aposta Set Numero = 20 Where IDNumero_Aposta = 1999999456;
DELETE Numero_Aposta Where IDNumero_Aposta = 1999999456;
DELETE APOSTA WHERE IDAPOSTA = 1999999456;
Select * From LogNumero_Aposta;

--Exercicio 02

--Liste os estados com maior número de apostas, e maior valor arrecadado em cada concurso. 
--Adicionalmente também deve ser exibido o total de acertadores e o valor da premiação em cada estado.

Select Count(apo.IDAposta) as Quantidade_Apostas, Sum(apo.Valor) as Valor_Arrecadado
  , Count(apop.IDAposta_Premiada) as Quantidade_Apostas_Premiadas
  , Sum(apop.Valor) as Valor_Premiacao
  , c.UF, apo.IDConcurso
  From Aposta apo 
  Inner Join Cidade c On apo.IDCidade = c.IDCidade
  Left Join Aposta_Premiada apop On apo.IDAposta = apop.IDAposta
  Group By c.UF, apo.IDConcurso 
  Order By Count(apo.IDAposta) DESC, Sum(apo.Valor) DESC;



