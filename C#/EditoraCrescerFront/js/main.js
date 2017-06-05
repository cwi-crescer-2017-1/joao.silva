var modulo = angular.module('EditoraCWI', ['ngRoute','auth','toastr']);  //Adicionar dependencia do 'auth' e opcional do ngStorage
var livroSendoRevisado = null;
var livroSendoPublicado = null;

modulo.config(function ($routeProvider) {  
  $routeProvider 
    .when('/paginaInicial', { 
      controller: 'PaginaInicial', //ControllerLivros
      templateUrl: '../html/paginaInicialLivros.html' 
    })  
    .when('/adminstrativo',{
      controller: 'PaginaCRUD', //ControllerUsuario
      templateUrl: '../html/crudLivros.html',
      resolve: {
        autenticado: function (authService) {
          return authService.isAutenticadoPromise();
        }
      }
    })
    .when('/revisarLivro',{
      controller: 'PaginaRevisao',
      templateUrl: '../html/revisar.html',
      resolve: {
        autenticado: function (authService) {
          return authService.isAutenticadoPromise();
        }
      }
    })
    .when('/publicarLivro',{
      controller: 'PaginaPublicacao',
      templateUrl: '../html/publicar.html',
      resolve:{
        autenticado: function (authService) {
          return authService.isAutenticadoPromise();
        }
      }
    })
    .otherwise({redirectTo: '/paginaInicial'}); 
}); 


// Configurações utilizadas pelo módulo de autenticação (authService)
modulo.constant('authConfig', {

    // Obrigatória - URL da API que retorna o usuário
    //urlUsuario: 'http://10.99.3.24/AutDemo.WebApi/api/acessos/usuario',
    urlUsuario: 'http://localhost:60184/api/usuarios',

    // Obrigatória - URL da aplicação que possui o formulário de login
    urlLogin: '/paginaInicial',

    // Opcional - URL da aplicação para onde será redirecionado (se for informado) após o LOGIN com sucesso
    urlPrivado: '/adminstrativo',

    // Opcional - URL da aplicação para onde será redirecionado (se for informado) após o LOGOUT
    urlLogout: '/paginaInicial'
});

