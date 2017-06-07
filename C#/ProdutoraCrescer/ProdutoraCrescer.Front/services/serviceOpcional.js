modulo.factory('serviceOpcional',function($http){

    let urlBase = 'http://localhost:61689/api/';

    function obterLista(){
        return $http.get(urlBase+'opcional/');
    }
    function obterPorId(id){
        return $http.get(urlBase+'opcional/'+id);
    }
    return { 
        obterLista:obterLista,
        obterPorId:obterPorId
    }; 
});