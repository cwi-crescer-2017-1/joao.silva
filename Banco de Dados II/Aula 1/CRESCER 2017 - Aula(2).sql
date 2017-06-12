CREATE TABLE PESSOA (
  IDPessoa integer not null,
  Nome varchar2(30) not null,
  constraint PK_Pessoa primary key (IDPessoa)
);

Create sequence SQPessoa; -- Cria uma sequencia para o Id(tem a mesma função do auto_increment, porém roda de forma diferente)

Insert Into Pessoa (IDPessoa, Nome) Values(SQPessoa.nextval, 'Andre'); --.nextval insere o próximo valor na sequencia

Select * From Pessoa;

--No Oracle SQL o commit não é automático a não ser que se use DDL
--Evite misturar comandos que fazem alterações no BD com comandos de seleção

Commit; --realmente salva os dados, modificações no BD
--EXEMPLOS
Select IDProduto, Nome
From PRODUTO 
Where lower(Nome) like :Nome;

Select Produto.busca_nome(idproduto) nome_do_produto
From pedidoitem;

SELECT * FROM PRODUTO;
SELECT * FROM PEDIDO;
SELECT * FROM PEDIDOITEM;

--LISTA 01 DE EXERCICIOS

--Exercicio 01 
CREATE VIEW produtos_n_vendidos_4_meses AS
Select *
From Produto Po 
Where Po.IDProduto != ALL(Select Po.IDPRODUTO
From PRODUTO Po 
Join PEDIDOITEM Pe On Po.IDPRODUTO = Pe.IDPRODUTO
Join PEDIDO Pd On Pe.IDPEDIDO = Pd.IDPEDIDO
Where Pd.DATAPEDIDO > Add_months(TRUNC(sysdate),-4));
COMMIT;

SELECT P4.IDPRODUTO, P4.Nome FROM produtos_n_vendidos_4_meses P4;

--Exercicio 02

UPDATE Produto Po 
SET Po.SITUACAO = 'I' 
WHERE Po.IDPRODUTO = ANY(
  SELECT p4.IDPRODUTO FROM produtos_n_vendidos_4_meses p4
  );  

SELECT P4.IDPRODUTO, P4.Nome, P4.Situacao FROM produtos_n_vendidos_4_meses P4;

--Exercicio 03
CREATE VIEW vendidos_em_2017 AS
Select Po.IDPRODUTO, SUM(Pe.Quantidade) AS QuantidadeVendida
From PRODUTO Po 
Join PEDIDOITEM Pe On Po.IDPRODUTO = Pe.IDPRODUTO
Join PEDIDO Pd On Pe.IDPEDIDO = Pd.IDPEDIDO
Where Pd.DATAPEDIDO > TO_DATE('January 01, 2017','Month dd, YYYY','NLS_DATE_LANGUAGE = American')
GROUP BY Po.IDPRODUTO;

COMMIT;

SELECT v17.IDPRODUTO, v17.QUANTIDADEVENDIDA FROM vendidos_em_2017 v17;

SELECT v17.IDPRODUTO, v17.QUANTIDADEVENDIDA FROM vendidos_em_2017 v17 WHERE v17.IDPRODUTO = 1;