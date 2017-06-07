modulo.factory('serviceCliente',function($http){

    let urlBase = 'http://localhost:61689/api/';

    function registrar(nome,endereco,cpf,genero,dataNascimento,email){
        let cliente = {};
        cliente.Nome = nome;
        cliente.Endereco = endereco;
        cliente.CPF = cpf;
        cliente.Genero = genero;
        cliente.DataNascimento = dataNascimento;
        cliente.Email = email;
        return $http.post(urlBase+'cliente/registrar',cliente);
    }
    function obterLista(){
        return $http.get(urlBase+'cliente/');
    }
    function obterPorId(id){
        return $http.get(urlBase+'cliente/'+id);
    }
    return { 
        registrar:registrar,
        obterLista:obterLista,
        obterPorId:obterPorId
    }; 
});