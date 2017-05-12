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
  return typeof a ==="number" && a%2!==0 && virotia();
}
var vitoria = function(){return "Love me"} ;
var derrota = function(){return "Love me not"};

console.log("Resultado:", daisyGame(5));

/*Exercício 2*/

var textos = ["Oi,","tudo","bem","?"];
function oMaior(a){
   return isObject(a)===true && maior(a);
}
var maior =  function(textos){
  var maior = 0;
  var oMaior = "";
  for(var texto of textos){
    if ( texto.length > maior ) {
       maior = texto.length;
       oMaior = texto;
    }
  }
  return oMaior;
}
console.log("Maior: ", oMaior(textos));

/*Exercício 3*/

function imprime(instrutores, funcao){
    for(var instrutor of instrutores){
      if(isFunction(funcao)){funcao(instrutor)}
    }
}
var instrutor = (function (instrutor){
    console.log("olá querido instrutor:", instrutor);
})
var instrutores = ["bernardo","nunes","fabrício","ben-hur","carlos"];
imprime(instrutores, instrutor);

/*Exercício 4*/
function soma(a){
	function somaInterna(b){
		return a + b;
	}
	return somaInterna;
}
console.log("Soma (3)(4)", soma(3)(4));

/*Exercicio 5*/

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
console.log("FiboSum: ", fiboSum(7));


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
function ordenarAscendente(meusCafes){
  var resultado;
  for(var i=0;i<meusCafes.length;i++){
    for(var x=i;x<meusCafes.length;x++){
      var valorMenorEncontrado = meusCafes[x]<meusCafes[i];
      if(valorMenorEncontrado){
          var temp = meusCafes[i];
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
