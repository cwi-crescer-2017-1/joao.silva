modulo.factory('servicePacote',function($http){

    let urlBase = 'http://localhost:61689/api/';

    function obterLista(){
        return $http.get(urlBase+'pacote/');
    }
    function obterPorId(id){
        return $http.get(urlBase+'pacote/'+id);
    }
    return { 
        obterLista:obterLista,
        obterPorId:obterPorId
    }; 
});