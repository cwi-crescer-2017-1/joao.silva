modulo.controller('controllerMenu',['$scope','toastr','$location','authService','authConfig','serviceUsuario','serviceCliente','serviceFesta','serviceOpcional','servicePacote','serviceReserva','$interval', function(model,toastr,$location,authService,authConfig,serviceUsuario,serviceCliente,serviceFesta,serviceOpcional,servicePacote,serviceReserva,$interval){
    model.atrasos = [];
    model.logout = logout;
    model.gerente = false;

    if(authService.isntAutenticado()){
        $location.path('/home');   
    }
    if(authService.possuiPermissao('Gerente')){
        model.gerente = true;   
    }
    let atualizarHoras = $interval(atualizaHoras, 1000);

    model.atualizaHoras = atualizaHoras;
    function atualizaHoras(){
        let data = new Date();
        let horario = data.toTimeString().split(' ')[0];    
        model.horario = horario;
    }

    model.gerencia = gerencia;

    function gerencia(){
        $location.path('/gerencia');
    }

    model.irParaDevolucao = irParaDevolucao;
    function irParaDevolucao(){
        $location.path('/devolucao');
    }

    model.irParaReserva = irParaReserva;
    function irParaReserva(){
        $location.path('/reserva');
    }

    model.logout = logout;
    function logout(){
        authService.logout();
        toastr.info('Deslogado');
        $location.path('/home'); 
    }

    model.FormataDataUsuario = FormataDataUsuario;
    function FormataDataUsuario(dataString){
        if(typeof dataString === "string"){
            var regex = /-/gi;
            dataString = dataString.substring(0,10);
            dataString = dataString.replace(regex, '/');
            return dataString; 
        }
        return "NaN";
    }

    relatorioAtrasos();
    function relatorioAtrasos() {
        serviceReserva.ObterRelatorioAtrasos().then(function(response){
            model.atrasos = response.data.dados;
        });
    }
}]);