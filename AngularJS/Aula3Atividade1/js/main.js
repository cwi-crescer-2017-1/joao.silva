var modulo = angular.module('Aula3Atividade1',[]);
modulo.controller('AtividadeForm',['$scope', function (model){
    model.instrutores = [{nome: 'Bernardo', sobrenome: 'Rezende', idade: "30", email: 'bernardo@cwi.com.br', jaDeuAula: true, aula: 'OO'}
];
    model.aulas = ['HTML e CSS', 'JavaScript', 'Banco de dados', 'AngularJS', 'Orientação a objetos'];
    model.adicionarInstrutor = adicionarInstrutor;
    model.erro = "cadastro.nome.$error.maxlength || cadastro.nome.$error.minlength || cadastro.nome.$error.required || cadastro.sobrenome.$error.maxlength ||  cadastro.idade.$error.required || cadastro.email.$error.required";
    function adicionarInstrutor(){
        let novoInstrutor={nome: model.cadastro.nome.$viewValue, 
            sobrenome:model.cadastro.sobrenome.$viewValue,
            idade:model.cadastro.idade.$viewValue, 
            email:model.cadastro.email.$viewValue,
            jaDeuAula: model.cadastro.jaDeuAula.$viewValue, 
            aula:model.cadastro.aula.$viewValue};
        model.instrutores.push(novoInstrutor);
        model.instrutor = {};
        console.log(model.instrutores);
    }
}])