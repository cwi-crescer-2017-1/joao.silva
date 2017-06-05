modulo.controller('PaginaCRUD',['$scope','$routeParams','servicesLivros','toastr','$location','authService','authConfig', function(model,$routeParams,servicesLivros,toastr,$location,authService,authConfig){ 

    livroSendoPublicado = null;
    livroSendoRevisado = null;

    model.usuarioRevisor = false;
    model.usuarioPublicador = false;

    model.permissoes = [];
    if(!authService.isAutenticado()){
        $location.path(authConfig.urlLogout);
    }else{
        let permissoes = authService.getUsuario().Permissoes;
        model.permissoes = permissoes;
        model.permissoes.forEach(function(permissao){
            if(permissao.Nome === "Administrador"){
                model.usuarioRevisor = true; 
                model.usuarioPublicador = true; 
            } 
            if(permissao.Nome === "Revisor"){ 
                model.usuarioRevisor = true; 
            }else if(permissao.Nome === "Publicador"){
                model.usuarioPublicador = true;  
            } 
        });
    }
    model.revisar = revisar;
    function revisar(livro){
        livroSendoRevisado = livro; 
        $location.path('/revisarLivro');
    }
    
    model.publicar = publicar;
    function publicar(livro){
        livroSendoPublicado = livro; 
        $location.path('/publicarLivro');
    }

    model.naoRevisado = naoRevisado;
    function naoRevisado(DataRevisao){
        if(DataRevisao===null){
            return true;
        }
        return false;
    }

    model.naoPublicado = naoPublicado;
    function naoPublicado(DataPublicacao){
        if(DataPublicacao===null){
            return true;
        }
        return false;
    }

    model.naoPublicadoERevisado = naoPublicadoERevisado;
    function naoPublicadoERevisado(DataPublicacao,DataRevisao){
        if(DataPublicacao===null && DataRevisao!==null){
            return true;
        }
        return false;
    }

    model.finalDeSemana = finalDeSemana;
    function finalDeSemana(){
        let today = new Date();
        let day = today.getDay();
        if(day===0||day===6){
            return true;
        }
        return false;
    }

    //Variaveis de controle da página de livros
    var paginacao = {
        skip : 0,
        quantidade: 12
    }
    //Funções compatilhadas
    model.proximaPaginaDeLivros = proximaPaginaDeLivros;
    model.paginaAnteriorDeLivros = paginaAnteriorDeLivros;
    model.irParaPaginaX = irParaPaginaX;

    //Listar livros
    listXLivrosAPartirDoUltimoEnviado();
    function listXLivrosAPartirDoUltimoEnviado() {
        servicesLivros.listLimitadaCompleta(paginacao.quantidade,paginacao.skip).then(function(response){
            model.livros = response.data.dados.livros;
        });
    }

    function proximaPaginaDeLivros(){
        if(model.livros.length>=paginacao.quantidade){
            paginacao.skip = paginacao.skip+paginacao.quantidade;
            listXLivrosAPartirDoUltimoEnviado();
        }        
    }
    function paginaAnteriorDeLivros(){
        if(paginacao.skip>=paginacao.quantidade){
            paginacao.skip = paginacao.skip-paginacao.quantidade;
            listXLivrosAPartirDoUltimoEnviado();
        }
    }
    function irParaPaginaX(){
        paginacao.skip = (paginaX-1)*paginacao.quantidade;
        listXLivrosAPartirDoUltimoEnviado();     
    }
}]);