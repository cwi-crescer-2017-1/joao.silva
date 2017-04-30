alter table empregado add DataNascimento date;

begin transaction
go

update Empregado set DataNascimento = convert(date, '22/12/1962', 103) where idEmpregado = 	7369;
update Empregado set DataNascimento = convert(date, '25/02/1961', 103) where idEmpregado = 	7499;
update Empregado set DataNascimento = convert(date, '27/02/1962', 103) where idEmpregado = 	7521;
update Empregado set DataNascimento = convert(date, '09/04/1952', 103) where idEmpregado = 	7566;
update Empregado set DataNascimento = convert(date, '06/10/1950', 103) where idEmpregado = 	7654;
update Empregado set DataNascimento = convert(date, '07/05/1959', 103) where idEmpregado = 	7698;
update Empregado set DataNascimento = convert(date, '15/06/1956', 103) where idEmpregado = 	7782;
update Empregado set DataNascimento = convert(date, '13/12/1966', 103) where idEmpregado = 	7788;
update Empregado set DataNascimento = convert(date, '22/11/1961', 103) where idEmpregado = 	7839;
update Empregado set DataNascimento = convert(date, '15/09/1954', 103) where idEmpregado = 	7844;
update Empregado set DataNascimento = convert(date, '22/01/1944', 103) where idEmpregado = 	7876;
update Empregado set DataNascimento = convert(date, '10/12/1955', 103) where idEmpregado = 	7900;
update Empregado set DataNascimento = convert(date, '09/12/1957', 103) where idEmpregado = 	7902;
update Empregado set DataNascimento = convert(date, '30/01/1955', 103) where idEmpregado = 	7934;
update Empregado set DataNascimento = convert(date, '24/01/1969', 103) where idEmpregado = 	7940;

commit
go