DESC CLIENTE;

Create table LogCliente_Operacao (
  IDLogCliente   integer not null,
  Usuario        varchar2(30),
  Data           date default sysdate,  
  Operacao       char(1) not null,
    constraint PK_LogCliente_Operacao 
       primary key (IDLogCliente)
);

Create sequence sqLogCliente_Operacao;

create or replace
trigger TR_AUD1_CLIENTE
    after insert or update or delete on CLIENTE
Declare
  v_operacao char(1);
Begin

  if INSERTING then
     v_operacao := 'I';
  elsif UPDATING then
     v_operacao := 'U';       
  else
     v_operacao := 'D';
  end if;
  Insert into LogCliente_Operacao (idlogcliente, data, usuario, operacao)
      values (sqlogcliente_operacao.nextval, sysdate, user, v_operacao);

End TR_AUD1_CLIENTE;

insert into cliente (idcliente, nome, razaosocial) 
 values (100000, 'coca cola/ FL1', 'coca cola F1');

insert into cliente (idcliente, nome, razaosocial) 
 values (100001, 'coca cola/ FL2', 'coca cola F2');

insert into cliente (idcliente, nome, razaosocial) 
 values (100002, 'coca cola/ FL3', 'coca cola F3');

insert into cliente (idcliente, nome, razaosocial) 
 values (100003, 'coca cola/ FL4', 'coca cola F4');
 
Select * from logcliente_operacao;
commit;
Delete Cliente Where IDCliente=100003;
rollback;
UPDATE Cliente Set nome = 'testeUpdate' Where IDCliente = 100002;

Update cliente 
Set    RazaoSocial = upper(RazaoSocial)
Where  IDCliente between 100000 and 100003;

Create table LogCliente (
  IDLogCliente   integer not null,
  IDCliente      integer not null,
  Operacao       char(1) not null,
  Usuario        varchar2(50),
  Data           date default sysdate,
  Nome_Novo      varchar2(50),
  Nome_Antigo    varchar2(50),
    constraint PK_LogCliente 
       primary key (IDLogCliente)
);

Create sequence sqLogCliente;

create or replace trigger TR_AUD2_CLIENTE
    after insert or update or delete on CLIENTE
    for each row
Declare
  v_idcliente   Integer;
  v_operacao    Char(1);
  v_nome_Antigo Cliente.Nome%type;
  v_nome_novo   Cliente.Nome%type;
Begin

  if INSERTING then
     v_operacao    := 'I';
     v_idcliente   := :new.idcliente;
     v_nome_novo   := :new.nome; 
     v_nome_antigo := NULL;
  elsif UPDATING then
     v_operacao := 'U';       
     v_idcliente   := :old.idcliente;  -- MANTEVE-SE O "OLD" PORQUE O ID NÃO DEVE SER ALTERADO
     v_nome_novo   := :new.nome;       -- NOVO NOME
     v_nome_antigo := :old.nome;     -- ANTIGO NOME
  else
     v_operacao := 'D';
     v_idcliente   := :old.idcliente;  -- 
     v_nome_novo   := NULL;            -- EM OPERAÇÕES DE DELETE NÃO EXISTEM VALORES "NOVOS"
     v_nome_antigo := :old.nome;     -- NOME ANTES DA EXCLUSÃO
  end if;

  Insert into LogCliente (idlogcliente, idcliente, operacao, usuario, data, Nome_Antigo, Nome_Novo)
      values (sqlogcliente.nextval, v_idcliente, v_operacao, user, sysdate, v_nome_Antigo, v_nome_novo);

End TR_AUD2_CLIENTE;

SELECT * FROM Cliente;

SELECT * FROM CIDADE WHERE IDCIDADE = 493;
SELECT * FROM Cidade Where IDCidade = 493;
Update Cidade Set nome = 'Teste' Where IDCidade = 493;