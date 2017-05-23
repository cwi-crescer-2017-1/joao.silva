modulo.controller('PaginaAulas',['$scope','$routeParams','aulaService', function(model,$routeParams,aulaService){
    
    model.id = $routeParams.idUrl;

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

    function adicionarAula(nomeAula) {
        let resposta = aulaService.create(nomeAula);
        if(resposta===false){
            alert('Falha ao adicionar aula');
        }else{
            model.limparCampoAula();
            alert('Aula adicionada com sucesso');
        }
    };
    // function salvarAlteracaoAula(idAula,novoNome){
    //     let resposta = aulaService.update(idAula,novoNome);
    //     if(resposta===false){
    //         alert('A alteração falhou');
    //     }else{
    //         model.cancelarAlteracaoAula(idAula);
    //         model.limparCampoAula();
    //         alert('A alteração foi um sucesso');
    //     }
    // }
    
    function salvarAlteracaoAula(idAula,novoNome) {
        resposta = aulaService.update(idAula,novoNome);
        if(resposta===false){
            alert('A alteração falhou');
        }else{
            model.cancelarAlteracaoAula(idAula);
            model.limparCampoAula();
            alert('A alteração foi um sucesso');
            listAulas();
        }            
    };   

    function deletarAula(idAula){
        resposta = aulaService.delete(idAula);
        if(resposta===false){
            alert('Falha ao deletar aula');
        }else{
            alert('Aula deletada com sucesso');
        }
    }
    /*
    function deletarAula(idAula){
        aulaService.delete(idAula).then(function (response){
            if(response.data===false){
                alert('Falha ao deletar aula');
            }else{
                alert('Aula deletada com sucesso');
            }
        });
    }
    */
    function encontrarIndexItemComAlteracaoAulaAtivada(idAula){
      if(typeof model.itensComAlteracaoAtiva !== 'undefined'){
        for(let i=0; i<model.itensComAlteracaoAtiva.length;i++){
            if(model.itensComAlteracaoAtiva[i] === idAula){
                return i;
            }
        }
      }
    };
    function ativarAlteracaoAula(idAula){
        model.limparCampoAula();
        model.itensComAlteracaoAtiva.push(idAula);
    };
    function alterandoAula(idAula){
        estaAlterando = typeof model.encontrarIndexItemComAlteracaoAulaAtivada(idAula) !== 'undefined';
        return estaAlterando;
    }
    function cancelarAlteracaoAula(idAula){
        model.limparCampoAula();
        index = model.encontrarIndexItemComAlteracaoAulaAtivada(idAula);
        model.itensComAlteracaoAtiva.splice(index,1);
    }
    function limparCampoAula(){
        model.nomeAulaErro='';
        model.nomeaula='';
    }    
}]);