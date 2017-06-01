modulo.controller('PaginaInicial',['$scope','$routeParams','servicesLivros','toastr', function(model,$routeParams,servicesLivros,toastr){ 
    model.livrosLancamentos=[];
    model.dezLivros=[];
    model.nomeAntigo;
    
    //Variaveis de controle da página de livros
    var paginacao = {
        skip : 0,
        quantidade: 5
    }

    //Funções compatilhadas
    model.proximaPaginaDeLivros = proximaPaginaDeLivros;
    model.paginaAnteriorDeLivros = paginaAnteriorDeLivros;
    model.irParaPaginaX = irParaPaginaX;

    //Listar livros
    listXLivrosAPartirDoUltimoEnviado();
    function listXLivrosAPartirDoUltimoEnviado() {
        servicesLivros.listLimitada(paginacao.quantidade,paginacao.skip).then(function(response){
            model.livros = response.data;
        });
    }

    function proximaPaginaDeLivros(){
        paginacao.skip = paginacao.skip+5;
        listXLivrosAPartirDoUltimoEnviado();
    }
    function paginaAnteriorDeLivros(){
        if(skip>5){
            paginacao.skip = paginacao.skip-5;
        }
        listXLivrosAPartirDoUltimoEnviado();
    }
    function irParaPaginaX(){
        paginacao.skip = (paginaX-1)*paginacao.quantidade;
        listXLivrosAPartirDoUltimoEnviado();
    }
}]);