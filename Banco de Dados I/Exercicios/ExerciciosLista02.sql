--Lista 02 de Exercicios de Banco de Dados I

--Exercicio 01

SELECT E.IDEmpregado as 'ID',
	   E.NomeEmpregado AS 'Nome'
FROM Empregado E
ORDER BY E.DataAdmissao ASC;
 
--Exercicio 02

SELECT *
FROM Empregado E
WHERE E.Comissao IS NULL
ORDER BY E.Salario

--Exercicio 03

SELECT E.IDEmpregado AS 'ID',
		E.NomeEmpregado AS 'Nome',
		(E.Salario*13) AS 'Salário Anual',
		(E.Comissao*12) AS 'Comissão Anual',
		(E.Salario*13) + ISNULL(E.Comissao*12, 0) AS 'Renda Anual'
FROM Empregado E;

--Exercicio 04

SELECT E.IDEmpregado,
		E.NomeEmpregado AS 'Nome',
		E.Cargo,
		E.Salario AS 'Salário Mensal'
FROM EMPREGADO E 
WHERE (E.Salario*13) < 18500.00 OR Cargo = 'Atendente';