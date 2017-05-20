var modulo = angular.module('CRUD',[]);
modulo.controller('Crescer',['$scope', function (model){
    model.aulas = [{id:0,nome:'Teste'}, {id:1,nome:'Heroísmo'}, {id:2,nome:'Poções'}, {id:3,nome:'Defesa contra as artes das trevas'}];
    model.instrutores = [{id:0,nome:'Teste',sobrenome:'Tester',idade:'22',email:'teste@tester.com.br',dandoAula:true,aula:[0],urlFoto:'../img/perfil_padrao.jpeg'},
                         {id:1,nome:'Saitama',sobrenome:'',idade:'26',email:'opm@heroassociation.jp',dandoAula:false,aula:[],urlFoto:'../img/perfil_padrao.jpeg'},
                         {id:2,nome:'Toshinori',sobrenome:'Yagi',idade:'36',email:'yagi@gmail.jp',dandoAula:true,aula:[1],urlFoto:'../img/perfil_padrao.jpeg'},
                         {id:3,nome:'Severus',sobrenome:'Snape',idade:'38',email:'severus@discipline.uk',dandoAula:true,aula:[2,3],urlFoto:'../img/perfil_padrao.jpeg'}];
    console.log(model.aulas);
    console.log(model.instrutores);            
    }])