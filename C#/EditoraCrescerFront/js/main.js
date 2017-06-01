var modulo = angular.module('EditoraCWI', ['ngRoute','toastr']); 
modulo.config(function ($routeProvider) {  
  $routeProvider 
    .when('/paginaInicial', { 
      controller: 'PaginaInicial', 
      templateUrl: '../html/paginaInicialLivros.html' 
    }) 
    .otherwise({redirectTo: '/paginaInicial'}); 
}); 