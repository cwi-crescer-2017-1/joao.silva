modulo.controller('PaginaPublicacao',['$scope','$routeParams','servicesLivros','toastr','$location','authService','authConfig', function(model,$routeParams,servicesLivros,toastr,$location,authService,authConfig){ 
    model.livroSendoPublicado = livroSendoPublicado;

    model.publicar = publicar;
    function publicar(){
        let isbn = model.livroSendoPublicado.Isbn;
        servicesLivros.publicarLivro(isbn).then(function(response){
            toastr.success('Publicação completa!');
            livroSendoPublicado = null;
            $location.path('/adminstrativo');
        });
    }
    model.revisarNovamente = revisarNovamente;
    function revisarNovamente(){
        let isbn = model.livroSendoPublicado.Isbn;
        servicesLivros.pedirNovaRevisao(isbn).then(function(response){
            toastr.success('Nova revisão solicitada.');
            livroSendoPublicado = null;
            $location.path('/adminstrativo');
        });
    }
    if(!authService.isAutenticado()){
        $location.path(authConfig.urlLogout);
    }else{
        let permissoes = authService.getUsuario().Permissoes;
        let usuarioPublicador = false;
        model.permissoes = permissoes;
        model.permissoes.forEach(function(permissao){
            if(permissao.Nome === "Publicador" || permissao.Nome === "Administrador"){ 
                usuarioPublicador = true; 
            }
        });
        if(!usuarioPublicador){
            $location.path(authConfig.urlPrivado);
        }
    }

}]);