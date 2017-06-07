modulo.controller('controllerLogin',['$scope','toastr','$location','authService', function(model,toastr,$location,authService){
    model.login = login;
    
    if(authService.isAutenticado()){
        $location.path('/adminstrativo');
        logado = true; 
    }
    function login(usuario) {
        if(authService.isAutenticado()){
            $location.path('/adminstrativo');
        }
        authService.login(usuario)
        .then(
            function (response) {
            toastr.success('Logado com sucesso!');
            logado = true;
            model.usuario = {};
            },
            function (response) {
            toastr.error('Erro no Login! Verifique seu usuário e senha');
        });
    };
}]);