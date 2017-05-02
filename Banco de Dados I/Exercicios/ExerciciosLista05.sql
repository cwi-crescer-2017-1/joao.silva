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

SELECT * INTO EmpregadoAux FROM Empregado;

BEGIN TRANSACTION
UPDATE Empregado
SET Salario = Salario * 1.173 
FROM Empregado E INNER JOIN Departamento D 
ON E.IDDepartamento = D.IDDepartamento
WHERE D.Localizacao = 'SAO PAULO';

--Verificar (Empregados de SAO LEOPOLDO devem ter os mesmo salários)
SELECT E.Salario, D.Localizacao FROM EmpregadoAux E INNER JOIN Departamento D 
ON E.IDDepartamento = D.IDDepartamento
WHERE D.Localizacao = 'SAO PAULO' OR D.Localizacao = 'SAO LEOPOLDO';

SELECT E.Salario, D.Localizacao FROM Empregado E INNER JOIN Departamento D 
ON E.IDDepartamento = D.IDDepartamento
WHERE D.Localizacao = 'SAO PAULO' OR D.Localizacao = 'SAO LEOPOLDO';

--COMMIT
--ROLLBACK

--Exercicio 04

SELECT C2.Nome, C2.UF FROM Cidade C2 GROUP BY C2.Nome, C2.UF HAVING COUNT(C2.IDCidade)>=2; 


--Exercicio 05

Definindo Cidades

Faça uma alteraçao nas cidades que tenham nome+UF duplicados, 
adicione no final do nome um asterisco. Mas atenção! apenas a cidade com maior ID deve ser alterada.
 
SELECT INTO CidadeAux FROM (SELECT C2.Nome, C2.UF FROM Cidade C2 GROUP BY C2.Nome, C2.UF HAVING COUNT(C2.IDCidade)>=2);
BEGIN TRANSACTION
UPDATE Cidade 
SET Nome = Nome+'*'
WHERE Nome+UF IN(
		SELECT DISTINCT C.Nome+C.UF FROM Cidade C GROUP BY C.Nome, C.UF HAVING COUNT(C.IDCidade)>=2
)

SELECT * FROM Cidade C ORDER BY C.Nome;
ROLLBACK