modulo.controller('controllerReserva',['$scope','toastr','$location','authService','authConfig','serviceUsuario','servicePacote','serviceFesta','serviceOpcional','serviceCliente','serviceReserva', function(model,toastr,$location,authService,authConfig,serviceUsuario,servicePacote,serviceFesta,serviceOpcional,serviceCliente,serviceReserva){
    model.logout = logout;
    model.gerente = false;
    model.primeiraFase = true;
    model.segundaFaseCadastro = false;
    model.segundaFaseCadastrado = false;
    model.terceiraFase = false;

    model.tempoReservaEmDias;
    model.IdFestaSelecionada = null;
    model.IdPacoteSelecionado = null;
    model.IdOpcionalSelecionado = null;
    model.cliente = null;

    if(authService.isntAutenticado()){
        $location.path('/home');   
    }
    if(authService.possuiPermissao('Gerente')){
        model.gerente = true;   
    }

    model.idUsuario = authService.getUsuario().Id;

    model.clienteCadastrado = clienteCadastrado;
    function clienteCadastrado(bool){
        if(bool){
            model.segundaFaseCadastrado = true;
            model.primeiraFase = false;
        }else{
            model.segundaFaseCadastro = true;
            model.primeiraFase = false;
        }
    }

    model.mostrarBotao = mostrarBotao;
    function mostrarBotao(cliente){
        if(typeof cliente === "undefined" || cliente === null){
            return false;
        }
        return true;
    }
    model.cancelarCadastroCliente = cancelarCadastroCliente;
    function cancelarCadastroCliente(){
        model.segundaFaseCadastro = false;
        model.primeiraFase = true;
    }

    model.selecionarCliente = selecionarCliente;
    function selecionarCliente(cliente){
        model.cliente = cliente;
        model.segundaFaseCadastrado = false;
        model.terceiraFase = true;
    }

    model.cancelarSelecaoCliente = cancelarSelecaoCliente;
    function cancelarSelecaoCliente(){
        model.segundaFaseCadastrado = false;     
        model.primeiraFase = true;
    }

    model.cancelarTodoCadastro = finalizarTodoCadastro;
    function finalizarTodoCadastro(){
        model.terceiraFase = false;
        model.primeiraFase = true;
    }

    model.registrarCliente = registrarCliente;
    function registrarCliente(cliente) {
        if(typeof cliente.cpfNumber !== "undefined" && cliente.cpfNumber !== null){
            cliente.cpf = cliente.cpfNumber.toString();
            if(cliente.cpf.length !== 11){
                toastr.error('Campo CPF inválido');
            }else if(cliente.dataNascimentoJS === null){
                toastr.error('Data de Nascimento inválida');
            }else if(typeof cliente.nome === "undefined" || cliente.Nome === null){
                toastr.error('Nome inválido');
            }else if(typeof cliente.endereco === "undefined"|| cliente.endereco === null){
                toastr.error('Endereço inválido');
            }else if(typeof cliente.email === "undefined" || cliente.email === null){
                toastr.error('Email inválido');
            }else if(typeof model.genero === "undefined" || model.genero === null){
                toastr.error('Gênero inválido');
            }else{                
                let dataNascimento = FormataDataBD(cliente.dataNascimentoJS);
                serviceCliente.registrar(cliente.nome,cliente.endereco,cliente.cpf,model.genero,dataNascimento,cliente.email).then(function(response){
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
        }else{
            toastr.error('Campo CPF inválido');
        }
    }

    model.definirSexo = definirSexo;
    function definirSexo(sexo){
        model.genero = sexo;
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
    function cadastrarReserva(tempoReservaEmDias) {
        if(typeof model.IdFestaSelecionada ==="undefined" || model.IdFestaSelecionada===null){
            toastr.error("Festa ainda não selecionada, tente novamente");
        }else if(typeof model.IdPacoteSelecionado ==="undefined" || model.IdPacoteSelecionado===null){
            toastr.error("Pacote ainda não selecionado, tente novamente");
        }else if(typeof tempoReservaEmDias === "undefined" || tempoReservaEmDias===null || tempoReservaEmDias<=0){
            toastr.error("Tempo de reserva inválido");
        }else{
            console.log(model.IdOpcionalSelecionado);
                 serviceReserva.registrar(tempoReservaEmDias,model.cliente.Id,model.idUsuario,model.IdOpcionalSelecionado,model.IdPacoteSelecionado,model.IdFestaSelecionada).then(function(response){
                 model.resposta = response.data.dados;
                 if(model.resposta!=null){
                    toastr.success('Reserva registrada com sucesso!');
                    finalizarTodoCadastro();
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
            model.pacotes = response.data.dados.pacotes;
        });
    }

    model.obterListaFesta = obterListaPacote;
    function obterListaFesta(){
        serviceFesta.obterLista().then(function(response){
            model.festas = response.data.dados.festas;
        });
    }   

    model.obterListaOpcional = obterListaOpcional;
    function obterListaOpcional(){
        serviceOpcional.obterLista().then(function(response){
            model.opcionais = response.data.dados.opcionais;
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

    model.irParaGerencia = irParaGerencia;
    function irParaGerencia(){
        $location.path('/gerencia');
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