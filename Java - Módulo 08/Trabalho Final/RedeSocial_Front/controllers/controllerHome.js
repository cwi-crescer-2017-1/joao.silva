modulo.controller('controllerHome',['$scope','toastr','$location','authService','servicePostagem','servicePerfil', function(model,toastr,$location,authService,servicePostagem,servicePerfil){
    model.perfilCorrente = authService.getUsuario().perfil;
    model.nomeCorrente = model.perfilCorrente.nome;
    model.verComentarios = false;
    model.verComentarioClick = 0;
    model.mostrarPesquisa = false;
    let mensagemComentarioMostrar = "Mostrar comentários   .";
    let mensagemComentarioEsconder = "Esconder comentários";
    model.botaoComentario = mensagemComentarioMostrar;
    model.pesquisaUsuario = "";

    let pagina = 0;
    let tamanhoPagina = 5;
    let nomeConfig = function(){
        let nome = model.perfilCorrente.nome;
        if(nome.length>16){
             let excesso = nome.length-16;
             model.nomeCorrente = nome.substr(0,(nome.length-excesso));
             model.nomeCorrente = model.nomeCorrente.concat("...");
        }
    }
    nomeConfig();
    model.pesquisar = function(){
        if(typeof model.pesquisaUsuario !== "undefined" && typeof model.pesquisaUsuario !== "null" && model.pesquisaUsuario.replace(/\s{2,}/g, ' ') !== ""){
        servicePerfil.getFilterByName(model.pesquisaUsuario).then(
                    function (response) {
                        model.perfisPesquisados = response.data;
                        if(model.perfisPesquisados.length===0){
                            toastr.info('Nenhum perfil encontrado!');
                        }else{
                            model.mostrarPesquisa = true;
                            console.log(model.perfisPesquisados);
                        }
                    },
                    function (response) {
                        toastr.error('Erro ao pesquisar por usuários!');
                    });
        }else{
            toastr.warning('Necessário inserir nome para pesquisa!');
        }
    }
    model.retirarPesquisa = function(){
        model.mostrarPesquisa = false;
    }
    model.registrarPostagem = function (){
        if(typeof model.postagemNova.texto.length === "undefined" || typeof model.postagemNova.texto.length === "null" ||model.postagemNova.texto.length<0){
            toastr.error('Texto da postagem obrigatório!');
        }else{
            servicePostagem.registrar(model.postagemNova.fotoUrl,model.postagemNova.texto,model.perfilCorrente).then(
                function (response) {
                    $location.path('/home');
                    toastr.success('Postagem realizada!');
                    location.reload();
                },
                function (response) {
                toastr.error('Erro inesperado durante a postagem!');
            });
        }
    }
    model.isEmpty = function (variavel){
        if(typeof variavel === "undefined" || variavel === null){
            return true;
        }else if(typeof variavel === 'string'){
            return variavel.replace(" ","") === "";
        }
        return false;
    }
    model.ativarDesativaComentarios = function(){
        if(model.verComentarioClick === 0){
            model.verComentarios = true;
            model.verComentarioClick = 1;
            model.botaoComentario = mensagemComentarioEsconder;
        }else{
            model.verComentarios = false;
            model.verComentarioClick = 0;
            model.botaoComentario = mensagemComentarioMostrar;
        }
 
    }
    model.getPostagens = function(){
        servicePostagem.getPage(pagina,tamanhoPagina)
        .then(
            function (response) {
            model.postagens = response.data.content;
                    console.log(model.postagens);
            },
            function (response) {
            toastr.error('Erro ao carregar as postagens');
        });
    }
    model.calculoData = function(data){
        var date1 = (new Date(data-388000));
        var date2 = new Date();
        var timeDiff = Math.abs(date2.getTime() - date1.getTime());
        var diffDays = Math.ceil(timeDiff / (1000 * 3600 * 24)); 
        if((timeDiff/(1000 * 3600 * 24)<60)){
            return 'Há menos de uma hora atrás';
        }
        return 'Há '+diffDays+' horas atrás.';
    }
    model.getPostagens();
}]);
