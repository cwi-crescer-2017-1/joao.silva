modulo.controller('PaginaInstrutoresUD',['$scope','$routeParams','instrutorService','aulaService','toastr', function (model,$routeParams,instrutorService,aulaService,toastr){
    model.id = $routeParams.idUrl;

    listAulas();
    function listAulas() {
        aulaService.list().then(function(response){
            model.aulas = response.data;
        });
    }

    //update
    model.alteracaoInstrutor={};
    model.alteracaoInstrutorIniciada = false;
    model.cancelarAlteracaoInstrutor = cancelarAlteracaoInstrutor;
    model.iniciarAlteracaoInstrutor = iniciarAlteracaoInstrutor;
    model.salvarAlteracaoInstrutor = salvarAlteracaoInstrutor;
    function salvarAlteracaoInstrutor(instrutorAlterado){ 
        instrutorService.update(instrutorAlterado).then(function(response){
            let resposta = response.data;
            model.limparCamposInstrutor();
            toastr.success('Instrutor alterado com sucesso!', 'Sucesso!');
        });
    };
    function iniciarAlteracaoInstrutor(idInstrutor){
        listAulas();
        instrutorService.findById(idInstrutor).then(function(response){
            let instrutor = response.data;
            model.alteracaoInstrutorIniciada = true;
            model.alteracaoInstrutor = angular.copy(instrutor);
        })
    }
    function cancelarAlteracaoInstrutor(alteracaoInstrutor){
        model.alteracaoInstrutorIniciada = false;
        model.alteracaoInstrutor = {};
    }  

    //delete
    model.idInstrutorDeletado = null;
    model.deletarInstrutor = deletarInstrutor;
    function deletarInstrutor(idInstrutor){
        instrutorService.delete(idInstrutor).then(function(response){
            let resposta = response.data;
            model.limparCamposInstrutor();
            toastr.success('Instrutor deletado com sucesso!', 'Sucesso!');
        });
    };
    function limparCamposInstrutor(){
        model.instrutor = {};
    }
    
    //limpar campos preenchidos
    model.limparCamposInstrutor = limparCamposInstrutor;
    function limparCamposInstrutor(){
        model.alteracaoInstrutor = {};
        model.instrutor = {};
        model.idInstrutorDeletado = null;
        model.alteracaoInstrutorIniciada = false;
    }
}]);
