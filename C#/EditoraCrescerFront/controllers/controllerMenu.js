modulo.controller('controllerMenu',['$scope','toastr','$location','authService','authConfig','serviceRegistro', function(model,toastr,$location,authService,authConfig,serviceRegistro){
    model.logado = false;
    model.registrando = false;
    model.usuario = {};
    if(authService.isAutenticado()){
        $location.path(authConfig.urlPrivado);
        model.logado = true; 
    }
    model.login = function (usuario) {
        authService.login(usuario)
        .then(
            function (response) {
            toastr.success('Logado com sucesso!');
            model.logado = true;
            model.usuario = {};
            },
            function (response) {
            toastr.error('Erro no Login! Verifique seu usuário e senha');
        });
    };

    model.registrar = registrar;
    function registrar(nome,email,senha){
        serviceRegistro.registrar(nome,email,senha).then(function(response){
            let resposta = response.data.resultado;
            if(resposta){
                toastr.success('Use suas novas credenciais para logar','Usuário criado com sucesso!');
                model.usuario = {};
                cancelarRegistro();
            }else{
                toastr.error('Erro no cadastro! Email ou senha inválidos');
            }           
        })
    }

    model.iniciarRegistro = iniciarRegistro;
    function iniciarRegistro(){
        model.registrando = true;
        model.usuario = {};
    }
    model.cancelarRegistro = cancelarRegistro;
    function cancelarRegistro(){
        model.registrando = false;
        model.usuario = {};
    }
    model.logout = function(){
        authService.logout();
        livroSendoPublicado = null;
        livroSendoRevisado = null;
        toastr.info('Deslogado');
        model.logado = false;
        model.usuario = {};
    }

}]);