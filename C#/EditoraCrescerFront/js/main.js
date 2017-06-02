var modulo = angular.module('EditoraCWI', ['ngRoute','toastr']);  //Adicionar dependencia do 'auth' e opcional do ngStorage
modulo.config(function ($routeProvider) {  
  $routeProvider 
    .when('/paginaInicial', { 
      controller: 'PaginaInicial', 
      templateUrl: '../html/paginaInicialLivros.html' 
    })  
    /*resolve:{
      autenticado: function(authService){
        return authService.isAutenticadoPromisse();
      }
    }*/
    .otherwise({redirectTo: '/paginaInicial'}); 
}); 