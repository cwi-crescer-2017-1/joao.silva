var modulo = angular.module('ProdutoraCrescer', ['ngRoute','auth','toastr']);  

modulo.config(function ($routeProvider) {  
  $routeProvider 
    .when('/home', { 
      controller: 'controllerLogin',
      templateUrl: '../html/login.html' 
    })  
    .when('/adminstrativo',{
      controller: 'controllerMenu',
      templateUrl: '../html/menu.html',
      resolve: {
        autenticado: function (authService) {
          return authService.isAutenticadoPromise();
        }
      }
    })
    .when('/gerencia',{
      controller: 'controllerGerencia',
      templateUrl: '../html/gerencia.html',
      resolve: {
        autenticado: function (authService) {
          return authService.isAutenticadoPromise();
        }
      }
    })
    .when('/reserva',{
      controller: 'controllerReserva',
      templateUrl: '../html/reserva.html',
      resolve:{
        autenticado: function (authService) {
          return authService.isAutenticadoPromise();
        }
      }
    })
    .otherwise({redirectTo: '/home'}); 
}); 


// Configurações utilizadas pelo módulo de autenticação (authService)
modulo.constant('authConfig', {

    // Obrigatória - URL da API que retorna o usuário
    //urlUsuario: 'http://10.99.3.24/AutDemo.WebApi/api/acessos/usuario',
    urlUsuario: 'http://localhost:61689/api/usuario',

    // Obrigatória - URL da aplicação que possui o formulário de login
    urlLogin: '/home',

    // Opcional - URL da aplicação para onde será redirecionado (se for informado) após o LOGIN com sucesso
    urlPrivado: '/adminstrativo',

    // Opcional - URL da aplicação para onde será redirecionado (se for informado) após o LOGOUT
    urlLogout: '/home'
});

