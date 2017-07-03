modulo.controller('controllerHome',['$scope','toastr','$location','authService','servicePostagem', function(model,toastr,$location,authService,servicePostagem){
    model.perfilCorrente = authService.getUsuario().perfil;
    model.nomeCorrente = model.perfilCorrente.nome;
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
    model.getPostagens = function(){
        servicePostagem.getPage(pagina,tamanhoPagina)
        .then(
            function (response) {
            console.log(response.data);
            },
            function (response) {
            toastr.error('Erro ao carregar as postagens');
        });
    }
    model.getPostagens();
}]);