modulo.controller('PaginaInstrutores',['$scope','instrutorService','aulaService', function (model,instrutorService,aulaService){

    model.alteracaoInstrutor;
    model.alteracaoInstrutorIniciada = false;

    model.limpaErrosInstrutor = limpaErrosInstrutor;
    model.cancelarAlteracaoInstrutor = cancelarAlteracaoInstrutor;
    model.iniciarAlteracaoInstrutor = iniciarAlteracaoInstrutor;
    model.stringAulas = stringAulas;
    model.dandoAulaToString = dandoAulaToString;
    model.limparInscricaoInstrutor = limparInscricaoInstrutor;
    model.limparCampoAula = limparCampoAula;
    //Lista os instrutores
    model.instrutores = listInstrutores();
    function listInstrutores(){
        return instrutorService.list();
    }
    
    //Lista as aulas
    model.aulas = listAulas();
    function listAulas() {
        return aulaService.list();
    }
    /*
    function listInstrutores() {
        instrutorService.list().then(function (response) {
        console.log(response.data);
        alert('tchauinstrutor');
        model.aulas = response.data;
      });
    }
    */
    //Funções de click
    model.adicionarInstrutor = adicionarInstrutor;
    model.salvarAlteracaoInstrutor = salvarAlteracaoInstrutor;
    model.deletarInstrutor = deletarInstrutor;

    function adicionarInstrutor(instrutor){
        resposta = instrutorService.create(instrutor);
        if(resposta===false){
            alert('Falha ao adicionar instrutor');
        }else{
            model.limparCampoAula();
            alert('Instrutor adicionado com sucesso');
        }
    }

    /*
    function adicionarInstrutor(instrutor){
        instrutorService.create(instrutor).then(function (response){
            if(response.data===false){
                alert('Falha ao adicionar instrutor');
            }else{
                model.limparCampoAula();
                alert('Instrutor adicionado com sucesso');
            }
        });
    };
    */
    function salvarAlteracaoInstrutor(alteracaoInstrutor){
        resposta = instrutorService.update(alteracaoInstrutor);
        if(resposta===false){
            alert('Falha ao salvar alterações no instrutor');
        }else{
            model.alteracaoInstrutorIniciada = false;
            model.limparCampoAula();
            alert('Instrutor alterado com sucesso');
        }
    }
    /*
    function salvarAlteracaoInstrutor(alteracaoInstrutor){
        instrutorService.update(alteracaoInstrutor).then(function (response){
            if(response.data===false){
                alert('Falha ao salvar alterações no instrutor');
            }else{
                model.limparCampoAula();
                alert('Instrutor alterado com sucesso');
            }
        });
    };
    */
    function deletarInstrutor(idInstrutor){
        resposta = instrutorService.delete(idInstrutor);
        if(resposta===false){
            alert('Falha ao deletar instrutor');
        }else{
            model.limparCampoAula();
            alert('Instrutor deletado com sucesso');
        }
    }
    /*
    function deletarInstrutor(idInstrutor){
        instrutorService.delete(idInstrutor).than(function (response){
            if(response.data===false){
                alert('Falha ao deletar instrutor');
            }else{
                model.limparCampoAula();
                alert('Instrutor deletado com sucesso');
            }
        });
    };
    */
    function dandoAulaToString(dandoAula){
        if(dandoAula===true){
            return 'Sim';
        }else{
            return 'Não';
        }
    };      
    function stringAulas(aulasId){
        if(typeof aulasId!=='undefined'){
            let aulasNomes=[];
            for(let i=0;i<aulasId.length;i++){
                aulasNomes.push(aulaService.findById(aulasId[i]).nome);
            };
            return aulasNomes.join(', ');
        };   
    };  
    function iniciarAlteracaoInstrutor(idInstrutor){
        let instrutoresA = instrutorService.list();
            for(instrutor of instrutoresA){
                if(instrutor.id===idInstrutor){
                    model.alteracaoInstrutorIniciada = true;
                    model.alteracaoInstrutor = angular.copy(instrutor);
                    model.exnome=instrutor.nome;
                    model.exemail=instrutor.email;
                    model.idInstrutorASerAlteradoErro='';
                    return;
                }
            }
            model.idInstrutorASerAlteradoErro='erro';
            alert('ID inválido ou não encontrado! Tente outro');
    }
    /*
    function iniciarAlteracaoInstrutor(idInstrutor){
        instrutorService.list().then(function(response){
            let instrutores = response.data;
            for(instrutor of instrutores){
                if(instrutor.id===idInstrutor){
                    model.alteracaoInstrutorIniciada = true;
                    model.alteracaoInstrutor = angular.copy(instrutor);
                    model.exnome=instrutor.nome;
                    model.exemail=instrutor.email;
                    model.idInstrutorASerAlteradoErro='';
                    return;
                }
            }
            model.idInstrutorASerAlteradoErro='erro';
            alert('ID inválido ou não encontrado! Tente outro');
        })
    }
    */
    function cancelarAlteracaoInstrutor(alteracaoInstrutor){
        model.alteracaoInstrutorIniciada = false;
        model.alteracaoInstrutor = {};
    }   
    function limpaErrosInstrutor(){
        model.campoInválido='';
        model.nomeInstrutorErro='';
        model.sobrenomeInstrutorErro='';
        model.idadeInstrutorErro='';
        model.emailInstrutorErro='';
        model.urlFotoInstrutorErro='';
        model.idInstrutorASerAlteradoErro='';
        model.idNomeASerDeletadoErro='';
    }
    function limparCampoAula(){
        model.alteracaoInstrutor = {};
    }
    function limparInscricaoInstrutor(){
        model.limpaErrosInstrutor();
    }
}]);