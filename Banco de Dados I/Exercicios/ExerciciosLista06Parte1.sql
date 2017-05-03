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
