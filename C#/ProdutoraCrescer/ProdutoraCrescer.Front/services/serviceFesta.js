modulo.factory('serviceFesta',function($http){

    let urlBase = 'http://localhost:61689/api/';

    function obterLista(){
        return $http.get(urlBase+'festa/');
    }
    function obterPorId(id){
        return $http.get(urlBase+'festa/'+id);
    }
    return { 
        obterLista:obterLista,
        obterPorId:obterPorId
    }; 
});