SELECT * FROM APOSTA;
SELECT * FROM APOSTA_PREMIADA;
SELECT * FROM CIDADE;
SELECT * FROM CONCURSO;
SELECT * FROM NUMERO_APOSTA;
SELECT * FROM REGRA_RATEIO_PREMIO;


Create Index IX_Aposta_Concurso on Aposta(IdConcurso);

Select co.IDConcurso+1 as NovoID, Sum(apo.Valor)*0.453 as NovoValorPremioBruto, co.Acumulou
From Aposta apo 
Inner Join Concurso co On apo.IDConcurso = co.IDConcurso 
Where co.IDConcurso =  1824--(SELECT MAX(IDCONCURSO) FROM CONCURSO)
Group By co.IDConcurso,co.Acumulou;

Exec pck_megasena.gerarProximoConcurso;
ROLLBACK; 
DELETE Concurso WHERE IDConcurso = 1825;
SELECT * FROM Concurso;

SELECT * FROM Aposta;
SELECT * FROM Numero_Aposta;

Select IDAposta From Aposta
Where IDConcurso = 1824
ORDER BY IDAposta; 

Select na.Numero From Aposta apo
Inner Join Numero_Aposta na On apo.IDAposta = na.IDAposta
Where apo.IDAposta = 3;

Select * From Aposta apo
Inner Join Numero_Aposta na On apo.IDAposta = na.IDAposta; 

Create Global Temporary Table TEMP_Apostas_Vitoriosas (IdAposta number(38,0), Acertos number(1), IDConcurso number(38,0)) ON COMMIT DELETE ROWS;

DECLARE
    pConcurso        number := 1824;
    pNumero_Acertos  number := 0;
    pNumero          number := 0;
    pPrimeira_Dezena number := 0;
    pSegunda_Dezena  number := 0;
    pTerceira_Dezena number := 0;
    pQuarta_Dezena   number := 0;
    pQuinta_Dezena   number := 0;
    pSexta_Dezena    number := 0;
    
    cursor C_Apostas IS
      Select IDAposta From Aposta
        Where IDConcurso = pConcurso
        ORDER BY IDAposta;
   
   cursor C_Numeros_Aposta(pIDAposta in number) IS
      Select na.Numero From Aposta apo
        Inner Join Numero_Aposta na On apo.IDAposta = na.IDAposta
        Where apo.IDAposta = pIDAposta;
BEGIN
    Select Primeira_Dezena, Segunda_Dezena, Terceira_Dezena, Quarta_Dezena, Quinta_Dezena, Sexta_Dezena 
      Into pPrimeira_Dezena, pSegunda_Dezena, pTerceira_Dezena, pQuarta_Dezena, pQuinta_Dezena, pSexta_Dezena
        From Concurso 
        Where IDConcurso = pConcurso; 

    For pAposta In C_Apostas Loop
         pNumero_Acertos := 0;
         For pNumeroAposta In C_Numeros_Aposta(pAposta.IDAposta) Loop --pAposta.IDAposta --pNumeroAposta.Numero
           pNumero := pNumeroAposta.Numero;
           If pNumero = pPrimeira_Dezena Or pNumero = pSegunda_Dezena 
              Or pNumero = pTerceira_Dezena Or pNumero = pQuarta_Dezena 
              Or pNumero = pQuinta_Dezena Or pNumero = pSexta_Dezena Then
              pNumero_Acertos := pNumero_Acertos+1;
           End If;   
         End Loop;
         If pNumero_Acertos >= 4 Then
           Insert Into TEMP_Apostas_Vitoriosas(IDAposta,Acertos,IDConcurso) Values(pAposta.IDAposta,pNumero_Acertos,pConcurso);      
         End If;
    End Loop;
   -- gravarValores();
END;

Declare
 pIDConcurso       number :=1824;
 pPremio_Sena      number := 0;
 pPremio_Quina     number := 0;
 pPremio_Quadra    number := 0;
 pQtd_Ganhadores_6 number := 0;
 pQtd_Ganhadores_5 number := 0;
 pQtd_Ganhadores_4 number := 0;
 pPremio_Sena_Individual   number := 0;
 pPremio_Quina_Individual  number := 0;
 pPremio_Quadra_Individual number := 0;
 Cursor temp_apostas_vitoriosas Is
    Select IDAposta, Acertos From TEMP_Apostas_Vitoriosas;
Begin
   Select Count(IDAposta) Into pQtd_Ganhadores_4 From TEMP_Apostas_Vitoriosas Where Acertos = 4 AND IDConcurso = pIDConcurso;     
   Select Count(IDAposta) Into pQtd_Ganhadores_5 From TEMP_Apostas_Vitoriosas Where Acertos = 5 AND IDConcurso = pIDConcurso;   
   Select Count(IDAposta) Into pQtd_Ganhadores_6 From TEMP_Apostas_Vitoriosas Where Acertos = 6 AND IDConcurso = pIDConcurso;  
   Select Premio_Sena, Premio_Quina, Premio_Quadra Into pPremio_Sena,pPremio_Quina,pPremio_Quadra From Concurso Where IDConcurso = pIDConcurso;
   
   If pQtd_Ganhadores_6 = 0 Then
        Update Concurso Set Acumulou = 1 Where IDConcurso =  pIDConcurso;
   Elsif pQtd_Ganhadores_6 > 0 Then
        pPremio_Sena_Individual := pPremio_Sena/pQtd_Ganhadores_6;
   End If;
   If pQtd_Ganhadores_5>0 Then
        pPremio_Quina_Individual := pPremio_Quina/pQtd_Ganhadores_5;
   End If;
   If pQtd_Ganhadores_4>0 Then
        pPremio_Quadra_Individual := pPremio_Quadra/pQtd_Ganhadores_4;
   End If;
   
   For aposta In temp_apostas_vitoriosas Loop
        If aposta.Acertos = 4 Then
            INSERT INTO Aposta_Premiada(IDAposta,Acertos,Valor) Values(aposta.IDAposta,aposta.Acertos,pPremio_Quadra_Individual); 
        ElsIf aposta.Acertos = 5 Then
            INSERT INTO Aposta_Premiada(IDAposta,Acertos,Valor) Values(aposta.IDAposta,aposta.Acertos,pPremio_Quina_Individual);
        ElsIf aposta.Acertos = 6 Then
            INSERT INTO Aposta_Premiada(IDAposta,Acertos,Valor) Values(aposta.IDAposta,aposta.Acertos,pPremio_Sena_Individual);
        End If;
        Delete TEMP_Apostas_Vitoriosas Where IDAposta = aposta.IDAposta;
   End Loop;
End;
Rollback;
--DBMS_OUTPUT.PUT_LINE( 'Aposta: '||pAposta.IDAposta || ' - Acertou 4: '|| pNumero_Acertos);

Select na.Numero From Aposta apo
Inner Join Numero_Aposta na On apo.IDAposta = na.IDAposta
Where apo.IDAposta = 3;

Select Primeira_Dezena, Segunda_Dezena, Terceira_Dezena, Quarta_Dezena, Quinta_Dezena, Sexta_Dezena From Concurso Where IDConcurso = 1824;  

Exec pck_megasena.atualizaAcertadores(1824);
RollBack;
Exec pck_megasena.atualizaAcertadores(1816);
Exec pck_megasena.atualizaAcertadores(1817);

Select * From Concurso;
Select * From Aposta_Premiada Order By Acertos Desc;
Delete Aposta_Premiada;

Exec pck_megasena.gerarProximoConcurso; 
DELETE Concurso WHERE IDConcurso = 1825;
SELECT * FROM Concurso;

--Teste
--Com Acumulada
Exec pck_megasena.atualizaAcertadores(1824);
Exec pck_megasena.gerarProximoConcurso; 
SELECT * FROM Concurso;
RollBack;
DELETE Concurso WHERE IDConcurso = 1825;
--Sem Acumulada
Exec pck_megasena.gerarProximoConcurso; 
SELECT * FROM Concurso;
DELETE Concurso WHERE IDConcurso = 1825;
