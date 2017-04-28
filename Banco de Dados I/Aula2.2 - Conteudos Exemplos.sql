Select E.Cargo,
	IDDepartamento,
	Count(1) As TotalEmpregado
	From Empregado E
	WHERE E.Cargo = 'Atendente'
	Group By Cargo, IDDepartamento
	Having IDDepartamento IS NOT NULL
	Order By TotalEmpregado Asc;

SELECT * FROM EMPREGADO;

Select E.NomeEmpregado,
		E.DataAdmissao,
		DateDiff(year,E.DataAdmissao, getdate()) AS 'Anos de Trabalho'
		FROM Empregado E;
