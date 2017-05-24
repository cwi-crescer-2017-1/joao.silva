modulo.controller('PaginaInstrutoresUD',['$scope','$routeParams','instrutorService','aulaService','toastr', function (model,$routeParams,instrutorService,aulaService,toastr){
    model.id = $routeParams.idUrl;

    model.possuiErro = false;

    listAulas();
    function listAulas() {
        aulaService.list().then(function(response){
            model.aulas = response.data;
        });
    }

    //Erros
    model.nomeInstrutorErro = '';
    model.sobrenomeInstrutorErro = '';
    model.idadeInstrutorErro = '';
    model.emailInstrutorErro = '';

    //Update (estado e valores)
    model.alteracaoInstrutor={};
    model.alteracaoInstrutorIniciada = false;

    //Funções de configurações e internas
    model.cancelarAlteracaoInstrutor = cancelarAlteracaoInstrutor;
    model.iniciarAlteracaoInstrutor = iniciarAlteracaoInstrutor;
    model.salvarAlteracaoInstrutor = salvarAlteracaoInstrutor;
    model.deletarInstrutor = deletarInstrutor;
    model.limparCamposInstrutor = limparCamposInstrutor;
    model.limparErrosInstrutor = limparErrosInstrutor;

    //Update
    function salvarAlteracaoInstrutor(instrutorAlterado){ 
        model.limparErrosInstrutor();
        if(typeof instrutorAlterado === 'undefined'){
            toastr.error('Preencha todos os requisítos obrigatórios!', 'Erro');
            return;
        }
        model.possuiErro = false;
        if(typeof model.modificacaoInstrutor.$error.email !=='undefined' || typeof instrutorAlterado.email === 'undefined'){
            toastr.error('O e-mail do instrutor está incorreto! Não esqueça de utilizar o \'@\'', 'Erro');
            model.emailInstrutorErro = 'erro';
            model.possuiErro = true;
        }
        if(typeof instrutorAlterado.sobrenome !== 'undefined' && instrutorAlterado.sobrenome.length >30){
            toastr.error('Sobrenome do instrutor grande demais!', 'Erro');
            model.sobrenomeInstrutorErro = 'erro';
            model.possuiErro = true;
        }
        if(typeof instrutorAlterado.nome === 'undefined' || instrutorAlterado.nome.length<3 || instrutorAlterado.nome.length>20){
            toastr.error('Nome do instrutor inválido!', 'Erro');
            model.nomeInstrutorErro = 'erro';
            model.possuiErro = true;
        }
        if(typeof instrutorAlterado.idade === 'undefined' || Number(instrutorAlterado.idade)>90){
            toastr.error('Idade do instrutor inválida!', 'Erro');
            model.idadeInstrutorErro = 'erro';
            model.possuiErro = true;
        }
        if(model.possuiErro){
            return;
        }
        instrutorService.update(instrutorAlterado).then(function(response){
            let resposta = response.data;
            model.limparCamposInstrutor();
            toastr.success('Instrutor alterado com sucesso!', 'Sucesso!');
        });
    };
    function iniciarAlteracaoInstrutor(idInstrutor){
        listAulas();
        if(typeof idInstrutor === 'undefined' || idInstrutor === null){
            toastr.error('Formatação do ID inválida!', 'Erro');
            return;
        }
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
    function deletarInstrutor(idInstrutor){
        if(typeof idInstrutor === 'undefined' || idInstrutor === null){
            toastr.error('Formatação do ID inválida!', 'Erro');
            return;
        }
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
    function limparCamposInstrutor(){
        model.alteracaoInstrutor = {};
        model.instrutor = {};
        model.idInstrutorDeletado = null;
        model.alteracaoInstrutorIniciada = false;
        model.limparErrosInstrutor();
    }
    //Limpa erros da página
    function limparErrosInstrutor(){
        model.nomeInstrutorErro = '';
        model.sobrenomeInstrutorErro = '';
        model.idadeInstrutorErro = '';
        model.emailInstrutorErro = '';
    }
}]);
