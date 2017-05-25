//Para verificar o undefined e a soma com undefined,
//obs caso use delete para remover um campo da série o validador continua considerando está série válida, mesmo que com um campo a menos
//obs² quando uma serie possui numero de episodios indefinidos ela ainda é utilizada na conta da média, considerando assim que essa série possui 0 episódios
//series.push({"titulo":"TesteUndefined","anoEstreia":2014,"diretor":["Tester"],"genero":["Drama","Drama","Terror"],"elenco":["Debug","Error","Undefined"],"temporadas":undefined,"numeroEpisodios":undefined,"distribuidora":"JS"});
console.log(series);
function isObject(a){
    return typeof a === "object" && true;
}
function isNumber(a){
    return typeof a === "number" && true;
}
function isString(a){
    return typeof a === "string" && true;
}
function arrayToString(array,criterio,inicio=""){ /*Transforma um array em uma String conforme critério solicitado*/
  return `${inicio}${array.join(criterio)}`;
}

/*Exercício 1 - Atualizada*/

//delete series[0].distribuidora; //Ativar para verificar a validação de series sem alguma propriedade necessária

function seriesInvalidas(series){
  return  isObject(series) && validaSerie(series);
  //Valida se a variavel series é um objeto e se for realiza a validação das series e em seguida converte os
  //titulos das séries inválidas para apenas uma string
  function validaSerie(series){
    let anoAtual = new Date().getFullYear();
    let serieInvalida = series.filter(serie => {
      let nullOrUndefined = Object.values(serie).some(c => c===null || typeof c === 'undefined');
      let estreiaInvalida= serie.anoEstreia>anoAtual;
      return nullOrUndefined || estreiaInvalida;
    });
    return arrayToString(serieInvalida.map(s=>s.titulo)," - ","Séries inválidas: ");
  }
}
console.log("Exercicios 1: ",seriesInvalidas(series));

/*Exercício 2 - Atualizada*/

function filtrarSeriesPorAno(series, ano){
    return isObject(series) && isNumber(ano) && filtroDeSeriesPorAno(series, ano);
}

function filtroDeSeriesPorAno(series, ano){
  return series.filter(serie => serie.anoEstreia>ano).map(serie => serie.titulo);
}
console.log("Exercicios 2: ",filtrarSeriesPorAno(series, 2017));

/*Exercicio 3 - Atualizada*/
function mediaDeEpisodios(series){
  return isObject(series) && calcularMediaDeEpisodios(series);
}
function calcularMediaDeEpisodios(series){
  somaEpisodios = series.map(function(v){return v.numeroEpisodios}).reduce(function(a,b){return a+b});
  //Map seleciona o campo numeroEpisodios de cada serie e o reduce cria um "SUM" desses valores
  return somaEpisodios = somaEpisodios/series.length;
}
console.log("Exercicios 3: ",mediaDeEpisodios(series));

/*Exercicio 4 - Atualizada*/
function procurarPorNome(series, nome){
  return isObject(series) && isString(nome) && procuradorPorNome(series, nome);
}
function procuradorPorNome(series, nome){
  return series.map(serie => serie.elenco).some(elenco => elenco.includes(nome));
}
console.log("Exercicios 4 (true): ",procurarPorNome(series,"Gaten Matarazzo"));
console.log("Exercicios 4 (false): ",procurarPorNome(series,"Pedro de Alcântara Francisco António João Carlos Xavier de Paula Miguel Rafael Joaquim José Gonzaga Pascoal Cipriano Serafim"))

/*Exercicios 5*/
function mascadaEmSerie(serie){
  let mascadaElenco = serie.elenco.length*40000;
  let mascadaDiretoria = serie.diretor.length*100000;
  return isObject(serie) && mascadaElenco+mascadaDiretoria;
}
console.log("Exercicios 5: ");
console.log(`Mascada da série: ${series.map(function(serie){ let titulo = serie.titulo; let mascada = mascadaEmSerie(serie); return `\n ${titulo} é ${mascada}`;})}`);
console.log("----------------------------------------------------------------");
/*Exercicio 6 - Atualizada*/
/*A*/
function queroGenero(generoSelecionado) {
  return isString(generoSelecionado) && selecaoPorGenero(generoSelecionado);
}
function selecaoPorGenero(generoSelecionado){
  let seriesSelecionadas = series.map(serie=>serie.genero.includes(generoSelecionado) && serie.titulo);
    return seriesSelecionadas.filter(seriesSelecionadas => seriesSelecionadas!==false);
}
console.log("Exercicios 6.A: ",queroGenero("JavaScript"));
/*B*/
function queroTitulo(tituloSelecionado){
  return isString(tituloSelecionado) && selecaoPorTitulo(tituloSelecionado);
}
function selecaoPorTitulo(tituloSelecionado){
  return series
  .filter(serie => serie.titulo.includes(tituloSelecionado))
  .map(serie => serie.titulo);
}
console.log("Exercicios 6.B: ",queroTitulo("The"));

/*Exercicio 7 - Atualizada*/
console.log("Exercicios 7: ",);
function creditosIlluminatis(serie){
  if(isObject(serie)){
    console.log(serie.titulo);
    console.log("Diretores: ");
    console.log(arrayToString(listaDiretores(serie),"\n"));
    console.log("Elenco: ");
    console.log(arrayToString(listaElenco(serie), "\n"));
  }else{
    console.log("Série inválida");
  }
}
function listaDiretores(serie){
  return serie.diretor.sort(criterioDeOrdenacao);
}
function listaElenco(serie){
  return serie.elenco.sort(criterioDeOrdenacao);
}
function criterioDeOrdenacao(serie1, serie2){
   return serie1.pegarUltimoNome().localeCompare(serie2.pegarUltimoNome());
}
console.log(creditosIlluminatis(series[0]));
console.log("-----------------------------------",);
/*Exercicio 8 - Atualizada*/

function easteregg(series){
  return arrayToString(series.find(serie=>serie.elenco.every(elenco => elenco.temAbreviacao())) //.filter retornaria todos os arrays com a condição e nao apenas o primeiro
                .elenco
                .map(elenco=>elenco.match(/ [a-z][.] /gi)[0][1]),"","#");

}
console.log("Exercicio 8(EasterEgg): ",easteregg(series));
