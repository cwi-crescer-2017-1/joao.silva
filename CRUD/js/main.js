var modulo = angular.module('CRUD',[]);
var oi;
modulo.controller('Crescer',['$scope','$filter', function (model,filter){
    let idNovaAula=4;
    let idNovoInstrutor=4;
    model.aulas = [{},{id:0,nome:'Tester'},
                   {id:1,nome:'Heroísmo'},
                   {id:2,nome:'Poções'},
                   {id:3,nome:'Defesa contra as artes das trevas'}];
    model.instrutores = [{id:0,nome:'Teste',sobrenome:'Tester',idade:'22',email:'teste@tester.com.br',dandoAula:true,aula:[0],urlFoto:'img/perfil_padrao.jpg'},
                         {id:1,nome:'Saitama',sobrenome:'',idade:'26',email:'opm@heroassociation.jp',dandoAula:false,aula:[],urlFoto:'img/perfil_padrao.jpg'},
                         {id:2,nome:'Toshinori',sobrenome:'Yagi',idade:'36',email:'yagi@gmail.jp',dandoAula:true,aula:[1],urlFoto:'img/perfil_padrao.jpg'},
                         {id:3,nome:'Severus',sobrenome:'Snape',idade:'38',email:'severus@discipline.uk',dandoAula:true,aula:[2,3],urlFoto:'img/perfil_padrao.jpg'}];
    model.aulasSelecionadas=[];
    model.adicionarAula =function(nomeaula){
        let novaAula={id:idNovaAula,nome:nomeaula};
        idNovaAula++;
        model.aulas.push(novaAula);
    }
    model.stringAulas = function(aulasId){
        let aulasNomes=[];
        for(let i=0;i<aulasId.length;i++){
            aulasNomes.push(model.pegarNomeAulaPorId(aulasId[i]));
        }
        aulasNomes = filter('orderBy')(aulasNomes, '');
        return aulasNomes.join(", ");
    }
    model.temAula = function(dandoAula){
        if(dandoAula===true){
            return "Sim";
        }else{
            return "Não";
        }
    }         
    model.adicionarInstrutor = function(instrutor){
        let aulasInstrutor = model.aulasSelecionadas.map(aulaSelecionada => aulaSelecionada.id);
        let instrutorDandoAula;
        /* para select multiple for(let i=0;i<instrutor.aulas.length;i++){
            instrutor.aulas[i]=Number(instrutor.aulas[i]);
        }*/
        if(instrutor.dandoAula==='s'){instrutorDandoAula=true}else{instrutorDandoAula=false};
        let novoInstrutor = {id:idNovoInstrutor,nome: instrutor.nome,sobrenome:instrutor.sobrenome,idade:instrutor.idade,email:instrutor.email,dandoAula:instrutorDandoAula,aula:aulasInstrutor,urlFoto:instrutor.urlFoto};
        //para select multiple let novoInstrutor = {id:idNovoInstrutor,nome: instrutor.nome,sobrenome:instrutor.sobrenome,idade:instrutor.idade,email:instrutor.email,dandoAula:instrutorDandoAula,aula:instrutor.aulas,urlFoto:instrutor.urlFoto};
        model.instrutores.push(novoInstrutor);
    }
    model.selecaoAulas = function(idAula){
        if(!model.aulaJaSelecionada(idAula)){
            model.adicionarAulaASelecao(idAula);
        }      
    }
    model.adicionarAulaASelecao = function(idAula){
        let selecionada = {nome:model.pegarNomeAulaPorId(idAula),id:idAula};
        model.aulasSelecionadas.push(selecionada);
    }
     model.pegarNomeAulaPorId = function(idAula){
        for(aula of model.aulas){
            if(aula.id===idAula){ 
                return aula.nome;
            }
        } 
    }
    model.aulaJaSelecionada = function(idAula){
        for(aulaSelecionada of model.aulasSelecionadas){
            if(aulaSelecionada.id===idAula){
                return true;
            }
        }
        return false;
    }
    model.remocaoAulasSelecionadas = function (idAula){
        for(let i=0;i<model.aulasSelecionadas.length;i++){
            if(model.aulasSelecionadas[i].id===idAula){
             model.aulasSelecionadas.splice(i,1);
            }
        }
    }
    model.aulaValida = function(idAula){
        if(typeof idAula === 'undefined'){
            return true;
        }
        return false;
    }
}]);