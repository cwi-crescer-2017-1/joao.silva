USE [EmprestimoCelular];
USE [Crescer17];

INSERT INTO Colaborador(IDColaborador, Nome)
		VALUES(1,'Joelma'),
				(2,'Mariana'),
				(3,'Thiago');

INSERT INTO Cliente(IDCliente, Nome)
	VALUES(1, 'Mercado do Jô'),
			(2, 'Papelaria do Miguel'),
			(3, 'Oficina do Lu');

INSERT INTO Projeto(IDProjeto, Nome, IDCliente)
	VALUES(1,'Ecommerce do Miguel', 2),
			(2,'Ecommerce do Jô', 1),
			(3,'Website da Oficina do Lu',3);

INSERT INTO ModeloCelular(IDModeloCelular, Marca, Tipo, Codigo)
	VALUES(1, 'Motorola', 'Dual SIM', 'MT84739'),
			(2, 'Samgung', 'Single SIM', 'SMG95849'),
			(3, 'Apple',' Single SIM','I938494');

INSERT INTO Celular(IDCelular, IDModeloCelular)
	VALUES(1, 1),
			(2, 2),
			(3, 3);

INSERT INTO CHIP(IDChip,Numero,Operadora) VALUES(1, '97979463', 'Vivo');
INSERT INTO CHIP(IDChip,Numero,Operadora) VALUES(2, '82523463', 'Tim');
INSERT INTO CHIP(IDChip,Numero,Operadora) VALUES(3, '84533263', 'Tim');
INSERT INTO CHIP(IDChip,Numero,Operadora) VALUES(4, '91052375', 'Claro');
INSERT INTO CHIP(IDChip,Numero,Operadora) VALUES(5, '87523223', 'Tim');
INSERT INTO CHIP(IDChip,Numero,Operadora) VALUES(6, '84557463', 'OI');
INSERT INTO CHIP(IDChip,Numero,Operadora) VALUES(7, '97979003', 'Vivo');
INSERT INTO CHIP(IDChip,Numero,Operadora) VALUES(8, '82523403', 'Tim');
INSERT INTO CHIP(IDChip,Numero,Operadora) VALUES(9, '84533283', 'Tim');
INSERT INTO CHIP(IDChip,Numero,Operadora) VALUES(10, '91052205', 'Claro');
INSERT INTO CHIP(IDChip,Numero,Operadora) VALUES(11, '87523273', 'Tim');
INSERT INTO CHIP(IDChip,Numero,Operadora) VALUES(12, '84557443', 'OI');

INSERT INTO Emprestimo(IDEmprestimo, DataInicio, DataFinal, IDCelular, IDProjeto, IDColaborador)
	VALUES(1,CONVERT(Date, '19-03-2017', 103),CONVERT(DATE,'25-03-2017',103),2,1,1),
		  (2,CONVERT(DATE, '17-03-2017',103),CONVERT(DATE,'26-03-2017',103),1,2,1),
		  (3,CONVERT(DATE, '11-03-2017',103),CONVERT(DATE,'24-03-2017',103),3,1,2),
		  (4,CONVERT(DATE, '17-03-2017',103),CONVERT(DATE, '27-03-2017',103),2,2,3),
		  (5,CONVERT(DATE, '14-03-2017',103),CONVERT(DATE, '29-03-2017',103),3,3,2),
		  (6,CONVERT(DATE, '19-03-2017',103),CONVERT(DATE, '28-03-2017',103),1,3,3);

INSERT INTO EmprestimoChip(IDEmprestimo, IDChip)
		VALUES(1,1);
INSERT INTO EmprestimoChip(IDEmprestimo, IDChip)
		VALUES(2,2);
INSERT INTO EmprestimoChip(IDEmprestimo, IDChip)
		VALUES(3,3);
INSERT INTO EmprestimoChip(IDEmprestimo, IDChip)
		VALUES(4,4);
INSERT INTO EmprestimoChip(IDEmprestimo, IDChip)
		VALUES(5,5);
INSERT INTO EmprestimoChip(IDEmprestimo, IDChip)
		VALUES(6,6);
INSERT INTO EmprestimoChip(IDEmprestimo, IDChip)
		VALUES(1,6);
INSERT INTO EmprestimoChip(IDEmprestimo, IDChip)
		VALUES(2,5);
INSERT INTO EmprestimoChip(IDEmprestimo, IDChip)
		VALUES(3,4);
INSERT INTO EmprestimoChip(IDEmprestimo, IDChip)
		VALUES(4,3);
INSERT INTO EmprestimoChip(IDEmprestimo, IDChip)
		VALUES(5,2);
INSERT INTO EmprestimoChip(IDEmprestimo, IDChip)
		VALUES(6,1);

INSERT INTO Ligacao (IDLigacao, Data, Duracao, Custo, IDChip) VALUES (1,CONVERT(Date, '21-03-2017', 103), CONVERT(Time, '00:10:00', 8), 1.1, 3)
INSERT INTO Ligacao (IDLigacao,Data, Duracao, Custo, IDChip) VALUES (2,CONVERT(Date, '21-03-2017', 103), CONVERT(Time, '00:15:00', 8), 1.55, 3)
INSERT INTO Ligacao (IDLigacao,Data, Duracao, Custo, IDChip) VALUES (3,CONVERT(Date, '21-03-2017', 103), CONVERT(Time, '00:02:00', 8), 0.5, 3)
INSERT INTO Ligacao (IDLigacao,Data, Duracao, Custo, IDChip) VALUES (4,CONVERT(Date, '21-03-2017', 103), CONVERT(Time, '00:12:00', 8), 5.5, 3)
INSERT INTO Ligacao (IDLigacao,Data, Duracao, Custo, IDChip) VALUES (5,CONVERT(Date, '22-03-2017', 103), CONVERT(Time, '00:10:00', 8), 1.1, 3)
INSERT INTO Ligacao (IDLigacao,Data, Duracao, Custo, IDChip) VALUES (6,CONVERT(Date, '22-03-2017', 103), CONVERT(Time, '00:15:00', 8), 1.55, 3)
INSERT INTO Ligacao (IDLigacao,Data, Duracao, Custo, IDChip) VALUES (7,CONVERT(Date, '22-03-2017', 103), CONVERT(Time, '00:02:00', 8), 0.5, 3)
INSERT INTO Ligacao (IDLigacao,Data, Duracao, Custo, IDChip) VALUES (8,CONVERT(Date, '22-03-2017', 103), CONVERT(Time, '00:12:00', 8), 5.5, 3)
INSERT INTO Ligacao (IDLigacao,Data, Duracao, Custo, IDChip) VALUES (9,CONVERT(Date, '23-03-2017', 103), CONVERT(Time, '00:10:00', 8), 1.1, 3)
INSERT INTO Ligacao (IDLigacao,Data, Duracao, Custo, IDChip) VALUES (10,CONVERT(Date, '23-03-2017', 103), CONVERT(Time, '00:15:00', 8), 1.55, 3)
INSERT INTO Ligacao (IDLigacao,Data, Duracao, Custo, IDChip) VALUES (11,CONVERT(Date, '23-03-2017', 103), CONVERT(Time, '00:02:00', 8), 0.5, 3)
INSERT INTO Ligacao (IDLigacao,Data, Duracao, Custo, IDChip) VALUES (12,CONVERT(Date, '23-03-2017', 103), CONVERT(Time, '00:12:00', 8), 5.5, 3)

INSERT INTO Ligacao (IDLigacao,Data, Duracao, Custo, IDChip) VALUES (13,CONVERT(Date, '21-03-2017', 103), CONVERT(Time, '00:10:00', 8), 1.1, 1)
INSERT INTO Ligacao (IDLigacao,Data, Duracao, Custo, IDChip) VALUES (14,CONVERT(Date, '21-03-2017', 103), CONVERT(Time, '00:15:00', 8), 1.55, 1)
INSERT INTO Ligacao (IDLigacao,Data, Duracao, Custo, IDChip) VALUES (15,CONVERT(Date, '21-03-2017', 103), CONVERT(Time, '00:02:00', 8), 0.5, 1)
INSERT INTO Ligacao (IDLigacao,Data, Duracao, Custo, IDChip) VALUES (16,CONVERT(Date, '21-03-2017', 103), CONVERT(Time, '00:12:00', 8), 5.5, 1)
INSERT INTO Ligacao (IDLigacao,Data, Duracao, Custo, IDChip) VALUES (17,CONVERT(Date, '22-03-2017', 103), CONVERT(Time, '00:10:00', 8), 1.1, 1)
INSERT INTO Ligacao (IDLigacao,Data, Duracao, Custo, IDChip) VALUES (18,CONVERT(Date, '22-03-2017', 103), CONVERT(Time, '00:15:00', 8), 1.55, 1)
INSERT INTO Ligacao (IDLigacao,Data, Duracao, Custo, IDChip) VALUES (19,CONVERT(Date, '22-03-2017', 103), CONVERT(Time, '00:02:00', 8), 0.5, 1)
INSERT INTO Ligacao (IDLigacao,Data, Duracao, Custo, IDChip) VALUES (20,CONVERT(Date, '22-03-2017', 103), CONVERT(Time, '00:12:00', 8), 5.5, 1)
INSERT INTO Ligacao (IDLigacao,Data, Duracao, Custo, IDChip) VALUES (21,CONVERT(Date, '23-03-2017', 103), CONVERT(Time, '00:10:00', 8), 1.1, 1)
INSERT INTO Ligacao (IDLigacao,Data, Duracao, Custo, IDChip) VALUES (22,CONVERT(Date, '23-03-2017', 103), CONVERT(Time, '00:15:00', 8), 1.55, 1)
INSERT INTO Ligacao (IDLigacao,Data, Duracao, Custo, IDChip) VALUES (23,CONVERT(Date, '23-03-2017', 103), CONVERT(Time, '00:02:00', 8), 0.5, 1)
INSERT INTO Ligacao (IDLigacao,Data, Duracao, Custo, IDChip) VALUES (24,CONVERT(Date, '23-03-2017', 103), CONVERT(Time, '00:12:00', 8), 5.5, 1)

INSERT INTO Ligacao (IDLigacao,Data, Duracao, Custo, IDChip) VALUES (25,CONVERT(Date, '21-03-2017', 103), CONVERT(Time, '00:10:00', 8), 1.1, 2)
INSERT INTO Ligacao (IDLigacao,Data, Duracao, Custo, IDChip) VALUES (26,CONVERT(Date, '21-03-2017', 103), CONVERT(Time, '00:15:00', 8), 1.55, 2)
INSERT INTO Ligacao (IDLigacao,Data, Duracao, Custo, IDChip) VALUES (27,CONVERT(Date, '21-03-2017', 103), CONVERT(Time, '00:02:00', 8), 0.5, 2)
INSERT INTO Ligacao (IDLigacao,Data, Duracao, Custo, IDChip) VALUES (28,CONVERT(Date, '21-03-2017', 103), CONVERT(Time, '00:12:00', 8), 5.5, 2)
INSERT INTO Ligacao (IDLigacao,Data, Duracao, Custo, IDChip) VALUES (29,CONVERT(Date, '22-03-2017', 103), CONVERT(Time, '00:10:00', 8), 1.1, 2)
INSERT INTO Ligacao (IDLigacao,Data, Duracao, Custo, IDChip) VALUES (30,CONVERT(Date, '22-03-2017', 103), CONVERT(Time, '00:15:00', 8), 1.55, 2)
INSERT INTO Ligacao (IDLigacao,Data, Duracao, Custo, IDChip) VALUES (31,CONVERT(Date, '22-03-2017', 103), CONVERT(Time, '00:02:00', 8), 0.5, 2)
INSERT INTO Ligacao (IDLigacao,Data, Duracao, Custo, IDChip) VALUES (32,CONVERT(Date, '22-03-2017', 103), CONVERT(Time, '00:12:00', 8), 5.5, 2)
INSERT INTO Ligacao (IDLigacao,Data, Duracao, Custo, IDChip) VALUES (33,CONVERT(Date, '23-03-2017', 103), CONVERT(Time, '00:10:00', 8), 1.1, 2)
INSERT INTO Ligacao (IDLigacao,Data, Duracao, Custo, IDChip) VALUES (34,CONVERT(Date, '23-03-2017', 103), CONVERT(Time, '00:15:00', 8), 1.55, 2)
INSERT INTO Ligacao (IDLigacao,Data, Duracao, Custo, IDChip) VALUES (35,CONVERT(Date, '23-03-2017', 103), CONVERT(Time, '00:02:00', 8), 0.5, 2)
INSERT INTO Ligacao (IDLigacao,Data, Duracao, Custo, IDChip) VALUES (36,CONVERT(Date, '23-03-2017', 103), CONVERT(Time, '00:12:00', 8), 5.5, 2)

INSERT INTO Ligacao (IDLigacao,Data, Duracao, Custo, IDChip) VALUES (37,CONVERT(Date, '23-03-2017', 103), CONVERT(Time, '00:02:00', 8), 25.5, 2)
INSERT INTO Ligacao (IDLigacao,Data, Duracao, Custo, IDChip) VALUES (38,CONVERT(Date, '23-03-2017', 103), CONVERT(Time, '00:12:00', 8), 16.2, 3)

SELECT Pr.IDProjeto, SUM(Li.Custo) AS 'Gasto em ligações no projeto' FROM Projeto Pr
	INNER JOIN Emprestimo Em ON Pr.IDProjeto = Em.IDProjeto
	INNER JOIN EmprestimoChip Ec ON Em.IDEmprestimo = Ec.IDEmprestimo
	INNER JOIN Chip Ch ON Ch.IDChip = Ec.IDChip
	INNER JOIN Ligacao Li ON Li.IDChip = Ch.IDChip
WHERE Li.Data BETWEEN Em.DataInicio AND Em.DataFinal
GROUP BY Pr.IDProjeto;
