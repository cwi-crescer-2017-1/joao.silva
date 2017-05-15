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
function arrayToString(array,criterio){ /*Transforma um array em uma String conforme critério solicitado*/
  return array.join(criterio);
}
function PropNotUndefined(object, prop){ /*Verifica se a propriedade não está undefined*/
  return typeof object[prop] !== "undefined" && true;
}
function PropNotNull(object, prop){ /*Verifica se a propriedade não é igual a null*/
  return object[prop] !== null && true;
}
var genero = "genero";
var numeroEpisodios = "numeroEpisodios";
var elenco = "elenco";
var diretor = "diretor";
var titulo = "titulo";
/*Exercício 1*/

//delete series[0].distribuidora; //Ativar para verificar a validação de series sem alguma propriedade necessária

function seriesInvalidas(series){
  return  isObject(series) && arrayToString(percorreSeries(series), " - ");
  //Valida se a variavel series é um objeto e se for realiza a validação das series e em seguida converte os
  //titulos das séries inválidas para apenas uma string
  function percorreSeries(series){
    let seriesInvalidas = [];
    let serieInvalida;
    for(let x = 0; x<series.length; x++){
      serieInvalida = validaSerie(series[x]);
      if(serieInvalida){
        seriesInvalidas.push(series[x].titulo);
      }
    }
   return seriesInvalidas;
  }
  function validaSerie(serie){
    let anoAtual = new Date().getFullYear();
    if(Object.values(serie).some(c => c===null || typeof c === 'undefined') || serie.anoEstreia>anoAtual){
      return true;
    }
    return false;
  }
}

console.log("Exercicios 1: ",seriesInvalidas(series));

/*Alternativo - Bernardo*/
function seriesInvalidasAlternativa(series){
  let anoAtual = new Date().getFullYear();
  let invalidas = series.filter(serie =>{
    let algumCampoInvalido = Object.values(serie).some(c =>  c===null || typeof c === 'undefined');
    let estreiaInvalida = serie.anoEstreia>anoAtual;
    return algumCampoInvalido || estreiaInvalida;
  });
  return `Séries Inválidas: ${ invalidas.map(s => s.titulo).join(" - ") }`;
  //map, seleciona dentro de um objeto apenas o valor que você precisa, no caso foi extraido apenas o titulo de cada objeto
}
console.log("Exercicios 1 Alternativo: ",seriesInvalidasAlternativa(series));

/*Exercício 2*/

function filtrarSeriesPorAno(series, ano){
    return isObject(series) && isNumber(ano) && filtroDeSeriesPorAno(series, ano);
}

function filtroDeSeriesPorAno(series, ano){
  return series.filter(serie => serie.anoEstreia>ano).map(serie => serie.titulo);
}
console.log("Exercicios 2: ",filtrarSeriesPorAno(series, 2017));

/*Exercicio 3*/
function mediaDeEpisodios(series){
  return isObject(series) && calcularMediaDeEpisodios(series);
}
function calcularMediaDeEpisodios(series){
  somaEpisodios = series.map(function(v){return v.numeroEpisodios}).reduce(function(a,b){return a+b});
  //Map seleciona o campo numeroEpisodios de cada serie e o reduce cria um "SUM" desses valores
  return somaEpisodios = somaEpisodios/series.length;
}
console.log("Exercicios 3: ",mediaDeEpisodios(series));

/*Alternativo - Bernardo*/
function mediaDeEpisodiosAlternativa(series){
  return series.map(v => v.numeroEpisodios).reduce( (a,b) => a+b,0)/series.length;
}
console.log("Exercicios 3 Alternativo: ",mediaDeEpisodiosAlternativa(series));

/*Exercicio 4*/
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
  let mascadaElenco = serie[elenco].length*40000;
  let mascadaDiretoria = serie[diretor].length*100000;
  return isObject(serie) && mascadaElenco+mascadaDiretoria;
}
console.log("Exercicios 5: ");
for(let i=0; i<series.length; i++){
  console.log("Mascada da série",series[i].titulo,"é:",mascadaEmSerie(series[i]));//Testando mascada de todas as séries
}
console.log("----------------------------------------------------------------");
/*Exercicio 6*/
/*A*/
function queroGenero(generoSelecionado) {
  return isString(generoSelecionado) && selecaoPorGenero(generoSelecionado);
}
function selecaoPorGenero(generoSelecionado){
   let selecionados = [];
   for(let serie of series){
        if(temOGenero(serie,generoSelecionado)) selecionados.push(serie.titulo);
   }
   return selecionados;
}
function temOGenero(serie, generoSelecionado){
  for(let generoDaSerie of serie[genero]){
     if(generoDaSerie===generoSelecionado){
       return true;
     }
  }
  return false; //Retorna false quando a série não possue o genero
}
console.log("Exercicios 6.A: ",queroGenero("JavaScript"));
/*B*/
function queroTitulo(tituloSelecionado){
  return isString(tituloSelecionado) && selecaoPorTitulo(tituloSelecionado);
}
function selecaoPorTitulo(tituloSelecionado){
  return series.filter(serie => serie.titulo.toLowerCase === tituloSelecionado.toLowerCase);
  /*elecionados = [];
  for(let serie of series){
    let temOTitulo = serie[titulo].toLowerCase().search(tituloSelecionado.toLowerCase())>=0; //Passa todos para toLowerCasa considerando "Filme === filme"
    if(temOTitulo) selecionados.push(serie.titulo);
  }
  return selecionados;*/
}
console.log("Exercicios 6.B: ",queroTitulo("The"));

/*Exercicio 7*/
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
  let diretores=[];
  for(let diretor of serie.diretor){
    diretores.push(diretor);
  }
  return diretores.sort(sortUltimoNome);
}
function listaElenco(serie){
  let elenco=[];
  for(let ator of serie.elenco){
    elenco.push(ator);
  }
  return elenco.sort(sortUltimoNome);
}
function sortUltimoNome(a,b) {
    let separadorA = a.trim().split(" ");
    let separadorB = b.trim().split(" ");
    let comparadorA = separadorA[separadorA.length-1].toLowerCase();
    let comparadorB = separadorB[separadorB.length-1].toLowerCase();
    return comparadorA < comparadorB ? -1 : comparadorA > comparadorB ? 1 : 0;
};
console.log(creditosIlluminatis(series[8]));
console.log("-----------------------------------",);
/*Exercicio 8*/

function listaElencoNaoOrdenada(serie){
  let elenco=[];

  for(let ator of serie.elenco){
    elenco.push(ator);
  }
  return elenco;
}

function easteregg(series){
  let resposta;
  for(let serie of series){
    resposta = procuradorDeSerieComNomesAbrevidos(listaElencoNaoOrdenada(serie));
    if(resposta.valor === true){
      return "#" + arrayToString(resposta.lista,"");
    }
  }
  return "Nenhuma correspondência foi encontrada";
}
function procuradorDeSerieComNomesAbrevidos(listaElenco){
  let resposta = new Object();
  let lista = [];
  for(let ator of listaElenco){
    if(ator.indexOf(".")>=0){
      resposta.valor = true;
      lista.push(ator.charAt(ator.indexOf(".")-1));
    }else{
      resposta.valor = false;
      lista = [];
      return resposta; //Se algum ator não possuir a abreviação o algoritmo já passa para a proxima serie
    }
  }
  resposta.lista = lista;
  return resposta;
}
console.log("Exercicio 8(EasterEgg): ",easteregg(series));
