var modulo = angular.module('ProdutoraCrescer', ['ngRoute','auth','toastr']);  

modulo.config(function ($routeProvider) {  
  $routeProvider 
    .when('/login', { 
      controller: 'controllerLogin',
      templateUrl: '../html/login.html' 
    })  
    .when('/home', { 
      controller: 'controllerHome',
      templateUrl: '../html/home.html',
      resolve:{
        autenticado: function (authService) {
          return authService.isAutenticadoPromise();
        }
      } 
    })  
    .otherwise({redirectTo: '/home'}); 
}); 

modulo.directive("imgback",function(){
  return function(scope,element,attrs){
    let url = attrs.imgback;
    console.log(url);
    element.css({
      'background-image': 'url(' + url +')',
      'background-size' : '100% 100%'
    });   
  };
});
modulo.directive("required", function() {
  return {
    template: `<p style="color:red;display:inline-block;">*</p>`
  };
}); 

// Configurações utilizadas pelo módulo de autenticação (authService)
modulo.constant('authConfig', {

    // Obrigatória - URL da API que retorna o usuário
    //urlUsuario: 'http://10.99.3.24/AutDemo.WebApi/api/acessos/usuario',
    urlUsuario: 'http://localhost:8080/usuario/get',

    // Obrigatória - URL da aplicação que possui o formulário de login
    urlLogin: '/login',

    // Opcional - URL da aplicação para onde será redirecionado (se for informado) após o LOGIN com sucesso
    urlPrivado: '/home',

    // Opcional - URL da aplicação para onde será redirecionado (se for informado) após o LOGOUT
    urlLogout: '/login'
});

