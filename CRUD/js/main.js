var modulo = angular.module('CRUD',[]);
var oi;
modulo.controller('Crescer',['$scope', function (model){
    model.aulas = [{},
                   {id:0,nome:'Tester'},
                   {id:1,nome:'Heroísmo'},
                   {id:2,nome:'Poções'},
                   {id:3,nome:'Defesa contra as artes das trevas'}];
    model.instrutores = [{id:0,nome:'Teste',sobrenome:'Tester',idade:'22',email:'teste@tester.com.br',dandoAula:true,aula:[0],urlFoto:'../img/perfil_padrao.jpeg'},
                         {id:1,nome:'Saitama',sobrenome:'',idade:'26',email:'opm@heroassociation.jp',dandoAula:false,aula:[],urlFoto:'../img/perfil_padrao.jpeg'},
                         {id:2,nome:'Toshinori',sobrenome:'Yagi',idade:'36',email:'yagi@gmail.jp',dandoAula:true,aula:[1],urlFoto:'../img/perfil_padrao.jpeg'},
                         {id:3,nome:'Severus',sobrenome:'Snape',idade:'38',email:'severus@discipline.uk',dandoAula:true,aula:[2,3],urlFoto:'../img/perfil_padrao.jpeg'}];
    model.aulasSelecionadas = [];
    model.adicionarAula =function(aula){
        console.log(aula);
    }         
    model.adicionarInstrutor = function(instrutor){
        console.log(instrutor);
    }
    model.selecaoAulas = function(idAula){
        if(!model.aulaJaSelecionada(idAula)){
            model.selecionarAula(idAula);
        }      
    }
    model.selecionarAula = function(idAula){
        for(aula of model.aulas){
            if(aula.id===idAula){ 
                let selecionada = {nome:aula.nome,id:aula.id};
                model.aulasSelecionadas.push(selecionada);
            }
        } 
    }
    model.aulaJaSelecionada = function(idAula){ //Evita a todo custo que uma aula já adicionada seja adicionada novamente
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
             console.log(i);
             model.aulasSelecionadas.splice(i,1);
            }
        }
    }
    model.aulaValida = function(idAula){
        console.log(idAula);
        if(typeof idAula === 'undefined'){
            return true;
        }
        return false;
    }
    }])