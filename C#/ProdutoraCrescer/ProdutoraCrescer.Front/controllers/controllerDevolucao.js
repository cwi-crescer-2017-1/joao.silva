modulo.controller('controllerDevolucao',['$scope','toastr','$location','authService','authConfig','serviceReserva', function(model,toastr,$location,authService,authConfig,serviceReserva){
    model.reservas = [];
    model.logout = logout;
    model.gerente = false;
    model.devolvendo = false;
    model.classeDevolvendo = "";

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

    model.irParaDevolverItem = devolverItem;
    function devolverItem(reserva){
        model.valorDevolucao = 0;
        model.reservaDevolucao = {};
        serviceReserva.obterValorDevolucao(reserva.Id).then(function(response){
            model.devolvendo = true;
            model.valorDevolucao = response.data.dados.valor;
            model.reservaDevolucao = reserva; 
            model.classeDevolvendo = "telaFundoEscura";
        });
    }

    model.devolver = devolver;
    function devolver(reservaId){
        serviceReserva.Devolver(reservaId).then(function(response){
            let resposta = response.data.dados;
            if(typeof resposta === "object"){
                toastr.success('Item devolvido com sucesso!');
                obterListaNaoDevolvidos();
                fecharTelaDevolucao();
            }else if(typeof resposta === "string"){
                toastr.error(resposta);
                fecharTelaDevolucao();
            }else{
                toastr.error("Erro desconhecido no servidor");
                fecharTelaDevolucao();
            }
            
        });
    }

    model.cancelarDevolucao = fecharTelaDevolucao;
    function fecharTelaDevolucao(){
        model.devolvendo = false;
        model.valorDevolucao = 0;
        model.reservaDevolucao = {};
        model.classeDevolvendo = "";
    }

    obterListaNaoDevolvidos();
    function obterListaNaoDevolvidos() {
        serviceReserva.obterListaNaoDevolvidos().then(function(response){
            model.reservas = response.data.dados.reservas;
        });
    }

    model.MostrarOpcional = MostrarOpcional;
    function MostrarOpcional(OpcionalNome){
        if(typeof OpcionalNome === "undefined" || OpcionalNome === null || OpcionalNome===""|| OpcionalNome===" "){
            return "-";
        }else{
            return OpcionalNome;
        }
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