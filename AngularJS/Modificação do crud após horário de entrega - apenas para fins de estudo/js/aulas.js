modulo.controller('PaginaAulas',['$scope','$routeParams','aulaService', function(model,$routeParams,aulaService){
    
    model.id = $routeParams.idUrl;

    model.maxlengthAula = 20;
    model.minlengthAula = 3;

    model.itensComAlteracaoAtiva=[];
    model.aulasAntigas=[];
    model.nomeAulaErro='';
    model.nomeaula='';

    // listar aulas 
    listAulas();
    function listAulas() {
        aulaService.list().then(function(response){
            model.aulas = response.data;
        });
    }

    //Ações de click
    model.adicionarAula = adicionarAula;
    model.salvarAlteracaoAula = salvarAlteracaoAula;
    model.deletarAula = deletarAula;
    
    model.encontrarIndexItemComAlteracaoAulaAtivada = encontrarIndexItemComAlteracaoAulaAtivada;
    model.ativarAlteracaoAula = ativarAlteracaoAula;
    model.alterandoAula = alterandoAula;
    model.cancelarAlteracaoAula = cancelarAlteracaoAula;
    model.limparCampoAula = limparCampoAula;

    //Adiciona nova Aula
    function adicionarAula(nomeAula) {
        console.log('cadastroAula:',model.cadastroAula.$error.minlength.length);
        aulaService.create(nomeAula).then(function(response){
            let resposta = response.data;
            listAulas(); //Atualiza a lista
            alert('Aula adicionada com sucesso');
        });
    };

    //Altera uma Aula
    function salvarAlteracaoAula(idAula,novoNome) {
        aulaService.update(idAula,novoNome).then(function(response){
            let resposta = response.data;
            model.cancelarAlteracaoAula(idAula);
            model.limparCampoAula();
            listAulas(); //Atualiza a lista
            alert('A alteração foi um sucesso');
        }); 
    };           

    //Deleta uma Aula
    function deletarAula(idAula){
        aulaService.delete(idAula).then(function(response){
            let resposta = response.data;
            model.cancelarAlteracaoAula(idAula);
            model.limparCampoAula();
            listAulas();//Atualiza a lista
            alert('Aula deletada com sucesso :)');
        });
    };

    //Inicia o processo de alteração/exclusão de uma Aula
    function ativarAlteracaoAula(idAula){
        model.limparCampoAula();
        aulaService.findById(idAula).then(function(response){
            let aula = response.data;
            model.novoNome =  aula.nome;
        })
        model.itensComAlteracaoAtiva.push(idAula);
    };

    //Verifica se a aula está sendo alterada
    function alterandoAula(idAula){
        estaAlterando = typeof model.encontrarIndexItemComAlteracaoAulaAtivada(idAula) !== 'undefined';
        return estaAlterando;
    };

    //Encontra um item que esteja sendo alterado pelo ID
    function encontrarIndexItemComAlteracaoAulaAtivada(idAula){
      if(typeof model.itensComAlteracaoAtiva !== 'undefined'){
        for(let i=0; i<model.itensComAlteracaoAtiva.length;i++){
            if(model.itensComAlteracaoAtiva[i] === idAula){
                return i;
            }
        }
      }
    };

    //Finaliza o processo de alteração de aula
    function cancelarAlteracaoAula(idAula){
        model.limparCampoAula();
        index = model.encontrarIndexItemComAlteracaoAulaAtivada(idAula);
        model.itensComAlteracaoAtiva.splice(index,1);
    };
    //Limpa campos de erro
    function limparCampoAula(){
        model.nomeAulaErro='';
        model.nomeaula='';
    };   
}]);