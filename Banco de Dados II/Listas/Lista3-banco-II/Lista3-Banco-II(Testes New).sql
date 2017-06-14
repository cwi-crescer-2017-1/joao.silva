



--grant DEBUG ANY PROCEDURE to CRESCER2017; --Executar como SYSTEM -LOCAL (PRIVILÉGIOS)

SELECT C.NOME, C.UF FROM CIDADE C ORDER BY C.NOME, C.UF;

SELECT C.NOME, C.IDCIDADE,PCK_CIDADES_DUPLICADAS.PegaNomeCity(C.IDCliente) FROM CLIENTE C
  WHERE PCK_CIDADES_DUPLICADAS.PegaNomeCity(C.IDCliente) = 'Abadiania' 
        AND PCK_CIDADES_DUPLICADAS.PegarUF(C.IDCliente) = 'GO'; 
        
SELECT PCK_CIDADES_DUPLICADAS.PegaNomeCity(1) FROM DUAL;
SELECT PCK_CIDADES_DUPLICADAS.PegarUF(1) FROM DUAL;

Select c.UF
        From Cliente cl
        Inner Join Cidade c On cl.IDCidade = c.IDCidade
        Where cl.IDCliente = 100;
        
Exec PCK_CIDADES_DUPLICADAS.AtualizaIDCidadeCliente;