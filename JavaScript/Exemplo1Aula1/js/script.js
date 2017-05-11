console.log("Carregou!");
alert("Bem vindo(a)!");
var pi = 3.14;
if(typeof pi !=="undefined"){
  console.log(pi);
}
function somaSemReturn(a,b){

}
if(typeof somaSemReturn(1,2) === "undefined"){
  console.log("tipo void, só que undefined");
}
var somar = function(a,b){
  return a + b;
}
console.log(somar(1,2));
var somarArrowFunction = (a,b) => a+b;
console.log(somarArrowFunction(1,2));

var somarPreFeito = function(a,b,c=3){
  console.log("c",c)
  return a+b;
}
var somarPreFeitoModaAntiga = function(a,b,c){
  c = c || 3; //Se c não tiver valor ele dará o valor de 3
  console.log("c Moda Antiga",c)
  return a+b;
}
console.log(somarPreFeito(1,2));
console.log(somarPreFeitoModaAntiga(1,2));
var somarComArgumentosInternos = function(){
  var a= arguments[0], b=arguments[1];
  return a+b;
}
console.log("Função Somar com argumentos dentro da função: "+somarComArgumentosInternos(1,2));
//NUNCA REATRIBUIR O ISNAN, NUNCA REDEFINIR NADA GLOBAL
console.log("Saber se algo não é um número: " + isNaN(undefined+undefined));
var a = 1;
var b = 2;
var resultado = (function(a,b){
  return a*b;
})(a,b);
console.log("Resultado 1, a=1 e b=2:"+resultado);
a=2;
console.log("Resultado 1, a=2 e b=2:"+resultado);
a=100;
console.log("Resultado 1, a=100 e b=2:"+resultado);
//FOR IN - PROPRIEDADES DO OBJETO
//FOR OF - VALORES DO OBJETO
//ARRAYS SÃO OBJETOS SÓ QUE COM UMA PROPRIEDADE CHAMADA LENGTH QUE CONTA O NÚMERO DE CASAS
//DATAS NO JS SEMPRE COMEÇAM COM 0, POR EXEMPLO JANEIRO NO MONTH É ZERO(0), SEMPRE TERÁ QUE USAR TRATAMENTO PARA DATAS 
