create or replace Package Body pck_Cidades_Duplicadas As 
  
    Function PegaNomeCity(vIDCliente In Number) Return Varchar2 Is 
      vNomeCidade Varchar2(30);
      Begin
        Select c.Nome
        Into vNomeCidade
        From Cliente cl
        Inner Join Cidade c On cl.IDCidade = c.IDCidade
        Where cl.IDCliente = vIDCliente;
        
        Return vNomeCidade;
        
        Exception WHEN NO_DATA_FOUND THEN RETURN '';
      End; 
  
    Function PegarUF(vIDCliente In Number) Return Varchar2 Is 
      vNomeUF Varchar2(2);
      Begin
        Select c.UF
        Into vNomeUF
        From Cliente cl
        Inner Join Cidade c On cl.IDCidade = c.IDCidade
        Where cl.IDCliente = vIDCliente;
        Return vNomeUF;
      End;
      
    Procedure AtualizaIDCidadeCliente Is
      Cursor CidadeDuplicada Is
        Select Min(c.IDCidade) As IDCidade,c.Nome, c.UF
        From Cidade c
        Group By c.Nome, c.UF;  
      Begin
          For cidade In CidadeDuplicada Loop
              Update Cliente 
              Set IDCidade = cidade.IDCidade
              Where pck_Cidades_Duplicadas.PegaNomeCity(IDCliente) = cidade.Nome AND pck_Cidades_Duplicadas.PegarUF(IDCliente) = cidade.UF;
          End Loop;
      End AtualizaIDCidadeCliente;
  
    Procedure DeletaCidadeDuplicada Is
      Cursor CidadeDuplicada Is
        Select Min(c.IDCidade) As IDCidade,c.Nome, c.UF
        From Cidade c
        Group By c.Nome, c.UF;  
      Begin
        For cidade In CidadeDuplicada Loop
              Delete From Cidade 
              Where Nome = cidade.Nome AND UF = cidade.UF;
          End Loop;
      End DeletaCidadeDuplicada;
End pck_Cidades_Duplicadas;