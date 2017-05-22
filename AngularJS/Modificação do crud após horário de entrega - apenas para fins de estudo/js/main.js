var modulo = angular.module('CRUD', ['ngRoute']); 
modulo.config(function ($routeProvider) {  
  $routeProvider 
    .when('/paginaAulas', { 
      controller: 'PaginaAulas', 
      templateUrl: 'html/aulas.html' 
    }) 
    .when('/paginaInstrutores', { 
      controller: 'PaginaInstrutores', 
      templateUrl: 'html/instrutores.html' 
    }) 
    .otherwise({redirectTo: '/paginaAulas'}); 
}); 

modulo.controller('PrincipalController',['$scope','$filter', function (model,filter){
    model.aulas = [{id:0,nome:'Tester'},
                   {id:1,nome:'Heroísmo'},
                   {id:2,nome:'Poções'},
                   {id:3,nome:'Defesa contra as artes das trevas'}];
    model.pegarNomeAulaPorId = function(idAula){
        for(aula of model.aulas){
            if(aula.id===idAula){ 
                return aula.nome;
            }
        } 
    };               
}]); 