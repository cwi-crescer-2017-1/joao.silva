--Lista 04 de Exercicios - Banco de Dados I - Crescer 2017 - By: João Pedro Silvera e Silva 

--Exercicio 01
SELECT DATEDIFF(MONTH, Data_Inicio_Prev, Data_Fim_Prev) AS 'Tempo Previsto (Meses)', 
		DATEDIFF(MONTH, Data_Inicio_Real, Data_Fim_Real) AS 'Tempo Realizado (Meses)', 
		*  
FROM Licitacao L WHERE Data_Inicio_Real>Data_Inicio_Prev;

--Exercicio 02
SELECT TOP 10 L.Empresa_Licitante, 
		SUM(L.Valor_Realizado) AS 'Empresa Total Faturamento R$', 
		(SUM(L.Valor_Realizado)/SUM(L.Profissionais)) AS 'Valor Médio por Profissional'  
FROM Licitacao L 
GROUP BY L.Empresa_Licitante 
ORDER BY SUM(L.Valor_Realizado) DESC;

--Exercicio 03
SELECT TOP 10 L.Estado, L.Municipio, SUM(Imposto_Municipal) AS 'Imposto arrecadado' 
FROM Licitacao L 
GROUP BY L.Estado, L.Municipio
ORDER BY SUM(Imposto_Municipal) DESC;

--Exercicio 04
SELECT * FROM Licitacao L 
WHERE DATEPART(WEEKDAY,L.Data_Inicio_Real) = 1 
OR DATEPART(WEEKDAY,L.Data_Inicio_Real) = 7;

--Exercicio 05 
SELECT L.Empresa_Licitante, SUM(L.Valor_Realizado) AS Faturamento_Ano_Atual, 
L.Faturamento_1Ano_Anterior
FROM Licitacao L
GROUP BY L.Empresa_Licitante, L.Faturamento_1Ano_Anterior
HAVING SUM(L.Valor_Realizado)>(0.5*L.Faturamento_1Ano_Anterior);

--Exercicio 06
SELECT
CASE 
	WHEN L.Esfera='Federal' THEN L.Valor_Realizado - L.Imposto_Federal
	WHEN L.Esfera='Estadual' THEN L.Valor_Realizado - L.Imposto_Federal
	WHEN L.Esfera='Municipal' THEN L.Valor_Realizado - L.Imposto_Municipal
END AS 'Custo Real', *
FROM Licitacao L;

--Exercicio 07

SELECT * FROM Licitacao L 
WHERE L.Estado = 'RS'
AND L.Municipio = 'Caxias do Sul' 
AND YEAR(Data_Inicio_Real)='2017';

/*
Foi verificado que já havia um projeto com o mesmo objetivo só que a custos mais baixos 
em andamento e data de inicio e fim mais adiantadas.
O projeto em andamento possui uma empresa_licitante diferente e 
teve um maior número de empresas concorrentes.
*/
