--Lista 02 Banco de Dados II

--Exercicio 01
CREATE INDEX IX_Cidade_NomeUF on Cidade(Nome,UF);

CREATE INDEX IX_Cliente_Cidade on Cliente(IDCidade); -- DE 6 SEGUNDOS PARA 1 SEGUNDO

DECLARE
 CURSOR C_Cidade_Duplicadas IS
      Select Ci.Nome, Ci.UF
         From Cidade Ci
         Group by Ci.NOME, Ci.UF
         Having Count(Ci.NOME)>1;
         
  CURSOR C_Cliente_Cidade(vNomeCidade in varchar2, vUF in varchar2) IS
      Select cl.Nome as Nome_Cliente,c.Nome as Nome_Cidade
        From Cliente cl 
        Join Cidade c On cl.IDCidade = c.IDCidade
        WHERE c.NOME = vNomeCidade AND c.UF = vUF;     
  BEGIN
    FOR cidade IN C_Cidade_Duplicadas LOOP
      DBMS_OUTPUT.PUT_LINE( '-----------------------');
      DBMS_OUTPUT.PUT_LINE( 'Cidade: '|| cidade.Nome );
      DBMS_OUTPUT.PUT_LINE( '-----------------------');
      FOR cliente IN C_Cliente_Cidade(cidade.Nome, cidade.UF) LOOP
        DBMS_OUTPUT.PUT_LINE( 'Nome: '||cliente.Nome_Cliente || ' - Cidade: '|| cliente.Nome_Cidade);
      END LOOP;
    END LOOP;
END;

--Exercicio 02
DECLARE
  vIdPedido number := 1;
  vValorPedido decimal;
BEGIN  
    Select SUM(pro.PrecoVenda*pi.Quantidade) as ValorFinal
       INTO vValorPedido
       From  Pedido ped
       Join PedidoItem pi On ped.IDPedido = pi.IDPedido
       Join Produto pro On pro.IDProduto = pi.IDProduto
       Where  ped.IDPedido = vIdPedido
       Order  by 1;
       
    Update Pedido ped
      Set ValorPedido = vValorPedido
      Where ped.IDPedido = vIdPedido;
      
    DBMS_OUTPUT.PUT_LINE( 'Preco: '||vValorPedido);
END;

--Exercicio 03
SELECT * FROM PEDIDO ORDER BY DATAPEDIDO ASC;

CREATE INDEX IX_Pedido_Cliente On Pedido(IDCliente); 
DECLARE
  CURSOR C_Cliente_Sem_Pedido IS
    Select c.IDCliente, c.Nome, c.Situacao
      From Cliente c
      Join Pedido Pd On c.IDCliente = Pd.IDCliente
      Where Pd.DataPedido > Add_months(TRUNC(sysdate),-6)
      Group By c.IDCliente, c.Nome, c.Situacao
      Order By c.IDCliente;
BEGIN  
    FOR cliente IN C_Cliente_Sem_Pedido LOOP
        Update Cliente
          Set Situacao = 'I'
          Where IDCliente = cliente.IDCliente;
        DBMS_OUTPUT.PUT_LINE( 'Nome: '||cliente.Nome || ' - Situação: '|| cliente.Situacao);
    END LOOP;
END;

--Exercicio 04

DECLARE
  vIdProduto number := 4246;
  vAno number := 2017;
  vMes number := 1;
  vQuantidade number;
  
  Cursor C_Produto_Materiais IS
    Select m.IDMaterial, m.Descricao FROM Produto p
     Inner Join ProdutoMaterial pm On p.IDProduto = pm.IDProduto
     Inner Join Material m On pm.IDMaterial = m.IDMaterial
     Where p.IDProduto = vIdProduto;
  
  Cursor C_Material_Quantidade(vIDMaterial in number) IS
    Select SUM(pm.Quantidade) as Quantidade
        From Material m
        Inner Join ProdutoMaterial pm On m.IDMaterial = pm.IDMaterial
        Inner Join Produto p On pm.IDProduto = p.IDProduto
        Inner Join PedidoItem pi On p.IDProduto = pi.IDProduto
        Inner Join Pedido pe On pi.IDPedido = pe.IDPedido 
        Where 
            EXTRACT(YEAR FROM pe.DataPedido) = vAno 
            AND EXTRACT(MONTH FROM pe.DataPedido) = vMes 
            AND p.IDProduto = vIdProduto
            AND pm.IDMaterial = vIDMaterial
        Group By m.IDMaterial,m.Descricao
        Order By 1; 
BEGIN  
    FOR vProduto IN C_Produto_Materiais LOOP
        FOR vMaterial IN C_Material_Quantidade(vProduto.IDMaterial) LOOP
          DBMS_OUTPUT.PUT_LINE( 'Material: '||vProduto.Descricao || ' - Quantidade: '|| vMaterial.Quantidade);
        END LOOP;
    END LOOP;
END;




