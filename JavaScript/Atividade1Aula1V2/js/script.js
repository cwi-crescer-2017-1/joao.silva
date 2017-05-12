function isObject(a){
    return typeof a === "object" && true;
}
function isNumber(a){
    return typeof a === "number" && true;
}
function isFunction(a){
   return typeof a === "function" && true;
}

/*Exercício 1*/
function daisyGame(a) {
  return typeof a ==="number" && ((a%2===0 && derrota()) || (a%2!==0 && vitoria()));
}
var vitoria = function(){return "Love me"} ;
var derrota = function(){return "Love me not"};

console.log("Resultado:", daisyGame(5));
console.log("Resultado:", daisyGame(2));

/*Versão alternativa*/
function daisyGameA(numero){return `Love me${ numero % 2 !== 0 ? '' : ' not'}`}
console.log("Resultado A:",daisyGameA(1));
console.log("Resultado A:",daisyGameA(4));

/*Exercício 2*/

var textos = ["Oi,","tudo","bem","?"];
function oMaior(a){
   return isObject(a)===true && maior(a);
}
var maior =  function(textos){
  var maior = 0;
  var oMaior = "";
  for(var texto of textos){
    var isBigger = texto.length > maior;
    if (isBigger) {
       maior = texto.length;
       oMaior = texto;
    }
  }
  return oMaior;
}
console.log("Maior: ", oMaior(textos));

/*Exercício 3*/
function imprime(instrutores, funcao){ return isObject(instrutores) && isFunction(funcao) && imprimeReal(instrutores,funcao) }
function imprimeReal(instrutores, funcao){
    for(var instrutor of instrutores){
      if(isFunction(funcao)){funcao(instrutor)}
    }
}
var instrutor = (function (instrutor){
    console.log("olá querido instrutor:", instrutor);
})
var instrutores = ["bernardo","nunes","fabrício","ben-hur","carlos"];
imprime(instrutores, instrutor);

/*Versão Alternativa*/
function imprime(textos,funcao){
  isObject(textos) && textos.forEach(funcao)
}
imprime(instrutores,function(instrutor){console.log('olá querido instrutor:',instrutor)});

/*Exercício 4*/
function soma(number){
	return function somaInterna(numberInterno){
		return isNumber(number) && isNumber(numberInterno) && number + numberInterno;
	}
}
console.log("Soma (3)(4)", soma(3)(4));

/*Versão Alternativa*/
console.log("Soma (7)(4)", function soma(number){return function somaInterna(numberInterno){ return isNumber(number) && isNumber(numberInterno) && number + numberInterno}}(7)(4))

/*Exercício 5*/

function fiboSum(x){
	var a=0;
	var b=1;
	var soma = 1;
	for(var i=1; i<x; i++){
		b=b+a;
		a=b-a;
		soma+=b;
	}
	return soma;
}
console.log("FiboSum(7): ", fiboSum(7));

/*Alternativa - I fato de ser recursiva simples sem tratamentos torna ela mais lenta*/
function fibonacci(n){
    if(n===1 || n===2) return 1; //  IF SEM {} SÓ EXECUTA UMA INSTRUÇÃO
    return fibonacci(n-1)+fibonacci(n-2);
}
function fibonacciSum(n){
  if(n===1){
    return 1;
  }
  return fibonacci(n)+fibonacciSum(n-1);
}
console.log("FiboSum Alternativa(7): ", fibonacciSum(7));

/*Exercicio 6*/

function queroCafe(mascada, precos){
  if(isNumber(mascada) && isObject(precos)){
    return queroCafeReal(mascada, precos);
  }
}
function queroCafeReal(mascada, precos){
  var meusCafes=[];
  var cont=0;
  for(var i=0;i<precos.length;i++){
    if(precos[i]<mascada){
      meusCafes[cont]=precos[i];
      cont++;
    }
  }
  return ordenarAscendente(meusCafes);
}
function ordenarAscendente(meusCafes){ // let = é um var só que tem seu escopo limitado a seu bloco, o var sempre tem seu escopo na função inteira e é sempre declarada acima de função, porém não lhe um valor
  let resultado;
  for(let i=0;i<meusCafes.length;i++){
    for(let x=i;x<meusCafes.length;x++){
      let valorMenorEncontrado = meusCafes[x]<meusCafes[i];
      if(valorMenorEncontrado){
          let temp = meusCafes[i];
          meusCafes[i]=meusCafes[x];
          meusCafes[x]=temp;
      }
    }
    if(i==0){
      resultado = meusCafes[i];
    }else{
      resultado = resultado + "," + meusCafes[i];
    }
  }
  return resultado;
}
console.log("Cafés: ", queroCafe(3.14, [ 5.16, 2.12, 1.15, 3.11, 17.5 ]));

/*Alternativo*/
function queroCafeAlternativo(mascada,precos){
  let meusCafes=[];
  return precos
    .filter((a)=>a<=mascada)
    .sort((a,b)=>a-b)
    .join(",")
      /*return precos
      .filter(function(a){
        return a<= mascada;
      })
      .sort(function(a,b)){
        return a-b;
      })
      .join(',')
      */
}
console.log("Cafés (Alternativo): ", queroCafeAlternativo(3.14, [ 5.16, 2.12, 1.15, 3.11, 17.5 ]));

/*Testes*/
function oi(){
  console.log("Aqui já funciona ", i);
  var i=100;
  return tchau();
  function tchau(){
     console.log("Aqui ainda funciona", i);
     return "teste";
  }
}
console.log("Teste: ", oi());

/*const no js protege apenas a referencia do objeto e não seus valores*/
/*Const tem um valor explicativo, informando para um programador os valores que não devem ser mudados, mesmo isso sendo possivel*/

var teste = {nome:"Teste",motivo : "teste"};
console.log("Tem nome igual a = ", teste.nome);
delete teste.nome;
console.log("Não tem mais nome : ", teste.nome);

/*Slice*/
var texto = "olá mundo";
console.log("Texto: ",texto);
console.log("Casa 0 do texto: ", texto[0]);
console.log("Pegando o l do texto: ", texto.slice(1,2));
var textoCortado = texto.slice(0,3)+texto.slice(4,9);
console.log("Texto cortado, cortei o espaço", textoCortado);

/*Split*/
var nomeSplit = "Joao Pedro";
var arrayNome = nomeSplit.split(""); // --> passa a string para array
console.log("Passando String para Array(object): ",arrayNome);
console.log("Primeira letra do nome que virou array: ",arrayNome[0]);
var stringNomeAgain = arrayNome.join(""); //--> passa o array para string denovo, o valor passado para o join é o critério de junção
console.log("Passando Array para String(string): ",stringNomeAgain);
