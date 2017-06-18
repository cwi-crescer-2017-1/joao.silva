create or replace package pck_megasena is

  -- Author  : ANDRENUNES
  -- Purpose : Manipulação na base de dados da Loteria mais conhecida do Brasil
  
  -- Variáveis Globais - definidas em procedimento específico
  gPremio_sena          number(12,2) := 0;
  gPremio_quina         number(12,2) := 0;
  gPremio_quadra        number(12,2) := 0;
  gAcumulado_proximo_05 number(12,2) := 0;
  gAcumulado_final_ano  number(12,2) := 0;
  gId_Novo              number(38,0) := 0;
  gPremio_Bruto_Novo    number(12,2) := 0;
  gAcumulou             number(1,0)  := 0;
  gValorAcumulado       number(12,0) := 0;
  -- Public type declarations
  procedure salvaConcurso (pConcurso in integer,
                           pData     in date,
                           pPremio   in number);
  function buscaPercentual(pIdentificador in varchar2) return number;
  procedure atualizaAcertadores (pConcurso in integer);
  procedure gerarProximoConcurso;
  
end pck_megasena;