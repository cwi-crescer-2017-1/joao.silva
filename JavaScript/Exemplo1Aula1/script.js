function isObject(a){
    return typeof a === "object" && true;
}
function isNumber(a){
    return typeof a === "number" && true;
}
function isFunction(a){
   return typeof a === "function" && true;
}
function isNull(a){
  return
}
function isString(a){
    return typeof a === "string" && true;
}
function arrayToString(array,criterio){
  return array.join(criterio);
}
/*Séries Inválidas

Nesse exercício deverá ser implementada uma função chamada seriesInvalidas(series) que recebe o array de séries,
verifica quais são as séries inválidas e retorna o título das séries inválidas em formato String.

Exemplo:

seriesInvalidas(series); // retorna "Séries Inválidas: Série 1 - Série 2 ..."
Condições para as séries serem inválidas:

Ano de estreia maior que o ano atual;
Possuir algum campo que seja undefined ou null.*/
/*Exercício 1*/

function seriesInvalidas(series){
  return  isObject(series) && arrayToString(validador(series), " - ")
}
function validador(series){
  let anoAtual = new Date().getFullYear();
  let seriesInvalidas = [];
  seriesLabel:
  for(let x = 0; x<series.length; x++){
    if (series[x].anoEstreia>anoAtual){
        seriesInvalidas.push(series[x]);
    }else{
      for (let i in series[x]) {
        if (series[x][i] === null || typeof(series[x][i]) === "undefined") {
            seriesInvalidas.push(series[x].titulo);
            continue seriesLabel;
        }
      }
    }
  }
  return seriesInvalidas;
}
console.log(seriesInvalidas(series));

function pegarNomes(series){
  let seriesInvalidas = [];
  seriesNomes:
  for(let x = 0; x<series.length; x++){
      for (let i in series[x]) {
          seriesInvalidas.push(series[x].titulo);
          continue seriesNomes;
      }
  }
  return seriesInvalidas;
}
function seriePossuiTodasAsPropriedades(serie){
  return hasPropAndIsNotNull(serie, "anoEstreia") &&
  hasPropAndIsNotNull(serie,"diretor") &&
  hasPropAndIsNotNull(serie,"distribuidora") &&
  hasPropAndIsNotNull(serie,"elenco") &&
  hasPropAndIsNotNull(serie,"genero") &&
  hasPropAndIsNotNull(serie,"numeroEpisodios") &&
  hasPropAndIsNotNull(serie,"temporadas") &&
  hasPropAndIsNotNull(serie,"titulo") && true;
}
