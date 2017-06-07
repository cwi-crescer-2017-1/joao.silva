modulo.controller('controllerMenu',['$scope','toastr','$location','authService','authConfig','serviceUsuario','serviceCliente','serviceFesta','serviceOpcional','servicePacote','serviceReserva', function(model,toastr,$location,authService,authConfig,serviceUsuario,serviceCliente,serviceFesta,serviceOpcional,servicePacote,serviceReserva){
    model.logout = logout;
    model.atrasos = [];
    function logout(){
        authService.logout();
        livroSendoPublicado = null;
        livroSendoRevisado = null;
        toastr.info('Deslogado');
        model.logado = false;
        model.usuario = {};
    }
    relatorioAtrasos();
    function relatorioAtrasos() {
        serviceReserva.ObterRelatorioAtrasos().then(function(response){
            model.atrasos = response.data.dados;
        });
    }
}]);