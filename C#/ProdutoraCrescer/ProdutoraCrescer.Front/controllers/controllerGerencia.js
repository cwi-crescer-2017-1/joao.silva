modulo.controller('controllerGerencia',['$scope','toastr','$location','authService','authConfig','serviceUsuario', function(model,toastr,$location,authService,authConfig,serviceUsuario){
    model.logado = false;

    if(authService.isAutenticado()){
        $location.path('/adminstrativo');
        model.logado = true;
    }

    model.logout = logout;
    function logout(){
        authService.logout();
        toastr.info('Deslogado');
        model.logado = false;
    }
}]);