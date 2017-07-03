modulo.controller('controllerHome',['$scope','toastr','$location','authService','servicePostagem', function(model,toastr,$location,authService,servicePostagem){
    model.perfilCorrente = authService.getUsuario().perfil;
    model.nomeCorrente = model.perfilCorrente.nome;
    model.verComentarios = false;
    model.verComentarioClick = 0;
    model.botaoComentario = "Mostrar comentários";
    let pagina = 1;
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
            model.botaoComentario = "Esconder comentários";
        }else{
            model.verComentarios = false;
            model.verComentarioClick = 0;
            model.botaoComentario = "Mostrar comentários";
        }
 
    }
    model.getPostagens = function(){
        servicePostagem.getPage(pagina,tamanhoPagina)
        .then(
            function (response) {
            model.postagens = response.data.content;
            },
            function (response) {
            toastr.error('Erro ao carregar as postagens');
        });
    }
    model.getPostagens();
}]);
