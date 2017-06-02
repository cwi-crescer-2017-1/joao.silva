modulo.factory('servicesLivros',function($http){ //servicesInstrutores deve estar presente para executar a aulaService!
    
    let urlBase = 'http://localhost:60184/api';

    //Retorna lista de aulas
    function listLimitada(quantidade,skip){
        let propriedades = {
             url: urlBase+'/Livros',
             method: 'GET',
             params: {
                 quantidade:quantidade,
                 skip:skip
             }
        }
        return $http(propriedades);
    }
    function listLancamentos(){
        let propriedades = {
             url: urlBase+'/Livros/Lancamentos',
             method: 'GET'
        }
        return $http(propriedades);
    }
    return { 
        listLimitada:listLimitada,
        listLancamentos: listLancamentos
    }; 
});