create or replace package body pck_megasena is

  /* Busca valores percentuais conforme regra definida na tabela 'Regra_Rateio_Premio' */
  function buscaPercentual(pIdentificador in varchar2) return number as
        -- 
        v_percentual  regra_rateio_premio.percentual%type; -- herdará as propriedades do campo percentual
      begin
        
        -- busca percentual conforme parametro de entrada
        select percentual
        into   v_percentual   -- atribuí valor para a variavel
        from   regra_rateio_premio
        where  identificador = lower(pIdentificador);
        
        return v_percentual;
      exception
        when no_data_found then
          dbms_output.put_line('Erro: '||pIdentificador);
          raise_application_error(-20002, sqlerrm);
      end buscaPercentual;
  ---------------------------------------------------------------------------------------------------------------------------------------
  /* Executa o rateio dos premios conforme definção das regras */
  procedure defineRateioPremio (pPremio in number) as
    begin
    
       gPremio_sena          := buscaPercentual('premio_sena') * pPremio;
       gPremio_quina         := buscaPercentual('premio_quina') * pPremio;
       gPremio_quadra        := buscaPercentual('premio_quadra') * pPremio;
       gAcumulado_proximo_05 := buscaPercentual('acumulado_05') * pPremio;
       gAcumulado_final_ano  := buscaPercentual('acumulado_final_ano') * pPremio;
  
    end defineRateioPremio;

  ---------------------------------------------------------------------------------------------------------------------------------------
  /* Salva o registro referente ao concurso */
  procedure salvaConcurso (pConcurso in integer,
                           pData     in date,
                           pPremio   in number) as
    begin

       defineRateioPremio(pPremio);
       
       --insereConcurso( pConcurso, pData, gPremio_Sena, gPremio_Quina, gPremio_Quadra, gAcumulado_proximo_05, gAcumulado_final_ano );
       
       Insert into Concurso 
           (Idconcurso, Data_Sorteio, Premio_Sena, Premio_Quina, Premio_Quadra, Acumulado_Proximo_05, Acumulado_Final_Ano)
       Values 
           (pConcurso, pData, gPremio_Sena, gPremio_Quina, gPremio_Quadra, gAcumulado_proximo_05, gAcumulado_final_ano);
    end salvaConcurso;
  ---------------------------------------------------------------------------------------------------------------------------------------
    /*
     Questão "A" - implementar rotina que irá inserir um novo concurso
    */
   
   procedure gerarIDeValoreAcumulador as
      pValor_Acumulado number := 0;
      pPremio_Sena     number := 0;
   begin
      Select co.IDConcurso+1 as NovoID, Sum(apo.Valor)*0.453 as NovoValorPremioBruto, co.Acumulou, co.Premio_Sena
        Into gId_Novo,gPremio_Bruto_Novo,gAcumulou,pPremio_Sena  
        From Aposta apo
        Inner Join Concurso co On apo.IDConcurso = co.IDConcurso 
        Where co.IDConcurso = (SELECT MAX(IDCONCURSO) FROM CONCURSO)
        Group By co.IDConcurso,co.Acumulou,co.Premio_Sena;  
      IF gAcumulou = 1 THEN
         gPremio_Bruto_Novo := gPremio_Bruto_Novo + pPremio_Sena;
      END IF;
   end gerarIDeValoreAcumulador;
   
  procedure gerarProximoConcurso as
   pPremioBruto number(12,0) := 0;
   begin
      gerarIDeValoreAcumulador();
      --Fazer aposta premiada
      pPremioBruto := gValorAcumulado + gPremio_Bruto_Novo;
      salvaConcurso(gId_Novo,TRUNC(sysdate),pPremioBruto);
      
   end gerarProximoConcurso;
   
  ---------------------------------------------------------------------------------------------------------------------------------------
    /*
     Questão "B" - implementar rotina que irá inserir todos os acertadores de um determinado concurso
    */
  --Necessário criar esta tabela temporaria no banco   
  --Create Global Temporary Table TEMP_Apostas_Vitoriosas (IdAposta number(38,0), Acertos number(1), IDConcurso number(38,0)) ON COMMIT DELETE ROWS;
  Procedure salvarApostasPremiadas(pIDConcurso in number) As
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
   ElsIf pQtd_Ganhadores_6>0 Then
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
  End salvarApostasPremiadas;
  
  procedure atualizaAcertadores (pConcurso in integer) as
   pNumero_Acertos  number := 0;
   pNumero          number := 0;
   pPrimeira_Dezena number := 0;
   pSegunda_Dezena  number := 0;
   pTerceira_Dezena number := 0;
   pQuarta_Dezena   number := 0;
   pQuinta_Dezena   number := 0;
   pSexta_Dezena    number := 0;
   Cursor C_Apostas IS
      Select IDAposta From Aposta
        Where IDConcurso = pConcurso
        ORDER BY IDAposta;
   
   Cursor C_Numeros_Aposta(pIDAposta in number) IS
      Select na.Numero From Aposta apo
        Inner Join Numero_Aposta na On apo.IDAposta = na.IDAposta
        Where apo.IDAposta = pIDAposta;
        
   Begin
      Select Primeira_Dezena, Segunda_Dezena, Terceira_Dezena, Quarta_Dezena, Quinta_Dezena, Sexta_Dezena 
      Into pPrimeira_Dezena, pSegunda_Dezena, pTerceira_Dezena, pQuarta_Dezena, pQuinta_Dezena, pSexta_Dezena
        From Concurso 
        Where IDConcurso = pConcurso; 
        
      For pAposta In C_Apostas Loop
         pNumero_Acertos := 0;
         For pNumero_Aposta In C_Numeros_Aposta(pAposta.IDAposta) Loop --pAposta.IDAposta --pNumeroAposta.Numero
           pNumero := pNumero_Aposta.Numero;
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
      salvarApostasPremiadas(pConcurso);
 End atualizaAcertadores;
   
begin
  -- Initialization
  null; --<Statement>;
end pck_megasena;