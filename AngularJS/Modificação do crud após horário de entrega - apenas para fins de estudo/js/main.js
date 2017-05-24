var modulo = angular.module('CRUD', ['ngRoute','toastr']); 
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
    .when('/paginaInstrutoresUD',{
      controller: 'PaginaInstrutoresUD',
      templateUrl: 'html/instrutoresUD.html'
    })
    .otherwise({redirectTo: '/paginaAulas'}); 
}); 