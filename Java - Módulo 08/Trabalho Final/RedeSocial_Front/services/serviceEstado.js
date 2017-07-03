modulo.factory('serviceEstado',function($http){
    let urlBase = 'http://localhost:8080/estado/';
    function obterLista(){
        return $http.get(urlBase+'all');
    }
    return { 
        obterLista:obterLista,
    }; 
});