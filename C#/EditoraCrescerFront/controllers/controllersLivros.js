modulo.controller('PaginaInicial',['$scope','$routeParams','servicesLivros','toastr','$location', function(model,$routeParams,servicesLivros,toastr,$location){ 
    model.nomeAntigo;
    
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
        servicesLivros.listLimitada(paginacao.quantidade,paginacao.skip).then(function(response){
            model.livros = response.data.dados;
        });
    }
    listLancamentos();
    function listLancamentos(){
        servicesLivros.listLancamentos().then(function(response){
            model.lancamentos = response.data.dados;
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