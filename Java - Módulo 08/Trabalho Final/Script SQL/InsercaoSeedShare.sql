INSERT INTO Estado VALUES(99999991, 'Acre', 'Brasil');
INSERT INTO Estado VALUES(99999992, 'Alagoas', 'Brasil');
INSERT INTO Estado VALUES(99999993, 'Amazonas', 'Brasil');
INSERT INTO Estado VALUES(99999994, 'Amapá', 'Brasil');
INSERT INTO Estado VALUES(99999995, 'Bahia', 'Brasil');
INSERT INTO Estado VALUES(99999996, 'Ceará', 'Brasil');
INSERT INTO Estado VALUES(99999997, 'Distrito Federal', 'Brasil');
INSERT INTO Estado VALUES(99999998, 'Espírito Santo', 'Brasil');
INSERT INTO Estado VALUES(99999999, 'Goiás', 'Brasil');
INSERT INTO Estado VALUES(99999981, 'Maranhão', 'Brasil');
INSERT INTO Estado VALUES(99999982, 'Minas Gerais', 'Brasil');
INSERT INTO Estado VALUES(99999983, 'Mato Grosso do Sul', 'Brasil');
INSERT INTO Estado VALUES(99999984, 'Mato Grosso', 'Brasil');
INSERT INTO Estado VALUES(99999985, 'Pará', 'Brasil');
INSERT INTO Estado VALUES(99999986, 'Paraíba', 'Brasil');
INSERT INTO Estado VALUES(99999987, 'Pernambuco', 'Brasil');
INSERT INTO Estado VALUES(99999988, 'Piauí', 'Brasil');
INSERT INTO Estado VALUES(99999989, 'Paraná', 'Brasil');
INSERT INTO Estado VALUES(99999971, 'Rio de Janeiro', 'Brasil');
INSERT INTO Estado VALUES(99999972, 'Rio Grande do Norte', 'Brasil');
INSERT INTO Estado VALUES(99999973, 'Rondônia', 'Brasil');
INSERT INTO Estado VALUES(99999974, 'Roraima', 'Brasil');
INSERT INTO Estado VALUES(99999975, 'Rio Grande do Sul', 'Brasil');
INSERT INTO Estado VALUES(99999976, 'Santa Catarina', 'Brasil');
INSERT INTO Estado VALUES(99999977, 'Sergipe', 'Brasil');
INSERT INTO Estado VALUES(99999978, 'São Paulo', 'Brasil');
INSERT INTO Estado VALUES(99999979, 'Tocantins', 'Brasil');

INSERT INTO USUARIO(ID,Email,Senha) VALUES(99999997,'teste@teste.com','$2a$06$g2z3xv1wwucDr/gIOQmWh.2pzLjbMaOO6t6T8UC8.S83pEQMSP7fa');
INSERT INTO USUARIO(ID,Email,Senha) VALUES(99999998,'teste2@teste.com','$2a$06$g2z3xv1wwucDr/gIOQmWh.2pzLjbMaOO6t6T8UC8.S83pEQMSP7fa');
INSERT INTO USUARIO(ID,Email,Senha) VALUES(99999999,'teste3@teste.com','$2a$06$g2z3xv1wwucDr/gIOQmWh.2pzLjbMaOO6t6T8UC8.S83pEQMSP7fa');

INSERT INTO Perfil (ID,Nome,Interesses,Status,Sexo,Data_Nascimento,ID_Estado,Foto_Url) VALUES (99999997,'Fusce','Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur sed tortor. Integer aliquam adipiscing lacus. Ut nec urna et arcu imperdiet ullamcorper. Duis at lacus. Quisque purus','Lorem ipsum dolor','Donec',to_date('1962-03-11','YYYY/MM/DD'),99999998,'http://3.bp.blogspot.com/_HwxB51wkeTE/THa6_MV1zvI/AAAAAAAAElw/I-QSY-TJjbw/s1600/batman-for-facebook.jpg');
INSERT INTO Perfil (ID,Nome,Interesses,Status,Sexo,Data_Nascimento,ID_Estado,Foto_Url) VALUES (99999998,'Pedro','Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur sed tortor. Integer aliquam adipiscing lacus. Ut nec urna et arcu imperdiet ullamcorper. Duis at','Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur sed','blandit',to_date('1866-04-16','YYYY/MM/DD'),99999992,'http://3.bp.blogspot.com/_HwxB51wkeTE/THa6_MV1zvI/AAAAAAAAElw/I-QSY-TJjbw/s1600/batman-for-facebook.jpg');
INSERT INTO Perfil (ID,Nome,Interesses,Status,Sexo,Data_Nascimento,ID_Estado,Foto_Url) VALUES (99999999,'Sed','Lorem ipsum dolor sit','Lorem ipsum dolor','tempor',to_date('1907-09-30','YYYY/MM/DD'),99999991,'http://3.bp.blogspot.com/_HwxB51wkeTE/THa6_MV1zvI/AAAAAAAAElw/I-QSY-TJjbw/s1600/batman-for-facebook.jpg');

Update Usuario Set ID_PERFIL = 99999997 Where ID = 99999997;
Update Usuario Set ID_PERFIL = 99999998 Where ID = 99999998;
Update Usuario Set ID_PERFIL = 99999999 Where ID = 99999999;

INSERT INTO RELACIONAMENTO(ID,ID_PERFIL_SOLICITANTE,ID_PERFIL_SOLICITADO,DATA_SOLICITACAO,PENDENTE) VALUES(99999997,99999997,99999998,SYSDATE,1);
INSERT INTO RELACIONAMENTO(ID,ID_PERFIL_SOLICITANTE,ID_PERFIL_SOLICITADO,DATA_SOLICITACAO,DATA_RESPOSTA,PENDENTE,RESPOSTA) VALUES(99999998,99999997,99999999,SYSDATE,SYSDATE,0,1);
INSERT INTO RELACIONAMENTO(ID,ID_PERFIL_SOLICITANTE,ID_PERFIL_SOLICITADO,DATA_SOLICITACAO,DATA_RESPOSTA,PENDENTE,RESPOSTA) VALUES(99999999,99999998,99999999,SYSDATE,SYSDATE,0,0);
INSERT INTO RELACIONAMENTO(ID,ID_PERFIL_SOLICITANTE,ID_PERFIL_SOLICITADO,DATA_SOLICITACAO,PENDENTE) VALUES(88888887, 753, 99999997, sysdate, 1);
Update RELACIONAMENTO Set Resposta = 1, Pendente = 0 Where ID = 99999997;
INSERT INTO Postagem (ID,ID_Perfil,Url_img,Descricao,Data_Postagem) VALUES (99999991,99999997,'https://ichef.bbci.co.uk/news/ws/624/amz/worldservice/live/assets/images/2015/11/26/151126130740_planta_624x351_thinstock_nocredit.jpg','Lorem ipsum dolor',to_date('1907-09-30','YYYY/MM/DD'));
INSERT INTO Postagem (ID,ID_Perfil,Url_img,Descricao,Data_Postagem) VALUES (99999992,99999997,'https://ichef.bbci.co.uk/news/ws/624/amz/worldservice/live/assets/images/2015/11/26/151126130740_planta_624x351_thinstock_nocredit.jpg','Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur sed tortor. Integer aliquam adipiscing lacus. Ut nec urna et arcu',to_date('1907-09-30','YYYY/MM/DD'));
INSERT INTO Postagem (ID,ID_Perfil,Url_img,Descricao,Data_Postagem) VALUES (99999993,99999998,'https://ichef.bbci.co.uk/news/ws/624/amz/worldservice/live/assets/images/2015/11/26/151126130740_planta_624x351_thinstock_nocredit.jpg','Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur sed tortor.',to_date('1907-09-30','YYYY/MM/DD'));
INSERT INTO Postagem (ID,ID_Perfil,Url_img,Descricao,Data_Postagem) VALUES (99999994,99999997,'https://ichef.bbci.co.uk/news/ws/624/amz/worldservice/live/assets/images/2015/11/26/151126130740_planta_624x351_thinstock_nocredit.jpg','Lorem ipsum dolor sit amet, consectetuer adipiscing elit.',to_date('1907-09-30','YYYY/MM/DD'));
INSERT INTO Postagem (ID,ID_Perfil,Url_img,Descricao,Data_Postagem) VALUES (99999995,99999997,'https://ichef.bbci.co.uk/news/ws/624/amz/worldservice/live/assets/images/2015/11/26/151126130740_planta_624x351_thinstock_nocredit.jpg','Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur sed',to_date('1907-09-30','YYYY/MM/DD'));
INSERT INTO Postagem (ID,ID_Perfil,Url_img,Descricao,Data_Postagem) VALUES (99999996,99999998,'https://ichef.bbci.co.uk/news/ws/624/amz/worldservice/live/assets/images/2015/11/26/151126130740_planta_624x351_thinstock_nocredit.jpg','Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur sed tortor. Integer aliquam',to_date('1907-09-30','YYYY/MM/DD'));
INSERT INTO Postagem (ID,ID_Perfil,Url_img,Descricao,Data_Postagem) VALUES (99999997,99999999,'https://ichef.bbci.co.uk/news/ws/624/amz/worldservice/live/assets/images/2015/11/26/151126130740_planta_624x351_thinstock_nocredit.jpg','Lorem ipsum dolor sit amet, consectetuer',to_date('1907-09-30','YYYY/MM/DD'));
INSERT INTO Postagem (ID,ID_Perfil,Url_img,Descricao,Data_Postagem) VALUES (99999998,99999998,'https://ichef.bbci.co.uk/news/ws/624/amz/worldservice/live/assets/images/2015/11/26/151126130740_planta_624x351_thinstock_nocredit.jpg','Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur sed tortor. Integer aliquam adipiscing lacus. Ut nec urna et arcu',to_date('1907-09-30','YYYY/MM/DD'));
INSERT INTO Postagem (ID,ID_Perfil,Url_img,Descricao,Data_Postagem) VALUES (99999999,99999999,'https://ichef.bbci.co.uk/news/ws/624/amz/worldservice/live/assets/images/2015/11/26/151126130740_planta_624x351_thinstock_nocredit.jpg','Lorem ipsum dolor sit amet, consectetuer adipiscing',to_date('1907-09-30','YYYY/MM/DD'));
INSERT INTO Postagem (ID,ID_Perfil,Url_img,Descricao,Data_Postagem) VALUES (99999981,99999998,'https://ichef.bbci.co.uk/news/ws/624/amz/worldservice/live/assets/images/2015/11/26/151126130740_planta_624x351_thinstock_nocredit.jpg','Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur sed tortor. Integer',to_date('1907-09-30','YYYY/MM/DD'));
INSERT INTO Postagem (ID,ID_Perfil,Url_img,Descricao,Data_Postagem) VALUES (99999982,99999997,'https://ichef.bbci.co.uk/news/ws/624/amz/worldservice/live/assets/images/2015/11/26/151126130740_planta_624x351_thinstock_nocredit.jpg','Lorem ipsum dolor sit',to_date('1907-09-30','YYYY/MM/DD'));
INSERT INTO Postagem (ID,ID_Perfil,Url_img,Descricao,Data_Postagem) VALUES (99999983,99999998,'https://ichef.bbci.co.uk/news/ws/624/amz/worldservice/live/assets/images/2015/11/26/151126130740_planta_624x351_thinstock_nocredit.jpg','Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur sed',to_date('1907-09-30','YYYY/MM/DD'));
INSERT INTO Postagem (ID,ID_Perfil,Url_img,Descricao,Data_Postagem) VALUES (99999984,99999998,'https://ichef.bbci.co.uk/news/ws/624/amz/worldservice/live/assets/images/2015/11/26/151126130740_planta_624x351_thinstock_nocredit.jpg','Lorem',to_date('1907-09-30','YYYY/MM/DD'));
INSERT INTO Postagem (ID,ID_Perfil,Url_img,Descricao,Data_Postagem) VALUES (99999985,99999999,'https://ichef.bbci.co.uk/news/ws/624/amz/worldservice/live/assets/images/2015/11/26/151126130740_planta_624x351_thinstock_nocredit.jpg','Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur sed tortor. Integer',to_date('1907-09-30','YYYY/MM/DD'));
INSERT INTO Postagem (ID,ID_Perfil,Url_img,Descricao,Data_Postagem) VALUES (99999986,99999997,'https://ichef.bbci.co.uk/news/ws/624/amz/worldservice/live/assets/images/2015/11/26/151126130740_planta_624x351_thinstock_nocredit.jpg','Lorem ipsum dolor sit',to_date('1907-09-30','YYYY/MM/DD'));
INSERT INTO Postagem (ID,ID_Perfil,Url_img,Descricao,Data_Postagem) VALUES (99999987,99999999,'https://ichef.bbci.co.uk/news/ws/624/amz/worldservice/live/assets/images/2015/11/26/151126130740_planta_624x351_thinstock_nocredit.jpg','Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur sed tortor. Integer aliquam adipiscing lacus. Ut nec urna',to_date('1907-09-30','YYYY/MM/DD'));
INSERT INTO Postagem (ID,ID_Perfil,Url_img,Descricao,Data_Postagem) VALUES (99999988,99999997,'https://ichef.bbci.co.uk/news/ws/624/amz/worldservice/live/assets/images/2015/11/26/151126130740_planta_624x351_thinstock_nocredit.jpg','Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur sed tortor. Integer',to_date('1907-09-30','YYYY/MM/DD'));
INSERT INTO Postagem (ID,ID_Perfil,Url_img,Descricao,Data_Postagem) VALUES (99999989,99999998,'https://ichef.bbci.co.uk/news/ws/624/amz/worldservice/live/assets/images/2015/11/26/151126130740_planta_624x351_thinstock_nocredit.jpg','Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur sed tortor. Integer aliquam adipiscing lacus. Ut nec urna',to_date('1907-09-30','YYYY/MM/DD'));
INSERT INTO Postagem (ID,ID_Perfil,Url_img,Descricao,Data_Postagem) VALUES (99999971,99999999,'https://ichef.bbci.co.uk/news/ws/624/amz/worldservice/live/assets/images/2015/11/26/151126130740_planta_624x351_thinstock_nocredit.jpg','Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur sed tortor. Integer aliquam adipiscing lacus. Ut',to_date('1907-09-30','YYYY/MM/DD'));
INSERT INTO Postagem (ID,ID_Perfil,Url_img,Descricao,Data_Postagem) VALUES (99999972,99999997,'https://ichef.bbci.co.uk/news/ws/624/amz/worldservice/live/assets/images/2015/11/26/151126130740_planta_624x351_thinstock_nocredit.jpg','Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur sed tortor. Integer aliquam',to_date('1907-09-30','YYYY/MM/DD'));
INSERT INTO Postagem (ID,ID_Perfil,Url_img,Descricao,Data_Postagem) VALUES (99999973,99999998,'https://ichef.bbci.co.uk/news/ws/624/amz/worldservice/live/assets/images/2015/11/26/151126130740_planta_624x351_thinstock_nocredit.jpg','Lorem ipsum dolor',to_date('1907-09-30','YYYY/MM/DD'));
INSERT INTO Postagem (ID,ID_Perfil,Url_img,Descricao,Data_Postagem) VALUES (99999974,99999998,'https://ichef.bbci.co.uk/news/ws/624/amz/worldservice/live/assets/images/2015/11/26/151126130740_planta_624x351_thinstock_nocredit.jpg','Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur',to_date('1907-09-30','YYYY/MM/DD'));
INSERT INTO Postagem (ID,ID_Perfil,Url_img,Descricao,Data_Postagem) VALUES (99999975,99999997,'https://ichef.bbci.co.uk/news/ws/624/amz/worldservice/live/assets/images/2015/11/26/151126130740_planta_624x351_thinstock_nocredit.jpg','Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur sed tortor. Integer aliquam adipiscing lacus. Ut nec urna',to_date('1907-09-30','YYYY/MM/DD'));
INSERT INTO Postagem (ID,ID_Perfil,Url_img,Descricao,Data_Postagem) VALUES (99999976,99999997,'https://ichef.bbci.co.uk/news/ws/624/amz/worldservice/live/assets/images/2015/11/26/151126130740_planta_624x351_thinstock_nocredit.jpg','Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur sed tortor. Integer',to_date('1907-09-30','YYYY/MM/DD'));
INSERT INTO Postagem (ID,ID_Perfil,Url_img,Descricao,Data_Postagem) VALUES (99999977,99999998,'https://ichef.bbci.co.uk/news/ws/624/amz/worldservice/live/assets/images/2015/11/26/151126130740_planta_624x351_thinstock_nocredit.jpg','Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur sed tortor. Integer aliquam adipiscing lacus. Ut nec urna et arcu',to_date('1907-09-30','YYYY/MM/DD'));
INSERT INTO Postagem (ID,ID_Perfil,Url_img,Descricao,Data_Postagem) VALUES (99999978,99999997,'https://ichef.bbci.co.uk/news/ws/624/amz/worldservice/live/assets/images/2015/11/26/151126130740_planta_624x351_thinstock_nocredit.jpg','Lorem ipsum dolor sit amet,',to_date('1907-09-30','YYYY/MM/DD'));
INSERT INTO Postagem (ID,ID_Perfil,Url_img,Descricao,Data_Postagem) VALUES (99999979,99999999,'https://ichef.bbci.co.uk/news/ws/624/amz/worldservice/live/assets/images/2015/11/26/151126130740_planta_624x351_thinstock_nocredit.jpg','Lorem ipsum dolor sit amet,',to_date('1907-09-30','YYYY/MM/DD'));
INSERT INTO Postagem (ID,ID_Perfil,Url_img,Descricao,Data_Postagem) VALUES (99999961,99999997,'https://ichef.bbci.co.uk/news/ws/624/amz/worldservice/live/assets/images/2015/11/26/151126130740_planta_624x351_thinstock_nocredit.jpg','Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur sed tortor. Integer',to_date('1907-09-30','YYYY/MM/DD'));
INSERT INTO Postagem (ID,ID_Perfil,Url_img,Descricao,Data_Postagem) VALUES (99999962,99999999,'https://ichef.bbci.co.uk/news/ws/624/amz/worldservice/live/assets/images/2015/11/26/151126130740_planta_624x351_thinstock_nocredit.jpg','Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur sed tortor. Integer aliquam adipiscing lacus. Ut nec urna et',to_date('1907-09-30','YYYY/MM/DD'));
INSERT INTO Postagem (ID,ID_Perfil,Url_img,Descricao,Data_Postagem) VALUES (99999963,99999998,'https://ichef.bbci.co.uk/news/ws/624/amz/worldservice/live/assets/images/2015/11/26/151126130740_planta_624x351_thinstock_nocredit.jpg','Lorem ipsum',to_date('1907-09-30','YYYY/MM/DD'));
INSERT INTO Postagem (ID,ID_Perfil,Url_img,Descricao,Data_Postagem) VALUES (99999964,99999998,'https://ichef.bbci.co.uk/news/ws/624/amz/worldservice/live/assets/images/2015/11/26/151126130740_planta_624x351_thinstock_nocredit.jpg','Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur sed tortor. Integer aliquam adipiscing',to_date('1907-09-30','YYYY/MM/DD'));
INSERT INTO Postagem (ID,ID_Perfil,Url_img,Descricao,Data_Postagem) VALUES (99999965,99999997,'https://ichef.bbci.co.uk/news/ws/624/amz/worldservice/live/assets/images/2015/11/26/151126130740_planta_624x351_thinstock_nocredit.jpg','Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur sed tortor. Integer',to_date('1907-09-30','YYYY/MM/DD'));

INSERT INTO Curtida (ID,Data_Curtida,ID_POSTAGEM,ID_PERFIL) VALUES (99999991,SYSDATE,99999965,99999999);
INSERT INTO Curtida (ID,Data_Curtida,ID_POSTAGEM,ID_PERFIL) VALUES (99999992,SYSDATE,99999991,99999999);
INSERT INTO Curtida (ID,Data_Curtida,ID_POSTAGEM,ID_PERFIL) VALUES (99999993,SYSDATE,99999992,99999999);
INSERT INTO Curtida (ID,Data_Curtida,ID_POSTAGEM,ID_PERFIL) VALUES (99999994,SYSDATE,99999994,99999999);
INSERT INTO Curtida (ID,Data_Curtida,ID_POSTAGEM,ID_PERFIL) VALUES (99999995,SYSDATE,99999995,99999999);
INSERT INTO Curtida (ID,Data_Curtida,ID_POSTAGEM,ID_PERFIL) VALUES (99999996,SYSDATE,99999982,99999999);

INSERT INTO Curtida (ID,Data_Curtida,ID_POSTAGEM,ID_PERFIL) VALUES (99999997,SYSDATE,99999997,99999997);
INSERT INTO Curtida (ID,Data_Curtida,ID_POSTAGEM,ID_PERFIL) VALUES (99999998,SYSDATE,99999999,99999997);
INSERT INTO Curtida (ID,Data_Curtida,ID_POSTAGEM,ID_PERFIL) VALUES (99999999,SYSDATE,99999985,99999997);
INSERT INTO Curtida (ID,Data_Curtida,ID_POSTAGEM,ID_PERFIL) VALUES (99999981,SYSDATE,99999987,99999997);
INSERT INTO Curtida (ID,Data_Curtida,ID_POSTAGEM,ID_PERFIL) VALUES (99999982,SYSDATE,99999971,99999997);

INSERT INTO Comentario (ID,Data_Comentario,ID_POSTAGEM,ID_PERFIL,TEXTO) VALUES (99999991,SYSDATE,99999965,99999999,'haha');
INSERT INTO Comentario (ID,Data_Comentario,ID_POSTAGEM,ID_PERFIL,TEXTO) VALUES (99999992,SYSDATE,99999991,99999999,'kkk');
INSERT INTO Comentario (ID,Data_Comentario,ID_POSTAGEM,ID_PERFIL,TEXTO) VALUES (99999993,SYSDATE,99999992,99999999,'perfeito');
INSERT INTO Comentario (ID,Data_Comentario,ID_POSTAGEM,ID_PERFIL,TEXTO) VALUES (99999994,SYSDATE,99999994,99999999,'curti');
INSERT INTO Comentario (ID,Data_Comentario,ID_POSTAGEM,ID_PERFIL,TEXTO) VALUES (99999995,SYSDATE,99999995,99999999,'amei');
INSERT INTO Comentario (ID,Data_Comentario,ID_POSTAGEM,ID_PERFIL,TEXTO) VALUES (99999996,SYSDATE,99999982,99999999,'ehuehuehuehue');

INSERT INTO Comentario (ID,Data_Comentario,ID_POSTAGEM,ID_PERFIL,TEXTO) VALUES (99999997,SYSDATE,99999997,99999997,'comentário construtivo');
INSERT INTO Comentario (ID,Data_Comentario,ID_POSTAGEM,ID_PERFIL,TEXTO) VALUES (99999998,SYSDATE,99999999,99999997,'o mundo é dos nets');
INSERT INTO Comentario (ID,Data_Comentario,ID_POSTAGEM,ID_PERFIL,TEXTO) VALUES (99999999,SYSDATE,99999985,99999997,'fsafasda');
INSERT INTO Comentario (ID,Data_Comentario,ID_POSTAGEM,ID_PERFIL,TEXTO) VALUES (99999981,SYSDATE,99999987,99999997,'a vida');
INSERT INTO Comentario (ID,Data_Comentario,ID_POSTAGEM,ID_PERFIL,TEXTO) VALUES (99999982,SYSDATE,99999971,99999997,'ehuehueheu');
commit;
Select * From Estado;
Select * From Usuario;
Select * From Perfil;
Select * From Relacionamento;
Select * From Postagem;
INSERT INTO Curtida (ID,Data_Curtida,ID_POSTAGEM,ID_PERFIL) VALUES (99000095,SYSDATE,200,99999997);
Update Postagem Set ID = 99999999 Where Descricao = 'Lalaland';
Select * From Curtida;
Select * From Comentario;
Select * From Curtida Where ID_PERFIL = 99999997 And ID_Postagem = 350;
DELETE postagem Where Descricao = 'dasda';
update postagem set data_postagem = sysdate where id=99999983;
commit;
Select * From Postagem pos Where pos.ID_Perfil IN( Select pe.ID From Perfil pe Where pe.ID IN(Select re.ID_PERFIL_SOLICITADO From Relacionamento re Where re.ID_PERFIL_SOLICITADO = 99999997 OR re.ID_PERFIL_SOLICITANTE = 99999997 AND re.Resposta = 1) OR pe.ID IN (Select re.ID_PERFIL_SOLICITANTE From Relacionamento re Where re.ID_PERFIL_SOLICITADO = 99999997 OR re.ID_PERFIL_SOLICITANTE = 99999997 AND re.Resposta = 1)) ORDER BY pos.DATA_POSTAGEM DESC;
Select Count(pos.ID) From Postagem pos Where pos.ID_Perfil IN( Select pe.ID From Perfil pe Where pe.ID IN(Select re.ID_PERFIL_SOLICITADO From Relacionamento re Where re.ID_PERFIL_SOLICITADO = 99999997 OR re.ID_PERFIL_SOLICITANTE = 99999997 AND re.Resposta = 1) OR pe.ID IN (Select re.ID_PERFIL_SOLICITANTE From Relacionamento re Where re.ID_PERFIL_SOLICITADO = 99999997 OR re.ID_PERFIL_SOLICITANTE = 99999997 AND re.Resposta = 1));
Update Postagem Set Descricao = 'Lalaland', Url_Img = 'https://upload.wikimedia.org/wikipedia/en/thumb/6/63/IMG_%28business%29.svg/1280px-IMG_%28business%29.svg.png' Where ID = 99999996;

Select pos.* From Postagem pos Where pos.ID_Perfil IN( Select pe.ID From Perfil pe Where pe.ID IN(Select re.ID_PERFIL_SOLICITADO From Relacionamento re Where (re.ID_PERFIL_SOLICITADO = 1300 OR re.ID_PERFIL_SOLICITANTE = 1300) AND Re.Pendente = 0 AND re.Resposta = 1) OR pe.ID IN (Select re.ID_PERFIL_SOLICITANTE From Relacionamento re Where (re.ID_PERFIL_SOLICITADO = 1300 OR re.ID_PERFIL_SOLICITANTE = 1300) AND re.Resposta = 1 AND Re.Pendente = 0));
Select * From Usuario Where Usuario.ID_PERFIL = 1300;
/*Amigos*/
Select pe.* From Perfil pe Where pe.ID IN (Select re.ID_PERFIL_SOLICITADO From Relacionamento re Where re.ID_PERFIL_SOLICITADO = 99999997 OR re.ID_PERFIL_SOLICITANTE = 99999997 AND re.Resposta = 1) OR pe.ID IN(Select re.ID_PERFIL_SOLICITANTE From Relacionamento re Where re.ID_PERFIL_SOLICITADO = 99999997 OR re.ID_PERFIL_SOLICITANTE = 99999997 AND re.Resposta = 1) AND pe.ID != 99999997;
/*Solicitações pendentes*/
Select pe.* From Perfil pe Where pe.ID IN (Select re.ID_PERFIL_SOLICITADO From Relacionamento re Where re.ID_PERFIL_SOLICITADO = 99999997 OR re.ID_PERFIL_SOLICITANTE = 99999997 AND Re.Resposta Is Null And Re.Pendente = 1) OR pe.ID IN(Select re.ID_PERFIL_SOLICITANTE From Relacionamento re Where re.ID_PERFIL_SOLICITADO = 99999997 OR re.ID_PERFIL_SOLICITANTE = 99999997 AND re.Resposta IS NULL AND re.PENDENTE = 1) AND pe.ID != 99999997;

Select * From Perfil Where nome = 'Ped_%';

select pe.* from Perfil pe where pe.id In (select Re.Id_Perfil_Solicitado from Relacionamento re where re.id_perfil_solicitante = 99999997 And re.pendente = 0 And re.resposta = 1) Or pe.id In (select re.id_perfil_solicitante from Relacionamento re where re.id_perfil_solicitado = 99999997 And re.pendente = 0 And re.resposta = 1) And pe.id != 99999997;

Select * From Postagem po Where po.id In (select cur.ID_POSTAGEM from Curtida cur Where cur.id_perfil = 99999997);

