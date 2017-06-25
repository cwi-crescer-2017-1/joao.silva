Select * From Funcionario Order By ID DESC;
Select * From Cliente;
Select * From Genero;
Select * From Locacao;
Select * From Video;
commit;
insert into Funcionario (ID,NOME,RG) VALUES(SEQ_FUNCIONARIO.NEXTVAL,'PAULO','12345678965');
Select * From Locacao;
Select * From Funcionario Where ID = 100;