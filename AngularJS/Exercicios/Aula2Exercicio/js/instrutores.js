var modulo = angular.module('InstrutoresAPP',[]);
modulo.controller('instrutores',['$scope', function (model){
    model.instrutores =[{ nome: 'Pedro (PHP)', aula: [{numero: 3,nome: 'HTML e CSS'}]},
    {nome: 'Zanatta',aula: [{numero: 5,nome: 'AngularJS'}]},
    {nome: 'Bernardo',aula: [{numero: 1,nome: 'OO'},{numero: 4,nome: 'Javascript'}]},
    {nome: 'Nunes',aula: [{numero: 2,nome: 'Banco de Dados I'}]}];
    model.aulas = extrairArrayAulas(model.instrutores);
    modulo.extrairArrayAulas = extrairArrayAulas;
    function extrairArrayAulas(instrutores){
            let arrayAulas=[];
            instrutores.forEach(instrutor=> {
                instrutor.aula.forEach(aula=>{
                    arrayAulas.push({nome: aula.nome, numero: aula.numero, instrutor: instrutor.nome});
                });
            });
            return arrayAulas; 
    }
}])
/*Exercicio 02*/
modulo.filter('mascada',function(){
    return function(nome){
        return nome.replace(/(nunes)/ig,'$ $1 $'); //retorna os caractesres $ $ ao lado do nome nunes caso ele possua esse nome, /i = ignore case
    }
});
/*Exercicio 03*/
modulo.filter('numeroAula', function(){
    return function(aula){
        let numero = aula.numero.toString();//grava o número em uma String
        while(numero.length<3) numero= `0${numero}`;//Para concatenar com zeros até o número possuir 3 digitos
        return `${numero} - ${aula.nome.toUpperCase()}`; //Envia a concatenação do numero e da aula com nome em letras maiusculas
    }
})
   