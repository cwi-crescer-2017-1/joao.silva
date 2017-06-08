modulo.controller('controllerMenu',['$scope','toastr','$location','authService','authConfig','serviceUsuario','serviceCliente','serviceFesta','serviceOpcional','servicePacote','serviceReserva', function(model,toastr,$location,authService,authConfig,serviceUsuario,serviceCliente,serviceFesta,serviceOpcional,servicePacote,serviceReserva){
    model.logout = logout;
    model.atrasos = [];
    model.gerente = false;

    if(authService.isntAutenticado()){
        $location.path('/home');   
    }
    if(authService.possuiPermissao('Gerente')){
        model.gerente = true;   
    }

    model.gerencia = gerencia;

    function gerencia(){
        $location.path('/gerencia');
    }

    model.logout = logout;
    function logout(){
        authService.logout();
        toastr.info('Deslogado');
        $location.path('/home'); 
    }

    relatorioAtrasos();
    function relatorioAtrasos() {
        serviceReserva.ObterRelatorioAtrasos().then(function(response){
            model.atrasos = response.data.dados;
        });
    }
}]);