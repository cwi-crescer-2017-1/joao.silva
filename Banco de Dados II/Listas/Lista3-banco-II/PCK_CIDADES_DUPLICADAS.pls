create or replace Package pck_Cidades_Duplicadas As
  Procedure AtualizaIDCidadeCliente;
  Procedure DeletaCidadeDuplicada;
  Function PegaNomeCidadeCliente(vIDCliente In Number) Return Cidade.Nome%type;
  Function PegaNomeUFCliente(vIDCliente In Number) Return Cidade.UF%type;
End pck_Cidades_Duplicadas;