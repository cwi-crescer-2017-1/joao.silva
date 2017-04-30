
--LISTA 03 DE EXERCICIOS - BANCO DE DADOS I - CRESCER 2017

USE [crescer-2017];

-- Exercicio 01 
SELECT E.IDEmpregado,
		 E.NomeEmpregado AS Nome,
		 DATEDIFF(YEAR,E.DataNascimento,E.DataAdmissao) AS Idade
FROM Empregado E
WHERE YEAR(E.DataAdmissao) = '1980';


--Exercicio 02
SELECT TOP 1 E.CARGO, COUNT(IDEmpregado) AS QTD_EMPREGADOS FROM EMPREGADO E
GROUP BY E.CARGO
ORDER BY QTD_EMPREGADOS DESC;

--Exercicio 03

SELECT C.UF, COUNT(C.IDCidade) AS Total_Cidade
FROM Cidade C
GROUP BY C.UF;

--Exercicio 04

INSERT INTO Departamento(IDDepartamento, NomeDepartamento, Localizacao)
VALUES(70, 'Inovação', 'SÃO LEOPOLDO');

UPDATE Empregado SET IDDepartamento = 70 
WHERE MONTH(DataAdmissao) = 12 AND Cargo <> 'Atendente';  