create or replace Package Body pck_Cidades_Duplicadas As 
  
    Function PegaNomeCidadeCliente(vIDCliente In Number) Return Cidade.Nome%type Is 
      vNomeCidade Cidade.Nome%type;
      Begin
        Select c.Nome
        Into vNomeCidade
        From Cliente cl
        Inner Join Cidade c On cl.IDCidade = c.IDCidade
        Where cl.IDCliente = vIDCliente;
      End; 
  
    Function PegaNomeUFCliente(vIDCliente In Number) Return Cidade.UF%type Is 
      vNomeUF Cidade.UF%type;
      Begin
        Select c.UF
        Into vNomeUF
        From Cliente cl
        Inner Join Cidade c On cl.IDCidade = c.IDCidade
        Where cl.IDCliente = vIDCliente;
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
              Where pck_Cidades_Duplicadas.PegaNomeCidadeCliente(IDCliente) = cidade.Nome AND pck_Cidades_Duplicadas.PegaNomeUFCliente(IDCliente) = cidade.UF;
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