modulo.controller('PaginaInstrutores',['$scope','$routeParams','instrutorService','aulaService', function (model,$routeParams,instrutorService,aulaService){
    model.id = $routeParams.idUrl;
    
    model.alteracaoInstrutor={};
    model.alteracaoInstrutorIniciada = false;
    model.limpaErrosInstrutor = limpaErrosInstrutor;
    model.cancelarAlteracaoInstrutor = cancelarAlteracaoInstrutor;
    model.iniciarAlteracaoInstrutor = iniciarAlteracaoInstrutor;
    model.dandoAulaToString = dandoAulaToString;
    model.limparCamposInstrutor = limparCamposInstrutor;

    //Lista os instrutores
    listInstrutores();
    function listInstrutores() { 
        instrutorService.list().then(function(response){
        model.instrutores = response.data;
      });
    }
    listAulas();
    function listAulas() {
        aulaService.list().then(function(response){
            model.aulas = response.data;
        });
    }
    //Funções de click
    model.adicionarInstrutor = adicionarInstrutor;
    model.salvarAlteracaoInstrutor = salvarAlteracaoInstrutor;
    model.deletarInstrutor = deletarInstrutor;

    //Create
    function adicionarInstrutor(instrutor){
        instrutorService.create(instrutor).then(function(response){
            let resposta = response.data;
            model.limparCamposInstrutor();
            listInstrutores();
            alert('Instrutor adicionado com sucesso');
        });
    };

    //update
    function salvarAlteracaoInstrutor(instrutorAlterado){ 
        instrutorService.update(instrutorAlterado).then(function(response){
            let resposta = response.data;
            model.limparCamposInstrutor();
            listInstrutores();
            alert('Instrutor alterado com sucesso');
        });
    };
    
    //delete
    function deletarInstrutor(idInstrutor){
        instrutorService.delete(idInstrutor).then(function(response){
            let resposta = response.data;
            model.limparCamposInstrutor();
            listInstrutores();
            alert('Instrutor deletado com sucesso');
        });
    };


    function dandoAulaToString(dandoAula){
        if(dandoAula===true){
            return 'Sim';
        }else{
            return 'Não';
        }
    };      
   
    function iniciarAlteracaoInstrutor(idInstrutor){
        instrutorService.findById(idInstrutor).then(function(response){
            let instrutor = response.data;
            model.alteracaoInstrutorIniciada = true;
            model.alteracaoInstrutor = angular.copy(instrutor);
            model.idInstrutorASerAlteradoErro='';
        })
    }
    
    function cancelarAlteracaoInstrutor(alteracaoInstrutor){
        model.alteracaoInstrutorIniciada = false;
        model.alteracaoInstrutor = {};
    }   

    function limpaErrosInstrutor(){
        model.nomeInstrutorErro='';
        model.sobrenomeInstrutorErro='';
        model.idadeInstrutorErro='';
        model.emailInstrutorErro='';
        model.urlFotoInstrutorErro='';
        model.idInstrutorASerAlteradoErro='';
        model.idNomeASerDeletadoErro='';
    }
    function limparCamposInstrutor(){
        model.alteracaoInstrutor = {};
        model.instrutor = {};
        model.alteracaoInstrutorIniciada = false;
    }
}]);