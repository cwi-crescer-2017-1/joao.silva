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

CREATE FUNCTION get_quantidade_vendida_2017(IdProduto_d IN NUMBER) 
   RETURN NUMBER 
   IS QTD NUMBER(12,3);
   BEGIN 
      SELECT v17.QUANTIDADEVENDIDA 
      INTO QTD
      FROM vendidos_em_2017 v17 
      WHERE v17.IDPRODUTO = IdProduto_d;
      RETURN(QTD); 
    END;

SELECT get_quantidade_vendida_2017(2) AS quantidade_vendida FROM DUAL;

COMMIT;
    