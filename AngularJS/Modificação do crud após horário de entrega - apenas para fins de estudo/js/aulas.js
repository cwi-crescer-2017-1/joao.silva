modulo.controller('PaginaAulas',['$scope','$filter', function (model,filter){
    let idNovaAula=4;
    model.itensComAlteracaoAtiva=[];
    model.aulasAntigas=[];
    model.adicionarAula =function(nomeaula){
        model.nomeAulaErro='';
        if(model.validaNomeAula(nomeaula)){
            let novaAula={id:idNovaAula,nome:nomeaula};
            idNovaAula++;
            model.aulas.push(novaAula);
            model.nomeAulaErro='';
            alert('Aula criada com sucesso');
            model.nomeaula = ''; //Zerar campo de texto após criação da nova aula
        }
    };
    model.validaNomeAula = function(nome){
        if(typeof nome === 'undefined'){
            alert('Nome inválido! Tente outro.');
            model.nomeAulaErro='erro';
            return false;
        }
        if(nome.length<3||nome.length>20){
            alert('Nome inválido! Tente outro.');
            model.nomeAulaErro='erro';
            return false;
        }
        for(aula of model.aulas){
            if(aula.nome.toLowerCase() === nome.toLowerCase()){
                alert('Aula já cadastrada! Tente outra.');
                model.nomeAulaErro='erro';
                return false;
            }
        }
        model.nomeAulaErro='';
        return true;
    }
    model.pegarIndexAulaPorID = function(idAula){
        for(let i=0;i<model.aulas.length;i++){
            if(model.aulas[i].id===idAula){
                return i; 
            }
        }
    }
    model.encontrarIndexItemComAlteracaoAulaAtivada = function (idAula){
      if(typeof model.itensComAlteracaoAtiva !== 'undefined'){
        for(let i=0; i<model.itensComAlteracaoAtiva.length;i++){
            if(model.itensComAlteracaoAtiva[i] === idAula){
                return i;
            }
            }
       }
    };
    model.ativarAlteracaoAula = function(idAula){
        model.nomeAulaErro='';
        model.itensComAlteracaoAtiva.push(idAula);
    };
    model.alterandoAula = function(idAula){
        estaAlterando = typeof model.encontrarIndexItemComAlteracaoAulaAtivada(idAula) !== 'undefined';
        return estaAlterando;
    }
    model.cancelarAlteracaoAula = function(idAula){
        model.nomeAulaErro='';
        index = model.encontrarIndexItemComAlteracaoAulaAtivada(idAula);
        model.itensComAlteracaoAtiva.splice(index,1);
    }
    model.salvarAlteracaoAula = function(idAula,novoNome){
        model.nomeAulaErro='';
        let index = model.pegarIndexAulaPorID(idAula);
        console.log(model.aulas[index]);
        if(model.validaNomeAula(novoNome)){
            model.aulas[index].nome = novoNome;
            model.cancelarAlteracaoAula(idAula);
            alert('Alteração realizada com sucesso!');
        }
    }
    model.deletarAula = function(idAula){
        let index = model.pegarIndexAulaPorID(idAula);
        let nomeAula;
        if(model.aulaNaoUtilizada(idAula)){
            nomeAula = model.aulas[index].nome;
            model.aulas.splice(index,1);
            alert(`Aula ${nomeAula} deletada com sucesso`);
        }
    }
    model.aulaNaoUtilizada = function(idAula){
        let index = model.pegarIndexAulaPorID(idAula);
        for(let i=0;i<model.instrutores.length;i++){ //Percorre todos os intrutores
            for(let x=0;x<model.instrutores[i].aula.length;x++){//Percorre todas as aulas de cada instrutor
                if(model.aulas[index].id===model.instrutores[i].aula[x]){
                    model.nomeAulaErro='erro';
                    alert('Aula atrelada a um instrutor, impossível deletar');
                    return false;
                }
            }
        }
        return true;
    }
    model.limparCampoAula = function(){
        model.nomeAulaErro='';
        model.nomeaula='';
    }    
}]);