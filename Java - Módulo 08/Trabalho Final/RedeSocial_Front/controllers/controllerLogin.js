modulo.controller('controllerLogin',['$scope','toastr','$location','authService','serviceEstado','serviceUsuario','servicePerfil', function(model,toastr,$location,authService,serviceEstado,serviceUsuario,servicePerfil){
    if(authService.isAutenticado()){
        $location.path('/home');
    }
    model.login = login;
    model.registrar = registrar;
    model.estados;
    model.registrando = false;
    inicializarCampos();
    function isEmpty(variavel){
        if(typeof variavel === "undefined" || variavel === null){
            return true;
        }else if(typeof variavel === 'string'){
            return variavel.replace(" ","") === "";
        }
        return false;
    }
    model.getEstados = function(){
        serviceEstado.obterLista()
        .then(
            function (response) {
            model.estados = response.data;
            },
            function (response) {
            toastr.error('Erro no carregamento dos estados');
            });
    }
    model.getEstados();
    function login(usuarioLogin) {
        authService.login(usuarioLogin)
        .then(
            function (response) {
                toastr.success('Logado com sucesso!');
                model.usuario = {};
                $location.path('/home');
            },
            function (response) {
                 toastr.error('Erro no Login. Verifique seu usuário e senha');
        });
    };
    function registrar(){
        if(registroValido()){
            serviceUsuario.registrar(model.usuario.username,model.usuario.password).then(
                function (response) {
                    model.usuarioCorrente = response.data;  
                    if(typeof model.usuarioCorrente !== "undefined" && model.usuarioCorrente !== null){
                        servicePerfil.registrar(model.perfil.nome,model.perfil.genero,model.perfil.fotoUrl,model.perfil.dataNascimento,model.perfil.estado)
                        .then(
                            function (response) {
                                model.perfilCorrente = response.data;
                                if(typeof model.perfilCorrente !=="undefined" && model.perfilCorrente !== null){
                                    serviceUsuario.addPerfil(model.usuarioCorrente.id,model.usuario.username,model.usuario.password,model.perfilCorrente)
                                    .then(
                                        function (response) {
                                            model.usuarioCorrente = response.data;
                                            toastr.success('Cadastrado com sucesso!');
                                            let tempEmail = model.usuarioCorrente.username;
                                            inicializarCampos();
                                            model.usuarioLogin.username = tempEmail;
                                            model.registrando = false;
                                        },
                                        function (response) {
                                            toastr.error('Erro ao vincular perfil ao usuário');
                                    });
                                }
                            },
                            function (response) {
                                toastr.error('Erro ao cadastrar perfil');
                        });
                    }
                },
                function (response) {
                    toastr.error('Erro ao cadastrar usuário');
            });
        }
    }
    function registroValido(){
        inicializaErros();
        let valido = true;
        if(isEmpty(model.usuario.username)){
            toastr.error('Email inválido.'); 
            model.erroEmail = true;
            valido = false;
        }
        if(isEmpty(model.usuario.password)){
            toastr.error('Senha inválida.'); 
            model.erroSenha = true;
            valido=false;
        }else if(isEmpty(model.confirmacaoSenha)){
            toastr.error('Confirmação de senha necessária.'); 
            model.erroConfirmacao = true;
            valido=false;
        }else if(model.confirmacaoSenha!==model.usuario.password){
            toastr.error('Senha e confirmação de senha não correspondem.');
            model.erroEConfirmacao = true;
            valido=false;
        }
        if(isEmpty(model.perfil.nome)){
            toastr.error('Nome incorreto.');
            model.erroNome = true;
            valido=false;
        }
        if(isEmpty(model.perfil.genero)){
            toastr.error('Por favor, selecione um gênero.');
            valido=false;
        }else if(isEmpty(model.perfil.fotoUrl)){
            if(model.perfil.genero==='Masculino'){
                model.perfil.fotoUrl = 'http://media.istockphoto.com/vectors/man-profile-environmental-conservation-and-nature-interface-icon-vector-id531102485';
            }else if(model.perfil.genero==='Feminino'){
                model.perfil.fotoUrl = 'http://www.istockphoto.com/br/vetor/mulher-perfil-a-conserva%C3%A7%C3%A3o-do-ambiente-e-a-natureza-%C3%ADcone-padr%C3%A3o-de-interface-gm531026809-55185752';
            }else{
                model.perfil.fotoUrl = 'http://www.istockphoto.com/br/vetor/homem-perfil-a-conserva%C3%A7%C3%A3o-do-ambiente-e-a-natureza-%C3%ADcone-padr%C3%A3o-de-interface-gm531026807-55185720';
            }
        }
        if(isEmpty(model.perfil.dataNascimento)){
            toastr.error('Insira uma data de nascimento válida');
            model.erroDataNascimento = true;
            valido=false;
        }
        if(isEmpty(model.perfil.estado)){
            toastr.error('Selecione um estado.');
            model.erroEstado = "erro";
            valido=false;
        }
        return valido;
    }
    function inicializarCampos(){
        model.usuario = {};
        model.perfil = {};
        model.usuarioLogin = {};
        model.usuarioLogin.username = '';
        model.usuarioLogin.password = '';
        model.usuario.username = '';
        model.usuario.password = '';
        model.confirmacaoSenha = '';
        model.perfil.nome = '';
        model.perfil.genero = null;
        model.perfil.fotoUrl = '';
        model.perfil.dataNascimento = null;
        model.perfil.estado = null;
        inicializaErros();
    }
    function inicializaErros(){
        model.erroEmailLogin = false;
        model.erroSenhaLogin = false;
        model.erroEmail = false;
        model.erroSenha = false;
        model.erroConfirmacao = false;
        model.erroSenhaEConfirmacao = false;
        model.erroNome = false;
        model.erroFotoUrl = false;
        model.erroDataNascimento = false;
        model.erroEstado = false;
    }
}]);