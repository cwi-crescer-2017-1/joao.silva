SELECT TOP 100 * FROM Livro;
SELECT TOP 100 * FROM Autor;
SELECT TOP 100 * FROM Revisor;
SELECT TOP 100 * FROM Usuarios;
SELECT TOP 100 * FROM Permissao;
SELECT TOP 100 * FROM UsuarioPermissao;
DELETE Revisor;
DELETE Livro WHERE Livro.Titulo = 'Harry Potter';
SELECT TOP 100 * FROM [dbo].[__MigrationHistory];

DELETE Usuarios Where Id = 28;

UPDATE Livro SET IdRevisor = 25 WHERE Isbn = 111 or Isbn = 112 or Isbn = 113;
INSERT INTO Livro (Titulo, Descricao, Genero, IdAutor,IdRevisor, Capa,DataPublicacao,DataRevisao) VALUES('Harry Potter','Era uma vez...','Ficção',11,null,'http://4.bp.blogspot.com/-_yWA68ZZUSs/Uc8GEm2bmaI/AAAAAAAACgI/arTfVSI_lH4/s960/1004044_10151499823121914_202603791_n.jpg',null,null);

UPDATE Livro SET Capa = 'http://4.bp.blogspot.com/-_yWA68ZZUSs/Uc8GEm2bmaI/AAAAAAAACgI/arTfVSI_lH4/s960/1004044_10151499823121914_202603791_n.jpg';