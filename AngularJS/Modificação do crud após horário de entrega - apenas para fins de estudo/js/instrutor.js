modulo.controller('PaginaInstrutores',['$scope','$routeParams','instrutorService','aulaService','toastr', function (model,$routeParams,instrutorService,aulaService,toastr){
    model.id = $routeParams.idUrl;

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

    model.nomeInstrutorErro = '';
    //Create
    function adicionarInstrutor(instrutor){
        let tamanhoNome = instrutor.nome.length;
        if(tamanhoNome<3 || tamanhoNome>20){
            toastr.error('Nome do instrutor inválido!', 'Erro');
            model.nomeInstrutorErro = 'erro';
        }
        instrutorService.create(instrutor).then(function(response){
            let resposta = response.data;
            model.nomeInstrutorErro = '';
            model.limparCamposInstrutor();
            listInstrutores();
            toastr.success('Instrutor adicionado com sucesso!', 'Sucesso!');
        });
    };

    model.dandoAulaToString = dandoAulaToString;
    function dandoAulaToString(dandoAula){
        if(dandoAula===true){
            return 'Sim';
        }else{
            return 'Não';
        }
    };       

    //Limpar campos instrutor
    model.limparCamposInstrutor = limparCamposInstrutor;
    function limparCamposInstrutor(){
        model.nomeInstrutorErro = '';
        model.instrutor = {};
    }
}]);