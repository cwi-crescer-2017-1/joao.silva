--Lista de Exercicios 06 - Modulo 2: Banco de Dados I - Crescer 2017 

USE[Crescer17];

--Exercicio 01
SELECT TOP 1 SUBSTRING(C.Nome,0,CHARINDEX(' ',C.Nome)) AS PrimeiroNome,
		COUNT(SUBSTRING(C.Nome,0,CHARINDEX(' ',C.Nome))) AS TotalOcorrencias
FROM Cliente C 
GROUP BY SUBSTRING(C.Nome,0,CHARINDEX(' ',C.Nome))
ORDER BY COUNT(SUBSTRING(C.Nome,0,CHARINDEX(' ',C.Nome))) DESC;

--Exercicio 02
SELECT COUNT(P.IDPedido) AS Quantidade, SUM(P.ValorPedido) AS ValorPedido 
FROM Pedido P
WHERE MONTH(P.DataPedido) = 4 AND YEAR(P.DataPedido) = 2017;

--Exercicio 03
SELECT Cidade.UF, COUNT(Cliente.IDCidade) AS TotalClientes 
FROM Cidade INNER JOIN Cliente ON Cidade.IDCidade = Cliente.IDCidade
WHERE Cidade.UF IN( 
	SELECT TOP 1 C.UF
	FROM Cidade C 
	INNER JOIN Cliente Cl ON C.IDCidade = Cl.IDCidade
	GROUP BY C.UF
	ORDER BY COUNT(Cl.IDCidade) ASC
) OR Cidade.UF IN(
	SELECT TOP 1 C.UF
	FROM Cidade C 
	INNER JOIN Cliente Cl ON C.IDCidade = Cl.IDCidade
	GROUP BY C.UF
	ORDER BY COUNT(Cl.IDCidade) DESC
)
GROUP BY Cidade.UF;

--Exercicio 04
INSERT INTO Produto(Nome ,PrecoCusto, PrecoVenda, Situacao)
	VALUES('Galocha Maragato',35.67,77.95,'A');
	--,GETDATE() -- , DataCadastro

--Exercicio 05
SELECT * FROM Produto Pr 
LEFT JOIN PedidoItem Ip ON Pr.IDProduto = Ip.IDProduto
LEFT JOIN Pedido Pe ON Ip.IDPedido = Pe.IDPedido
WHERE Pe.IDPEDIDO IS NULL;

--Exercicio 06
SELECT TOP 30 SUM(Ip.Quantidade*Pr.PrecoVenda) AS QuantidadeVendida2016, 
	Pr.IDProduto, Pr.Nome FROM Produto Pr 
INNER JOIN PedidoItem Ip ON Pr.IDProduto = Ip.IDProduto
INNER JOIN Pedido Pe ON Ip.IDPedido = Pe.IDPedido
WHERE YEAR(DataPedido) = 2016
GROUP BY Pr.IDProduto, Pr.Nome
ORDER BY SUM(Ip.Quantidade*Pr.PrecoVenda) DESC;