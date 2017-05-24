modulo.controller('PaginaInstrutores',['$scope','$routeParams','instrutorService','aulaService','toastr', function (model,$routeParams,instrutorService,aulaService,toastr){
    model.id = $routeParams.idUrl;
    model.possuiErro = false;

    //ng-class de erros
    model.nomeInstrutorErro = '';
    model.sobrenomeInstrutorErro = '';
    model.idadeInstrutorErro = '';
    model.emailInstrutorErro = '';
    //Funções configuração
    model.limparErrosInstrutor = limparErrosInstrutor;
    model.limparCamposInstrutor = limparCamposInstrutor;
    model.dandoAulaToString = dandoAulaToString;

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

    //Create
    function adicionarInstrutor(instrutor){
        model.limparErrosInstrutor();
        console.log(model.cadastroInstrutor.$error.email);
        if(typeof instrutor === 'undefined'){
            toastr.error('Preencha todos os requisítos obrigatórios!', 'Erro');
            return;
        }
        model.possuiErro = false;
        if(typeof model.cadastroInstrutor.$error.email !=='undefined' || typeof instrutor.email === 'undefined'){
            toastr.error('O e-mail do instrutor está incorreto! Não esqueça de utilizar o \'@\'', 'Erro');
            model.emailInstrutorErro = 'erro';
            model.possuiErro = true;
        }
        if(typeof instrutor.sobrenome !== 'undefined' && instrutor.sobrenome.length >30){
            toastr.error('Sobrenome do instrutor grande demais!', 'Erro');
            model.sobrenomeInstrutorErro = 'erro';
            model.possuiErro = true;
        }
        if(typeof instrutor.nome === 'undefined' || instrutor.nome.length<3 || instrutor.nome.length>20){
            toastr.error('Nome do instrutor inválido!', 'Erro');
            model.nomeInstrutorErro = 'erro';
            model.possuiErro = true;
        }
        if(typeof instrutor.idade === 'undefined' || Number(instrutor.idade)>90){
            toastr.error('Idade do instrutor inválida!', 'Erro');
            model.idadeInstrutorErro = 'erro';
            model.possuiErro = true;
        } 
        if(model.possuiErro){
            return;
        }
        instrutorService.create(instrutor).then(function(response){
            let resposta = response.data;
            model.nomeInstrutorErro = '';
            model.limparCamposInstrutor();
            listInstrutores();
            toastr.success('Instrutor adicionado com sucesso!', 'Sucesso!');
        });
    };
    
    function dandoAulaToString(dandoAula){
        if(dandoAula===true){
            return 'Sim';
        }else{
            return 'Não';
        }
    };       

    //Limpar campos instrutor
    function limparCamposInstrutor(){
        model.instrutor = {};
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