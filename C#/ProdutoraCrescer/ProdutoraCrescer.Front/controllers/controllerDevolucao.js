modulo.controller('controllerDevolucao',['$scope','toastr','$location','authService','authConfig','serviceReserva', function(model,toastr,$location,authService,authConfig,serviceReserva){
    model.reservas = [];
    model.logout = logout;
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

    model.irParaAdministrativo = irParaAdministrativo;
    function irParaAdministrativo(){
        $location.path('/adminstrativo');
    }

    model.irParaGerencia = irParaGerencia;
    function irParaGerencia(){
        $location.path('/gerencia');
    }

    model.irParaDevolverItem = irParaDevolverItem;
    function irParaDevolverItem(idReserva){
        console.log(idReserva)
    }
    obterListaNaoDevolvidos();
    function obterListaNaoDevolvidos() {
        serviceReserva.ObterRelatorioAtrasos().then(function(response){
            model.reservas = response.data.dados;
        });
    }

    model.FormataData = FormataDataUsuario;
    function FormataDataUsuario(dataString){
        if(typeof dataString === "string"){
            var regex = /-/gi;
            dataString = dataString.substring(0,10);
            dataString = dataString.replace(regex, '/');
            return dataString; 
        }
        return "NaN";
    }

    model.Devolvido = Devolvido;
    function Devolvido(devolvido){
        if(typeof devolvido === "undefined" || devolvido === null || devolvido === false){
            return "Não";
        }else{
            return "Sim";
        }
    }
}]);