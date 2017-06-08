modulo.controller('controllerReserva',['$scope','toastr','$location','authService','authConfig','serviceUsuario','servicePacote','serviceFesta','serviceOpcional','serviceCliente','serviceReserva', function(model,toastr,$location,authService,authConfig,serviceUsuario,servicePacote,serviceFesta,serviceOpcional,serviceCliente,serviceReserva){
    model.logout = logout;
    model.gerente = false;
    model.primeiraFase = true;
    model.segundaFaseCadastro = false;
    model.segundaFaseCadastrado = false;
    model.terceiraFase = false;

    model.tempoReservaEmDias = 1;
    model.IdFestaSelecionada = null;
    model.IdPacoteSelecionado = null;
    model.IdOpcionalSelecionado = null;

    if(authService.isntAutenticado()){
        $location.path('/home');   
    }
    if(authService.possuiPermissao('Gerente')){
        model.gerente = true;   
    }

    model.idUsuario = authService.getUsuario().Id;

    model.clienteCadastrado = clienteCadastrado;
    function clienteCadastrado(bool){
        model.segundaFaseCadastro = true;
        model.primeiraFase = false;
    }

    model.cancelarCadastroCliente = cancelarCadastroCliente;
    function cancelarCadastroCliente(){
        model.segundaFaseCadastro = false;
        model.primeiraFase = true;
    }

    model.selecionarCliente = selecionarCliente;
    function selecionarCliente(cliente){
        model.IdclienteSelecionado = cliente.Id;
        model.segundaFaseCadastrado = false;
        model.terceiraFase = true;
    }

    model.cancelarSelecaoCliente = cancelarSelecaoCliente;
    function cancelarSelecaoCliente(){
        model.segundaFaseCadastrado = false;     
        model.primeiraFase = true;
    }

    model.cancelarTodoCadastro = cancelarTodoCadastro;
    function cancelarTodoCadastro(){
        model.terceiraFase = false;
        model.primeiraFase = true;
    }

    model.registrarCliente = registrarCliente;
    function registrarCliente(cliente) {
        if(cliente.cpf.length != 11){
            toastr.error('Campo CPF inválido');
        }else{
            cliente.dataNascimento = FormataDataBD(cliente.dataNascimento);
            serviceCliente.registrar(cliente).then(function(response){
            let resposta =  response.data.dados;
            if(resposta !== null){
                toastr.success('Registrado com sucesso!');
                model.segundaFaseCadastro = false;
                model.terceiraFase = true;
                model.cliente = resposta;
            }else{
                toastr.error(resposta);
            }
        });
        }
    }

    model.festaSelecionada = festaSelecionada;
    function festaSelecionada(festaId){
        model.IdFestaSelecionada = festaId;
    }

    model.pacoteSelecionado = pacoteSelecionado;
    function pacoteSelecionado(pacoteId){
        model.IdPacoteSelecionado = pacoteId;
    }

    model.opcionalSelecionada = opcionalSelecionada;
    function opcionalSelecionada(opcionalId){
        model.IdOpcionalSelecionado = opcionalId;
    }

    model.cadastrarReserva = cadastrarReserva;
    function cadastrarReserva() {
        if(model.IdFestaSelecionada===null){
            toastr.error("Festa ainda não selecionada, tente novamente");
        }else{
            serviceReserva.registrar(model.tempoReservaEmDias,model.IdClienteSelecionado,model.idUsuario,model.IdOpcionalSelecionado,model.IdPacoteSelecionado,model.IdFestaSelecionada).then(function(response){
                 model.resposta = response.data.dados;
                 if(model.resposta!=null){
                    toastr.success('Reserva registrada com sucesso!');
                 }else{
                     toastr.error("Erro na criação da reserva");
                 }
            });
        }
    }


    model.obterClientePorId = obterClientePorId;
    function obterClientePorId(idCliente){
        serviceCliente.obterClientePorId(idCliente).then(function(response){
            model.cliente = response.data.dados;
        });
    }

    model.obterClientePorNome = obterClientePorNome;
    function obterClientePorNome(nome){
        serviceCliente.obterClientePorNome(nome).then(function(response){
            model.clientesNome = response.data.dados;
        });
    }


    model.obterListaCliente = obterListaCliente;
    function obterListaCliente(){
        serviceCliente.obterLista().then(function(response){
            model.clientes = response.data.dados;
        });
    }

    obterListaOpcional();
    obterListaFesta();
    obterListaPacote();

    model.obterListaPacote = obterListaPacote;
    function obterListaPacote(){
        servicePacote.obterLista().then(function(response){
            model.pacotes = response.data.dados;
        });
    }

    model.obterListaFesta = obterListaPacote;
    function obterListaFesta(){
        serviceFesta.obterLista().then(function(response){
            model.festas = response.data.dados;
        });
    }   

    model.obterListaOpcional = obterListaOpcional;
    function obterListaOpcional(){
        serviceOpcional.obterLista().then(function(response){
            model.opcionais = response.data.dados;
        });
    }

    model.gerencia = gerencia;
    function gerencia(){
        $location.path('/gerencia');
    }

    model.irParaAdministrativo = irParaAdministrativo;
    function irParaAdministrativo(){
        $location.path('/administrativo');
    }
    
    model.logout = logout;
    function logout(){
        authService.logout();
        toastr.info('Deslogado');
        $location.path('/home'); 
    }

    function FormataDataBD(data){
        let dd = data.getDate();
        let mm = data.getMonth()+1;
        let yyyy = data.getFullYear();

        if(dd<10) {
            dd='0'+dd;
        } 

        if(mm<10) {
            mm='0'+mm;
        } 

        data = yyyy+'-'+mm+'-'+dd;
        return data;
    }
}]);