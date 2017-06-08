modulo.controller('controllerGerencia',['$scope','toastr','$location','authService','authConfig','serviceUsuario','serviceReserva', function(model,toastr,$location,authService,authConfig,serviceUsuario,serviceReserva){
    model.reservas = {};
    if(authService.isntAutenticado()){
        $location.path('/home');
    }
    if(authService.naoPossuiPermissao('Gerente')){
        $location.path('/adminstrativo'); 
    }

    model.menuAdministrativo = menuAdministrativo;
    function menuAdministrativo(){
        $location.path('/adminstrativo');  
    }

    model.logout = logout;
    function logout(){
        authService.logout();
        toastr.info('Deslogado');
        $location.path('/home'); 
    }

    model.relatorioMensal = relatorioMensal;
    relatorioMensal(today());
    function relatorioMensal(data) {
        if(typeof data !== "undefined"){
            dataFinal = FormataDataBD(data);
            serviceReserva.ObterRelatorioLocacaoMensal(dataFinal).then(function(response){
            model.reservas = response.data.dados.resposta.Reservas;
            model.ValorRelatorio = response.data.dados.resposta.Valor;
            });
        }else{
            toastr.error("Data inválida");
        }
    }

    model.Devolvido = Devolvido;
    function Devolvido(devolvido){
        if(typeof devolvido === "undefined" || devolvido === null || devolvido === false){
            return "Não";
        }else{
            return "Sim";
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

    function today(){
        return new Date();
    }

    function FormataDataBD(data){
        let dd = data.getDate();
        let mm = data.getMonth()+1;
        let yyyy = data.getFullYear();

        if(dd<10) {
            dd='0'+dd
        } 

        if(mm<10) {
            mm='0'+mm
        } 

        data = yyyy+'-'+mm+'-'+dd;
        return data;
    }

}]);