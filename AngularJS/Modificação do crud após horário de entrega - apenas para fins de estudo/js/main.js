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