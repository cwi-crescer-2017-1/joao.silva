USE [crescer-2017];
SELECT * FROM EMPREGADO;
SELECT * FROM DEPARTAMENTO;

--Exercicio 01
SELECT E.NomeEmpregado, D.NomeDepartamento, 
		G.NomeEmpregado as 'NomeGerente' 
FROM Empregado E 
INNER JOIN Empregado G ON E.IDGerente = G.IDEmpregado
INNER JOIN Departamento D ON E.IDDepartamento = D.IDDepartamento;

--Exercicio 02
SELECT * FROM EMPREGADO E ORDER BY E.Salario DESC;

SELECT DISTINCT D.IDDepartamento, D.NomeDepartamento
FROM Departamento D
LEFT JOIN EMPREGADO E ON D.IDDepartamento = E.IDDepartamento
WHERE E.Salario = (SELECT MAX(E.Salario) FROM Empregado E WHERE E.IDDepartamento IS NOT NULL);

--Exercicio 03
BEGIN TRANSACTION
SELECT * INTO EmpregadoAux FROM Empregado;

UPDATE Empregado
SET Salario = Salario * 1.173 
FROM Empregado E INNER JOIN Departamento D 
ON E.IDDepartamento = D.IDDepartamento
WHERE D.Localizacao = 'SAO PAULO';

--Verificar (Empregados de SAO LEOPOLDO devem ter os mesmo salários e os de SP devem ser diferentes)
SELECT E.Salario, D.Localizacao FROM EmpregadoAux E INNER JOIN Departamento D 
ON E.IDDepartamento = D.IDDepartamento
WHERE D.Localizacao = 'SAO PAULO' OR D.Localizacao = 'SAO LEOPOLDO';

SELECT E.Salario, D.Localizacao FROM Empregado E INNER JOIN Departamento D 
ON E.IDDepartamento = D.IDDepartamento
WHERE D.Localizacao = 'SAO PAULO' OR D.Localizacao = 'SAO LEOPOLDO';

--ROLLBACK

--Exercicio 04

SELECT C.Nome, C.UF FROM Cidade C GROUP BY C.Nome, C.UF HAVING COUNT(C.IDCidade)>=2; 

--Exercicio 05

Insert into Cidade (IDCidade, Nome, UF)
   values (1135, 'Belo Horizonte', 'MG'),
			(2135, 'Brasilia', 'DF'),
			(3135, 'Brasilia', 'DF');

CREATE VIEW TodasCidadesRepetidas AS
SELECT ROW_NUMBER() OVER(PARTITION BY C.Nome, C.UF ORDER BY C.Nome,C.IDCidade ASC) AS IDGrupoRepetido, C.IDCidade ,C.Nome, C.UF FROM Cidade C WHERE C.Nome+C.UF IN (
	SELECT C.Nome+C.UF FROM Cidade C GROUP BY C.Nome, C.UF HAVING COUNT(C.IDCidade)>1);

CREATE VIEW CidadeRepetidasComMaiorID AS
SELECT * FROM TodasCidadesRepetidas T WHERE T.IDGrupoRepetido>1;

BEGIN TRANSACTION
UPDATE Cidade
SET Cidade.Nome = Cidade.Nome+REPLICATE('*',(SELECT IDGrupoRepetido-1 FROM TodasCidadesRepetidas TR WHERE Cidade.IDCidade = TR.IDCidade))
WHERE CAST(IDCidade AS VARCHAR)+Nome+UF IN (
	SELECT CAST(CR.IDCidade AS VARCHAR)+CR.Nome+CR.UF FROM  CidadeRepetidasComMaiorID CR);

SELECT * FROM Cidade ORDER BY Cidade.Nome;

--Limpeza dos Dados para re-executar o exercicio 05
ROLLBACK
DROP VIEW TodasCidadesRepetidas;
DROP VIEW CidadeRepetidasComMaiorID; 
DELETE Cidade
FROM Cidade C
WHERE C.IDCidade = 1135 OR C.IDCidade = 2135 OR C.IDCidade = 3135; 


