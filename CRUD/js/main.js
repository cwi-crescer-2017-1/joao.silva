var modulo = angular.module('CRUD',[]);
var oi;
modulo.controller('Crescer',['$scope','$filter', function (model,filter){
    let idNovaAula=4;
    let idNovoInstrutor=4;
    model.aulas = [{id:0,nome:'Tester'},
                   {id:1,nome:'Heroísmo'},
                   {id:2,nome:'Poções'},
                   {id:3,nome:'Defesa contra as artes das trevas'}];
    model.instrutores = [{id:0,nome:'Teste',sobrenome:'Tester',idade:'22',email:'teste@tester.com.br',dandoAula:true,aula:[0],urlFoto:'img/perfil_padrao.jpg'},
                         {id:1,nome:'Saitama',sobrenome:'',idade:'26',email:'opm@heroassociation.jp',dandoAula:false,aula:[],urlFoto:'img/perfil_padrao.jpg'},
                         {id:2,nome:'Toshinori',sobrenome:'Yagi',idade:'36',email:'yagi@gmail.jp',dandoAula:true,aula:[1],urlFoto:'img/perfil_padrao.jpg'},
                         {id:3,nome:'Severus',sobrenome:'Snape',idade:'38',email:'severus@discipline.uk',dandoAula:true,aula:[2,3],urlFoto:'img/perfil_padrao.jpg'}];
    model.itensComAlteracaoAtiva=[];
    model.adicionarAula =function(nomeaula){
        let novaAula={id:idNovaAula,nome:nomeaula};
        idNovaAula++;
        model.aulas.push(novaAula);
    };
    model.stringAulas = function(aulasId){
        let aulasNomes=[];
        for(let i=0;i<aulasId.length;i++){
            aulasNomes.push(model.pegarNomeAulaPorId(aulasId[i]));
        }
        aulasNomes = filter('orderBy')(aulasNomes, '');
        return aulasNomes.join(", ");
    };
    model.dandoAulaToString = function(dandoAula){
        if(dandoAula===true){
            return "Sim";
        }else{
            return "Não";
        }
    };        
    model.adicionarInstrutor = function(instrutor){
        let instrutorDandoAula;
        for(let i=0;i<instrutor.aulas.length;i++){
            instrutor.aulas[i]=Number(instrutor.aulas[i]);
        }
        if(instrutor.dandoAula==='s'){instrutorDandoAula=true}else{instrutorDandoAula=false};
        let novoInstrutor = {id:idNovoInstrutor,nome: instrutor.nome,sobrenome:instrutor.sobrenome,idade:instrutor.idade,email:instrutor.email,dandoAula:instrutorDandoAula,aula:instrutor.aulas,urlFoto:instrutor.urlFoto};
        model.instrutores.push(novoInstrutor);
        idNovoInstrutor++;
    };
     model.pegarNomeAulaPorId = function(idAula){
        for(aula of model.aulas){
            if(aula.id===idAula){ 
                return aula.nome;
            }
        } 
    };
    model.verificarExistenciaNomeInstrutor = function(nome){
        for(instrutor of model.instrutores){
            if(instrutor.nome.toLowerCase() === nome.toLowerCase()){
                return true;
            }
        }
        return false;
    }
    model.verificarExistenciaNomeAula = function(nome){
        for(aula of model.aulas){
            if(aula.nome.toLowerCase() === nome.toLowerCase()){
                return true;
            }
        }
        return false;
    }
    //Módulo Alterar Nome
    model.encontrarIndexItemComAlteracaoAtivada = function (idAula){
      for(let i=0; i<model.itensComAlteracaoAtiva.length;i++){
          if(model.itensComAlteracaoAtiva[i] === idAula){
             return i;
           }
        }
    };
    model.ativarAlteracao = function(idAula){
        model.itensComAlteracaoAtiva.push(idAula);
    };
    model.alterando = function(idAula){
        estaAlterando = typeof model.encontrarIndexItemComAlteracaoAtivada(idAula) !== 'undefined';
        return estaAlterando;
    }
    model.cancelarAlteracao =  function(idAula){
        index = model.encontrarIndexItemComAlteracaoAtivada(idAula);
        model.itensComAlteracaoAtiva.splice(index,1);
    }
    model.salvarAlteracao = function(idAula,novoNome){
        if(model.verificarExistenciaNomeAula(novoNome)){
            alert("Nome já adicionado! Tente outro.");
            return false;
        }
        model.aulas[idAula].nome = novoNome;
        model.cancelarAlteracao(idAula);
        alert("Alteração realizada com sucesso!");
    }
}]);