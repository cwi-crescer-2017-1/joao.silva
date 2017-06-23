create tablespace Modulo8Teste
   datafile 'C:\Oracle\oraclexe\app\oracle\oradata\XE\MODULO8TESTE.DBF'
   size 100m
   autoextend on
   next 100m
   maxsize 2048m;
Create user Modulo8 identified by Modulo8 default tablespace Modulo8Teste;
grant connect, resource, create view to Modulo8;
