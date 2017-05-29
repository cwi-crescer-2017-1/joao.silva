var modulo = angular.module('ChatAPI', ['ngRoute']); 
modulo.config(function ($routeProvider) {  
  $routeProvider 
    .when('/paginaLogin', { 
      controller: 'PaginaLogin', 
      templateUrl: 'html/login.html' 
    }) 
    .when('/paginaChat', { 
      controller: 'PaginaChat', 
      templateUrl: 'html/chat.html' 
    }) 
    .when('/paginaRegistro',{
      controller: 'PaginaLogin', 
      templateUrl: 'html/registro.html' 
    })
    .otherwise({redirectTo: '/paginaRegistro'}); 
}); 
var usuarioLogado = {nome:"",id:0,imgUrl:"",nomeDeUsuario:""};