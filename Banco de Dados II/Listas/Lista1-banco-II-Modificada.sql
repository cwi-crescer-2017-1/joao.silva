--LISTA 01 DE EXERCICIOS
SELECT * FROM PRODUTO;
--Exercicio 01 
CREATE OR REPLACE VIEW produtos_n_vendidos_4_meses AS
Select Po.IDPRODUTO, Po.NOME, Po.DATACADASTRO, Po.PRECOCUSTO, Po.PRECOVENDA, Po.SITUACAO
From Produto Po 
Where Po.IDProduto NOT IN(Select Po.IDPRODUTO
From PRODUTO Po 
Join PEDIDOITEM Pe On Po.IDPRODUTO = Pe.IDPRODUTO
Join PEDIDO Pd On Pe.IDPEDIDO = Pd.IDPEDIDO
Where Pd.DATAPEDIDO > Add_months(TRUNC(sysdate),-4));

COMMIT;

SELECT P4.IDPRODUTO, P4.Nome FROM produtos_n_vendidos_4_meses P4;

--Exercicio 02

Update Produto Po 
Set Po.SITUACAO = 'I' 
Where Po.IDPRODUTO = Any(
  Select p4.IDPRODUTO From produtos_n_vendidos_4_meses p4
  );  

--Versão instrutor
Update Produto Set Situacao = 'I'
Where IDProduto IN (Select IDProduto From produtos_n_vendidos_4_meses) and Situacao NOT LIKE 'I';

COMMIT;

SELECT P4.IDPRODUTO, P4.Nome, P4.Situacao FROM produtos_n_vendidos_4_meses P4;

--Exercicio 03

CREATE OR REPLACE VIEW quantidade_vendida_em_2017 AS
Select Po.IDPRODUTO, SUM(Pe.Quantidade) AS QuantidadeVendida
From PRODUTO Po 
Join PEDIDOITEM Pe On Po.IDPRODUTO = Pe.IDPRODUTO
Join PEDIDO Pd On Pe.IDPEDIDO = Pd.IDPEDIDO
Where Pd.DATAPEDIDO > TO_DATE('January 01, 2017','Month dd, YYYY','NLS_DATE_LANGUAGE = American')
GROUP BY Po.IDPRODUTO;

CREATE OR REPLACE FUNCTION get_quantidade_vendida_2017(IdProduto_d IN NUMBER) 
   RETURN NUMBER 
   IS QTD NUMBER(12,3);
   BEGIN 
      SELECT v17.QUANTIDADEVENDIDA 
      INTO QTD
      FROM quantidade_vendida_em_2017 v17 
      WHERE v17.IDPRODUTO = IdProduto_d;
      RETURN(QTD); 
    END;

SELECT get_quantidade_vendida_2017(123) AS quantidade_vendida FROM DUAL;

COMMIT;