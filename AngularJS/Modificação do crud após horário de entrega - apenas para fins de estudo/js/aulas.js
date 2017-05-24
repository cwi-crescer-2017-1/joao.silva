modulo.controller('PaginaAulas',['$scope','$routeParams','aulaService','toastr', function(model,$routeParams,aulaService,toastr){
    model.id = $routeParams.idUrl;

    model.maxlengthAula = 20;
    model.minlengthAula = 3;

    model.itensComAlteracaoAtiva=[];
    model.aulasAntigas=[];
    model.nomeaula='';
    model.nomeAntigo;

    //ng-show mensagem de erro
    model.showNomeErro='';

    //ng-class para estilos css
    model.nomeAulaErro='';
    model.nomeAlterado='';

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
        if(typeof model.cadastroAula.$error.minlength !=='undefined' || typeof model.cadastroAula.$error.maxlength !=='undefined'){
            model.nomeAulaErro='erro';
            model.showNomeErro=true;
            toastr.error('Nome inválido!', 'Erro');
        }else{
            aulaService.create(nomeAula).then(function(response){
            model.nomeAulaErro='';
            model.showNomeErro=false;
            let resposta = response.data;
            listAulas(); //Atualiza a lista7
            model.limparCampoAula(); //Limpa campo de texto
            toastr.success('Aula adicionada com sucesso!', 'Sucesso!');
            });
        }

    };

    //Altera uma Aula
    function salvarAlteracaoAula(idAula,novoNome) {
        if(novoNome.length<3||novoNome.length>20){
            model.nomeAlterado='erro';
            toastr.error('Novo nome inválido!', 'Erro na alteração');
            return;
        }
        aulaService.update(idAula,novoNome).then(function(response){
            let resposta = response.data;
            model.nomeAlterado='';
            model.cancelarAlteracaoAula(idAula);
            model.limparCampoAula();
            listAulas(); //Atualiza a lista
            toastr.success('Aula alterada com sucesso!', 'Sucesso!');
        }); 
    };           

    //Deleta uma Aula
    function deletarAula(idAula){
        aulaService.delete(idAula).then(function(response){
            let resposta = response.data;
            model.cancelarAlteracaoAula(idAula);
            model.limparCampoAula();
            listAulas();//Atualiza a lista
            toastr.success('Aula deletada com sucesso!', 'Sucesso!');
        });
    };

    //Inicia o processo de alteração/exclusão de uma Aula
    function ativarAlteracaoAula(idAula){
        listAulas();
        aulaService.findById(idAula).then(function(response){
            let aula = response.data;
            model.novoNome =  aula.nome;
            model.nomeAntigo = aula.nome;
            console.log(model.novoNome);
            
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
        model.nomeAlterado='';
        model.novoNome = model.nomeAntigo;
    };
    //Limpa campos de erro
    function limparCampoAula(){
        model.showNomeErro=false;
        model.nomeAulaErro='';
        model.nomeAlterado='';
        model.nomeaula='';
    };   
}]);