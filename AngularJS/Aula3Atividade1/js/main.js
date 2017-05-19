var modulo = angular.module('Aula3Atividade1',[]);
modulo.controller('AtividadeForm',['$scope', function (model){
    model.instrutores = [{nome: 'Bernardo', sobrenome: 'Rezende', idade: 30, email: 'bernardo@cwi.com.br', jaDeuAula: true, aula: 'OO'}
];
    model.aulas = ['HTML e CSS', 'JavaScript', 'Banco de dados', 'AngularJS', 'Orientação a objetos'];
    model.adicionarInstrutor = adicionarInstrutor;
    function adicionarInstrutor(){
        model.instrutores.push({nome: model.cadastro.nome.$viewValue, 
            sobrenome:model.cadastro.sobrenome.$viewValue,
            idade:model.cadastro.idade.$viewValue, 
            email:model.cadastro.email.$viewValue,
            jaDeuAula: model.cadastro.jaDeuAula.$viewValue, 
            aula:model.cadastro.aula.$viewValue});
        console.log(model.instrutores);
    }
}])